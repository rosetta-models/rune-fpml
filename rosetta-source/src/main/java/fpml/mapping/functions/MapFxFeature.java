package fpml.mapping.functions;

import cdm.product.template.FxFeature;
import cdm.product.template.FxFeature.FxFeatureBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxFeature.MapFxFeatureDefault.class)
public abstract class MapFxFeature implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapComposite mapComposite;
	@Inject protected MapQuanto mapQuanto;
	@Inject protected MapReferenceCurrencyWithScheme mapReferenceCurrencyWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return fxFeature 
	*/
	public FxFeature evaluate(DataDocument fpmlDataDocument) {
		FxFeature.FxFeatureBuilder fxFeatureBuilder = doEvaluate(fpmlDataDocument);
		
		final FxFeature fxFeature;
		if (fxFeatureBuilder == null) {
			fxFeature = null;
		} else {
			fxFeature = fxFeatureBuilder.build();
			objectValidator.validate(FxFeature.class, fxFeature);
		}
		
		return fxFeature;
	}

	protected abstract FxFeature.FxFeatureBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFxFeatureDefault extends MapFxFeature {
		@Override
		protected FxFeature.FxFeatureBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FxFeature.FxFeatureBuilder fxFeature = FxFeature.builder();
			return assignOutput(fxFeature, fpmlDataDocument);
		}
		
		protected FxFeature.FxFeatureBuilder assignOutput(FxFeature.FxFeatureBuilder fxFeature, DataDocument fpmlDataDocument) {
			fxFeature = toBuilder(FxFeature.builder()
				.setReferenceCurrencyValue(mapReferenceCurrencyWithScheme.evaluate(fpmlDataDocument))
				.setComposite(mapComposite.evaluate(fpmlDataDocument))
				.setQuanto(mapQuanto.evaluate(fpmlDataDocument))
				.setCrossCurrency(mapComposite.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(fxFeature)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

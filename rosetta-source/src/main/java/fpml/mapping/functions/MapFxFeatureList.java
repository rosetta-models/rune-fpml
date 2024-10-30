package fpml.mapping.functions;

import cdm.product.template.FxFeature;
import cdm.product.template.FxFeature.FxFeatureBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxFeatureList.MapFxFeatureListDefault.class)
public abstract class MapFxFeatureList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapComposite mapComposite;
	@Inject protected MapQuanto mapQuanto;
	@Inject protected MapReferenceCurrencyWithScheme mapReferenceCurrencyWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return fxFeatureList 
	*/
	public List<? extends FxFeature> evaluate(DataDocument fpmlDataDocument) {
		List<FxFeature.FxFeatureBuilder> fxFeatureListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends FxFeature> fxFeatureList;
		if (fxFeatureListBuilder == null) {
			fxFeatureList = null;
		} else {
			fxFeatureList = fxFeatureListBuilder.stream().map(FxFeature::build).collect(Collectors.toList());
			objectValidator.validate(FxFeature.class, fxFeatureList);
		}
		
		return fxFeatureList;
	}

	protected abstract List<FxFeature.FxFeatureBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFxFeatureListDefault extends MapFxFeatureList {
		@Override
		protected List<FxFeature.FxFeatureBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<FxFeature.FxFeatureBuilder> fxFeatureList = new ArrayList<>();
			return assignOutput(fxFeatureList, fpmlDataDocument);
		}
		
		protected List<FxFeature.FxFeatureBuilder> assignOutput(List<FxFeature.FxFeatureBuilder> fxFeatureList, DataDocument fpmlDataDocument) {
			fxFeatureList.addAll(toBuilder(MapperC.<FxFeature>of(MapperS.of(FxFeature.builder()
				.setReferenceCurrencyValue(mapReferenceCurrencyWithScheme.evaluate(fpmlDataDocument))
				.setComposite(mapComposite.evaluate(fpmlDataDocument))
				.setQuanto(mapQuanto.evaluate(fpmlDataDocument))
				.setCrossCurrency(mapComposite.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(fxFeatureList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

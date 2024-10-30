package fpml.mapping.functions;

import cdm.product.template.Composite;
import cdm.product.template.Composite.CompositeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapComposite.MapCompositeDefault.class)
public abstract class MapComposite implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapFxSpotRateSource mapFxSpotRateSource;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlDataDocument 
	* @return composite 
	*/
	public Composite evaluate(DataDocument fpmlDataDocument) {
		Composite.CompositeBuilder compositeBuilder = doEvaluate(fpmlDataDocument);
		
		final Composite composite;
		if (compositeBuilder == null) {
			composite = null;
		} else {
			composite = compositeBuilder.build();
			objectValidator.validate(Composite.class, composite);
		}
		
		return composite;
	}

	protected abstract Composite.CompositeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCompositeDefault extends MapComposite {
		@Override
		protected Composite.CompositeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Composite.CompositeBuilder composite = Composite.builder();
			return assignOutput(composite, fpmlDataDocument);
		}
		
		protected Composite.CompositeBuilder assignOutput(Composite.CompositeBuilder composite, DataDocument fpmlDataDocument) {
			composite = toBuilder(Composite.builder()
				.setDeterminationMethod(null)
				.setRelativeDate(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.setFxSpotRateSource(mapFxSpotRateSource.evaluate(fpmlDataDocument))
				.setFixingTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(composite)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

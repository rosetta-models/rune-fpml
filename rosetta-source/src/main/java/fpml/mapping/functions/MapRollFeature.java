package fpml.mapping.functions;

import cdm.product.common.settlement.RollFeature;
import cdm.product.common.settlement.RollFeature.RollFeatureBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRollFeature.MapRollFeatureDefault.class)
public abstract class MapRollFeature implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapOffset mapOffset;

	/**
	* @param fpmlDataDocument 
	* @return rollFeature 
	*/
	public RollFeature evaluate(DataDocument fpmlDataDocument) {
		RollFeature.RollFeatureBuilder rollFeatureBuilder = doEvaluate(fpmlDataDocument);
		
		final RollFeature rollFeature;
		if (rollFeatureBuilder == null) {
			rollFeature = null;
		} else {
			rollFeature = rollFeatureBuilder.build();
			objectValidator.validate(RollFeature.class, rollFeature);
		}
		
		return rollFeature;
	}

	protected abstract RollFeature.RollFeatureBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRollFeatureDefault extends MapRollFeature {
		@Override
		protected RollFeature.RollFeatureBuilder doEvaluate(DataDocument fpmlDataDocument) {
			RollFeature.RollFeatureBuilder rollFeature = RollFeature.builder();
			return assignOutput(rollFeature, fpmlDataDocument);
		}
		
		protected RollFeature.RollFeatureBuilder assignOutput(RollFeature.RollFeatureBuilder rollFeature, DataDocument fpmlDataDocument) {
			rollFeature = toBuilder(RollFeature.builder()
				.setRollSourceCalendar(null)
				.setDeliveryDateRollConvention(mapOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(rollFeature)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

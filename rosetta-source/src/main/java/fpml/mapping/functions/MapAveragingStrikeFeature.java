package fpml.mapping.functions;

import cdm.product.template.AveragingStrikeFeature;
import cdm.product.template.AveragingStrikeFeature.AveragingStrikeFeatureBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAveragingStrikeFeature.MapAveragingStrikeFeatureDefault.class)
public abstract class MapAveragingStrikeFeature implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAveragingCalculation mapAveragingCalculation;
	@Inject protected MapObservationTerms mapObservationTerms;

	/**
	* @param fpmlDataDocument 
	* @return averagingStrikeFeature 
	*/
	public AveragingStrikeFeature evaluate(DataDocument fpmlDataDocument) {
		AveragingStrikeFeature.AveragingStrikeFeatureBuilder averagingStrikeFeatureBuilder = doEvaluate(fpmlDataDocument);
		
		final AveragingStrikeFeature averagingStrikeFeature;
		if (averagingStrikeFeatureBuilder == null) {
			averagingStrikeFeature = null;
		} else {
			averagingStrikeFeature = averagingStrikeFeatureBuilder.build();
			objectValidator.validate(AveragingStrikeFeature.class, averagingStrikeFeature);
		}
		
		return averagingStrikeFeature;
	}

	protected abstract AveragingStrikeFeature.AveragingStrikeFeatureBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAveragingStrikeFeatureDefault extends MapAveragingStrikeFeature {
		@Override
		protected AveragingStrikeFeature.AveragingStrikeFeatureBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AveragingStrikeFeature.AveragingStrikeFeatureBuilder averagingStrikeFeature = AveragingStrikeFeature.builder();
			return assignOutput(averagingStrikeFeature, fpmlDataDocument);
		}
		
		protected AveragingStrikeFeature.AveragingStrikeFeatureBuilder assignOutput(AveragingStrikeFeature.AveragingStrikeFeatureBuilder averagingStrikeFeature, DataDocument fpmlDataDocument) {
			averagingStrikeFeature = toBuilder(AveragingStrikeFeature.builder()
				.setAveragingCalculation(mapAveragingCalculation.evaluate(fpmlDataDocument))
				.setObservationTerms(mapObservationTerms.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(averagingStrikeFeature)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

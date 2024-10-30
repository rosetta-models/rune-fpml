package fpml.mapping.functions;

import cdm.base.math.AveragingCalculationMethod;
import cdm.base.math.AveragingCalculationMethod.AveragingCalculationMethodBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAveragingCalculationMethod.MapAveragingCalculationMethodDefault.class)
public abstract class MapAveragingCalculationMethod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return averagingCalculationMethod 
	*/
	public AveragingCalculationMethod evaluate(DataDocument fpmlDataDocument) {
		AveragingCalculationMethod.AveragingCalculationMethodBuilder averagingCalculationMethodBuilder = doEvaluate(fpmlDataDocument);
		
		final AveragingCalculationMethod averagingCalculationMethod;
		if (averagingCalculationMethodBuilder == null) {
			averagingCalculationMethod = null;
		} else {
			averagingCalculationMethod = averagingCalculationMethodBuilder.build();
			objectValidator.validate(AveragingCalculationMethod.class, averagingCalculationMethod);
		}
		
		return averagingCalculationMethod;
	}

	protected abstract AveragingCalculationMethod.AveragingCalculationMethodBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAveragingCalculationMethodDefault extends MapAveragingCalculationMethod {
		@Override
		protected AveragingCalculationMethod.AveragingCalculationMethodBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AveragingCalculationMethod.AveragingCalculationMethodBuilder averagingCalculationMethod = AveragingCalculationMethod.builder();
			return assignOutput(averagingCalculationMethod, fpmlDataDocument);
		}
		
		protected AveragingCalculationMethod.AveragingCalculationMethodBuilder assignOutput(AveragingCalculationMethod.AveragingCalculationMethodBuilder averagingCalculationMethod, DataDocument fpmlDataDocument) {
			averagingCalculationMethod = toBuilder(AveragingCalculationMethod.builder()
				.setIsWeighted(null)
				.setCalculationMethod(null)
				.build());
			
			return Optional.ofNullable(averagingCalculationMethod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

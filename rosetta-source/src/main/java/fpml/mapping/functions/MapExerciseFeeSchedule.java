package fpml.mapping.functions;

import cdm.product.template.ExerciseFeeSchedule;
import cdm.product.template.ExerciseFeeSchedule.ExerciseFeeScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExerciseFeeSchedule.MapExerciseFeeScheduleDefault.class)
public abstract class MapExerciseFeeSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAmountSchedule mapAmountSchedule;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;
	@Inject protected MapSchedule mapSchedule;

	/**
	* @param fpmlDataDocument 
	* @return exerciseFeeSchedule 
	*/
	public ExerciseFeeSchedule evaluate(DataDocument fpmlDataDocument) {
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder exerciseFeeScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final ExerciseFeeSchedule exerciseFeeSchedule;
		if (exerciseFeeScheduleBuilder == null) {
			exerciseFeeSchedule = null;
		} else {
			exerciseFeeSchedule = exerciseFeeScheduleBuilder.build();
			objectValidator.validate(ExerciseFeeSchedule.class, exerciseFeeSchedule);
		}
		
		return exerciseFeeSchedule;
	}

	protected abstract ExerciseFeeSchedule.ExerciseFeeScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExerciseFeeScheduleDefault extends MapExerciseFeeSchedule {
		@Override
		protected ExerciseFeeSchedule.ExerciseFeeScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExerciseFeeSchedule.ExerciseFeeScheduleBuilder exerciseFeeSchedule = ExerciseFeeSchedule.builder();
			return assignOutput(exerciseFeeSchedule, fpmlDataDocument);
		}
		
		protected ExerciseFeeSchedule.ExerciseFeeScheduleBuilder assignOutput(ExerciseFeeSchedule.ExerciseFeeScheduleBuilder exerciseFeeSchedule, DataDocument fpmlDataDocument) {
			exerciseFeeSchedule = toBuilder(ExerciseFeeSchedule.builder()
				.setPayer(null)
				.setReceiver(null)
				.setNotionalReferenceValue(mapMoney.evaluate(fpmlDataDocument))
				.setFeeAmountSchedule(mapAmountSchedule.evaluate(fpmlDataDocument))
				.setFeeRateSchedule(mapSchedule.evaluate(fpmlDataDocument))
				.setFeePaymentDate(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(exerciseFeeSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

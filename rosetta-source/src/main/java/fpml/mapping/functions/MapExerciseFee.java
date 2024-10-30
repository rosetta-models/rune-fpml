package fpml.mapping.functions;

import cdm.product.template.ExerciseFee;
import cdm.product.template.ExerciseFee.ExerciseFeeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExerciseFee.MapExerciseFeeDefault.class)
public abstract class MapExerciseFee implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlDataDocument 
	* @return exerciseFee 
	*/
	public ExerciseFee evaluate(DataDocument fpmlDataDocument) {
		ExerciseFee.ExerciseFeeBuilder exerciseFeeBuilder = doEvaluate(fpmlDataDocument);
		
		final ExerciseFee exerciseFee;
		if (exerciseFeeBuilder == null) {
			exerciseFee = null;
		} else {
			exerciseFee = exerciseFeeBuilder.build();
			objectValidator.validate(ExerciseFee.class, exerciseFee);
		}
		
		return exerciseFee;
	}

	protected abstract ExerciseFee.ExerciseFeeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExerciseFeeDefault extends MapExerciseFee {
		@Override
		protected ExerciseFee.ExerciseFeeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExerciseFee.ExerciseFeeBuilder exerciseFee = ExerciseFee.builder();
			return assignOutput(exerciseFee, fpmlDataDocument);
		}
		
		protected ExerciseFee.ExerciseFeeBuilder assignOutput(ExerciseFee.ExerciseFeeBuilder exerciseFee, DataDocument fpmlDataDocument) {
			exerciseFee = toBuilder(ExerciseFee.builder()
				.setPayer(null)
				.setReceiver(null)
				.setNotionalReferenceValue(mapMoney.evaluate(fpmlDataDocument))
				.setFeeAmount(null)
				.setFeeRate(null)
				.setFeePaymentDate(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(exerciseFee)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

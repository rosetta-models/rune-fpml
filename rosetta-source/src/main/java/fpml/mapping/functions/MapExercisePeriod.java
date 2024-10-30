package fpml.mapping.functions;

import cdm.product.template.ExercisePeriod;
import cdm.product.template.ExercisePeriod.ExercisePeriodBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExercisePeriod.MapExercisePeriodDefault.class)
public abstract class MapExercisePeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlDataDocument 
	* @return exercisePeriod 
	*/
	public ExercisePeriod evaluate(DataDocument fpmlDataDocument) {
		ExercisePeriod.ExercisePeriodBuilder exercisePeriodBuilder = doEvaluate(fpmlDataDocument);
		
		final ExercisePeriod exercisePeriod;
		if (exercisePeriodBuilder == null) {
			exercisePeriod = null;
		} else {
			exercisePeriod = exercisePeriodBuilder.build();
			objectValidator.validate(ExercisePeriod.class, exercisePeriod);
		}
		
		return exercisePeriod;
	}

	protected abstract ExercisePeriod.ExercisePeriodBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExercisePeriodDefault extends MapExercisePeriod {
		@Override
		protected ExercisePeriod.ExercisePeriodBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExercisePeriod.ExercisePeriodBuilder exercisePeriod = ExercisePeriod.builder();
			return assignOutput(exercisePeriod, fpmlDataDocument);
		}
		
		protected ExercisePeriod.ExercisePeriodBuilder assignOutput(ExercisePeriod.ExercisePeriodBuilder exercisePeriod, DataDocument fpmlDataDocument) {
			exercisePeriod = toBuilder(ExercisePeriod.builder()
				.setEarliestExerciseDateTenor(mapPeriod.evaluate(fpmlDataDocument))
				.setExerciseFrequency(mapPeriod.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(exercisePeriod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

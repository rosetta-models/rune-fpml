package fpml.mapping.functions;

import cdm.product.template.ExerciseProcedure;
import cdm.product.template.ExerciseProcedure.ExerciseProcedureBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExerciseProcedure.MapExerciseProcedureDefault.class)
public abstract class MapExerciseProcedure implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAutomaticExercise mapAutomaticExercise;
	@Inject protected MapManualExercise mapManualExercise;

	/**
	* @param fpmlDataDocument 
	* @return exerciseProcedure 
	*/
	public ExerciseProcedure evaluate(DataDocument fpmlDataDocument) {
		ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedureBuilder = doEvaluate(fpmlDataDocument);
		
		final ExerciseProcedure exerciseProcedure;
		if (exerciseProcedureBuilder == null) {
			exerciseProcedure = null;
		} else {
			exerciseProcedure = exerciseProcedureBuilder.build();
			objectValidator.validate(ExerciseProcedure.class, exerciseProcedure);
		}
		
		return exerciseProcedure;
	}

	protected abstract ExerciseProcedure.ExerciseProcedureBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExerciseProcedureDefault extends MapExerciseProcedure {
		@Override
		protected ExerciseProcedure.ExerciseProcedureBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure = ExerciseProcedure.builder();
			return assignOutput(exerciseProcedure, fpmlDataDocument);
		}
		
		protected ExerciseProcedure.ExerciseProcedureBuilder assignOutput(ExerciseProcedure.ExerciseProcedureBuilder exerciseProcedure, DataDocument fpmlDataDocument) {
			exerciseProcedure = toBuilder(ExerciseProcedure.builder()
				.setManualExercise(mapManualExercise.evaluate(fpmlDataDocument))
				.setAutomaticExercise(mapAutomaticExercise.evaluate(fpmlDataDocument))
				.setFollowUpConfirmation(null)
				.setLimitedRightToConfirm(null)
				.setSplitTicket(null)
				.build());
			
			return Optional.ofNullable(exerciseProcedure)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

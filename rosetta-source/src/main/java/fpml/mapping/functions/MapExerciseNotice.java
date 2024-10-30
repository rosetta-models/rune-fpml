package fpml.mapping.functions;

import cdm.product.template.ExerciseNotice;
import cdm.product.template.ExerciseNotice.ExerciseNoticeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExerciseNotice.MapExerciseNoticeDefault.class)
public abstract class MapExerciseNotice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterWithScheme mapBusinessCenterWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return exerciseNotice 
	*/
	public ExerciseNotice evaluate(DataDocument fpmlDataDocument) {
		ExerciseNotice.ExerciseNoticeBuilder exerciseNoticeBuilder = doEvaluate(fpmlDataDocument);
		
		final ExerciseNotice exerciseNotice;
		if (exerciseNoticeBuilder == null) {
			exerciseNotice = null;
		} else {
			exerciseNotice = exerciseNoticeBuilder.build();
			objectValidator.validate(ExerciseNotice.class, exerciseNotice);
		}
		
		return exerciseNotice;
	}

	protected abstract ExerciseNotice.ExerciseNoticeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExerciseNoticeDefault extends MapExerciseNotice {
		@Override
		protected ExerciseNotice.ExerciseNoticeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExerciseNotice.ExerciseNoticeBuilder exerciseNotice = ExerciseNotice.builder();
			return assignOutput(exerciseNotice, fpmlDataDocument);
		}
		
		protected ExerciseNotice.ExerciseNoticeBuilder assignOutput(ExerciseNotice.ExerciseNoticeBuilder exerciseNotice, DataDocument fpmlDataDocument) {
			exerciseNotice = toBuilder(ExerciseNotice.builder()
				.setExerciseNoticeGiver(null)
				.setExerciseNoticeReceiver(null)
				.setBusinessCenterValue(mapBusinessCenterWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(exerciseNotice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

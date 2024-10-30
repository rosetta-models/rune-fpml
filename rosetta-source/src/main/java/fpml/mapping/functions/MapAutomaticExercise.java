package fpml.mapping.functions;

import cdm.product.template.AutomaticExercise;
import cdm.product.template.AutomaticExercise.AutomaticExerciseBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAutomaticExercise.MapAutomaticExerciseDefault.class)
public abstract class MapAutomaticExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return automaticExercise 
	*/
	public AutomaticExercise evaluate(DataDocument fpmlDataDocument) {
		AutomaticExercise.AutomaticExerciseBuilder automaticExerciseBuilder = doEvaluate(fpmlDataDocument);
		
		final AutomaticExercise automaticExercise;
		if (automaticExerciseBuilder == null) {
			automaticExercise = null;
		} else {
			automaticExercise = automaticExerciseBuilder.build();
			objectValidator.validate(AutomaticExercise.class, automaticExercise);
		}
		
		return automaticExercise;
	}

	protected abstract AutomaticExercise.AutomaticExerciseBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAutomaticExerciseDefault extends MapAutomaticExercise {
		@Override
		protected AutomaticExercise.AutomaticExerciseBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AutomaticExercise.AutomaticExerciseBuilder automaticExercise = AutomaticExercise.builder();
			return assignOutput(automaticExercise, fpmlDataDocument);
		}
		
		protected AutomaticExercise.AutomaticExerciseBuilder assignOutput(AutomaticExercise.AutomaticExerciseBuilder automaticExercise, DataDocument fpmlDataDocument) {
			automaticExercise = toBuilder(AutomaticExercise.builder()
				.setThresholdRate(null)
				.setIsApplicable(null)
				.build());
			
			return Optional.ofNullable(automaticExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

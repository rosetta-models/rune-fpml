package fpml.mapping.functions;

import cdm.product.template.ManualExercise;
import cdm.product.template.ManualExercise.ManualExerciseBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapManualExercise.MapManualExerciseDefault.class)
public abstract class MapManualExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapExerciseNotice mapExerciseNotice;

	/**
	* @param fpmlDataDocument 
	* @return manualExercise 
	*/
	public ManualExercise evaluate(DataDocument fpmlDataDocument) {
		ManualExercise.ManualExerciseBuilder manualExerciseBuilder = doEvaluate(fpmlDataDocument);
		
		final ManualExercise manualExercise;
		if (manualExerciseBuilder == null) {
			manualExercise = null;
		} else {
			manualExercise = manualExerciseBuilder.build();
			objectValidator.validate(ManualExercise.class, manualExercise);
		}
		
		return manualExercise;
	}

	protected abstract ManualExercise.ManualExerciseBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapManualExerciseDefault extends MapManualExercise {
		@Override
		protected ManualExercise.ManualExerciseBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ManualExercise.ManualExerciseBuilder manualExercise = ManualExercise.builder();
			return assignOutput(manualExercise, fpmlDataDocument);
		}
		
		protected ManualExercise.ManualExerciseBuilder assignOutput(ManualExercise.ManualExerciseBuilder manualExercise, DataDocument fpmlDataDocument) {
			manualExercise = toBuilder(ManualExercise.builder()
				.setExerciseNotice(mapExerciseNotice.evaluate(fpmlDataDocument))
				.setFallbackExercise(null)
				.build());
			
			return Optional.ofNullable(manualExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

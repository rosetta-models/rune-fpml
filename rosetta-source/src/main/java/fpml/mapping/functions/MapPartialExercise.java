package fpml.mapping.functions;

import cdm.product.template.PartialExercise;
import cdm.product.template.PartialExercise.PartialExerciseBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPartialExercise.MapPartialExerciseDefault.class)
public abstract class MapPartialExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return partialExercise 
	*/
	public PartialExercise evaluate(DataDocument fpmlDataDocument) {
		PartialExercise.PartialExerciseBuilder partialExerciseBuilder = doEvaluate(fpmlDataDocument);
		
		final PartialExercise partialExercise;
		if (partialExerciseBuilder == null) {
			partialExercise = null;
		} else {
			partialExercise = partialExerciseBuilder.build();
			objectValidator.validate(PartialExercise.class, partialExercise);
		}
		
		return partialExercise;
	}

	protected abstract PartialExercise.PartialExerciseBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPartialExerciseDefault extends MapPartialExercise {
		@Override
		protected PartialExercise.PartialExerciseBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PartialExercise.PartialExerciseBuilder partialExercise = PartialExercise.builder();
			return assignOutput(partialExercise, fpmlDataDocument);
		}
		
		protected PartialExercise.PartialExerciseBuilder assignOutput(PartialExercise.PartialExerciseBuilder partialExercise, DataDocument fpmlDataDocument) {
			partialExercise = toBuilder(PartialExercise.builder()
				.setNotionaReferenceValue(mapMoney.evaluate(fpmlDataDocument))
				.setIntegralMultipleAmount(null)
				.setMinimumNotionalAmount(null)
				.setMinimumNumberOfOptions(null)
				.build());
			
			return Optional.ofNullable(partialExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

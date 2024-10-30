package fpml.mapping.functions;

import cdm.product.template.MultipleExercise;
import cdm.product.template.MultipleExercise.MultipleExerciseBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMultipleExercise.MapMultipleExerciseDefault.class)
public abstract class MapMultipleExercise implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return multipleExercise 
	*/
	public MultipleExercise evaluate(DataDocument fpmlDataDocument) {
		MultipleExercise.MultipleExerciseBuilder multipleExerciseBuilder = doEvaluate(fpmlDataDocument);
		
		final MultipleExercise multipleExercise;
		if (multipleExerciseBuilder == null) {
			multipleExercise = null;
		} else {
			multipleExercise = multipleExerciseBuilder.build();
			objectValidator.validate(MultipleExercise.class, multipleExercise);
		}
		
		return multipleExercise;
	}

	protected abstract MultipleExercise.MultipleExerciseBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMultipleExerciseDefault extends MapMultipleExercise {
		@Override
		protected MultipleExercise.MultipleExerciseBuilder doEvaluate(DataDocument fpmlDataDocument) {
			MultipleExercise.MultipleExerciseBuilder multipleExercise = MultipleExercise.builder();
			return assignOutput(multipleExercise, fpmlDataDocument);
		}
		
		protected MultipleExercise.MultipleExerciseBuilder assignOutput(MultipleExercise.MultipleExerciseBuilder multipleExercise, DataDocument fpmlDataDocument) {
			multipleExercise = toBuilder(MultipleExercise.builder()
				.setNotionaReferenceValue(mapMoney.evaluate(fpmlDataDocument))
				.setIntegralMultipleAmount(null)
				.setMinimumNotionalAmount(null)
				.setMinimumNumberOfOptions(null)
				.setMaximumNotionalAmount(null)
				.setMaximumNumberOfOptions(null)
				.build());
			
			return Optional.ofNullable(multipleExercise)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

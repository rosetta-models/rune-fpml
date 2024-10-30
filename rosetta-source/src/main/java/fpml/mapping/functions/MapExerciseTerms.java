package fpml.mapping.functions;

import cdm.product.template.ExerciseTerms;
import cdm.product.template.ExerciseTerms.ExerciseTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExerciseTerms.MapExerciseTermsDefault.class)
public abstract class MapExerciseTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapAdjustableOrRelativeDateList mapAdjustableOrRelativeDateList;
	@Inject protected MapAdjustableOrRelativeDates mapAdjustableOrRelativeDates;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapExerciseFee mapExerciseFee;
	@Inject protected MapExerciseFeeSchedule mapExerciseFeeSchedule;
	@Inject protected MapExerciseProcedure mapExerciseProcedure;
	@Inject protected MapMultipleExercise mapMultipleExercise;
	@Inject protected MapPartialExercise mapPartialExercise;

	/**
	* @param fpmlDataDocument 
	* @return exerciseTerms 
	*/
	public ExerciseTerms evaluate(DataDocument fpmlDataDocument) {
		ExerciseTerms.ExerciseTermsBuilder exerciseTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final ExerciseTerms exerciseTerms;
		if (exerciseTermsBuilder == null) {
			exerciseTerms = null;
		} else {
			exerciseTerms = exerciseTermsBuilder.build();
			objectValidator.validate(ExerciseTerms.class, exerciseTerms);
		}
		
		return exerciseTerms;
	}

	protected abstract ExerciseTerms.ExerciseTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExerciseTermsDefault extends MapExerciseTerms {
		@Override
		protected ExerciseTerms.ExerciseTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExerciseTerms.ExerciseTermsBuilder exerciseTerms = ExerciseTerms.builder();
			return assignOutput(exerciseTerms, fpmlDataDocument);
		}
		
		protected ExerciseTerms.ExerciseTermsBuilder assignOutput(ExerciseTerms.ExerciseTermsBuilder exerciseTerms, DataDocument fpmlDataDocument) {
			exerciseTerms = toBuilder(ExerciseTerms.builder()
				.setStyle(null)
				.setCommencementDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setExerciseDates(mapAdjustableOrRelativeDates.evaluate(fpmlDataDocument))
				.setExpirationDate(new ArrayList(mapAdjustableOrRelativeDateList.evaluate(fpmlDataDocument)))
				.setRelevantUnderlyingDate(mapAdjustableOrRelativeDates.evaluate(fpmlDataDocument))
				.setEarliestExerciseTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setLatestExerciseTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setExpirationTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setExpirationTimeType(null)
				.setMultipleExercise(mapMultipleExercise.evaluate(fpmlDataDocument))
				.setExerciseFeeSchedule(mapExerciseFeeSchedule.evaluate(fpmlDataDocument))
				.setExerciseProcedure(mapExerciseProcedure.evaluate(fpmlDataDocument))
				.setExerciseFee(mapExerciseFee.evaluate(fpmlDataDocument))
				.setPartialExercise(mapPartialExercise.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(exerciseTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

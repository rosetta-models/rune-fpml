package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDates;
import fpml.confirmation.BermudaExercise;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.ExerciseFeeSchedule;
import fpml.confirmation.MultipleExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BermudaExerciseValidator implements Validator<BermudaExercise> {

	private List<ComparisonResult> getComparisonResults(BermudaExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("bermudaExerciseDates", (AdjustableOrRelativeDates) o.getBermudaExerciseDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("relevantUnderlyingDate", (AdjustableOrRelativeDates) o.getRelevantUnderlyingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("earliestExerciseTime", (BusinessCenterTime) o.getEarliestExerciseTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("latestExerciseTime", (BusinessCenterTime) o.getLatestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationTime", (BusinessCenterTime) o.getExpirationTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("multipleExercise", (MultipleExercise) o.getMultipleExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseFeeSchedule", (ExerciseFeeSchedule) o.getExerciseFeeSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BermudaExercise> validate(RosettaPath path, BermudaExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BermudaExercise", ValidationType.CARDINALITY, "BermudaExercise", path, "", error);
		}
		return success("BermudaExercise", ValidationType.CARDINALITY, "BermudaExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BermudaExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BermudaExercise", ValidationType.CARDINALITY, "BermudaExercise", path, "", res.getError());
				}
				return success("BermudaExercise", ValidationType.CARDINALITY, "BermudaExercise", path, "");
			})
			.collect(toList());
	}

}

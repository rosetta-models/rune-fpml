package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.SharedAmericanExercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SharedAmericanExerciseValidator implements Validator<SharedAmericanExercise> {

	private List<ComparisonResult> getComparisonResults(SharedAmericanExercise o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("commencementDate", (AdjustableOrRelativeDate) o.getCommencementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expirationDate", (AdjustableOrRelativeDate) o.getExpirationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("latestExerciseTime", (BusinessCenterTime) o.getLatestExerciseTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("latestExerciseTimeDetermination", (DeterminationMethod) o.getLatestExerciseTimeDetermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SharedAmericanExercise> validate(RosettaPath path, SharedAmericanExercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SharedAmericanExercise", ValidationType.CARDINALITY, "SharedAmericanExercise", path, "", error);
		}
		return success("SharedAmericanExercise", ValidationType.CARDINALITY, "SharedAmericanExercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SharedAmericanExercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SharedAmericanExercise", ValidationType.CARDINALITY, "SharedAmericanExercise", path, "", res.getError());
				}
				return success("SharedAmericanExercise", ValidationType.CARDINALITY, "SharedAmericanExercise", path, "");
			})
			.collect(toList());
	}

}

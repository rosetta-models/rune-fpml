package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Exercise;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExerciseTypeFormatValidator implements Validator<Exercise> {

	private List<ComparisonResult> getComparisonResults(Exercise o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Exercise> validate(RosettaPath path, Exercise o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Exercise", ValidationType.TYPE_FORMAT, "Exercise", path, "", error);
		}
		return success("Exercise", ValidationType.TYPE_FORMAT, "Exercise", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Exercise o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Exercise", ValidationType.TYPE_FORMAT, "Exercise", path, "", res.getError());
				}
				return success("Exercise", ValidationType.TYPE_FORMAT, "Exercise", path, "");
			})
			.collect(toList());
	}

}

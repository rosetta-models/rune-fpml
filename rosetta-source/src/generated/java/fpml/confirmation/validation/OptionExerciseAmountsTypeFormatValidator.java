package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionExerciseAmounts;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountsTypeFormatValidator implements Validator<OptionExerciseAmounts> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmounts o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OptionExerciseAmounts> validate(RosettaPath path, OptionExerciseAmounts o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExerciseAmounts", ValidationType.TYPE_FORMAT, "OptionExerciseAmounts", path, "", error);
		}
		return success("OptionExerciseAmounts", ValidationType.TYPE_FORMAT, "OptionExerciseAmounts", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmounts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmounts", ValidationType.TYPE_FORMAT, "OptionExerciseAmounts", path, "", res.getError());
				}
				return success("OptionExerciseAmounts", ValidationType.TYPE_FORMAT, "OptionExerciseAmounts", path, "");
			})
			.collect(toList());
	}

}

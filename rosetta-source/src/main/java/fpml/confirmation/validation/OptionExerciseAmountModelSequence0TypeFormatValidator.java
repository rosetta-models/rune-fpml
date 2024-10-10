package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionExerciseAmountModelSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountModelSequence0TypeFormatValidator implements Validator<OptionExerciseAmountModelSequence0> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmountModelSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OptionExerciseAmountModelSequence0> validate(RosettaPath path, OptionExerciseAmountModelSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExerciseAmountModelSequence0", ValidationType.TYPE_FORMAT, "OptionExerciseAmountModelSequence0", path, "", error);
		}
		return success("OptionExerciseAmountModelSequence0", ValidationType.TYPE_FORMAT, "OptionExerciseAmountModelSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmountModelSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmountModelSequence0", ValidationType.TYPE_FORMAT, "OptionExerciseAmountModelSequence0", path, "", res.getError());
				}
				return success("OptionExerciseAmountModelSequence0", ValidationType.TYPE_FORMAT, "OptionExerciseAmountModelSequence0", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionExerciseAmountsSequence3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountsSequence3TypeFormatValidator implements Validator<OptionExerciseAmountsSequence3> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmountsSequence3 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OptionExerciseAmountsSequence3> validate(RosettaPath path, OptionExerciseAmountsSequence3 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExerciseAmountsSequence3", ValidationType.TYPE_FORMAT, "OptionExerciseAmountsSequence3", path, "", error);
		}
		return success("OptionExerciseAmountsSequence3", ValidationType.TYPE_FORMAT, "OptionExerciseAmountsSequence3", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmountsSequence3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmountsSequence3", ValidationType.TYPE_FORMAT, "OptionExerciseAmountsSequence3", path, "", res.getError());
				}
				return success("OptionExerciseAmountsSequence3", ValidationType.TYPE_FORMAT, "OptionExerciseAmountsSequence3", path, "");
			})
			.collect(toList());
	}

}

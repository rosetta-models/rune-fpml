package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionExerciseAmountModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountModelTypeFormatValidator implements Validator<OptionExerciseAmountModel> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmountModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OptionExerciseAmountModel> validate(RosettaPath path, OptionExerciseAmountModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExerciseAmountModel", ValidationType.TYPE_FORMAT, "OptionExerciseAmountModel", path, "", error);
		}
		return success("OptionExerciseAmountModel", ValidationType.TYPE_FORMAT, "OptionExerciseAmountModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmountModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmountModel", ValidationType.TYPE_FORMAT, "OptionExerciseAmountModel", path, "", res.getError());
				}
				return success("OptionExerciseAmountModel", ValidationType.TYPE_FORMAT, "OptionExerciseAmountModel", path, "");
			})
			.collect(toList());
	}

}

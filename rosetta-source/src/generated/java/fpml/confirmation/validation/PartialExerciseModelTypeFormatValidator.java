package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PartialExerciseModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PartialExerciseModelTypeFormatValidator implements Validator<PartialExerciseModel> {

	private List<ComparisonResult> getComparisonResults(PartialExerciseModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("minimumNumberOfOptions", o.getMinimumNumberOfOptions(), empty(), of(0), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public ValidationResult<PartialExerciseModel> validate(RosettaPath path, PartialExerciseModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PartialExerciseModel", ValidationType.TYPE_FORMAT, "PartialExerciseModel", path, "", error);
		}
		return success("PartialExerciseModel", ValidationType.TYPE_FORMAT, "PartialExerciseModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartialExerciseModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PartialExerciseModel", ValidationType.TYPE_FORMAT, "PartialExerciseModel", path, "", res.getError());
				}
				return success("PartialExerciseModel", ValidationType.TYPE_FORMAT, "PartialExerciseModel", path, "");
			})
			.collect(toList());
	}

}

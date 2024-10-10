package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionExerciseAmountModelSequence2;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountModelSequence2Validator implements Validator<OptionExerciseAmountModelSequence2> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmountModelSequence2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("exerciseInNumberOfUnits", (BigDecimal) o.getExerciseInNumberOfUnits() != null ? 1 : 0, 1, 1), 
				checkCardinality("outstandingNumberOfUnits", (BigDecimal) o.getOutstandingNumberOfUnits() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<OptionExerciseAmountModelSequence2> validate(RosettaPath path, OptionExerciseAmountModelSequence2 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExerciseAmountModelSequence2", ValidationType.CARDINALITY, "OptionExerciseAmountModelSequence2", path, "", error);
		}
		return success("OptionExerciseAmountModelSequence2", ValidationType.CARDINALITY, "OptionExerciseAmountModelSequence2", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmountModelSequence2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmountModelSequence2", ValidationType.CARDINALITY, "OptionExerciseAmountModelSequence2", path, "", res.getError());
				}
				return success("OptionExerciseAmountModelSequence2", ValidationType.CARDINALITY, "OptionExerciseAmountModelSequence2", path, "");
			})
			.collect(toList());
	}

}

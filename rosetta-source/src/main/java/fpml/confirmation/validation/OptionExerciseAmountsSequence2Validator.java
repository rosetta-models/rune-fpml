package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NumberOfOptionsReference;
import fpml.confirmation.OptionExerciseAmountsSequence2;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountsSequence2Validator implements Validator<OptionExerciseAmountsSequence2> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmountsSequence2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("numberOfOptionsReference", (NumberOfOptionsReference) o.getNumberOfOptionsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNumberOfOptions", (BigDecimal) o.getExerciseInNumberOfOptions() != null ? 1 : 0, 1, 1), 
				checkCardinality("outstandingNumberOfOptions", (BigDecimal) o.getOutstandingNumberOfOptions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionExerciseAmountsSequence2> validate(RosettaPath path, OptionExerciseAmountsSequence2 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExerciseAmountsSequence2", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence2", path, "", error);
		}
		return success("OptionExerciseAmountsSequence2", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence2", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmountsSequence2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmountsSequence2", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence2", path, "", res.getError());
				}
				return success("OptionExerciseAmountsSequence2", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence2", path, "");
			})
			.collect(toList());
	}

}

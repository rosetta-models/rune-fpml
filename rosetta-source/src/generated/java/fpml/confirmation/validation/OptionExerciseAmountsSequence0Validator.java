package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Money;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.OptionExerciseAmountsSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountsSequence0Validator implements Validator<OptionExerciseAmountsSequence0> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmountsSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalReference", (NotionalReference) o.getNotionalReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNotionalAmount", (Money) o.getExerciseInNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("outstandingNotionalAmount", (Money) o.getOutstandingNotionalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionExerciseAmountsSequence0> validate(RosettaPath path, OptionExerciseAmountsSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExerciseAmountsSequence0", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence0", path, "", error);
		}
		return success("OptionExerciseAmountsSequence0", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmountsSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmountsSequence0", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence0", path, "", res.getError());
				}
				return success("OptionExerciseAmountsSequence0", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence0", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OptionExerciseAmounts;
import fpml.confirmation.OptionExerciseAmountsSequence0;
import fpml.confirmation.OptionExerciseAmountsSequence1;
import fpml.confirmation.OptionExerciseAmountsSequence2;
import fpml.confirmation.OptionExerciseAmountsSequence3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountsValidator implements Validator<OptionExerciseAmounts> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmounts o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("optionExerciseAmountsSequence0", (OptionExerciseAmountsSequence0) o.getOptionExerciseAmountsSequence0() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExerciseAmountsSequence1", (OptionExerciseAmountsSequence1) o.getOptionExerciseAmountsSequence1() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExerciseAmountsSequence2", (OptionExerciseAmountsSequence2) o.getOptionExerciseAmountsSequence2() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionExerciseAmountsSequence3", (OptionExerciseAmountsSequence3) o.getOptionExerciseAmountsSequence3() != null ? 1 : 0, 0, 1)
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
			return failure("OptionExerciseAmounts", ValidationType.CARDINALITY, "OptionExerciseAmounts", path, "", error);
		}
		return success("OptionExerciseAmounts", ValidationType.CARDINALITY, "OptionExerciseAmounts", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmounts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmounts", ValidationType.CARDINALITY, "OptionExerciseAmounts", path, "", res.getError());
				}
				return success("OptionExerciseAmounts", ValidationType.CARDINALITY, "OptionExerciseAmounts", path, "");
			})
			.collect(toList());
	}

}

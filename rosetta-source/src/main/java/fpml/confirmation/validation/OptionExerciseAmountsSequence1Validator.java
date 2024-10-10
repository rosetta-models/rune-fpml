package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.OptionExerciseAmountsSequence1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptionExerciseAmountsSequence1Validator implements Validator<OptionExerciseAmountsSequence1> {

	private List<ComparisonResult> getComparisonResults(OptionExerciseAmountsSequence1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalScheduleReference", (NotionalReference) o.getNotionalScheduleReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseInNotionalSchedule", (NonNegativeAmountSchedule) o.getExerciseInNotionalSchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("outstandingNotionalSchedule", (NonNegativeAmountSchedule) o.getOutstandingNotionalSchedule() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<OptionExerciseAmountsSequence1> validate(RosettaPath path, OptionExerciseAmountsSequence1 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OptionExerciseAmountsSequence1", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence1", path, "", error);
		}
		return success("OptionExerciseAmountsSequence1", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence1", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExerciseAmountsSequence1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExerciseAmountsSequence1", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence1", path, "", res.getError());
				}
				return success("OptionExerciseAmountsSequence1", ValidationType.CARDINALITY, "OptionExerciseAmountsSequence1", path, "");
			})
			.collect(toList());
	}

}

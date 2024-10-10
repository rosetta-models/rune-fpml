package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationSequence;
import fpml.confirmation.FutureValueAmount;
import fpml.confirmation.Schedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CalculationSequenceValidator implements Validator<CalculationSequence> {

	private List<ComparisonResult> getComparisonResults(CalculationSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedRateSchedule", (Schedule) o.getFixedRateSchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("futureValueNotional", (FutureValueAmount) o.getFutureValueNotional() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CalculationSequence> validate(RosettaPath path, CalculationSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CalculationSequence", ValidationType.CARDINALITY, "CalculationSequence", path, "", error);
		}
		return success("CalculationSequence", ValidationType.CARDINALITY, "CalculationSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationSequence", ValidationType.CARDINALITY, "CalculationSequence", path, "", res.getError());
				}
				return success("CalculationSequence", ValidationType.CARDINALITY, "CalculationSequence", path, "");
			})
			.collect(toList());
	}

}

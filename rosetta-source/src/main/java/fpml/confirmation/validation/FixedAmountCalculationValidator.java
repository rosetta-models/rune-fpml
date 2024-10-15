package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CalculationAmount;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FixedAmountCalculation;
import fpml.confirmation.FixedRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedAmountCalculationValidator implements Validator<FixedAmountCalculation> {

	private List<ComparisonResult> getComparisonResults(FixedAmountCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationAmount", (CalculationAmount) o.getCalculationAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRate", (FixedRate) o.getFixedRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FixedAmountCalculation> validate(RosettaPath path, FixedAmountCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedAmountCalculation", ValidationType.CARDINALITY, "FixedAmountCalculation", path, "", error);
		}
		return success("FixedAmountCalculation", ValidationType.CARDINALITY, "FixedAmountCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedAmountCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedAmountCalculation", ValidationType.CARDINALITY, "FixedAmountCalculation", path, "", res.getError());
				}
				return success("FixedAmountCalculation", ValidationType.CARDINALITY, "FixedAmountCalculation", path, "");
			})
			.collect(toList());
	}

}

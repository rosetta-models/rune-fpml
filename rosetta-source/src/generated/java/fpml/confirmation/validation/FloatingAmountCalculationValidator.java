package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.CalculationAmount;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingAmountCalculation;
import fpml.confirmation.FloatingRateCalculation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingAmountCalculationValidator implements Validator<FloatingAmountCalculation> {

	private List<ComparisonResult> getComparisonResults(FloatingAmountCalculation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationAmount", (CalculationAmount) o.getCalculationAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRate", (FloatingRateCalculation) o.getFloatingRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialFixingDate", (Date) o.getInitialFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalFixingDate", (AdjustableDate) o.getFinalFixingDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FloatingAmountCalculation> validate(RosettaPath path, FloatingAmountCalculation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingAmountCalculation", ValidationType.CARDINALITY, "FloatingAmountCalculation", path, "", error);
		}
		return success("FloatingAmountCalculation", ValidationType.CARDINALITY, "FloatingAmountCalculation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingAmountCalculation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingAmountCalculation", ValidationType.CARDINALITY, "FloatingAmountCalculation", path, "", res.getError());
				}
				return success("FloatingAmountCalculation", ValidationType.CARDINALITY, "FloatingAmountCalculation", path, "");
			})
			.collect(toList());
	}

}

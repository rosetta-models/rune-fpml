package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FixedAmountCalculation;
import fpml.confirmation.FloatingAmountCalculation;
import fpml.confirmation.Money;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodicPayment;
import fpml.confirmation.RollConventionEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PeriodicPaymentValidator implements Validator<PeriodicPayment> {

	private List<ComparisonResult> getComparisonResults(PeriodicPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstPeriodStartDate", (Date) o.getFirstPeriodStartDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstPaymentDate", (Date) o.getFirstPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("lastRegularPaymentDate", (Date) o.getLastRegularPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("rollConvention", (RollConventionEnum) o.getRollConvention() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedAmount", (Money) o.getFixedAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedAmountCalculation", (FixedAmountCalculation) o.getFixedAmountCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingAmountCalculation", (FloatingAmountCalculation) o.getFloatingAmountCalculation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PeriodicPayment> validate(RosettaPath path, PeriodicPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PeriodicPayment", ValidationType.CARDINALITY, "PeriodicPayment", path, "", error);
		}
		return success("PeriodicPayment", ValidationType.CARDINALITY, "PeriodicPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodicPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PeriodicPayment", ValidationType.CARDINALITY, "PeriodicPayment", path, "", res.getError());
				}
				return success("PeriodicPayment", ValidationType.CARDINALITY, "PeriodicPayment", path, "");
			})
			.collect(toList());
	}

}

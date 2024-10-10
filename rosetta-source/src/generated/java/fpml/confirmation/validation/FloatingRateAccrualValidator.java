package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateAccrual;
import fpml.confirmation.FloatingRateAccrualSequence;
import fpml.confirmation.FloatingRateIndexLoanModel;
import fpml.confirmation.PaymentProjection;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodWithDaysModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateAccrualValidator implements Validator<FloatingRateAccrual> {

	private List<ComparisonResult> getComparisonResults(FloatingRateAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndexLoanModel", (FloatingRateIndexLoanModel) o.getFloatingRateIndexLoanModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("spread", (BigDecimal) o.getSpread() != null ? 1 : 0, 1, 1), 
				checkCardinality("pikSpread", (BigDecimal) o.getPikSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodWithDaysModel", (PeriodWithDaysModel) o.getPeriodWithDaysModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("floatingRateAccrualSequence", (FloatingRateAccrualSequence) o.getFloatingRateAccrualSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentProjection", (PaymentProjection) o.getPaymentProjection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FloatingRateAccrual> validate(RosettaPath path, FloatingRateAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateAccrual", ValidationType.CARDINALITY, "FloatingRateAccrual", path, "", error);
		}
		return success("FloatingRateAccrual", ValidationType.CARDINALITY, "FloatingRateAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateAccrual", ValidationType.CARDINALITY, "FloatingRateAccrual", path, "", res.getError());
				}
				return success("FloatingRateAccrual", ValidationType.CARDINALITY, "FloatingRateAccrual", path, "");
			})
			.collect(toList());
	}

}

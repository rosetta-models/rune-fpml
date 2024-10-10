package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FixedRateAccrual;
import fpml.confirmation.FixedRateAccrualSequence;
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

public class FixedRateAccrualValidator implements Validator<FixedRateAccrual> {

	private List<ComparisonResult> getComparisonResults(FixedRateAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("pikSpread", (BigDecimal) o.getPikSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodWithDaysModel", (PeriodWithDaysModel) o.getPeriodWithDaysModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixedRateAccrualSequence", (FixedRateAccrualSequence) o.getFixedRateAccrualSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentProjection", (PaymentProjection) o.getPaymentProjection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FixedRateAccrual> validate(RosettaPath path, FixedRateAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedRateAccrual", ValidationType.CARDINALITY, "FixedRateAccrual", path, "", error);
		}
		return success("FixedRateAccrual", ValidationType.CARDINALITY, "FixedRateAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRateAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRateAccrual", ValidationType.CARDINALITY, "FixedRateAccrual", path, "", res.getError());
				}
				return success("FixedRateAccrual", ValidationType.CARDINALITY, "FixedRateAccrual", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.Currency;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateIndexLoanModel;
import fpml.confirmation.FloatingRateOption;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.RateLimits;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateOptionValidator implements Validator<FloatingRateOption> {

	private List<ComparisonResult> getComparisonResults(FloatingRateOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("accrualOptionId", (AccrualTypeId) o.getAccrualOptionId() != null ? 1 : 0, 1, 1), 
				checkCardinality("dayCountFraction", (DayCountFraction) o.getDayCountFraction() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentFrequency", (Period) o.getPaymentFrequency() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndexLoanModel", (FloatingRateIndexLoanModel) o.getFloatingRateIndexLoanModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("spread", (BigDecimal) o.getSpread() != null ? 1 : 0, 1, 1), 
				checkCardinality("pikSpread", (BigDecimal) o.getPikSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("periodModel", (PeriodModel) o.getPeriodModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("baseRateLimits", (RateLimits) o.getBaseRateLimits() != null ? 1 : 0, 0, 1), 
				checkCardinality("allInRateLimits", (RateLimits) o.getAllInRateLimits() != null ? 1 : 0, 0, 1), 
				checkCardinality("drawdownNoticeDays", (Integer) o.getDrawdownNoticeDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxRateSetNoticeDays", (Integer) o.getFxRateSetNoticeDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("rateSetNoticeDays", (Integer) o.getRateSetNoticeDays() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FloatingRateOption> validate(RosettaPath path, FloatingRateOption o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateOption", ValidationType.CARDINALITY, "FloatingRateOption", path, "", error);
		}
		return success("FloatingRateOption", ValidationType.CARDINALITY, "FloatingRateOption", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateOption", ValidationType.CARDINALITY, "FloatingRateOption", path, "", res.getError());
				}
				return success("FloatingRateOption", ValidationType.CARDINALITY, "FloatingRateOption", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAccrualSettlementPeriod;
import fpml.confirmation.FxAccrualSettlementPeriodPayoff;
import fpml.confirmation.FxSettlementPeriodBarrier;
import fpml.confirmation.SettlementPeriodFixingDates;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodValidator implements Validator<FxAccrualSettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expiryDate", (Date) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (Date) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("payoff", (List<? extends FxAccrualSettlementPeriodPayoff>) o.getPayoff() == null ? 0 : ((List<? extends FxAccrualSettlementPeriodPayoff>) o.getPayoff()).size(), 1, 0), 
				checkCardinality("accrualFactor", (BigDecimal) o.getAccrualFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("barrier", (FxSettlementPeriodBarrier) o.getBarrier() != null ? 1 : 0, 0, 1), 
				checkCardinality("accrualFixingDates", (SettlementPeriodFixingDates) o.getAccrualFixingDates() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxAccrualSettlementPeriod> validate(RosettaPath path, FxAccrualSettlementPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAccrualSettlementPeriod", ValidationType.CARDINALITY, "FxAccrualSettlementPeriod", path, "", error);
		}
		return success("FxAccrualSettlementPeriod", ValidationType.CARDINALITY, "FxAccrualSettlementPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriod", ValidationType.CARDINALITY, "FxAccrualSettlementPeriod", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriod", ValidationType.CARDINALITY, "FxAccrualSettlementPeriod", path, "");
			})
			.collect(toList());
	}

}

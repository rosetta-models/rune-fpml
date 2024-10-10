package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CashPriceMethod;
import fpml.confirmation.CashSettlement;
import fpml.confirmation.CashSettlementPaymentDate;
import fpml.confirmation.CrossCurrencyMethod;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.YieldCurveMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CashSettlementValidator implements Validator<CashSettlement> {

	private List<ComparisonResult> getComparisonResults(CashSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashSettlementValuationTime", (BusinessCenterTime) o.getCashSettlementValuationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementValuationDate", (RelativeDateOffset) o.getCashSettlementValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementPaymentDate", (CashSettlementPaymentDate) o.getCashSettlementPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashPriceMethod", (CashPriceMethod) o.getCashPriceMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashPriceAlternateMethod", (CashPriceMethod) o.getCashPriceAlternateMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("parYieldCurveAdjustedMethod", (YieldCurveMethod) o.getParYieldCurveAdjustedMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("zeroCouponYieldAdjustedMethod", (YieldCurveMethod) o.getZeroCouponYieldAdjustedMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("parYieldCurveUnadjustedMethod", (YieldCurveMethod) o.getParYieldCurveUnadjustedMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("crossCurrencyMethod", (CrossCurrencyMethod) o.getCrossCurrencyMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralizedCashPriceMethod", (YieldCurveMethod) o.getCollateralizedCashPriceMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CashSettlement> validate(RosettaPath path, CashSettlement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CashSettlement", ValidationType.CARDINALITY, "CashSettlement", path, "", error);
		}
		return success("CashSettlement", ValidationType.CARDINALITY, "CashSettlement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashSettlement", ValidationType.CARDINALITY, "CashSettlement", path, "", res.getError());
				}
				return success("CashSettlement", ValidationType.CARDINALITY, "CashSettlement", path, "");
			})
			.collect(toList());
	}

}

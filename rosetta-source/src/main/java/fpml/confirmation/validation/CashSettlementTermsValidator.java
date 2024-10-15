package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CashSettlementTerms;
import fpml.confirmation.Currency;
import fpml.confirmation.FixedRecoveryModel;
import fpml.confirmation.Money;
import fpml.confirmation.QuotationRateTypeEnum;
import fpml.confirmation.ValuationDate;
import fpml.confirmation.ValuationMethodEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CashSettlementTermsValidator implements Validator<CashSettlementTerms> {

	private List<ComparisonResult> getComparisonResults(CashSettlementTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDate", (ValuationDate) o.getValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationTime", (BusinessCenterTime) o.getValuationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationMethod", (QuotationRateTypeEnum) o.getQuotationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationAmount", (Money) o.getQuotationAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("minimumQuotationAmount", (Money) o.getMinimumQuotationAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementBusinessDays", (Integer) o.getCashSettlementBusinessDays() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRecoveryModel", (FixedRecoveryModel) o.getFixedRecoveryModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedSettlement", (Boolean) o.getFixedSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("accruedInterest", (Boolean) o.getAccruedInterest() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationMethod", (ValuationMethodEnum) o.getValuationMethod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CashSettlementTerms> validate(RosettaPath path, CashSettlementTerms o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CashSettlementTerms", ValidationType.CARDINALITY, "CashSettlementTerms", path, "", error);
		}
		return success("CashSettlementTerms", ValidationType.CARDINALITY, "CashSettlementTerms", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlementTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashSettlementTerms", ValidationType.CARDINALITY, "CashSettlementTerms", path, "", res.getError());
				}
				return success("CashSettlementTerms", ValidationType.CARDINALITY, "CashSettlementTerms", path, "");
			})
			.collect(toList());
	}

}

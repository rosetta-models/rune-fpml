package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashSettlementReferenceBanks;
import fpml.confirmation.CrossCurrencyMethod;
import fpml.confirmation.Currency;
import fpml.confirmation.QuotationRateTypeEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CrossCurrencyMethodValidator implements Validator<CrossCurrencyMethod> {

	private List<ComparisonResult> getComparisonResults(CrossCurrencyMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashSettlementReferenceBanks", (CashSettlementReferenceBanks) o.getCashSettlementReferenceBanks() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementCurrency", (List<? extends Currency>) o.getCashSettlementCurrency() == null ? 0 : ((List<? extends Currency>) o.getCashSettlementCurrency()).size(), 1, 2), 
				checkCardinality("quotationRateType", (QuotationRateTypeEnum) o.getQuotationRateType() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CrossCurrencyMethod> validate(RosettaPath path, CrossCurrencyMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CrossCurrencyMethod", ValidationType.CARDINALITY, "CrossCurrencyMethod", path, "", error);
		}
		return success("CrossCurrencyMethod", ValidationType.CARDINALITY, "CrossCurrencyMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CrossCurrencyMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CrossCurrencyMethod", ValidationType.CARDINALITY, "CrossCurrencyMethod", path, "", res.getError());
				}
				return success("CrossCurrencyMethod", ValidationType.CARDINALITY, "CrossCurrencyMethod", path, "");
			})
			.collect(toList());
	}

}

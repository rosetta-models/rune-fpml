package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AmountReference;
import fpml.confirmation.Commission;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.PriceSequence;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.ReturnLegValuationPrice;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnLegValuationPriceValidator implements Validator<ReturnLegValuationPrice> {

	private List<ComparisonResult> getComparisonResults(ReturnLegValuationPrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commission", (Commission) o.getCommission() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceSequence", (PriceSequence) o.getPriceSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("amountRelativeTo", (AmountReference) o.getAmountRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityPriceModel", (EquityPriceModel) o.getEquityPriceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleanNetPrice", (BigDecimal) o.getCleanNetPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationCharacteristics", (QuotationCharacteristics) o.getQuotationCharacteristics() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationRules", (EquityValuation) o.getValuationRules() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReturnLegValuationPrice> validate(RosettaPath path, ReturnLegValuationPrice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnLegValuationPrice", ValidationType.CARDINALITY, "ReturnLegValuationPrice", path, "", error);
		}
		return success("ReturnLegValuationPrice", ValidationType.CARDINALITY, "ReturnLegValuationPrice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnLegValuationPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnLegValuationPrice", ValidationType.CARDINALITY, "ReturnLegValuationPrice", path, "", res.getError());
				}
				return success("ReturnLegValuationPrice", ValidationType.CARDINALITY, "ReturnLegValuationPrice", path, "");
			})
			.collect(toList());
	}

}

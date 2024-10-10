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
import fpml.confirmation.Price;
import fpml.confirmation.PriceSequence;
import fpml.confirmation.QuotationCharacteristics;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PriceValidator implements Validator<Price> {

	private List<ComparisonResult> getComparisonResults(Price o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commission", (Commission) o.getCommission() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceSequence", (PriceSequence) o.getPriceSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("amountRelativeTo", (AmountReference) o.getAmountRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("equityPriceModel", (EquityPriceModel) o.getEquityPriceModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleanNetPrice", (BigDecimal) o.getCleanNetPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationCharacteristics", (QuotationCharacteristics) o.getQuotationCharacteristics() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Price> validate(RosettaPath path, Price o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Price", ValidationType.CARDINALITY, "Price", path, "", error);
		}
		return success("Price", ValidationType.CARDINALITY, "Price", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Price o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Price", ValidationType.CARDINALITY, "Price", path, "", res.getError());
				}
				return success("Price", ValidationType.CARDINALITY, "Price", path, "");
			})
			.collect(toList());
	}

}

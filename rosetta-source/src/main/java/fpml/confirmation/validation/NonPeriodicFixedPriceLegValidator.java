package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonPeriodicFixedPriceLeg;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.QuantityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NonPeriodicFixedPriceLegValidator implements Validator<NonPeriodicFixedPriceLeg> {

	private List<ComparisonResult> getComparisonResults(NonPeriodicFixedPriceLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixedPrice", (FixedPrice) o.getFixedPrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("totalPrice", (NonNegativeMoney) o.getTotalPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityReference", (QuantityReference) o.getQuantityReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodityPaymentDatesModel", (CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<NonPeriodicFixedPriceLeg> validate(RosettaPath path, NonPeriodicFixedPriceLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NonPeriodicFixedPriceLeg", ValidationType.CARDINALITY, "NonPeriodicFixedPriceLeg", path, "", error);
		}
		return success("NonPeriodicFixedPriceLeg", ValidationType.CARDINALITY, "NonPeriodicFixedPriceLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonPeriodicFixedPriceLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonPeriodicFixedPriceLeg", ValidationType.CARDINALITY, "NonPeriodicFixedPriceLeg", path, "", res.getError());
				}
				return success("NonPeriodicFixedPriceLeg", ValidationType.CARDINALITY, "NonPeriodicFixedPriceLeg", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Asset;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.InstrumentTradeDetails;
import fpml.confirmation.InstrumentTradePricing;
import fpml.confirmation.InstrumentTradePrincipal;
import fpml.confirmation.InstrumentTradeQuantity;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InstrumentTradeDetailsValidator implements Validator<InstrumentTradeDetails> {

	private List<ComparisonResult> getComparisonResults(InstrumentTradeDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("underlyingAsset", (Asset) o.getUnderlyingAsset() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantity", (InstrumentTradeQuantity) o.getQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricing", (InstrumentTradePricing) o.getPricing() != null ? 1 : 0, 0, 1), 
				checkCardinality("principal", (InstrumentTradePrincipal) o.getPrincipal() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<InstrumentTradeDetails> validate(RosettaPath path, InstrumentTradeDetails o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InstrumentTradeDetails", ValidationType.CARDINALITY, "InstrumentTradeDetails", path, "", error);
		}
		return success("InstrumentTradeDetails", ValidationType.CARDINALITY, "InstrumentTradeDetails", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InstrumentTradeDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InstrumentTradeDetails", ValidationType.CARDINALITY, "InstrumentTradeDetails", path, "", res.getError());
				}
				return success("InstrumentTradeDetails", ValidationType.CARDINALITY, "InstrumentTradeDetails", path, "");
			})
			.collect(toList());
	}

}

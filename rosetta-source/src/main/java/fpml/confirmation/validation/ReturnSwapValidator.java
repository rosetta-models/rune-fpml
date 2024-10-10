package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.PrincipalExchangeFeatures;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ReturnSwap;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapValidator implements Validator<ReturnSwap> {

	private List<ComparisonResult> getComparisonResults(ReturnSwap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("returnSwapLeg", (List<? extends DirectionalLeg>) o.getReturnSwapLeg() == null ? 0 : ((List<? extends DirectionalLeg>) o.getReturnSwapLeg()).size(), 1, 0), 
				checkCardinality("principalExchangeFeatures", (PrincipalExchangeFeatures) o.getPrincipalExchangeFeatures() != null ? 1 : 0, 0, 1), 
				checkCardinality("extraordinaryEvents", (ExtraordinaryEvents) o.getExtraordinaryEvents() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReturnSwap> validate(RosettaPath path, ReturnSwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwap", ValidationType.CARDINALITY, "ReturnSwap", path, "", error);
		}
		return success("ReturnSwap", ValidationType.CARDINALITY, "ReturnSwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwap", ValidationType.CARDINALITY, "ReturnSwap", path, "", res.getError());
				}
				return success("ReturnSwap", ValidationType.CARDINALITY, "ReturnSwap", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerAmounts;
import fpml.confirmation.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BuyerSellerAmountsValidator implements Validator<BuyerSellerAmounts> {

	private List<ComparisonResult> getComparisonResults(BuyerSellerAmounts o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("buyersAmount", (NonNegativeMoney) o.getBuyersAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellersAmount", (NonNegativeMoney) o.getSellersAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<BuyerSellerAmounts> validate(RosettaPath path, BuyerSellerAmounts o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BuyerSellerAmounts", ValidationType.CARDINALITY, "BuyerSellerAmounts", path, "", error);
		}
		return success("BuyerSellerAmounts", ValidationType.CARDINALITY, "BuyerSellerAmounts", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BuyerSellerAmounts o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BuyerSellerAmounts", ValidationType.CARDINALITY, "BuyerSellerAmounts", path, "", res.getError());
				}
				return success("BuyerSellerAmounts", ValidationType.CARDINALITY, "BuyerSellerAmounts", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IssuerId;
import fpml.confirmation.ProductComponentIdentifier;
import fpml.confirmation.ProductReference;
import fpml.confirmation.TradeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProductComponentIdentifierValidator implements Validator<ProductComponentIdentifier> {

	private List<ComparisonResult> getComparisonResults(ProductComponentIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("premiumProductReference", (ProductReference) o.getPremiumProductReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("issuer", (IssuerId) o.getIssuer() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeId", (TradeId) o.getTradeId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ProductComponentIdentifier> validate(RosettaPath path, ProductComponentIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProductComponentIdentifier", ValidationType.CARDINALITY, "ProductComponentIdentifier", path, "", error);
		}
		return success("ProductComponentIdentifier", ValidationType.CARDINALITY, "ProductComponentIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductComponentIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductComponentIdentifier", ValidationType.CARDINALITY, "ProductComponentIdentifier", path, "", res.getError());
				}
				return success("ProductComponentIdentifier", ValidationType.CARDINALITY, "ProductComponentIdentifier", path, "");
			})
			.collect(toList());
	}

}

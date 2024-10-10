package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ProductId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProductIdValidator implements Validator<ProductId> {

	private List<ComparisonResult> getComparisonResults(ProductId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("productIdScheme", (String) o.getProductIdScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ProductId> validate(RosettaPath path, ProductId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProductId", ValidationType.CARDINALITY, "ProductId", path, "", error);
		}
		return success("ProductId", ValidationType.CARDINALITY, "ProductId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductId", ValidationType.CARDINALITY, "ProductId", path, "", res.getError());
				}
				return success("ProductId", ValidationType.CARDINALITY, "ProductId", path, "");
			})
			.collect(toList());
	}

}

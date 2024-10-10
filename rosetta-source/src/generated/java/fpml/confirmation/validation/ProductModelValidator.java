package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AssetClass;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProductModelValidator implements Validator<ProductModel> {

	private List<ComparisonResult> getComparisonResults(ProductModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ProductModel> validate(RosettaPath path, ProductModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProductModel", ValidationType.CARDINALITY, "ProductModel", path, "", error);
		}
		return success("ProductModel", ValidationType.CARDINALITY, "ProductModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductModel", ValidationType.CARDINALITY, "ProductModel", path, "", res.getError());
				}
				return success("ProductModel", ValidationType.CARDINALITY, "ProductModel", path, "");
			})
			.collect(toList());
	}

}

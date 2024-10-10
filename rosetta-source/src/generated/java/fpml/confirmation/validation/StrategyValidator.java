package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Product;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ProductReference;
import fpml.confirmation.Strategy;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StrategyValidator implements Validator<Strategy> {

	private List<ComparisonResult> getComparisonResults(Strategy o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("premiumProductReference", (ProductReference) o.getPremiumProductReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("product", (List<? extends Product>) o.getProduct() == null ? 0 : ((List<? extends Product>) o.getProduct()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<Strategy> validate(RosettaPath path, Strategy o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Strategy", ValidationType.CARDINALITY, "Strategy", path, "", error);
		}
		return success("Strategy", ValidationType.CARDINALITY, "Strategy", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Strategy o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Strategy", ValidationType.CARDINALITY, "Strategy", path, "", res.getError());
				}
				return success("Strategy", ValidationType.CARDINALITY, "Strategy", path, "");
			})
			.collect(toList());
	}

}

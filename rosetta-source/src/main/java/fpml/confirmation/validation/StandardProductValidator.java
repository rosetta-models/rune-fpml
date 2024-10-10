package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CashflowNotional;
import fpml.confirmation.ProductModel;
import fpml.confirmation.StandardProduct;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StandardProductValidator implements Validator<StandardProduct> {

	private List<ComparisonResult> getComparisonResults(StandardProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("notional", (CashflowNotional) o.getNotional() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<StandardProduct> validate(RosettaPath path, StandardProduct o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StandardProduct", ValidationType.CARDINALITY, "StandardProduct", path, "", error);
		}
		return success("StandardProduct", ValidationType.CARDINALITY, "StandardProduct", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StandardProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StandardProduct", ValidationType.CARDINALITY, "StandardProduct", path, "", res.getError());
				}
				return success("StandardProduct", ValidationType.CARDINALITY, "StandardProduct", path, "");
			})
			.collect(toList());
	}

}

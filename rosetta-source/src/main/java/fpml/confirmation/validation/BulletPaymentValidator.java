package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BulletPayment;
import fpml.confirmation.Payment;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BulletPaymentValidator implements Validator<BulletPayment> {

	private List<ComparisonResult> getComparisonResults(BulletPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payment", (Payment) o.getPayment() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<BulletPayment> validate(RosettaPath path, BulletPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BulletPayment", ValidationType.CARDINALITY, "BulletPayment", path, "", error);
		}
		return success("BulletPayment", ValidationType.CARDINALITY, "BulletPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BulletPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BulletPayment", ValidationType.CARDINALITY, "BulletPayment", path, "", res.getError());
				}
				return success("BulletPayment", ValidationType.CARDINALITY, "BulletPayment", path, "");
			})
			.collect(toList());
	}

}

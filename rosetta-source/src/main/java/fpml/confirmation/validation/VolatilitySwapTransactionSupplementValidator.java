package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.ProductModel;
import fpml.confirmation.VolatilityLeg;
import fpml.confirmation.VolatilitySwapTransactionSupplement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VolatilitySwapTransactionSupplementValidator implements Validator<VolatilitySwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(VolatilitySwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatilityLeg", (List<? extends VolatilityLeg>) o.getVolatilityLeg() == null ? 0 : ((List<? extends VolatilityLeg>) o.getVolatilityLeg()).size(), 1, 0), 
				checkCardinality("equityUnderlyerProvisionsModel", (EquityUnderlyerProvisionsModel) o.getEquityUnderlyerProvisionsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<VolatilitySwapTransactionSupplement> validate(RosettaPath path, VolatilitySwapTransactionSupplement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilitySwapTransactionSupplement", ValidationType.CARDINALITY, "VolatilitySwapTransactionSupplement", path, "", error);
		}
		return success("VolatilitySwapTransactionSupplement", ValidationType.CARDINALITY, "VolatilitySwapTransactionSupplement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilitySwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilitySwapTransactionSupplement", ValidationType.CARDINALITY, "VolatilitySwapTransactionSupplement", path, "", res.getError());
				}
				return success("VolatilitySwapTransactionSupplement", ValidationType.CARDINALITY, "VolatilitySwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}

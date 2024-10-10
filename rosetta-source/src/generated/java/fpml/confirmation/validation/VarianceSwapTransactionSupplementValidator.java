package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.ProductModel;
import fpml.confirmation.VarianceLeg;
import fpml.confirmation.VarianceSwapTransactionSupplement;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VarianceSwapTransactionSupplementValidator implements Validator<VarianceSwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(VarianceSwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("varianceLeg", (List<? extends VarianceLeg>) o.getVarianceLeg() == null ? 0 : ((List<? extends VarianceLeg>) o.getVarianceLeg()).size(), 1, 0), 
				checkCardinality("equityUnderlyerProvisionsModel", (EquityUnderlyerProvisionsModel) o.getEquityUnderlyerProvisionsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<VarianceSwapTransactionSupplement> validate(RosettaPath path, VarianceSwapTransactionSupplement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VarianceSwapTransactionSupplement", ValidationType.CARDINALITY, "VarianceSwapTransactionSupplement", path, "", error);
		}
		return success("VarianceSwapTransactionSupplement", ValidationType.CARDINALITY, "VarianceSwapTransactionSupplement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VarianceSwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VarianceSwapTransactionSupplement", ValidationType.CARDINALITY, "VarianceSwapTransactionSupplement", path, "", res.getError());
				}
				return success("VarianceSwapTransactionSupplement", ValidationType.CARDINALITY, "VarianceSwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DividendLeg;
import fpml.confirmation.DividendSwapTransactionSupplement;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.FixedPaymentLeg;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendSwapTransactionSupplementValidator implements Validator<DividendSwapTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(DividendSwapTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendLeg", (DividendLeg) o.getDividendLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixedLeg", (FixedPaymentLeg) o.getFixedLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityUnderlyerProvisionsModel", (EquityUnderlyerProvisionsModel) o.getEquityUnderlyerProvisionsModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DividendSwapTransactionSupplement> validate(RosettaPath path, DividendSwapTransactionSupplement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendSwapTransactionSupplement", ValidationType.CARDINALITY, "DividendSwapTransactionSupplement", path, "", error);
		}
		return success("DividendSwapTransactionSupplement", ValidationType.CARDINALITY, "DividendSwapTransactionSupplement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendSwapTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendSwapTransactionSupplement", ValidationType.CARDINALITY, "DividendSwapTransactionSupplement", path, "", res.getError());
				}
				return success("DividendSwapTransactionSupplement", ValidationType.CARDINALITY, "DividendSwapTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}

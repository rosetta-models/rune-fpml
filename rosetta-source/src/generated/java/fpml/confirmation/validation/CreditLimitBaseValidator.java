package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditLimitBase;
import fpml.confirmation.Currency;
import fpml.confirmation.LimitId;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditLimitBaseValidator implements Validator<CreditLimitBase> {

	private List<ComparisonResult> getComparisonResults(CreditLimitBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("limitId", (LimitId) o.getLimitId() != null ? 1 : 0, 1, 1), 
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("tenor", (Period) o.getTenor() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CreditLimitBase> validate(RosettaPath path, CreditLimitBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditLimitBase", ValidationType.CARDINALITY, "CreditLimitBase", path, "", error);
		}
		return success("CreditLimitBase", ValidationType.CARDINALITY, "CreditLimitBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimitBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimitBase", ValidationType.CARDINALITY, "CreditLimitBase", path, "", res.getError());
				}
				return success("CreditLimitBase", ValidationType.CARDINALITY, "CreditLimitBase", path, "");
			})
			.collect(toList());
	}

}

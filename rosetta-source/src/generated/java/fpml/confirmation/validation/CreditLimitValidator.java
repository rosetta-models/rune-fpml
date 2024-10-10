package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CreditLimit;
import fpml.confirmation.Currency;
import fpml.confirmation.LimitApplicable;
import fpml.confirmation.LimitId;
import fpml.confirmation.Period;
import fpml.confirmation.ProductModel;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CreditLimitValidator implements Validator<CreditLimit> {

	private List<ComparisonResult> getComparisonResults(CreditLimit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("limitId", (LimitId) o.getLimitId() != null ? 1 : 0, 1, 1), 
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("tenor", (Period) o.getTenor() != null ? 1 : 0, 1, 1), 
				checkCardinality("limitApplicable", (List<? extends LimitApplicable>) o.getLimitApplicable() == null ? 0 : ((List<? extends LimitApplicable>) o.getLimitApplicable()).size(), 1, 0), 
				checkCardinality("expirationDate", (ZonedDateTime) o.getExpirationDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<CreditLimit> validate(RosettaPath path, CreditLimit o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CreditLimit", ValidationType.CARDINALITY, "CreditLimit", path, "", error);
		}
		return success("CreditLimit", ValidationType.CARDINALITY, "CreditLimit", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditLimit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditLimit", ValidationType.CARDINALITY, "CreditLimit", path, "", res.getError());
				}
				return success("CreditLimit", ValidationType.CARDINALITY, "CreditLimit", path, "");
			})
			.collect(toList());
	}

}

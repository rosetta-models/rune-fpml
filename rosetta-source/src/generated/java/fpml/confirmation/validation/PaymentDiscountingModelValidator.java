package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Money;
import fpml.confirmation.PaymentDiscountingModel;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PaymentDiscountingModelValidator implements Validator<PaymentDiscountingModel> {

	private List<ComparisonResult> getComparisonResults(PaymentDiscountingModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("discountFactor", (BigDecimal) o.getDiscountFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("presentValueAmount", (Money) o.getPresentValueAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PaymentDiscountingModel> validate(RosettaPath path, PaymentDiscountingModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PaymentDiscountingModel", ValidationType.CARDINALITY, "PaymentDiscountingModel", path, "", error);
		}
		return success("PaymentDiscountingModel", ValidationType.CARDINALITY, "PaymentDiscountingModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDiscountingModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentDiscountingModel", ValidationType.CARDINALITY, "PaymentDiscountingModel", path, "", res.getError());
				}
				return success("PaymentDiscountingModel", ValidationType.CARDINALITY, "PaymentDiscountingModel", path, "");
			})
			.collect(toList());
	}

}

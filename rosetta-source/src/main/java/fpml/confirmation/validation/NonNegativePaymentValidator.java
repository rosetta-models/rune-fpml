package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NonNegativePaymentValidator implements Validator<NonNegativePayment> {

	private List<ComparisonResult> getComparisonResults(NonNegativePayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentDate", (AdjustableOrRelativeDate) o.getPaymentDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentAmount", (NonNegativeMoney) o.getPaymentAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<NonNegativePayment> validate(RosettaPath path, NonNegativePayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NonNegativePayment", ValidationType.CARDINALITY, "NonNegativePayment", path, "", error);
		}
		return success("NonNegativePayment", ValidationType.CARDINALITY, "NonNegativePayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonNegativePayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonNegativePayment", ValidationType.CARDINALITY, "NonNegativePayment", path, "", res.getError());
				}
				return success("NonNegativePayment", ValidationType.CARDINALITY, "NonNegativePayment", path, "");
			})
			.collect(toList());
	}

}

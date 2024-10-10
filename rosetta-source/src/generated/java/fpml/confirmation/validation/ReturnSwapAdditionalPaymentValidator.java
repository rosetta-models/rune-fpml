package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdditionalPaymentAmount;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentType;
import fpml.confirmation.ReturnSwapAdditionalPayment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapAdditionalPaymentValidator implements Validator<ReturnSwapAdditionalPayment> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapAdditionalPayment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("additionalPaymentAmount", (AdditionalPaymentAmount) o.getAdditionalPaymentAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("additionalPaymentDate", (AdjustableOrRelativeDate) o.getAdditionalPaymentDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentType", (PaymentType) o.getPaymentType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReturnSwapAdditionalPayment> validate(RosettaPath path, ReturnSwapAdditionalPayment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapAdditionalPayment", ValidationType.CARDINALITY, "ReturnSwapAdditionalPayment", path, "", error);
		}
		return success("ReturnSwapAdditionalPayment", ValidationType.CARDINALITY, "ReturnSwapAdditionalPayment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapAdditionalPayment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapAdditionalPayment", ValidationType.CARDINALITY, "ReturnSwapAdditionalPayment", path, "", res.getError());
				}
				return success("ReturnSwapAdditionalPayment", ValidationType.CARDINALITY, "ReturnSwapAdditionalPayment", path, "");
			})
			.collect(toList());
	}

}

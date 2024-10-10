package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Money;
import fpml.confirmation.PaymentDetailSequence;
import fpml.confirmation.PaymentRule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PaymentDetailSequenceValidator implements Validator<PaymentDetailSequence> {

	private List<ComparisonResult> getComparisonResults(PaymentDetailSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentRule", (PaymentRule) o.getPaymentRule() != null ? 1 : 0, 1, 1), 
				checkCardinality("paymentAmount", (Money) o.getPaymentAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PaymentDetailSequence> validate(RosettaPath path, PaymentDetailSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PaymentDetailSequence", ValidationType.CARDINALITY, "PaymentDetailSequence", path, "", error);
		}
		return success("PaymentDetailSequence", ValidationType.CARDINALITY, "PaymentDetailSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDetailSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentDetailSequence", ValidationType.CARDINALITY, "PaymentDetailSequence", path, "", res.getError());
				}
				return success("PaymentDetailSequence", ValidationType.CARDINALITY, "PaymentDetailSequence", path, "");
			})
			.collect(toList());
	}

}

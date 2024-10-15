package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PaymentDetailSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PaymentDetailSequenceTypeFormatValidator implements Validator<PaymentDetailSequence> {

	private List<ComparisonResult> getComparisonResults(PaymentDetailSequence o) {
		return Lists.<ComparisonResult>newArrayList(
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
			return failure("PaymentDetailSequence", ValidationType.TYPE_FORMAT, "PaymentDetailSequence", path, "", error);
		}
		return success("PaymentDetailSequence", ValidationType.TYPE_FORMAT, "PaymentDetailSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDetailSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentDetailSequence", ValidationType.TYPE_FORMAT, "PaymentDetailSequence", path, "", res.getError());
				}
				return success("PaymentDetailSequence", ValidationType.TYPE_FORMAT, "PaymentDetailSequence", path, "");
			})
			.collect(toList());
	}

}

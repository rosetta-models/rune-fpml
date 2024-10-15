package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PaymentDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PaymentDetailsTypeFormatValidator implements Validator<PaymentDetails> {

	private List<ComparisonResult> getComparisonResults(PaymentDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PaymentDetails> validate(RosettaPath path, PaymentDetails o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PaymentDetails", ValidationType.TYPE_FORMAT, "PaymentDetails", path, "", error);
		}
		return success("PaymentDetails", ValidationType.TYPE_FORMAT, "PaymentDetails", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentDetails", ValidationType.TYPE_FORMAT, "PaymentDetails", path, "", res.getError());
				}
				return success("PaymentDetails", ValidationType.TYPE_FORMAT, "PaymentDetails", path, "");
			})
			.collect(toList());
	}

}

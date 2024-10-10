package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PaymentDatesReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PaymentDatesReferenceTypeFormatValidator implements Validator<PaymentDatesReference> {

	private List<ComparisonResult> getComparisonResults(PaymentDatesReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PaymentDatesReference> validate(RosettaPath path, PaymentDatesReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PaymentDatesReference", ValidationType.TYPE_FORMAT, "PaymentDatesReference", path, "", error);
		}
		return success("PaymentDatesReference", ValidationType.TYPE_FORMAT, "PaymentDatesReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentDatesReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentDatesReference", ValidationType.TYPE_FORMAT, "PaymentDatesReference", path, "", res.getError());
				}
				return success("PaymentDatesReference", ValidationType.TYPE_FORMAT, "PaymentDatesReference", path, "");
			})
			.collect(toList());
	}

}

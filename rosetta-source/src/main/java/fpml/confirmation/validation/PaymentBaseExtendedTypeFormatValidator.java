package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PaymentBaseExtended;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PaymentBaseExtendedTypeFormatValidator implements Validator<PaymentBaseExtended> {

	private List<ComparisonResult> getComparisonResults(PaymentBaseExtended o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PaymentBaseExtended> validate(RosettaPath path, PaymentBaseExtended o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PaymentBaseExtended", ValidationType.TYPE_FORMAT, "PaymentBaseExtended", path, "", error);
		}
		return success("PaymentBaseExtended", ValidationType.TYPE_FORMAT, "PaymentBaseExtended", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PaymentBaseExtended o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PaymentBaseExtended", ValidationType.TYPE_FORMAT, "PaymentBaseExtended", path, "", res.getError());
				}
				return success("PaymentBaseExtended", ValidationType.TYPE_FORMAT, "PaymentBaseExtended", path, "");
			})
			.collect(toList());
	}

}

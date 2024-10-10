package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PayerReceiverModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PayerReceiverModelTypeFormatValidator implements Validator<PayerReceiverModel> {

	private List<ComparisonResult> getComparisonResults(PayerReceiverModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PayerReceiverModel> validate(RosettaPath path, PayerReceiverModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PayerReceiverModel", ValidationType.TYPE_FORMAT, "PayerReceiverModel", path, "", error);
		}
		return success("PayerReceiverModel", ValidationType.TYPE_FORMAT, "PayerReceiverModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PayerReceiverModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PayerReceiverModel", ValidationType.TYPE_FORMAT, "PayerReceiverModel", path, "", res.getError());
				}
				return success("PayerReceiverModel", ValidationType.TYPE_FORMAT, "PayerReceiverModel", path, "");
			})
			.collect(toList());
	}

}

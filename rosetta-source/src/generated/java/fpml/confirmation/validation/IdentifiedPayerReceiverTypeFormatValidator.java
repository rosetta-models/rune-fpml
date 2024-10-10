package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IdentifiedPayerReceiver;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IdentifiedPayerReceiverTypeFormatValidator implements Validator<IdentifiedPayerReceiver> {

	private List<ComparisonResult> getComparisonResults(IdentifiedPayerReceiver o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<IdentifiedPayerReceiver> validate(RosettaPath path, IdentifiedPayerReceiver o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IdentifiedPayerReceiver", ValidationType.TYPE_FORMAT, "IdentifiedPayerReceiver", path, "", error);
		}
		return success("IdentifiedPayerReceiver", ValidationType.TYPE_FORMAT, "IdentifiedPayerReceiver", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IdentifiedPayerReceiver o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IdentifiedPayerReceiver", ValidationType.TYPE_FORMAT, "IdentifiedPayerReceiver", path, "", res.getError());
				}
				return success("IdentifiedPayerReceiver", ValidationType.TYPE_FORMAT, "IdentifiedPayerReceiver", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IdentifiedPayerReceiver;
import fpml.confirmation.PayerReceiverEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IdentifiedPayerReceiverValidator implements Validator<IdentifiedPayerReceiver> {

	private List<ComparisonResult> getComparisonResults(IdentifiedPayerReceiver o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (PayerReceiverEnum) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
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
			return failure("IdentifiedPayerReceiver", ValidationType.CARDINALITY, "IdentifiedPayerReceiver", path, "", error);
		}
		return success("IdentifiedPayerReceiver", ValidationType.CARDINALITY, "IdentifiedPayerReceiver", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IdentifiedPayerReceiver o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IdentifiedPayerReceiver", ValidationType.CARDINALITY, "IdentifiedPayerReceiver", path, "", res.getError());
				}
				return success("IdentifiedPayerReceiver", ValidationType.CARDINALITY, "IdentifiedPayerReceiver", path, "");
			})
			.collect(toList());
	}

}

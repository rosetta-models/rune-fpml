package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MessageId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MessageIdValidator implements Validator<MessageId> {

	private List<ComparisonResult> getComparisonResults(MessageId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("messageIdScheme", (String) o.getMessageIdScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<MessageId> validate(RosettaPath path, MessageId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MessageId", ValidationType.CARDINALITY, "MessageId", path, "", error);
		}
		return success("MessageId", ValidationType.CARDINALITY, "MessageId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MessageId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MessageId", ValidationType.CARDINALITY, "MessageId", path, "", res.getError());
				}
				return success("MessageId", ValidationType.CARDINALITY, "MessageId", path, "");
			})
			.collect(toList());
	}

}

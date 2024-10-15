package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MessageHeaderModel;
import fpml.confirmation.MessageId;
import fpml.confirmation.NotificationMessageHeader;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NotificationMessageHeaderValidator implements Validator<NotificationMessageHeader> {

	private List<ComparisonResult> getComparisonResults(NotificationMessageHeader o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("messageId", (MessageId) o.getMessageId() != null ? 1 : 0, 1, 1), 
				checkCardinality("inReplyTo", (MessageId) o.getInReplyTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("messageHeaderModel", (MessageHeaderModel) o.getMessageHeaderModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<NotificationMessageHeader> validate(RosettaPath path, NotificationMessageHeader o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NotificationMessageHeader", ValidationType.CARDINALITY, "NotificationMessageHeader", path, "", error);
		}
		return success("NotificationMessageHeader", ValidationType.CARDINALITY, "NotificationMessageHeader", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotificationMessageHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotificationMessageHeader", ValidationType.CARDINALITY, "NotificationMessageHeader", path, "", res.getError());
				}
				return success("NotificationMessageHeader", ValidationType.CARDINALITY, "NotificationMessageHeader", path, "");
			})
			.collect(toList());
	}

}

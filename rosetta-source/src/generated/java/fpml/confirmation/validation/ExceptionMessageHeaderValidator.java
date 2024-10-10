package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExceptionMessageHeader;
import fpml.confirmation.MessageHeaderModel;
import fpml.confirmation.MessageId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExceptionMessageHeaderValidator implements Validator<ExceptionMessageHeader> {

	private List<ComparisonResult> getComparisonResults(ExceptionMessageHeader o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("messageId", (MessageId) o.getMessageId() != null ? 1 : 0, 1, 1), 
				checkCardinality("inReplyTo", (MessageId) o.getInReplyTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("messageHeaderModel", (MessageHeaderModel) o.getMessageHeaderModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ExceptionMessageHeader> validate(RosettaPath path, ExceptionMessageHeader o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExceptionMessageHeader", ValidationType.CARDINALITY, "ExceptionMessageHeader", path, "", error);
		}
		return success("ExceptionMessageHeader", ValidationType.CARDINALITY, "ExceptionMessageHeader", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExceptionMessageHeader o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExceptionMessageHeader", ValidationType.CARDINALITY, "ExceptionMessageHeader", path, "", res.getError());
				}
				return success("ExceptionMessageHeader", ValidationType.CARDINALITY, "ExceptionMessageHeader", path, "");
			})
			.collect(toList());
	}

}

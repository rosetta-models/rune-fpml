package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MessageHeaderModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MessageHeaderModelTypeFormatValidator implements Validator<MessageHeaderModel> {

	private List<ComparisonResult> getComparisonResults(MessageHeaderModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<MessageHeaderModel> validate(RosettaPath path, MessageHeaderModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MessageHeaderModel", ValidationType.TYPE_FORMAT, "MessageHeaderModel", path, "", error);
		}
		return success("MessageHeaderModel", ValidationType.TYPE_FORMAT, "MessageHeaderModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MessageHeaderModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MessageHeaderModel", ValidationType.TYPE_FORMAT, "MessageHeaderModel", path, "", res.getError());
				}
				return success("MessageHeaderModel", ValidationType.TYPE_FORMAT, "MessageHeaderModel", path, "");
			})
			.collect(toList());
	}

}

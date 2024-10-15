package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Message;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MessageValidator implements Validator<Message> {

	private List<ComparisonResult> getComparisonResults(Message o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Message> validate(RosettaPath path, Message o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Message", ValidationType.CARDINALITY, "Message", path, "", error);
		}
		return success("Message", ValidationType.CARDINALITY, "Message", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Message o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Message", ValidationType.CARDINALITY, "Message", path, "", res.getError());
				}
				return success("Message", ValidationType.CARDINALITY, "Message", path, "");
			})
			.collect(toList());
	}

}

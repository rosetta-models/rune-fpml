package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TaskIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TaskIdentifierTypeFormatValidator implements Validator<TaskIdentifier> {

	private List<ComparisonResult> getComparisonResults(TaskIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TaskIdentifier> validate(RosettaPath path, TaskIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TaskIdentifier", ValidationType.TYPE_FORMAT, "TaskIdentifier", path, "", error);
		}
		return success("TaskIdentifier", ValidationType.TYPE_FORMAT, "TaskIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaskIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TaskIdentifier", ValidationType.TYPE_FORMAT, "TaskIdentifier", path, "", res.getError());
				}
				return success("TaskIdentifier", ValidationType.TYPE_FORMAT, "TaskIdentifier", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TaskId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TaskIdValidator implements Validator<TaskId> {

	private List<ComparisonResult> getComparisonResults(TaskId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("taskIdScheme", (String) o.getTaskIdScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TaskId> validate(RosettaPath path, TaskId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TaskId", ValidationType.CARDINALITY, "TaskId", path, "", error);
		}
		return success("TaskId", ValidationType.CARDINALITY, "TaskId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TaskId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TaskId", ValidationType.CARDINALITY, "TaskId", path, "", res.getError());
				}
				return success("TaskId", ValidationType.CARDINALITY, "TaskId", path, "");
			})
			.collect(toList());
	}

}

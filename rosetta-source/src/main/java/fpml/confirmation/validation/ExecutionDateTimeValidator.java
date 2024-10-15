package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ExecutionDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ExecutionDateTimeValidator implements Validator<ExecutionDateTime> {

	private List<ComparisonResult> getComparisonResults(ExecutionDateTime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (ZonedDateTime) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("executionDateTimeScheme", (String) o.getExecutionDateTimeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ExecutionDateTime> validate(RosettaPath path, ExecutionDateTime o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ExecutionDateTime", ValidationType.CARDINALITY, "ExecutionDateTime", path, "", error);
		}
		return success("ExecutionDateTime", ValidationType.CARDINALITY, "ExecutionDateTime", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionDateTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExecutionDateTime", ValidationType.CARDINALITY, "ExecutionDateTime", path, "", res.getError());
				}
				return success("ExecutionDateTime", ValidationType.CARDINALITY, "ExecutionDateTime", path, "");
			})
			.collect(toList());
	}

}

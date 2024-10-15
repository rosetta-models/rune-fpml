package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StepBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StepBaseValidator implements Validator<StepBase> {

	private List<ComparisonResult> getComparisonResults(StepBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("stepDate", (Date) o.getStepDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<StepBase> validate(RosettaPath path, StepBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StepBase", ValidationType.CARDINALITY, "StepBase", path, "", error);
		}
		return success("StepBase", ValidationType.CARDINALITY, "StepBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StepBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StepBase", ValidationType.CARDINALITY, "StepBase", path, "", res.getError());
				}
				return success("StepBase", ValidationType.CARDINALITY, "StepBase", path, "");
			})
			.collect(toList());
	}

}

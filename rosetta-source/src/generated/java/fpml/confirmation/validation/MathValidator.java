package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Math;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MathValidator implements Validator<Math> {

	private List<ComparisonResult> getComparisonResults(Math o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Math> validate(RosettaPath path, Math o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Math", ValidationType.CARDINALITY, "Math", path, "", error);
		}
		return success("Math", ValidationType.CARDINALITY, "Math", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Math o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Math", ValidationType.CARDINALITY, "Math", path, "", res.getError());
				}
				return success("Math", ValidationType.CARDINALITY, "Math", path, "");
			})
			.collect(toList());
	}

}

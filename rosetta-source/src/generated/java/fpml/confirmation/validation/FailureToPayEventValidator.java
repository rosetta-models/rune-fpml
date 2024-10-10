package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FailureToPayEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FailureToPayEventValidator implements Validator<FailureToPayEvent> {

	private List<ComparisonResult> getComparisonResults(FailureToPayEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FailureToPayEvent> validate(RosettaPath path, FailureToPayEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FailureToPayEvent", ValidationType.CARDINALITY, "FailureToPayEvent", path, "", error);
		}
		return success("FailureToPayEvent", ValidationType.CARDINALITY, "FailureToPayEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FailureToPayEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FailureToPayEvent", ValidationType.CARDINALITY, "FailureToPayEvent", path, "", res.getError());
				}
				return success("FailureToPayEvent", ValidationType.CARDINALITY, "FailureToPayEvent", path, "");
			})
			.collect(toList());
	}

}

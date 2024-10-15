package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TerminatingEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TerminatingEventValidator implements Validator<TerminatingEvent> {

	private List<ComparisonResult> getComparisonResults(TerminatingEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("terminatingEventScheme", (String) o.getTerminatingEventScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TerminatingEvent> validate(RosettaPath path, TerminatingEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TerminatingEvent", ValidationType.CARDINALITY, "TerminatingEvent", path, "", error);
		}
		return success("TerminatingEvent", ValidationType.CARDINALITY, "TerminatingEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TerminatingEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TerminatingEvent", ValidationType.CARDINALITY, "TerminatingEvent", path, "", res.getError());
				}
				return success("TerminatingEvent", ValidationType.CARDINALITY, "TerminatingEvent", path, "");
			})
			.collect(toList());
	}

}

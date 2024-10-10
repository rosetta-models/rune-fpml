package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ObligationDefaultEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ObligationDefaultEventValidator implements Validator<ObligationDefaultEvent> {

	private List<ComparisonResult> getComparisonResults(ObligationDefaultEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ObligationDefaultEvent> validate(RosettaPath path, ObligationDefaultEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ObligationDefaultEvent", ValidationType.CARDINALITY, "ObligationDefaultEvent", path, "", error);
		}
		return success("ObligationDefaultEvent", ValidationType.CARDINALITY, "ObligationDefaultEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObligationDefaultEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObligationDefaultEvent", ValidationType.CARDINALITY, "ObligationDefaultEvent", path, "", res.getError());
				}
				return success("ObligationDefaultEvent", ValidationType.CARDINALITY, "ObligationDefaultEvent", path, "");
			})
			.collect(toList());
	}

}

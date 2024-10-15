package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ObligationAccelerationEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ObligationAccelerationEventTypeFormatValidator implements Validator<ObligationAccelerationEvent> {

	private List<ComparisonResult> getComparisonResults(ObligationAccelerationEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ObligationAccelerationEvent> validate(RosettaPath path, ObligationAccelerationEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ObligationAccelerationEvent", ValidationType.TYPE_FORMAT, "ObligationAccelerationEvent", path, "", error);
		}
		return success("ObligationAccelerationEvent", ValidationType.TYPE_FORMAT, "ObligationAccelerationEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObligationAccelerationEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObligationAccelerationEvent", ValidationType.TYPE_FORMAT, "ObligationAccelerationEvent", path, "", res.getError());
				}
				return success("ObligationAccelerationEvent", ValidationType.TYPE_FORMAT, "ObligationAccelerationEvent", path, "");
			})
			.collect(toList());
	}

}

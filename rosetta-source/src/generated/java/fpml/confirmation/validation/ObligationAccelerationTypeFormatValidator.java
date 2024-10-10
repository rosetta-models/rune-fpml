package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ObligationAcceleration;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ObligationAccelerationTypeFormatValidator implements Validator<ObligationAcceleration> {

	private List<ComparisonResult> getComparisonResults(ObligationAcceleration o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ObligationAcceleration> validate(RosettaPath path, ObligationAcceleration o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ObligationAcceleration", ValidationType.TYPE_FORMAT, "ObligationAcceleration", path, "", error);
		}
		return success("ObligationAcceleration", ValidationType.TYPE_FORMAT, "ObligationAcceleration", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObligationAcceleration o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObligationAcceleration", ValidationType.TYPE_FORMAT, "ObligationAcceleration", path, "", res.getError());
				}
				return success("ObligationAcceleration", ValidationType.TYPE_FORMAT, "ObligationAcceleration", path, "");
			})
			.collect(toList());
	}

}

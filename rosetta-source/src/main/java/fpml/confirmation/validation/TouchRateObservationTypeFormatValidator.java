package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TouchRateObservation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TouchRateObservationTypeFormatValidator implements Validator<TouchRateObservation> {

	private List<ComparisonResult> getComparisonResults(TouchRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TouchRateObservation> validate(RosettaPath path, TouchRateObservation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TouchRateObservation", ValidationType.TYPE_FORMAT, "TouchRateObservation", path, "", error);
		}
		return success("TouchRateObservation", ValidationType.TYPE_FORMAT, "TouchRateObservation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TouchRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TouchRateObservation", ValidationType.TYPE_FORMAT, "TouchRateObservation", path, "", res.getError());
				}
				return success("TouchRateObservation", ValidationType.TYPE_FORMAT, "TouchRateObservation", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TouchRateObservationSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TouchRateObservationSequenceTypeFormatValidator implements Validator<TouchRateObservationSequence> {

	private List<ComparisonResult> getComparisonResults(TouchRateObservationSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TouchRateObservationSequence> validate(RosettaPath path, TouchRateObservationSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TouchRateObservationSequence", ValidationType.TYPE_FORMAT, "TouchRateObservationSequence", path, "", error);
		}
		return success("TouchRateObservationSequence", ValidationType.TYPE_FORMAT, "TouchRateObservationSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TouchRateObservationSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TouchRateObservationSequence", ValidationType.TYPE_FORMAT, "TouchRateObservationSequence", path, "", res.getError());
				}
				return success("TouchRateObservationSequence", ValidationType.TYPE_FORMAT, "TouchRateObservationSequence", path, "");
			})
			.collect(toList());
	}

}

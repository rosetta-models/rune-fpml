package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TriggerRateObservation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TriggerRateObservationTypeFormatValidator implements Validator<TriggerRateObservation> {

	private List<ComparisonResult> getComparisonResults(TriggerRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TriggerRateObservation> validate(RosettaPath path, TriggerRateObservation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TriggerRateObservation", ValidationType.TYPE_FORMAT, "TriggerRateObservation", path, "", error);
		}
		return success("TriggerRateObservation", ValidationType.TYPE_FORMAT, "TriggerRateObservation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriggerRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TriggerRateObservation", ValidationType.TYPE_FORMAT, "TriggerRateObservation", path, "", res.getError());
				}
				return success("TriggerRateObservation", ValidationType.TYPE_FORMAT, "TriggerRateObservation", path, "");
			})
			.collect(toList());
	}

}

package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxDisruptionEvents;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDisruptionEventsTypeFormatValidator implements Validator<FxDisruptionEvents> {

	private List<ComparisonResult> getComparisonResults(FxDisruptionEvents o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxDisruptionEvents> validate(RosettaPath path, FxDisruptionEvents o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDisruptionEvents", ValidationType.TYPE_FORMAT, "FxDisruptionEvents", path, "", error);
		}
		return success("FxDisruptionEvents", ValidationType.TYPE_FORMAT, "FxDisruptionEvents", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruptionEvents o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruptionEvents", ValidationType.TYPE_FORMAT, "FxDisruptionEvents", path, "", res.getError());
				}
				return success("FxDisruptionEvents", ValidationType.TYPE_FORMAT, "FxDisruptionEvents", path, "");
			})
			.collect(toList());
	}

}

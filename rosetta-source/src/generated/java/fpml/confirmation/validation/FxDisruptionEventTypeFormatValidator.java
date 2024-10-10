package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxDisruptionEvent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDisruptionEventTypeFormatValidator implements Validator<FxDisruptionEvent> {

	private List<ComparisonResult> getComparisonResults(FxDisruptionEvent o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxDisruptionEvent> validate(RosettaPath path, FxDisruptionEvent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDisruptionEvent", ValidationType.TYPE_FORMAT, "FxDisruptionEvent", path, "", error);
		}
		return success("FxDisruptionEvent", ValidationType.TYPE_FORMAT, "FxDisruptionEvent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruptionEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruptionEvent", ValidationType.TYPE_FORMAT, "FxDisruptionEvent", path, "", res.getError());
				}
				return success("FxDisruptionEvent", ValidationType.TYPE_FORMAT, "FxDisruptionEvent", path, "");
			})
			.collect(toList());
	}

}

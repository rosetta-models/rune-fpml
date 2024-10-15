package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxDisruptionFallbacks;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxDisruptionFallbacksTypeFormatValidator implements Validator<FxDisruptionFallbacks> {

	private List<ComparisonResult> getComparisonResults(FxDisruptionFallbacks o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxDisruptionFallbacks> validate(RosettaPath path, FxDisruptionFallbacks o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxDisruptionFallbacks", ValidationType.TYPE_FORMAT, "FxDisruptionFallbacks", path, "", error);
		}
		return success("FxDisruptionFallbacks", ValidationType.TYPE_FORMAT, "FxDisruptionFallbacks", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxDisruptionFallbacks o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxDisruptionFallbacks", ValidationType.TYPE_FORMAT, "FxDisruptionFallbacks", path, "", res.getError());
				}
				return success("FxDisruptionFallbacks", ValidationType.TYPE_FORMAT, "FxDisruptionFallbacks", path, "");
			})
			.collect(toList());
	}

}

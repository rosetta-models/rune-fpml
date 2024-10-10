package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxFlexibleForward;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFlexibleForwardTypeFormatValidator implements Validator<FxFlexibleForward> {

	private List<ComparisonResult> getComparisonResults(FxFlexibleForward o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxFlexibleForward> validate(RosettaPath path, FxFlexibleForward o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFlexibleForward", ValidationType.TYPE_FORMAT, "FxFlexibleForward", path, "", error);
		}
		return success("FxFlexibleForward", ValidationType.TYPE_FORMAT, "FxFlexibleForward", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFlexibleForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFlexibleForward", ValidationType.TYPE_FORMAT, "FxFlexibleForward", path, "", res.getError());
				}
				return success("FxFlexibleForward", ValidationType.TYPE_FORMAT, "FxFlexibleForward", path, "");
			})
			.collect(toList());
	}

}

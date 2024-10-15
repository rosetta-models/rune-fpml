package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RateLimits;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RateLimitsTypeFormatValidator implements Validator<RateLimits> {

	private List<ComparisonResult> getComparisonResults(RateLimits o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RateLimits> validate(RosettaPath path, RateLimits o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RateLimits", ValidationType.TYPE_FORMAT, "RateLimits", path, "", error);
		}
		return success("RateLimits", ValidationType.TYPE_FORMAT, "RateLimits", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateLimits o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RateLimits", ValidationType.TYPE_FORMAT, "RateLimits", path, "", res.getError());
				}
				return success("RateLimits", ValidationType.TYPE_FORMAT, "RateLimits", path, "");
			})
			.collect(toList());
	}

}

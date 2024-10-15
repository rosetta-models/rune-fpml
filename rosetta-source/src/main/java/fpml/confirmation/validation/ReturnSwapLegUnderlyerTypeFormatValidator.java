package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReturnSwapLegUnderlyer;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReturnSwapLegUnderlyerTypeFormatValidator implements Validator<ReturnSwapLegUnderlyer> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapLegUnderlyer o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReturnSwapLegUnderlyer> validate(RosettaPath path, ReturnSwapLegUnderlyer o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReturnSwapLegUnderlyer", ValidationType.TYPE_FORMAT, "ReturnSwapLegUnderlyer", path, "", error);
		}
		return success("ReturnSwapLegUnderlyer", ValidationType.TYPE_FORMAT, "ReturnSwapLegUnderlyer", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapLegUnderlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapLegUnderlyer", ValidationType.TYPE_FORMAT, "ReturnSwapLegUnderlyer", path, "", res.getError());
				}
				return success("ReturnSwapLegUnderlyer", ValidationType.TYPE_FORMAT, "ReturnSwapLegUnderlyer", path, "");
			})
			.collect(toList());
	}

}

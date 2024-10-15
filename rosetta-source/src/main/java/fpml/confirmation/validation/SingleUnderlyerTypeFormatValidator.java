package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SingleUnderlyer;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SingleUnderlyerTypeFormatValidator implements Validator<SingleUnderlyer> {

	private List<ComparisonResult> getComparisonResults(SingleUnderlyer o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<SingleUnderlyer> validate(RosettaPath path, SingleUnderlyer o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SingleUnderlyer", ValidationType.TYPE_FORMAT, "SingleUnderlyer", path, "", error);
		}
		return success("SingleUnderlyer", ValidationType.TYPE_FORMAT, "SingleUnderlyer", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SingleUnderlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SingleUnderlyer", ValidationType.TYPE_FORMAT, "SingleUnderlyer", path, "", res.getError());
				}
				return success("SingleUnderlyer", ValidationType.TYPE_FORMAT, "SingleUnderlyer", path, "");
			})
			.collect(toList());
	}

}

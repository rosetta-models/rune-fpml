package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxTargetConstantPayoff;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxTargetConstantPayoffTypeFormatValidator implements Validator<FxTargetConstantPayoff> {

	private List<ComparisonResult> getComparisonResults(FxTargetConstantPayoff o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FxTargetConstantPayoff> validate(RosettaPath path, FxTargetConstantPayoff o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxTargetConstantPayoff", ValidationType.TYPE_FORMAT, "FxTargetConstantPayoff", path, "", error);
		}
		return success("FxTargetConstantPayoff", ValidationType.TYPE_FORMAT, "FxTargetConstantPayoff", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetConstantPayoff o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetConstantPayoff", ValidationType.TYPE_FORMAT, "FxTargetConstantPayoff", path, "", res.getError());
				}
				return success("FxTargetConstantPayoff", ValidationType.TYPE_FORMAT, "FxTargetConstantPayoff", path, "");
			})
			.collect(toList());
	}

}

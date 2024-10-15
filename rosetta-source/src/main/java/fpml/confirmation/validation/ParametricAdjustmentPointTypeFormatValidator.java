package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ParametricAdjustmentPoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ParametricAdjustmentPointTypeFormatValidator implements Validator<ParametricAdjustmentPoint> {

	private List<ComparisonResult> getComparisonResults(ParametricAdjustmentPoint o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ParametricAdjustmentPoint> validate(RosettaPath path, ParametricAdjustmentPoint o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ParametricAdjustmentPoint", ValidationType.TYPE_FORMAT, "ParametricAdjustmentPoint", path, "", error);
		}
		return success("ParametricAdjustmentPoint", ValidationType.TYPE_FORMAT, "ParametricAdjustmentPoint", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricAdjustmentPoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParametricAdjustmentPoint", ValidationType.TYPE_FORMAT, "ParametricAdjustmentPoint", path, "", res.getError());
				}
				return success("ParametricAdjustmentPoint", ValidationType.TYPE_FORMAT, "ParametricAdjustmentPoint", path, "");
			})
			.collect(toList());
	}

}

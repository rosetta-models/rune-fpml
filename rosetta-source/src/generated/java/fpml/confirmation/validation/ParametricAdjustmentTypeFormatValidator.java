package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ParametricAdjustment;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ParametricAdjustmentTypeFormatValidator implements Validator<ParametricAdjustment> {

	private List<ComparisonResult> getComparisonResults(ParametricAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ParametricAdjustment> validate(RosettaPath path, ParametricAdjustment o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ParametricAdjustment", ValidationType.TYPE_FORMAT, "ParametricAdjustment", path, "", error);
		}
		return success("ParametricAdjustment", ValidationType.TYPE_FORMAT, "ParametricAdjustment", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ParametricAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ParametricAdjustment", ValidationType.TYPE_FORMAT, "ParametricAdjustment", path, "", res.getError());
				}
				return success("ParametricAdjustment", ValidationType.TYPE_FORMAT, "ParametricAdjustment", path, "");
			})
			.collect(toList());
	}

}

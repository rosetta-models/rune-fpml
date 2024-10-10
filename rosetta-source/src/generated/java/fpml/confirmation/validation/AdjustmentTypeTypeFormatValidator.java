package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustmentType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdjustmentTypeTypeFormatValidator implements Validator<AdjustmentType> {

	private List<ComparisonResult> getComparisonResults(AdjustmentType o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AdjustmentType> validate(RosettaPath path, AdjustmentType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdjustmentType", ValidationType.TYPE_FORMAT, "AdjustmentType", path, "", error);
		}
		return success("AdjustmentType", ValidationType.TYPE_FORMAT, "AdjustmentType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustmentType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustmentType", ValidationType.TYPE_FORMAT, "AdjustmentType", path, "", res.getError());
				}
				return success("AdjustmentType", ValidationType.TYPE_FORMAT, "AdjustmentType", path, "");
			})
			.collect(toList());
	}

}

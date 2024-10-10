package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ClearingInstructions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ClearingInstructionsTypeFormatValidator implements Validator<ClearingInstructions> {

	private List<ComparisonResult> getComparisonResults(ClearingInstructions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ClearingInstructions> validate(RosettaPath path, ClearingInstructions o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ClearingInstructions", ValidationType.TYPE_FORMAT, "ClearingInstructions", path, "", error);
		}
		return success("ClearingInstructions", ValidationType.TYPE_FORMAT, "ClearingInstructions", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ClearingInstructions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ClearingInstructions", ValidationType.TYPE_FORMAT, "ClearingInstructions", path, "", res.getError());
				}
				return success("ClearingInstructions", ValidationType.TYPE_FORMAT, "ClearingInstructions", path, "");
			})
			.collect(toList());
	}

}

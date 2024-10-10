package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Sensitivity;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SensitivityTypeFormatValidator implements Validator<Sensitivity> {

	private List<ComparisonResult> getComparisonResults(Sensitivity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Sensitivity> validate(RosettaPath path, Sensitivity o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Sensitivity", ValidationType.TYPE_FORMAT, "Sensitivity", path, "", error);
		}
		return success("Sensitivity", ValidationType.TYPE_FORMAT, "Sensitivity", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Sensitivity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Sensitivity", ValidationType.TYPE_FORMAT, "Sensitivity", path, "", res.getError());
				}
				return success("Sensitivity", ValidationType.TYPE_FORMAT, "Sensitivity", path, "");
			})
			.collect(toList());
	}

}

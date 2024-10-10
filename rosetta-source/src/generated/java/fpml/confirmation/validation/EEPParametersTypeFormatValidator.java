package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EEPParameters;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EEPParametersTypeFormatValidator implements Validator<EEPParameters> {

	private List<ComparisonResult> getComparisonResults(EEPParameters o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<EEPParameters> validate(RosettaPath path, EEPParameters o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EEPParameters", ValidationType.TYPE_FORMAT, "EEPParameters", path, "", error);
		}
		return success("EEPParameters", ValidationType.TYPE_FORMAT, "EEPParameters", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EEPParameters o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EEPParameters", ValidationType.TYPE_FORMAT, "EEPParameters", path, "", res.getError());
				}
				return success("EEPParameters", ValidationType.TYPE_FORMAT, "EEPParameters", path, "");
			})
			.collect(toList());
	}

}

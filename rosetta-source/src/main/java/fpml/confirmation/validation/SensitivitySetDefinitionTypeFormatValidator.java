package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SensitivitySetDefinition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SensitivitySetDefinitionTypeFormatValidator implements Validator<SensitivitySetDefinition> {

	private List<ComparisonResult> getComparisonResults(SensitivitySetDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("name", o.getName(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<SensitivitySetDefinition> validate(RosettaPath path, SensitivitySetDefinition o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SensitivitySetDefinition", ValidationType.TYPE_FORMAT, "SensitivitySetDefinition", path, "", error);
		}
		return success("SensitivitySetDefinition", ValidationType.TYPE_FORMAT, "SensitivitySetDefinition", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivitySetDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivitySetDefinition", ValidationType.TYPE_FORMAT, "SensitivitySetDefinition", path, "", res.getError());
				}
				return success("SensitivitySetDefinition", ValidationType.TYPE_FORMAT, "SensitivitySetDefinition", path, "");
			})
			.collect(toList());
	}

}

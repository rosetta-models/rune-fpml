package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.SensitivitySet;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SensitivitySetTypeFormatValidator implements Validator<SensitivitySet> {

	private List<ComparisonResult> getComparisonResults(SensitivitySet o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("name", o.getName(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<SensitivitySet> validate(RosettaPath path, SensitivitySet o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SensitivitySet", ValidationType.TYPE_FORMAT, "SensitivitySet", path, "", error);
		}
		return success("SensitivitySet", ValidationType.TYPE_FORMAT, "SensitivitySet", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivitySet o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivitySet", ValidationType.TYPE_FORMAT, "SensitivitySet", path, "", res.getError());
				}
				return success("SensitivitySet", ValidationType.TYPE_FORMAT, "SensitivitySet", path, "");
			})
			.collect(toList());
	}

}

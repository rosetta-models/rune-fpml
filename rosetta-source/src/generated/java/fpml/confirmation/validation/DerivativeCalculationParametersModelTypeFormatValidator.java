package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DerivativeCalculationParametersModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DerivativeCalculationParametersModelTypeFormatValidator implements Validator<DerivativeCalculationParametersModel> {

	private List<ComparisonResult> getComparisonResults(DerivativeCalculationParametersModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<DerivativeCalculationParametersModel> validate(RosettaPath path, DerivativeCalculationParametersModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DerivativeCalculationParametersModel", ValidationType.TYPE_FORMAT, "DerivativeCalculationParametersModel", path, "", error);
		}
		return success("DerivativeCalculationParametersModel", ValidationType.TYPE_FORMAT, "DerivativeCalculationParametersModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeCalculationParametersModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativeCalculationParametersModel", ValidationType.TYPE_FORMAT, "DerivativeCalculationParametersModel", path, "", res.getError());
				}
				return success("DerivativeCalculationParametersModel", ValidationType.TYPE_FORMAT, "DerivativeCalculationParametersModel", path, "");
			})
			.collect(toList());
	}

}

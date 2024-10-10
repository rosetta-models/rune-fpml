package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FiniteDifferenceDerivativeParametersModel;
import fpml.confirmation.PerturbationType;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FiniteDifferenceDerivativeParametersModelValidator implements Validator<FiniteDifferenceDerivativeParametersModel> {

	private List<ComparisonResult> getComparisonResults(FiniteDifferenceDerivativeParametersModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("perturbationAmount", (BigDecimal) o.getPerturbationAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("averaged", (Boolean) o.getAveraged() != null ? 1 : 0, 1, 1), 
				checkCardinality("perturbationType", (PerturbationType) o.getPerturbationType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FiniteDifferenceDerivativeParametersModel> validate(RosettaPath path, FiniteDifferenceDerivativeParametersModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FiniteDifferenceDerivativeParametersModel", ValidationType.CARDINALITY, "FiniteDifferenceDerivativeParametersModel", path, "", error);
		}
		return success("FiniteDifferenceDerivativeParametersModel", ValidationType.CARDINALITY, "FiniteDifferenceDerivativeParametersModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FiniteDifferenceDerivativeParametersModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FiniteDifferenceDerivativeParametersModel", ValidationType.CARDINALITY, "FiniteDifferenceDerivativeParametersModel", path, "", res.getError());
				}
				return success("FiniteDifferenceDerivativeParametersModel", ValidationType.CARDINALITY, "FiniteDifferenceDerivativeParametersModel", path, "");
			})
			.collect(toList());
	}

}

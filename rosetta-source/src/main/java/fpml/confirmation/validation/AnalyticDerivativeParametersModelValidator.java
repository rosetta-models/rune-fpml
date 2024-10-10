package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AnalyticDerivativeParametersModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AnalyticDerivativeParametersModelValidator implements Validator<AnalyticDerivativeParametersModel> {

	private List<ComparisonResult> getComparisonResults(AnalyticDerivativeParametersModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("derivativeFormula", (String) o.getDerivativeFormula() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AnalyticDerivativeParametersModel> validate(RosettaPath path, AnalyticDerivativeParametersModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AnalyticDerivativeParametersModel", ValidationType.CARDINALITY, "AnalyticDerivativeParametersModel", path, "", error);
		}
		return success("AnalyticDerivativeParametersModel", ValidationType.CARDINALITY, "AnalyticDerivativeParametersModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnalyticDerivativeParametersModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnalyticDerivativeParametersModel", ValidationType.CARDINALITY, "AnalyticDerivativeParametersModel", path, "", res.getError());
				}
				return success("AnalyticDerivativeParametersModel", ValidationType.CARDINALITY, "AnalyticDerivativeParametersModel", path, "");
			})
			.collect(toList());
	}

}

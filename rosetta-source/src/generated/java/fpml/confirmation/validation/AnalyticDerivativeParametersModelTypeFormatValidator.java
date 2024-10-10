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
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AnalyticDerivativeParametersModelTypeFormatValidator implements Validator<AnalyticDerivativeParametersModel> {

	private List<ComparisonResult> getComparisonResults(AnalyticDerivativeParametersModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("derivativeFormula", o.getDerivativeFormula(), 0, of(255), empty())
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
			return failure("AnalyticDerivativeParametersModel", ValidationType.TYPE_FORMAT, "AnalyticDerivativeParametersModel", path, "", error);
		}
		return success("AnalyticDerivativeParametersModel", ValidationType.TYPE_FORMAT, "AnalyticDerivativeParametersModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnalyticDerivativeParametersModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnalyticDerivativeParametersModel", ValidationType.TYPE_FORMAT, "AnalyticDerivativeParametersModel", path, "", res.getError());
				}
				return success("AnalyticDerivativeParametersModel", ValidationType.TYPE_FORMAT, "AnalyticDerivativeParametersModel", path, "");
			})
			.collect(toList());
	}

}

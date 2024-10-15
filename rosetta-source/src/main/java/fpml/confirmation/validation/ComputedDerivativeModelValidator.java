package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ComputedDerivativeModel;
import fpml.confirmation.DerivativeFormula;
import fpml.confirmation.PricingParameterDerivative;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ComputedDerivativeModelValidator implements Validator<ComputedDerivativeModel> {

	private List<ComparisonResult> getComparisonResults(ComputedDerivativeModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("partialDerivative", (List<? extends PricingParameterDerivative>) o.getPartialDerivative() == null ? 0 : ((List<? extends PricingParameterDerivative>) o.getPartialDerivative()).size(), 1, 0), 
				checkCardinality("formula", (DerivativeFormula) o.getFormula() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ComputedDerivativeModel> validate(RosettaPath path, ComputedDerivativeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ComputedDerivativeModel", ValidationType.CARDINALITY, "ComputedDerivativeModel", path, "", error);
		}
		return success("ComputedDerivativeModel", ValidationType.CARDINALITY, "ComputedDerivativeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ComputedDerivativeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ComputedDerivativeModel", ValidationType.CARDINALITY, "ComputedDerivativeModel", path, "", res.getError());
				}
				return success("ComputedDerivativeModel", ValidationType.CARDINALITY, "ComputedDerivativeModel", path, "");
			})
			.collect(toList());
	}

}

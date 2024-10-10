package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AssetOrTermPointOrPricingStructureReference;
import fpml.confirmation.DerivativeCalculationProcedure;
import fpml.confirmation.PricingParameterDerivative;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PricingParameterDerivativeValidator implements Validator<PricingParameterDerivative> {

	private List<ComparisonResult> getComparisonResults(PricingParameterDerivative o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("parameterReference", (AssetOrTermPointOrPricingStructureReference) o.getParameterReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationProcedure", (DerivativeCalculationProcedure) o.getCalculationProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<PricingParameterDerivative> validate(RosettaPath path, PricingParameterDerivative o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PricingParameterDerivative", ValidationType.CARDINALITY, "PricingParameterDerivative", path, "", error);
		}
		return success("PricingParameterDerivative", ValidationType.CARDINALITY, "PricingParameterDerivative", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingParameterDerivative o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingParameterDerivative", ValidationType.CARDINALITY, "PricingParameterDerivative", path, "", res.getError());
				}
				return success("PricingParameterDerivative", ValidationType.CARDINALITY, "PricingParameterDerivative", path, "");
			})
			.collect(toList());
	}

}

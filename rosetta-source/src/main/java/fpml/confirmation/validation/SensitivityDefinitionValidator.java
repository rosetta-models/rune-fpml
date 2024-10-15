package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ComputedDerivativeModel;
import fpml.confirmation.SensitivityDefinition;
import fpml.confirmation.SensitivityDescriptionModel;
import fpml.confirmation.ValuationScenarioReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SensitivityDefinitionValidator implements Validator<SensitivityDefinition> {

	private List<ComparisonResult> getComparisonResults(SensitivityDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationScenarioReference", (ValuationScenarioReference) o.getValuationScenarioReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("computedDerivativeModel", (ComputedDerivativeModel) o.getComputedDerivativeModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("sensitivityDescriptionModel", (SensitivityDescriptionModel) o.getSensitivityDescriptionModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SensitivityDefinition> validate(RosettaPath path, SensitivityDefinition o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SensitivityDefinition", ValidationType.CARDINALITY, "SensitivityDefinition", path, "", error);
		}
		return success("SensitivityDefinition", ValidationType.CARDINALITY, "SensitivityDefinition", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivityDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivityDefinition", ValidationType.CARDINALITY, "SensitivityDefinition", path, "", res.getError());
				}
				return success("SensitivityDefinition", ValidationType.CARDINALITY, "SensitivityDefinition", path, "");
			})
			.collect(toList());
	}

}

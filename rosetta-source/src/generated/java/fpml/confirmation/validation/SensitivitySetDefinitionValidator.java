package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DerivativeCalculationProcedure;
import fpml.confirmation.PricingInputType;
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.SensitivitySetDefinition;
import fpml.confirmation.ValuationScenarioReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SensitivitySetDefinitionValidator implements Validator<SensitivitySetDefinition> {

	private List<ComparisonResult> getComparisonResults(SensitivitySetDefinition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("sensitivityCharacteristics", (QuotationCharacteristics) o.getSensitivityCharacteristics() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationScenarioReference", (ValuationScenarioReference) o.getValuationScenarioReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingInputType", (PricingInputType) o.getPricingInputType() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingInputReference", (PricingStructureReference) o.getPricingInputReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("scale", (BigDecimal) o.getScale() != null ? 1 : 0, 1, 1), 
				checkCardinality("calculationProcedure", (DerivativeCalculationProcedure) o.getCalculationProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
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
			return failure("SensitivitySetDefinition", ValidationType.CARDINALITY, "SensitivitySetDefinition", path, "", error);
		}
		return success("SensitivitySetDefinition", ValidationType.CARDINALITY, "SensitivitySetDefinition", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SensitivitySetDefinition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SensitivitySetDefinition", ValidationType.CARDINALITY, "SensitivitySetDefinition", path, "", res.getError());
				}
				return success("SensitivitySetDefinition", ValidationType.CARDINALITY, "SensitivitySetDefinition", path, "");
			})
			.collect(toList());
	}

}

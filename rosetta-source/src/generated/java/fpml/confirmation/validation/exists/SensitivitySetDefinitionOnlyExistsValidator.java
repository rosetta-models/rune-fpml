package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DerivativeCalculationProcedure;
import fpml.confirmation.PricingInputType;
import fpml.confirmation.PricingStructureReference;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.SensitivityDefinition;
import fpml.confirmation.SensitivitySetDefinition;
import fpml.confirmation.ValuationScenarioReference;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SensitivitySetDefinitionOnlyExistsValidator implements ValidatorWithArg<SensitivitySetDefinition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SensitivitySetDefinition> ValidationResult<SensitivitySetDefinition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("sensitivityCharacteristics", ExistenceChecker.isSet((QuotationCharacteristics) o.getSensitivityCharacteristics()))
				.put("valuationScenarioReference", ExistenceChecker.isSet((ValuationScenarioReference) o.getValuationScenarioReference()))
				.put("pricingInputType", ExistenceChecker.isSet((PricingInputType) o.getPricingInputType()))
				.put("pricingInputReference", ExistenceChecker.isSet((PricingStructureReference) o.getPricingInputReference()))
				.put("scale", ExistenceChecker.isSet((BigDecimal) o.getScale()))
				.put("sensitivityDefinition", ExistenceChecker.isSet((List<? extends SensitivityDefinition>) o.getSensitivityDefinition()))
				.put("calculationProcedure", ExistenceChecker.isSet((DerivativeCalculationProcedure) o.getCalculationProcedure()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SensitivitySetDefinition", ValidationType.ONLY_EXISTS, "SensitivitySetDefinition", path, "");
		}
		return failure("SensitivitySetDefinition", ValidationType.ONLY_EXISTS, "SensitivitySetDefinition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

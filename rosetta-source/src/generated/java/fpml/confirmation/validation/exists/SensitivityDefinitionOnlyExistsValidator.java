package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ComputedDerivativeModel;
import fpml.confirmation.SensitivityDefinition;
import fpml.confirmation.SensitivityDescriptionModel;
import fpml.confirmation.ValuationScenarioReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SensitivityDefinitionOnlyExistsValidator implements ValidatorWithArg<SensitivityDefinition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SensitivityDefinition> ValidationResult<SensitivityDefinition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("valuationScenarioReference", ExistenceChecker.isSet((ValuationScenarioReference) o.getValuationScenarioReference()))
				.put("computedDerivativeModel", ExistenceChecker.isSet((ComputedDerivativeModel) o.getComputedDerivativeModel()))
				.put("sensitivityDescriptionModel", ExistenceChecker.isSet((SensitivityDescriptionModel) o.getSensitivityDescriptionModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SensitivityDefinition", ValidationType.ONLY_EXISTS, "SensitivityDefinition", path, "");
		}
		return failure("SensitivityDefinition", ValidationType.ONLY_EXISTS, "SensitivityDefinition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EEPParameters;
import fpml.confirmation.EEPRiskPeriod;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EEPParametersOnlyExistsValidator implements ValidatorWithArg<EEPParameters, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EEPParameters> ValidationResult<EEPParameters> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eEPApplicable", ExistenceChecker.isSet((Boolean) o.getEEPApplicable()))
				.put("riskPeriod", ExistenceChecker.isSet((EEPRiskPeriod) o.getRiskPeriod()))
				.put("equivalentApplicable", ExistenceChecker.isSet((Boolean) o.getEquivalentApplicable()))
				.put("penaltyApplicable", ExistenceChecker.isSet((Boolean) o.getPenaltyApplicable()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EEPParameters", ValidationType.ONLY_EXISTS, "EEPParameters", path, "");
		}
		return failure("EEPParameters", ValidationType.ONLY_EXISTS, "EEPParameters", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

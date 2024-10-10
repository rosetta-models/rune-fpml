package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationAgent;
import fpml.confirmation.CalculationAgentPartyEnum;
import fpml.confirmation.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CalculationAgentOnlyExistsValidator implements ValidatorWithArg<CalculationAgent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CalculationAgent> ValidationResult<CalculationAgent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationAgentPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getCalculationAgentPartyReference()))
				.put("calculationAgentParty", ExistenceChecker.isSet((CalculationAgentPartyEnum) o.getCalculationAgentParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationAgent", ValidationType.ONLY_EXISTS, "CalculationAgent", path, "");
		}
		return failure("CalculationAgent", ValidationType.ONLY_EXISTS, "CalculationAgent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

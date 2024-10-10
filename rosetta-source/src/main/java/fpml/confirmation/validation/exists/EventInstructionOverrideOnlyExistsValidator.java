package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.EventInstructionOverride;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.SettlementDetails;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EventInstructionOverrideOnlyExistsValidator implements ValidatorWithArg<EventInstructionOverride, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EventInstructionOverride> ValidationResult<EventInstructionOverride> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("overrideIdentifier", ExistenceChecker.isSet((OverrideIdentifier) o.getOverrideIdentifier()))
				.put("eventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getEventIdentifier()))
				.put("settlementDetails", ExistenceChecker.isSet((List<? extends SettlementDetails>) o.getSettlementDetails()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EventInstructionOverride", ValidationType.ONLY_EXISTS, "EventInstructionOverride", path, "");
		}
		return failure("EventInstructionOverride", ValidationType.ONLY_EXISTS, "EventInstructionOverride", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

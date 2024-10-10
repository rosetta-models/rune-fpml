package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestedClearingAction;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ClearingInstructionsOnlyExistsValidator implements ValidatorWithArg<ClearingInstructions, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ClearingInstructions> ValidationResult<ClearingInstructions> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("requestedClearingAction", ExistenceChecker.isSet((RequestedClearingAction) o.getRequestedClearingAction()))
				.put("requestedClearingOrganizationPartyReference", ExistenceChecker.isSet((PartyReference) o.getRequestedClearingOrganizationPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ClearingInstructions", ValidationType.ONLY_EXISTS, "ClearingInstructions", path, "");
		}
		return failure("ClearingInstructions", ValidationType.ONLY_EXISTS, "ClearingInstructions", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

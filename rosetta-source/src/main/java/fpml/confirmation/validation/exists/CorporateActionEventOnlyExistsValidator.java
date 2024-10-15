package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.CorporateActionEvent;
import fpml.confirmation.CorporateActionType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CorporateActionEventOnlyExistsValidator implements ValidatorWithArg<CorporateActionEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CorporateActionEvent> ValidationResult<CorporateActionEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("_type", ExistenceChecker.isSet((CorporateActionType) o.get_type()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CorporateActionEvent", ValidationType.ONLY_EXISTS, "CorporateActionEvent", path, "");
		}
		return failure("CorporateActionEvent", ValidationType.ONLY_EXISTS, "CorporateActionEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

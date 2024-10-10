package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SupervisorRegistration;
import fpml.confirmation.SupervisorRegistrationModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SupervisorRegistrationOnlyExistsValidator implements ValidatorWithArg<SupervisorRegistration, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SupervisorRegistration> ValidationResult<SupervisorRegistration> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supervisorRegistrationModel", ExistenceChecker.isSet((SupervisorRegistrationModel) o.getSupervisorRegistrationModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SupervisorRegistration", ValidationType.ONLY_EXISTS, "SupervisorRegistration", path, "");
		}
		return failure("SupervisorRegistration", ValidationType.ONLY_EXISTS, "SupervisorRegistration", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

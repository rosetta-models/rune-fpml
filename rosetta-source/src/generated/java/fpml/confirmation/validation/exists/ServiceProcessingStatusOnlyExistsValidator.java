package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ServiceProcessingCycle;
import fpml.confirmation.ServiceProcessingEvent;
import fpml.confirmation.ServiceProcessingStatus;
import fpml.confirmation.ServiceProcessingStep;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ServiceProcessingStatusOnlyExistsValidator implements ValidatorWithArg<ServiceProcessingStatus, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ServiceProcessingStatus> ValidationResult<ServiceProcessingStatus> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cycle", ExistenceChecker.isSet((ServiceProcessingCycle) o.getCycle()))
				.put("step", ExistenceChecker.isSet((ServiceProcessingStep) o.getStep()))
				.put("event", ExistenceChecker.isSet((ServiceProcessingEvent) o.getEvent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ServiceProcessingStatus", ValidationType.ONLY_EXISTS, "ServiceProcessingStatus", path, "");
		}
		return failure("ServiceProcessingStatus", ValidationType.ONLY_EXISTS, "ServiceProcessingStatus", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

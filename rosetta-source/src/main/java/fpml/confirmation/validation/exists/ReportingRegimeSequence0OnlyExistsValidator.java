package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingRegimeName;
import fpml.confirmation.ReportingRegimeSequence0;
import fpml.confirmation.SupervisorRegistration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportingRegimeSequence0OnlyExistsValidator implements ValidatorWithArg<ReportingRegimeSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportingRegimeSequence0> ValidationResult<ReportingRegimeSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((ReportingRegimeName) o.getName()))
				.put("supervisorRegistration", ExistenceChecker.isSet((List<? extends SupervisorRegistration>) o.getSupervisorRegistration()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportingRegimeSequence0", ValidationType.ONLY_EXISTS, "ReportingRegimeSequence0", path, "");
		}
		return failure("ReportingRegimeSequence0", ValidationType.ONLY_EXISTS, "ReportingRegimeSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ActionType;
import fpml.confirmation.ReportingRegimeIdentifier;
import fpml.confirmation.ReportingRegimeIdentifierSequence;
import fpml.confirmation.ReportingRole;
import fpml.confirmation.SupervisorRegistration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportingRegimeIdentifierOnlyExistsValidator implements ValidatorWithArg<ReportingRegimeIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportingRegimeIdentifier> ValidationResult<ReportingRegimeIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportingRegimeIdentifierSequence", ExistenceChecker.isSet((ReportingRegimeIdentifierSequence) o.getReportingRegimeIdentifierSequence()))
				.put("supervisorRegistration", ExistenceChecker.isSet((List<? extends SupervisorRegistration>) o.getSupervisorRegistration()))
				.put("reportingRole", ExistenceChecker.isSet((ReportingRole) o.getReportingRole()))
				.put("actionType", ExistenceChecker.isSet((ActionType) o.getActionType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportingRegimeIdentifier", ValidationType.ONLY_EXISTS, "ReportingRegimeIdentifier", path, "");
		}
		return failure("ReportingRegimeIdentifier", ValidationType.ONLY_EXISTS, "ReportingRegimeIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

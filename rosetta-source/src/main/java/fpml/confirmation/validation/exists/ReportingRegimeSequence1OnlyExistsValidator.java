package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityExecutionExceptionDeclaration;
import fpml.confirmation.ReportingRegimeSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportingRegimeSequence1OnlyExistsValidator implements ValidatorWithArg<ReportingRegimeSequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportingRegimeSequence1> ValidationResult<ReportingRegimeSequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mandatoryFacilityExecution", ExistenceChecker.isSet((Boolean) o.getMandatoryFacilityExecution()))
				.put("mandatoryFacilityExecutionException", ExistenceChecker.isSet((Boolean) o.getMandatoryFacilityExecutionException()))
				.put("mandatoryFacilityExecutionExceptionDeclaration", ExistenceChecker.isSet((FacilityExecutionExceptionDeclaration) o.getMandatoryFacilityExecutionExceptionDeclaration()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportingRegimeSequence1", ValidationType.ONLY_EXISTS, "ReportingRegimeSequence1", path, "");
		}
		return failure("ReportingRegimeSequence1", ValidationType.ONLY_EXISTS, "ReportingRegimeSequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

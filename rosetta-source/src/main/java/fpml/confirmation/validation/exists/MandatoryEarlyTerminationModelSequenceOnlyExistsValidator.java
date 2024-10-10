package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MandatoryEarlyTermination;
import fpml.confirmation.MandatoryEarlyTerminationModelSequence;
import fpml.confirmation.Period;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MandatoryEarlyTerminationModelSequenceOnlyExistsValidator implements ValidatorWithArg<MandatoryEarlyTerminationModelSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MandatoryEarlyTerminationModelSequence> ValidationResult<MandatoryEarlyTerminationModelSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mandatoryEarlyTerminationDateTenor", ExistenceChecker.isSet((Period) o.getMandatoryEarlyTerminationDateTenor()))
				.put("mandatoryEarlyTermination", ExistenceChecker.isSet((MandatoryEarlyTermination) o.getMandatoryEarlyTermination()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MandatoryEarlyTerminationModelSequence", ValidationType.ONLY_EXISTS, "MandatoryEarlyTerminationModelSequence", path, "");
		}
		return failure("MandatoryEarlyTerminationModelSequence", ValidationType.ONLY_EXISTS, "MandatoryEarlyTerminationModelSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

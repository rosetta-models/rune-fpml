package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EarlyTerminationProvisionSequence;
import fpml.confirmation.MandatoryEarlyTerminationModel;
import fpml.confirmation.OptionalEarlyTerminationModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EarlyTerminationProvisionSequenceOnlyExistsValidator implements ValidatorWithArg<EarlyTerminationProvisionSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EarlyTerminationProvisionSequence> ValidationResult<EarlyTerminationProvisionSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mandatoryEarlyTerminationModel", ExistenceChecker.isSet((MandatoryEarlyTerminationModel) o.getMandatoryEarlyTerminationModel()))
				.put("optionalEarlyTerminationModel", ExistenceChecker.isSet((OptionalEarlyTerminationModel) o.getOptionalEarlyTerminationModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EarlyTerminationProvisionSequence", ValidationType.ONLY_EXISTS, "EarlyTerminationProvisionSequence", path, "");
		}
		return failure("EarlyTerminationProvisionSequence", ValidationType.ONLY_EXISTS, "EarlyTerminationProvisionSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

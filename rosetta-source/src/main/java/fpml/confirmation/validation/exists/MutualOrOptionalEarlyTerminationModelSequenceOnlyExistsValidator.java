package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EarlyTerminationDateEnum;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequence;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequenceSequence;
import fpml.confirmation.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MutualOrOptionalEarlyTerminationModelSequenceOnlyExistsValidator implements ValidatorWithArg<MutualOrOptionalEarlyTerminationModelSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MutualOrOptionalEarlyTerminationModelSequence> ValidationResult<MutualOrOptionalEarlyTerminationModelSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("optionalEarlyTermination", ExistenceChecker.isSet((Boolean) o.getOptionalEarlyTermination()))
				.put("optionalEarlyTerminationDate", ExistenceChecker.isSet((EarlyTerminationDateEnum) o.getOptionalEarlyTerminationDate()))
				.put("optionalEarlyTerminationElectingPartyReference", ExistenceChecker.isSet((PartyReference) o.getOptionalEarlyTerminationElectingPartyReference()))
				.put("breakFundingRecovery", ExistenceChecker.isSet((Boolean) o.getBreakFundingRecovery()))
				.put("mutualOrOptionalEarlyTerminationModelSequenceSequence", ExistenceChecker.isSet((MutualOrOptionalEarlyTerminationModelSequenceSequence) o.getMutualOrOptionalEarlyTerminationModelSequenceSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MutualOrOptionalEarlyTerminationModelSequence", ValidationType.ONLY_EXISTS, "MutualOrOptionalEarlyTerminationModelSequence", path, "");
		}
		return failure("MutualOrOptionalEarlyTerminationModelSequence", ValidationType.ONLY_EXISTS, "MutualOrOptionalEarlyTerminationModelSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

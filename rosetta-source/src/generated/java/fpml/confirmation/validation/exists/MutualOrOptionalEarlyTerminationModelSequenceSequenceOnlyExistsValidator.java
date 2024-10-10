package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeElectionEnum;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequenceSequence;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MutualOrOptionalEarlyTerminationModelSequenceSequenceOnlyExistsValidator implements ValidatorWithArg<MutualOrOptionalEarlyTerminationModelSequenceSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MutualOrOptionalEarlyTerminationModelSequenceSequence> ValidationResult<MutualOrOptionalEarlyTerminationModelSequenceSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("breakFeeElection", ExistenceChecker.isSet((FeeElectionEnum) o.getBreakFeeElection()))
				.put("breakFeeRate", ExistenceChecker.isSet((BigDecimal) o.getBreakFeeRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MutualOrOptionalEarlyTerminationModelSequenceSequence", ValidationType.ONLY_EXISTS, "MutualOrOptionalEarlyTerminationModelSequenceSequence", path, "");
		}
		return failure("MutualOrOptionalEarlyTerminationModelSequenceSequence", ValidationType.ONLY_EXISTS, "MutualOrOptionalEarlyTerminationModelSequenceSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

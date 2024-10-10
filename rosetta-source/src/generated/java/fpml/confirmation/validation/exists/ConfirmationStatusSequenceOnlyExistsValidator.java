package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConfirmationStatusSequence;
import fpml.confirmation.EventProposedMatch;
import fpml.confirmation.EventsChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ConfirmationStatusSequenceOnlyExistsValidator implements ValidatorWithArg<ConfirmationStatusSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ConfirmationStatusSequence> ValidationResult<ConfirmationStatusSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("assertedEvent", ExistenceChecker.isSet((EventsChoice) o.getAssertedEvent()))
				.put("proposedMatch", ExistenceChecker.isSet((List<? extends EventProposedMatch>) o.getProposedMatch()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ConfirmationStatusSequence", ValidationType.ONLY_EXISTS, "ConfirmationStatusSequence", path, "");
		}
		return failure("ConfirmationStatusSequence", ValidationType.ONLY_EXISTS, "ConfirmationStatusSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

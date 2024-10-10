package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventIdentifier;
import fpml.confirmation.EventIdentifierSequence;
import fpml.confirmation.TradeIdentifier;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EventIdentifierOnlyExistsValidator implements ValidatorWithArg<EventIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EventIdentifier> ValidationResult<EventIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifierSequence", ExistenceChecker.isSet((EventIdentifierSequence) o.getEventIdentifierSequence()))
				.put("tradeIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getTradeIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EventIdentifier", ValidationType.ONLY_EXISTS, "EventIdentifier", path, "");
		}
		return failure("EventIdentifier", ValidationType.ONLY_EXISTS, "EventIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

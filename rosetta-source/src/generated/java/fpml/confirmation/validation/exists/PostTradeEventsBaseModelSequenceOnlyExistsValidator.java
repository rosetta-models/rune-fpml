package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PostTradeEventsBaseModelSequence;
import fpml.confirmation.TerminatingEvent;
import fpml.confirmation.TradeNotionalChange;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PostTradeEventsBaseModelSequenceOnlyExistsValidator implements ValidatorWithArg<PostTradeEventsBaseModelSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PostTradeEventsBaseModelSequence> ValidationResult<PostTradeEventsBaseModelSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("terminatingEvent", ExistenceChecker.isSet((TerminatingEvent) o.getTerminatingEvent()))
				.put("termination", ExistenceChecker.isSet((TradeNotionalChange) o.getTermination()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PostTradeEventsBaseModelSequence", ValidationType.ONLY_EXISTS, "PostTradeEventsBaseModelSequence", path, "");
		}
		return failure("PostTradeEventsBaseModelSequence", ValidationType.ONLY_EXISTS, "PostTradeEventsBaseModelSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

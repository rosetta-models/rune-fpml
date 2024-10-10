package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompressionActivitySequence0;
import fpml.confirmation.TradeIdentifier;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CompressionActivitySequence0OnlyExistsValidator implements ValidatorWithArg<CompressionActivitySequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CompressionActivitySequence0> ValidationResult<CompressionActivitySequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("replacementTradeIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getReplacementTradeIdentifier()))
				.put("originatingTradeIdentifier", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getOriginatingTradeIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CompressionActivitySequence0", ValidationType.ONLY_EXISTS, "CompressionActivitySequence0", path, "");
		}
		return failure("CompressionActivitySequence0", ValidationType.ONLY_EXISTS, "CompressionActivitySequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

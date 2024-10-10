package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompressionActivitySequence1;
import fpml.confirmation.TradeId;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CompressionActivitySequence1OnlyExistsValidator implements ValidatorWithArg<CompressionActivitySequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CompressionActivitySequence1> ValidationResult<CompressionActivitySequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("replacementTradeId", ExistenceChecker.isSet((TradeId) o.getReplacementTradeId()))
				.put("originatingTradeId", ExistenceChecker.isSet((List<? extends TradeId>) o.getOriginatingTradeId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CompressionActivitySequence1", ValidationType.ONLY_EXISTS, "CompressionActivitySequence1", path, "");
		}
		return failure("CompressionActivitySequence1", ValidationType.ONLY_EXISTS, "CompressionActivitySequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

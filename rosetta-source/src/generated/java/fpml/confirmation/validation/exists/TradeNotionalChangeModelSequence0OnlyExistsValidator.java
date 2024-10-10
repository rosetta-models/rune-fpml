package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.TradeNotionalChangeModelSequence0;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeNotionalChangeModelSequence0OnlyExistsValidator implements ValidatorWithArg<TradeNotionalChangeModelSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeNotionalChangeModelSequence0> ValidationResult<TradeNotionalChangeModelSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("changeInNotionalAmount", ExistenceChecker.isSet((List<? extends NonNegativeMoney>) o.getChangeInNotionalAmount()))
				.put("outstandingNotionalAmount", ExistenceChecker.isSet((List<? extends NonNegativeMoney>) o.getOutstandingNotionalAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeNotionalChangeModelSequence0", ValidationType.ONLY_EXISTS, "TradeNotionalChangeModelSequence0", path, "");
		}
		return failure("TradeNotionalChangeModelSequence0", ValidationType.ONLY_EXISTS, "TradeNotionalChangeModelSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

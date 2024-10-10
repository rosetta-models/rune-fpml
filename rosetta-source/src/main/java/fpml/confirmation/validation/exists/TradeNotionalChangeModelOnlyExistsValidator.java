package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeNotionalChangeModel;
import fpml.confirmation.TradeNotionalChangeModelSequence0;
import fpml.confirmation.TradeNotionalChangeModelSequence1;
import fpml.confirmation.TradeNotionalChangeModelSequence2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeNotionalChangeModelOnlyExistsValidator implements ValidatorWithArg<TradeNotionalChangeModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeNotionalChangeModel> ValidationResult<TradeNotionalChangeModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeNotionalChangeModelSequence0", ExistenceChecker.isSet((TradeNotionalChangeModelSequence0) o.getTradeNotionalChangeModelSequence0()))
				.put("tradeNotionalChangeModelSequence1", ExistenceChecker.isSet((TradeNotionalChangeModelSequence1) o.getTradeNotionalChangeModelSequence1()))
				.put("tradeNotionalChangeModelSequence2", ExistenceChecker.isSet((TradeNotionalChangeModelSequence2) o.getTradeNotionalChangeModelSequence2()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeNotionalChangeModel", ValidationType.ONLY_EXISTS, "TradeNotionalChangeModel", path, "");
		}
		return failure("TradeNotionalChangeModel", ValidationType.ONLY_EXISTS, "TradeNotionalChangeModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

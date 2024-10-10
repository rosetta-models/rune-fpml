package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeTradeModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Trade;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FeeTradeModelOnlyExistsValidator implements ValidatorWithArg<FeeTradeModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FeeTradeModel> ValidationResult<FeeTradeModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("feeTradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getFeeTradeIdentifier()))
				.put("feeTrade", ExistenceChecker.isSet((Trade) o.getFeeTrade()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FeeTradeModel", ValidationType.ONLY_EXISTS, "FeeTradeModel", path, "");
		}
		return failure("FeeTradeModel", ValidationType.ONLY_EXISTS, "FeeTradeModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

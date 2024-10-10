package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ChangeEvent;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Payment;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeChangeContent;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeChangeContentOnlyExistsValidator implements ValidatorWithArg<TradeChangeContent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeChangeContent> ValidationResult<TradeChangeContent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("oldTradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getOldTradeIdentifier()))
				.put("oldTrade", ExistenceChecker.isSet((Trade) o.getOldTrade()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("changeEvent", ExistenceChecker.isSet((ChangeEvent) o.getChangeEvent()))
				.put("payment", ExistenceChecker.isSet((Payment) o.getPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeChangeContent", ValidationType.ONLY_EXISTS, "TradeChangeContent", path, "");
		}
		return failure("TradeChangeContent", ValidationType.ONLY_EXISTS, "TradeChangeContent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

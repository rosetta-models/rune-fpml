package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.TradeIdentifierSequence;
import fpml.confirmation.TradeIdentifierSequenceChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeIdentifierSequenceOnlyExistsValidator implements ValidatorWithArg<TradeIdentifierSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeIdentifierSequence> ValidationResult<TradeIdentifierSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyAndAccountReferencesModel", ExistenceChecker.isSet((PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel()))
				.put("tradeIdentifierSequenceChoice", ExistenceChecker.isSet((List<? extends TradeIdentifierSequenceChoice>) o.getTradeIdentifierSequenceChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeIdentifierSequence", ValidationType.ONLY_EXISTS, "TradeIdentifierSequence", path, "");
		}
		return failure("TradeIdentifierSequence", ValidationType.ONLY_EXISTS, "TradeIdentifierSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IssuerTradeIdModel;
import fpml.confirmation.LinkId;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.ProductComponentIdentifier;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradeIdentifierExtended;
import fpml.confirmation.TradeIdentifierSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyTradeIdentifierOnlyExistsValidator implements ValidatorWithArg<PartyTradeIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyTradeIdentifier> ValidationResult<PartyTradeIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("issuerTradeIdModel", ExistenceChecker.isSet((IssuerTradeIdModel) o.getIssuerTradeIdModel()))
				.put("tradeIdentifierSequence", ExistenceChecker.isSet((TradeIdentifierSequence) o.getTradeIdentifierSequence()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("linkId", ExistenceChecker.isSet((List<? extends LinkId>) o.getLinkId()))
				.put("allocationTradeId", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getAllocationTradeId()))
				.put("resultingTradeId", ExistenceChecker.isSet((List<? extends TradeIdentifierExtended>) o.getResultingTradeId()))
				.put("blockTradeId", ExistenceChecker.isSet((TradeIdentifier) o.getBlockTradeId()))
				.put("originatingTradeId", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getOriginatingTradeId()))
				.put("productComponentIdentifier", ExistenceChecker.isSet((List<? extends ProductComponentIdentifier>) o.getProductComponentIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyTradeIdentifier", ValidationType.ONLY_EXISTS, "PartyTradeIdentifier", path, "");
		}
		return failure("PartyTradeIdentifier", ValidationType.ONLY_EXISTS, "PartyTradeIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

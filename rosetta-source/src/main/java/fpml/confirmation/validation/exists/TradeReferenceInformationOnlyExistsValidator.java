package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OriginatingEvent;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PartyTradeInformation;
import fpml.confirmation.ProductId;
import fpml.confirmation.ProductType;
import fpml.confirmation.TerminatingEvent;
import fpml.confirmation.TradeReferenceInformation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeReferenceInformationOnlyExistsValidator implements ValidatorWithArg<TradeReferenceInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeReferenceInformation> ValidationResult<TradeReferenceInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("originatingEvent", ExistenceChecker.isSet((OriginatingEvent) o.getOriginatingEvent()))
				.put("terminatingEvent", ExistenceChecker.isSet((TerminatingEvent) o.getTerminatingEvent()))
				.put("partyTradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier()))
				.put("partyTradeInformation", ExistenceChecker.isSet((List<? extends PartyTradeInformation>) o.getPartyTradeInformation()))
				.put("productType", ExistenceChecker.isSet((ProductType) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((ProductId) o.getProductId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeReferenceInformation", ValidationType.ONLY_EXISTS, "TradeReferenceInformation", path, "");
		}
		return failure("TradeReferenceInformation", ValidationType.ONLY_EXISTS, "TradeReferenceInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

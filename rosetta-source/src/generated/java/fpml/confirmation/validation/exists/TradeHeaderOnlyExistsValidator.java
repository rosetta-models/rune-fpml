package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.PackageSummary;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.PartyTradeInformation;
import fpml.confirmation.ProductSummary;
import fpml.confirmation.TradeHeader;
import fpml.confirmation.TradeSummary;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeHeaderOnlyExistsValidator implements ValidatorWithArg<TradeHeader, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeHeader> ValidationResult<TradeHeader> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyTradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier()))
				.put("partyTradeInformation", ExistenceChecker.isSet((List<? extends PartyTradeInformation>) o.getPartyTradeInformation()))
				.put("tradeSummary", ExistenceChecker.isSet((TradeSummary) o.getTradeSummary()))
				.put("productSummary", ExistenceChecker.isSet((ProductSummary) o.getProductSummary()))
				.put("originatingPackage", ExistenceChecker.isSet((PackageSummary) o.getOriginatingPackage()))
				.put("tradeDate", ExistenceChecker.isSet((IdentifiedDate) o.getTradeDate()))
				.put("clearedDate", ExistenceChecker.isSet((IdentifiedDate) o.getClearedDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeHeader", ValidationType.ONLY_EXISTS, "TradeHeader", path, "");
		}
		return failure("TradeHeader", ValidationType.ONLY_EXISTS, "TradeHeader", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

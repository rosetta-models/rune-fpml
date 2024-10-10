package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingStatusItem;
import fpml.confirmation.ClearingStatusValue;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Reason;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.TradePackage;
import fpml.confirmation.TradeReferenceInformationModel;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ClearingStatusItemOnlyExistsValidator implements ValidatorWithArg<ClearingStatusItem, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ClearingStatusItem> ValidationResult<ClearingStatusItem> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeIdentifier", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getTradeIdentifier()))
				.put("tradeReferenceInformationModel", ExistenceChecker.isSet((TradeReferenceInformationModel) o.getTradeReferenceInformationModel()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("tradePackage", ExistenceChecker.isSet((TradePackage) o.getTradePackage()))
				.put("clearingStatusValue", ExistenceChecker.isSet((ClearingStatusValue) o.getClearingStatusValue()))
				.put("updatedDateTime", ExistenceChecker.isSet((ZonedDateTime) o.getUpdatedDateTime()))
				.put("reason", ExistenceChecker.isSet((List<? extends Reason>) o.getReason()))
				.put("statusAppliesTo", ExistenceChecker.isSet((List<? extends PartyReference>) o.getStatusAppliesTo()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ClearingStatusItem", ValidationType.ONLY_EXISTS, "ClearingStatusItem", path, "");
		}
		return failure("ClearingStatusItem", ValidationType.ONLY_EXISTS, "ClearingStatusItem", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

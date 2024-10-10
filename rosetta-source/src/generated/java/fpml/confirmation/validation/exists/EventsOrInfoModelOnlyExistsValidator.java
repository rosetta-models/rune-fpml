package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventsOrInfoModel;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EventsOrInfoModelOnlyExistsValidator implements ValidatorWithArg<EventsOrInfoModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EventsOrInfoModel> ValidationResult<EventsOrInfoModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradingAndPostTradeEventsModel", ExistenceChecker.isSet((TradingAndPostTradeEventsModel) o.getTradingAndPostTradeEventsModel()))
				.put("tradeReferenceInformationModel", ExistenceChecker.isSet((TradeReferenceInformationModel) o.getTradeReferenceInformationModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EventsOrInfoModel", ValidationType.ONLY_EXISTS, "EventsOrInfoModel", path, "");
		}
		return failure("EventsOrInfoModel", ValidationType.ONLY_EXISTS, "EventsOrInfoModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

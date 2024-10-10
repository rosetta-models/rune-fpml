package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdditionalEvent;
import fpml.confirmation.ChangeEventsBaseModel;
import fpml.confirmation.EventsChoice;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.PostTradeEventsBaseModel;
import fpml.confirmation.TradingEventsBaseModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EventsChoiceOnlyExistsValidator implements ValidatorWithArg<EventsChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EventsChoice> ValidationResult<EventsChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradingEventsBaseModel", ExistenceChecker.isSet((TradingEventsBaseModel) o.getTradingEventsBaseModel()))
				.put("postTradeEventsBaseModel", ExistenceChecker.isSet((PostTradeEventsBaseModel) o.getPostTradeEventsBaseModel()))
				.put("changeEventsBaseModel", ExistenceChecker.isSet((ChangeEventsBaseModel) o.getChangeEventsBaseModel()))
				.put("optionsEventsBaseModel", ExistenceChecker.isSet((OptionsEventsBaseModel) o.getOptionsEventsBaseModel()))
				.put("additionalEvent", ExistenceChecker.isSet((AdditionalEvent) o.getAdditionalEvent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EventsChoice", ValidationType.ONLY_EXISTS, "EventsChoice", path, "");
		}
		return failure("EventsChoice", ValidationType.ONLY_EXISTS, "EventsChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

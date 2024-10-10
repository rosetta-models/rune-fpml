package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.KnockOutRateObservation;
import fpml.confirmation.NoTouchRateObservation;
import fpml.confirmation.OptionEvent;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.TouchRateObservation;
import fpml.confirmation.Trade;
import fpml.confirmation.TriggerRateObservation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionEventOnlyExistsValidator implements ValidatorWithArg<OptionEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionEvent> ValidationResult<OptionEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("originalTrade", ExistenceChecker.isSet((Trade) o.getOriginalTrade()))
				.put("tradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getTradeIdentifier()))
				.put("knockIn", ExistenceChecker.isSet((TriggerRateObservation) o.getKnockIn()))
				.put("knockOut", ExistenceChecker.isSet((KnockOutRateObservation) o.getKnockOut()))
				.put("touch", ExistenceChecker.isSet((List<? extends TouchRateObservation>) o.getTouch()))
				.put("noTouch", ExistenceChecker.isSet((NoTouchRateObservation) o.getNoTouch()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionEvent", ValidationType.ONLY_EXISTS, "OptionEvent", path, "");
		}
		return failure("OptionEvent", ValidationType.ONLY_EXISTS, "OptionEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

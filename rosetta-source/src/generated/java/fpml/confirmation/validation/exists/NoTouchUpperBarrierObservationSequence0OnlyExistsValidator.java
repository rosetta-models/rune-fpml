package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence0;
import fpml.confirmation.ObservedRate;
import fpml.confirmation.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NoTouchUpperBarrierObservationSequence0OnlyExistsValidator implements ValidatorWithArg<NoTouchUpperBarrierObservationSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NoTouchUpperBarrierObservationSequence0> ValidationResult<NoTouchUpperBarrierObservationSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("triggerRate", ExistenceChecker.isSet((BigDecimal) o.getTriggerRate()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("maximumObservedRate", ExistenceChecker.isSet((ObservedRate) o.getMaximumObservedRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NoTouchUpperBarrierObservationSequence0", ValidationType.ONLY_EXISTS, "NoTouchUpperBarrierObservationSequence0", path, "");
		}
		return failure("NoTouchUpperBarrierObservationSequence0", ValidationType.ONLY_EXISTS, "NoTouchUpperBarrierObservationSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

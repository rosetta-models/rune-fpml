package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence1;
import fpml.confirmation.ObservedPrice;
import fpml.confirmation.PositiveMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NoTouchUpperBarrierObservationSequence1OnlyExistsValidator implements ValidatorWithArg<NoTouchUpperBarrierObservationSequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NoTouchUpperBarrierObservationSequence1> ValidationResult<NoTouchUpperBarrierObservationSequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("triggerPrice", ExistenceChecker.isSet((PositiveMoney) o.getTriggerPrice()))
				.put("maximumObservedPrice", ExistenceChecker.isSet((ObservedPrice) o.getMaximumObservedPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NoTouchUpperBarrierObservationSequence1", ValidationType.ONLY_EXISTS, "NoTouchUpperBarrierObservationSequence1", path, "");
		}
		return failure("NoTouchUpperBarrierObservationSequence1", ValidationType.ONLY_EXISTS, "NoTouchUpperBarrierObservationSequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

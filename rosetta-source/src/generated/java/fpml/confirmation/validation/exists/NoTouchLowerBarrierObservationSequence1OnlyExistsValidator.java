package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence1;
import fpml.confirmation.ObservedPrice;
import fpml.confirmation.PositiveMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NoTouchLowerBarrierObservationSequence1OnlyExistsValidator implements ValidatorWithArg<NoTouchLowerBarrierObservationSequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NoTouchLowerBarrierObservationSequence1> ValidationResult<NoTouchLowerBarrierObservationSequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("triggerPrice", ExistenceChecker.isSet((PositiveMoney) o.getTriggerPrice()))
				.put("minimumObservedPrice", ExistenceChecker.isSet((ObservedPrice) o.getMinimumObservedPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NoTouchLowerBarrierObservationSequence1", ValidationType.ONLY_EXISTS, "NoTouchLowerBarrierObservationSequence1", path, "");
		}
		return failure("NoTouchLowerBarrierObservationSequence1", ValidationType.ONLY_EXISTS, "NoTouchLowerBarrierObservationSequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchLowerBarrierObservation;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence0;
import fpml.confirmation.NoTouchLowerBarrierObservationSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NoTouchLowerBarrierObservationOnlyExistsValidator implements ValidatorWithArg<NoTouchLowerBarrierObservation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NoTouchLowerBarrierObservation> ValidationResult<NoTouchLowerBarrierObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("noTouchLowerBarrierObservationSequence0", ExistenceChecker.isSet((NoTouchLowerBarrierObservationSequence0) o.getNoTouchLowerBarrierObservationSequence0()))
				.put("noTouchLowerBarrierObservationSequence1", ExistenceChecker.isSet((NoTouchLowerBarrierObservationSequence1) o.getNoTouchLowerBarrierObservationSequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NoTouchLowerBarrierObservation", ValidationType.ONLY_EXISTS, "NoTouchLowerBarrierObservation", path, "");
		}
		return failure("NoTouchLowerBarrierObservation", ValidationType.ONLY_EXISTS, "NoTouchLowerBarrierObservation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchUpperBarrierObservation;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence0;
import fpml.confirmation.NoTouchUpperBarrierObservationSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NoTouchUpperBarrierObservationOnlyExistsValidator implements ValidatorWithArg<NoTouchUpperBarrierObservation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NoTouchUpperBarrierObservation> ValidationResult<NoTouchUpperBarrierObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("noTouchUpperBarrierObservationSequence0", ExistenceChecker.isSet((NoTouchUpperBarrierObservationSequence0) o.getNoTouchUpperBarrierObservationSequence0()))
				.put("noTouchUpperBarrierObservationSequence1", ExistenceChecker.isSet((NoTouchUpperBarrierObservationSequence1) o.getNoTouchUpperBarrierObservationSequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NoTouchUpperBarrierObservation", ValidationType.ONLY_EXISTS, "NoTouchUpperBarrierObservation", path, "");
		}
		return failure("NoTouchUpperBarrierObservation", ValidationType.ONLY_EXISTS, "NoTouchUpperBarrierObservation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

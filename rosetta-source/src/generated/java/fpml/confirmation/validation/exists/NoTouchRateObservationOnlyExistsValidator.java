package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NoTouchRateObservation;
import fpml.confirmation.NoTouchRateObservationSequence0;
import fpml.confirmation.NoTouchRateObservationSequence1;
import fpml.confirmation.NoTouchUpperBarrierObservation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NoTouchRateObservationOnlyExistsValidator implements ValidatorWithArg<NoTouchRateObservation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NoTouchRateObservation> ValidationResult<NoTouchRateObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observationStartDate", ExistenceChecker.isSet((Date) o.getObservationStartDate()))
				.put("observationEndDate", ExistenceChecker.isSet((Date) o.getObservationEndDate()))
				.put("noTouchRateObservationSequence0", ExistenceChecker.isSet((NoTouchRateObservationSequence0) o.getNoTouchRateObservationSequence0()))
				.put("upperBarrier", ExistenceChecker.isSet((NoTouchUpperBarrierObservation) o.getUpperBarrier()))
				.put("noTouchRateObservationSequence1", ExistenceChecker.isSet((NoTouchRateObservationSequence1) o.getNoTouchRateObservationSequence1()))
				.put("isExercisable", ExistenceChecker.isSet((Boolean) o.getIsExercisable()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NoTouchRateObservation", ValidationType.ONLY_EXISTS, "NoTouchRateObservation", path, "");
		}
		return failure("NoTouchRateObservation", ValidationType.ONLY_EXISTS, "NoTouchRateObservation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

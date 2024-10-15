package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxComplexBarrierBaseSequence0;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxComplexBarrierBaseSequence0OnlyExistsValidator implements ValidatorWithArg<FxComplexBarrierBaseSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxComplexBarrierBaseSequence0> ValidationResult<FxComplexBarrierBaseSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observationStartDate", ExistenceChecker.isSet((Date) o.getObservationStartDate()))
				.put("observationStartTime", ExistenceChecker.isSet((BusinessCenterTime) o.getObservationStartTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxComplexBarrierBaseSequence0", ValidationType.ONLY_EXISTS, "FxComplexBarrierBaseSequence0", path, "");
		}
		return failure("FxComplexBarrierBaseSequence0", ValidationType.ONLY_EXISTS, "FxComplexBarrierBaseSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

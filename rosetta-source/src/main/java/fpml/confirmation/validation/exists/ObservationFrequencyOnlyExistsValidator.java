package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ObservationFrequency;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.RollConventionEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ObservationFrequencyOnlyExistsValidator implements ValidatorWithArg<ObservationFrequency, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ObservationFrequency> ValidationResult<ObservationFrequency> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("periodMultiplier", ExistenceChecker.isSet((Integer) o.getPeriodMultiplier()))
				.put("period", ExistenceChecker.isSet((PeriodEnum) o.getPeriod()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("periodConvention", ExistenceChecker.isSet((RollConventionEnum) o.getPeriodConvention()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ObservationFrequency", ValidationType.ONLY_EXISTS, "ObservationFrequency", path, "");
		}
		return failure("ObservationFrequency", ValidationType.ONLY_EXISTS, "ObservationFrequency", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

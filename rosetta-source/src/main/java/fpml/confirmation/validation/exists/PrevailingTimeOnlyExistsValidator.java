package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrevailingTime;
import fpml.confirmation.TimezoneLocation;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PrevailingTimeOnlyExistsValidator implements ValidatorWithArg<PrevailingTime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PrevailingTime> ValidationResult<PrevailingTime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("hourMinuteTime", ExistenceChecker.isSet((LocalTime) o.getHourMinuteTime()))
				.put("location", ExistenceChecker.isSet((TimezoneLocation) o.getLocation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PrevailingTime", ValidationType.ONLY_EXISTS, "PrevailingTime", path, "");
		}
		return failure("PrevailingTime", ValidationType.ONLY_EXISTS, "PrevailingTime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Period;
import fpml.confirmation.TimeDimension;
import fpml.confirmation.TimeDimensionSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TimeDimensionOnlyExistsValidator implements ValidatorWithArg<TimeDimension, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TimeDimension> ValidationResult<TimeDimension> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tenor", ExistenceChecker.isSet((Period) o.getTenor()))
				.put("timeDimensionSequence", ExistenceChecker.isSet((TimeDimensionSequence) o.getTimeDimensionSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TimeDimension", ValidationType.ONLY_EXISTS, "TimeDimension", path, "");
		}
		return failure("TimeDimension", ValidationType.ONLY_EXISTS, "TimeDimension", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

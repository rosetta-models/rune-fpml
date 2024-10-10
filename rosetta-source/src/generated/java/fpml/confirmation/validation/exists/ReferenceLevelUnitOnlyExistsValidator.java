package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceLevelUnit;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReferenceLevelUnitOnlyExistsValidator implements ValidatorWithArg<ReferenceLevelUnit, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReferenceLevelUnit> ValidationResult<ReferenceLevelUnit> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("weatherIndexReferenceLevelScheme", ExistenceChecker.isSet((String) o.getWeatherIndexReferenceLevelScheme()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReferenceLevelUnit", ValidationType.ONLY_EXISTS, "ReferenceLevelUnit", path, "");
		}
		return failure("ReferenceLevelUnit", ValidationType.ONLY_EXISTS, "ReferenceLevelUnit", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

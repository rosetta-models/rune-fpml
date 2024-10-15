package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDateOffset;
import fpml.confirmation.FxOffsetConventionEnum;
import fpml.confirmation.FxScheduleReference;
import fpml.confirmation.Period;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxDateOffsetOnlyExistsValidator implements ValidatorWithArg<FxDateOffset, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxDateOffset> ValidationResult<FxDateOffset> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("convention", ExistenceChecker.isSet((FxOffsetConventionEnum) o.getConvention()))
				.put("offset", ExistenceChecker.isSet((Period) o.getOffset()))
				.put("relativeTo", ExistenceChecker.isSet((FxScheduleReference) o.getRelativeTo()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxDateOffset", ValidationType.ONLY_EXISTS, "FxDateOffset", path, "");
		}
		return failure("FxDateOffset", ValidationType.ONLY_EXISTS, "FxDateOffset", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AdjustableOrRelativeDates;
import fpml.confirmation.RelativeDates;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdjustableOrRelativeDatesOnlyExistsValidator implements ValidatorWithArg<AdjustableOrRelativeDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdjustableOrRelativeDates> ValidationResult<AdjustableOrRelativeDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("adjustableDates", ExistenceChecker.isSet((AdjustableDates) o.getAdjustableDates()))
				.put("relativeDates", ExistenceChecker.isSet((RelativeDates) o.getRelativeDates()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdjustableOrRelativeDates", ValidationType.ONLY_EXISTS, "AdjustableOrRelativeDates", path, "");
		}
		return failure("AdjustableOrRelativeDates", ValidationType.ONLY_EXISTS, "AdjustableOrRelativeDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

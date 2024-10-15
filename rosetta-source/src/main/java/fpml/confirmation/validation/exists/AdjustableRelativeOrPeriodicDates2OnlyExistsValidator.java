package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.PeriodicDates;
import fpml.confirmation.RelativeDates;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdjustableRelativeOrPeriodicDates2OnlyExistsValidator implements ValidatorWithArg<AdjustableRelativeOrPeriodicDates2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdjustableRelativeOrPeriodicDates2> ValidationResult<AdjustableRelativeOrPeriodicDates2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("adjustableDates", ExistenceChecker.isSet((AdjustableDates) o.getAdjustableDates()))
				.put("relativeDates", ExistenceChecker.isSet((RelativeDates) o.getRelativeDates()))
				.put("periodicDates", ExistenceChecker.isSet((PeriodicDates) o.getPeriodicDates()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdjustableRelativeOrPeriodicDates2", ValidationType.ONLY_EXISTS, "AdjustableRelativeOrPeriodicDates2", path, "");
		}
		return failure("AdjustableRelativeOrPeriodicDates2", ValidationType.ONLY_EXISTS, "AdjustableRelativeOrPeriodicDates2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

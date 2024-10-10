package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDates;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPhysicalAmericanExerciseSequence0OnlyExistsValidator implements ValidatorWithArg<CommodityPhysicalAmericanExerciseSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPhysicalAmericanExerciseSequence0> ValidationResult<CommodityPhysicalAmericanExerciseSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commencementDates", ExistenceChecker.isSet((AdjustableOrRelativeDates) o.getCommencementDates()))
				.put("expirationDates", ExistenceChecker.isSet((AdjustableOrRelativeDates) o.getExpirationDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPhysicalAmericanExerciseSequence0", ValidationType.ONLY_EXISTS, "CommodityPhysicalAmericanExerciseSequence0", path, "");
		}
		return failure("CommodityPhysicalAmericanExerciseSequence0", ValidationType.ONLY_EXISTS, "CommodityPhysicalAmericanExerciseSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

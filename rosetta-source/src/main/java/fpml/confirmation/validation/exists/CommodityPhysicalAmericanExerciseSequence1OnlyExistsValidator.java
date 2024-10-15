package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence1;
import fpml.confirmation.CommodityRelativeExpirationDates;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPhysicalAmericanExerciseSequence1OnlyExistsValidator implements ValidatorWithArg<CommodityPhysicalAmericanExerciseSequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPhysicalAmericanExerciseSequence1> ValidationResult<CommodityPhysicalAmericanExerciseSequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("relativeCommencementDates", ExistenceChecker.isSet((CommodityRelativeExpirationDates) o.getRelativeCommencementDates()))
				.put("relativeExpirationDates", ExistenceChecker.isSet((CommodityRelativeExpirationDates) o.getRelativeExpirationDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPhysicalAmericanExerciseSequence1", ValidationType.ONLY_EXISTS, "CommodityPhysicalAmericanExerciseSequence1", path, "");
		}
		return failure("CommodityPhysicalAmericanExerciseSequence1", ValidationType.ONLY_EXISTS, "CommodityPhysicalAmericanExerciseSequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

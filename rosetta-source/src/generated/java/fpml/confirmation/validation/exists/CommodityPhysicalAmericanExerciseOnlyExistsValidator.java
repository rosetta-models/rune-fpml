package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalAmericanExercise;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence1;
import fpml.confirmation.PrevailingTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPhysicalAmericanExerciseOnlyExistsValidator implements ValidatorWithArg<CommodityPhysicalAmericanExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPhysicalAmericanExercise> ValidationResult<CommodityPhysicalAmericanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commodityPhysicalAmericanExerciseSequence0", ExistenceChecker.isSet((CommodityPhysicalAmericanExerciseSequence0) o.getCommodityPhysicalAmericanExerciseSequence0()))
				.put("commodityPhysicalAmericanExerciseSequence1", ExistenceChecker.isSet((CommodityPhysicalAmericanExerciseSequence1) o.getCommodityPhysicalAmericanExerciseSequence1()))
				.put("latestExerciseTime", ExistenceChecker.isSet((PrevailingTime) o.getLatestExerciseTime()))
				.put("expirationTime", ExistenceChecker.isSet((PrevailingTime) o.getExpirationTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPhysicalAmericanExercise", ValidationType.ONLY_EXISTS, "CommodityPhysicalAmericanExercise", path, "");
		}
		return failure("CommodityPhysicalAmericanExercise", ValidationType.ONLY_EXISTS, "CommodityPhysicalAmericanExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

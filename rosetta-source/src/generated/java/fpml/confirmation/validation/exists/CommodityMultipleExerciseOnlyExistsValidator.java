package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMultipleExercise;
import fpml.confirmation.CommodityNotionalQuantity;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityMultipleExerciseOnlyExistsValidator implements ValidatorWithArg<CommodityMultipleExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityMultipleExercise> ValidationResult<CommodityMultipleExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("integralMultipleQuantity", ExistenceChecker.isSet((CommodityNotionalQuantity) o.getIntegralMultipleQuantity()))
				.put("minimumNotionalQuantity", ExistenceChecker.isSet((CommodityNotionalQuantity) o.getMinimumNotionalQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityMultipleExercise", ValidationType.ONLY_EXISTS, "CommodityMultipleExercise", path, "");
		}
		return failure("CommodityMultipleExercise", ValidationType.ONLY_EXISTS, "CommodityMultipleExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityAmericanExerciseSequence;
import fpml.confirmation.CommodityExercisePeriods;
import fpml.confirmation.Frequency;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityAmericanExerciseSequenceOnlyExistsValidator implements ValidatorWithArg<CommodityAmericanExerciseSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityAmericanExerciseSequence> ValidationResult<CommodityAmericanExerciseSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("exercisePeriod", ExistenceChecker.isSet((List<? extends CommodityExercisePeriods>) o.getExercisePeriod()))
				.put("exerciseFrequency", ExistenceChecker.isSet((Frequency) o.getExerciseFrequency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityAmericanExerciseSequence", ValidationType.ONLY_EXISTS, "CommodityAmericanExerciseSequence", path, "");
		}
		return failure("CommodityAmericanExerciseSequence", ValidationType.ONLY_EXISTS, "CommodityAmericanExerciseSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

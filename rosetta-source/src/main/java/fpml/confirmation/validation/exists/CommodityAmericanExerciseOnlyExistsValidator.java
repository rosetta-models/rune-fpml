package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CommodityAmericanExercise;
import fpml.confirmation.CommodityAmericanExerciseSequence;
import fpml.confirmation.CommodityExercisePeriods;
import fpml.confirmation.CommodityMultipleExercise;
import fpml.confirmation.DeterminationMethod;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityAmericanExerciseOnlyExistsValidator implements ValidatorWithArg<CommodityAmericanExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityAmericanExercise> ValidationResult<CommodityAmericanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("exercisePeriod", ExistenceChecker.isSet((CommodityExercisePeriods) o.getExercisePeriod()))
				.put("commodityAmericanExerciseSequence", ExistenceChecker.isSet((CommodityAmericanExerciseSequence) o.getCommodityAmericanExerciseSequence()))
				.put("latestExerciseTime", ExistenceChecker.isSet((BusinessCenterTime) o.getLatestExerciseTime()))
				.put("latestExerciseTimeDetermination", ExistenceChecker.isSet((DeterminationMethod) o.getLatestExerciseTimeDetermination()))
				.put("expirationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getExpirationTime()))
				.put("multipleExercise", ExistenceChecker.isSet((CommodityMultipleExercise) o.getMultipleExercise()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityAmericanExercise", ValidationType.ONLY_EXISTS, "CommodityAmericanExercise", path, "");
		}
		return failure("CommodityAmericanExercise", ValidationType.ONLY_EXISTS, "CommodityAmericanExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

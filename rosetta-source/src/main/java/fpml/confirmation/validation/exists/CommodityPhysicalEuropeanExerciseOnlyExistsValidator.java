package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.CommodityPhysicalEuropeanExercise;
import fpml.confirmation.CommodityRelativeExpirationDates;
import fpml.confirmation.PrevailingTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPhysicalEuropeanExerciseOnlyExistsValidator implements ValidatorWithArg<CommodityPhysicalEuropeanExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPhysicalEuropeanExercise> ValidationResult<CommodityPhysicalEuropeanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("expirationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getExpirationDate()))
				.put("expirationDates", ExistenceChecker.isSet((AdjustableRelativeOrPeriodicDates2) o.getExpirationDates()))
				.put("relativeExpirationDates", ExistenceChecker.isSet((CommodityRelativeExpirationDates) o.getRelativeExpirationDates()))
				.put("expirationTime", ExistenceChecker.isSet((PrevailingTime) o.getExpirationTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPhysicalEuropeanExercise", ValidationType.ONLY_EXISTS, "CommodityPhysicalEuropeanExercise", path, "");
		}
		return failure("CommodityPhysicalEuropeanExercise", ValidationType.ONLY_EXISTS, "CommodityPhysicalEuropeanExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

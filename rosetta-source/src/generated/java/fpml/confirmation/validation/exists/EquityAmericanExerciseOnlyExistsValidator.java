package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.EquityAmericanExercise;
import fpml.confirmation.EquityExpirationModel;
import fpml.confirmation.EquityMultipleExercise;
import fpml.confirmation.TimeTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityAmericanExerciseOnlyExistsValidator implements ValidatorWithArg<EquityAmericanExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityAmericanExercise> ValidationResult<EquityAmericanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commencementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCommencementDate()))
				.put("expirationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getExpirationDate()))
				.put("latestExerciseTime", ExistenceChecker.isSet((BusinessCenterTime) o.getLatestExerciseTime()))
				.put("latestExerciseTimeDetermination", ExistenceChecker.isSet((DeterminationMethod) o.getLatestExerciseTimeDetermination()))
				.put("latestExerciseTimeType", ExistenceChecker.isSet((TimeTypeEnum) o.getLatestExerciseTimeType()))
				.put("equityExpirationModel", ExistenceChecker.isSet((EquityExpirationModel) o.getEquityExpirationModel()))
				.put("equityMultipleExercise", ExistenceChecker.isSet((EquityMultipleExercise) o.getEquityMultipleExercise()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityAmericanExercise", ValidationType.ONLY_EXISTS, "EquityAmericanExercise", path, "");
		}
		return failure("EquityAmericanExercise", ValidationType.ONLY_EXISTS, "EquityAmericanExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

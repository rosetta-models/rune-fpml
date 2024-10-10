package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CutName;
import fpml.confirmation.FxAmericanExercise;
import fpml.confirmation.FxMultipleExercise;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAmericanExerciseOnlyExistsValidator implements ValidatorWithArg<FxAmericanExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAmericanExercise> ValidationResult<FxAmericanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("commencementDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCommencementDate()))
				.put("expiryDate", ExistenceChecker.isSet((Date) o.getExpiryDate()))
				.put("expiryTime", ExistenceChecker.isSet((BusinessCenterTime) o.getExpiryTime()))
				.put("cutName", ExistenceChecker.isSet((CutName) o.getCutName()))
				.put("latestValueDate", ExistenceChecker.isSet((Date) o.getLatestValueDate()))
				.put("multipleExercise", ExistenceChecker.isSet((FxMultipleExercise) o.getMultipleExercise()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAmericanExercise", ValidationType.ONLY_EXISTS, "FxAmericanExercise", path, "");
		}
		return failure("FxAmericanExercise", ValidationType.ONLY_EXISTS, "FxAmericanExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

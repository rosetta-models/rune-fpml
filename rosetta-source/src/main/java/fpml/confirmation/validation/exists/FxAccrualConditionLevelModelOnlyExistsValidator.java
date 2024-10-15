package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualAverageStrikeReference;
import fpml.confirmation.FxAccrualConditionLevelModel;
import fpml.confirmation.FxAccrualConditionLevelModelSequence;
import fpml.confirmation.FxAccrualStrikeReference;
import fpml.confirmation.FxAccrualTriggerReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualConditionLevelModelOnlyExistsValidator implements ValidatorWithArg<FxAccrualConditionLevelModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualConditionLevelModel> ValidationResult<FxAccrualConditionLevelModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxAccrualConditionLevelModelSequence", ExistenceChecker.isSet((FxAccrualConditionLevelModelSequence) o.getFxAccrualConditionLevelModelSequence()))
				.put("strikeReference", ExistenceChecker.isSet((FxAccrualStrikeReference) o.getStrikeReference()))
				.put("averageStrikeReference", ExistenceChecker.isSet((FxAccrualAverageStrikeReference) o.getAverageStrikeReference()))
				.put("triggerReference", ExistenceChecker.isSet((FxAccrualTriggerReference) o.getTriggerReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualConditionLevelModel", ValidationType.ONLY_EXISTS, "FxAccrualConditionLevelModel", path, "");
		}
		return failure("FxAccrualConditionLevelModel", ValidationType.ONLY_EXISTS, "FxAccrualConditionLevelModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

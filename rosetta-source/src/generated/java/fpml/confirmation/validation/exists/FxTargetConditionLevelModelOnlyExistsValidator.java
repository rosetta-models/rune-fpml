package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxComplexBarrierBaseReference;
import fpml.confirmation.FxLevel;
import fpml.confirmation.FxLevelReference;
import fpml.confirmation.FxPivotReference;
import fpml.confirmation.FxStrikeReference;
import fpml.confirmation.FxTargetConditionLevelModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetConditionLevelModelOnlyExistsValidator implements ValidatorWithArg<FxTargetConditionLevelModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetConditionLevelModel> ValidationResult<FxTargetConditionLevelModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("level", ExistenceChecker.isSet((FxLevel) o.getLevel()))
				.put("strikeReference", ExistenceChecker.isSet((FxStrikeReference) o.getStrikeReference()))
				.put("pivotReference", ExistenceChecker.isSet((FxPivotReference) o.getPivotReference()))
				.put("barrierReference", ExistenceChecker.isSet((FxComplexBarrierBaseReference) o.getBarrierReference()))
				.put("levelReference", ExistenceChecker.isSet((FxLevelReference) o.getLevelReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetConditionLevelModel", ValidationType.ONLY_EXISTS, "FxTargetConditionLevelModel", path, "");
		}
		return failure("FxTargetConditionLevelModel", ValidationType.ONLY_EXISTS, "FxTargetConditionLevelModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

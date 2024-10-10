package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualConditionLevelModel;
import fpml.confirmation.FxAccrualRegionLowerBound;
import fpml.confirmation.FxRegionLowerBoundDirectionEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualRegionLowerBoundOnlyExistsValidator implements ValidatorWithArg<FxAccrualRegionLowerBound, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualRegionLowerBound> ValidationResult<FxAccrualRegionLowerBound> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("condition", ExistenceChecker.isSet((FxRegionLowerBoundDirectionEnum) o.getCondition()))
				.put("fxAccrualConditionLevelModel", ExistenceChecker.isSet((FxAccrualConditionLevelModel) o.getFxAccrualConditionLevelModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualRegionLowerBound", ValidationType.ONLY_EXISTS, "FxAccrualRegionLowerBound", path, "");
		}
		return failure("FxAccrualRegionLowerBound", ValidationType.ONLY_EXISTS, "FxAccrualRegionLowerBound", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

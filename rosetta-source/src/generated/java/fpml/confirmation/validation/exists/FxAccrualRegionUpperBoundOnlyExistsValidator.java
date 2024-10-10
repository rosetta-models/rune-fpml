package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualConditionLevelModel;
import fpml.confirmation.FxAccrualRegionUpperBound;
import fpml.confirmation.FxRegionUpperBoundDirectionEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualRegionUpperBoundOnlyExistsValidator implements ValidatorWithArg<FxAccrualRegionUpperBound, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualRegionUpperBound> ValidationResult<FxAccrualRegionUpperBound> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("condition", ExistenceChecker.isSet((FxRegionUpperBoundDirectionEnum) o.getCondition()))
				.put("fxAccrualConditionLevelModel", ExistenceChecker.isSet((FxAccrualConditionLevelModel) o.getFxAccrualConditionLevelModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualRegionUpperBound", ValidationType.ONLY_EXISTS, "FxAccrualRegionUpperBound", path, "");
		}
		return failure("FxAccrualRegionUpperBound", ValidationType.ONLY_EXISTS, "FxAccrualRegionUpperBound", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

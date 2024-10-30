package cdm.observable.asset.validation.exists;

import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRateIndexOnlyExistsValidator implements ValidatorWithArg<FloatingRateIndex, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateIndex> ValidationResult<FloatingRateIndex> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("InterestRateIndex", ExistenceChecker.isSet((InterestRateIndex) o.getInterestRateIndex()))
				.put("InflationIndex", ExistenceChecker.isSet((InflationIndex) o.getInflationIndex()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateIndex", ValidationType.ONLY_EXISTS, "FloatingRateIndex", path, "");
		}
		return failure("FloatingRateIndex", ValidationType.ONLY_EXISTS, "FloatingRateIndex", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

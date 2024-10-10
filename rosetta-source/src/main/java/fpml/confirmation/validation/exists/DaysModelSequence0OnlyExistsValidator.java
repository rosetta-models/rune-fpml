package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFrequencyType;
import fpml.confirmation.DaysModelSequence0;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DaysModelSequence0OnlyExistsValidator implements ValidatorWithArg<DaysModelSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DaysModelSequence0> ValidationResult<DaysModelSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dayDistribution", ExistenceChecker.isSet((CommodityFrequencyType) o.getDayDistribution()))
				.put("dayCount", ExistenceChecker.isSet((Integer) o.getDayCount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DaysModelSequence0", ValidationType.ONLY_EXISTS, "DaysModelSequence0", path, "");
		}
		return failure("DaysModelSequence0", ValidationType.ONLY_EXISTS, "DaysModelSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.BusinessCenters;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BusinessCentersOnlyExistsValidator implements ValidatorWithArg<BusinessCenters, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BusinessCenters> ValidationResult<BusinessCenters> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("businessCenter", ExistenceChecker.isSet((List<? extends BusinessCenter>) o.getBusinessCenter()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BusinessCenters", ValidationType.ONLY_EXISTS, "BusinessCenters", path, "");
		}
		return failure("BusinessCenters", ValidationType.ONLY_EXISTS, "BusinessCenters", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

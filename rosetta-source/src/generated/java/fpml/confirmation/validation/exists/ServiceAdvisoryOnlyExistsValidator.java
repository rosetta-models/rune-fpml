package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ServiceAdvisory;
import fpml.confirmation.ServiceAdvisoryCategory;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ServiceAdvisoryOnlyExistsValidator implements ValidatorWithArg<ServiceAdvisory, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ServiceAdvisory> ValidationResult<ServiceAdvisory> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("category", ExistenceChecker.isSet((ServiceAdvisoryCategory) o.getCategory()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("effectiveFrom", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveFrom()))
				.put("effectiveTo", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveTo()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ServiceAdvisory", ValidationType.ONLY_EXISTS, "ServiceAdvisory", path, "");
		}
		return failure("ServiceAdvisory", ValidationType.ONLY_EXISTS, "ServiceAdvisory", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

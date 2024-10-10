package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessUnit;
import fpml.confirmation.ContactInformation;
import fpml.confirmation.CountryCode;
import fpml.confirmation.Unit;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BusinessUnitOnlyExistsValidator implements ValidatorWithArg<BusinessUnit, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BusinessUnit> ValidationResult<BusinessUnit> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("businessUnitId", ExistenceChecker.isSet((Unit) o.getBusinessUnitId()))
				.put("contactInfo", ExistenceChecker.isSet((ContactInformation) o.getContactInfo()))
				.put("country", ExistenceChecker.isSet((CountryCode) o.getCountry()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BusinessUnit", ValidationType.ONLY_EXISTS, "BusinessUnit", path, "");
		}
		return failure("BusinessUnit", ValidationType.ONLY_EXISTS, "BusinessUnit", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

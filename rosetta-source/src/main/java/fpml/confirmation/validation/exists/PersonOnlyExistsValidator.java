package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessUnitReference;
import fpml.confirmation.ContactInformation;
import fpml.confirmation.CountryCode;
import fpml.confirmation.Person;
import fpml.confirmation.PersonId;
import fpml.confirmation.PersonSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PersonOnlyExistsValidator implements ValidatorWithArg<Person, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Person> ValidationResult<Person> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("personSequence", ExistenceChecker.isSet((PersonSequence) o.getPersonSequence()))
				.put("personId", ExistenceChecker.isSet((List<? extends PersonId>) o.getPersonId()))
				.put("businessUnitReference", ExistenceChecker.isSet((BusinessUnitReference) o.getBusinessUnitReference()))
				.put("contactInfo", ExistenceChecker.isSet((ContactInformation) o.getContactInfo()))
				.put("dateOfBirth", ExistenceChecker.isSet((Date) o.getDateOfBirth()))
				.put("country", ExistenceChecker.isSet((CountryCode) o.getCountry()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Person", ValidationType.ONLY_EXISTS, "Person", path, "");
		}
		return failure("Person", ValidationType.ONLY_EXISTS, "Person", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

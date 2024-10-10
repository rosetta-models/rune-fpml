package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CountryCode;
import fpml.confirmation.CreditRating;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.IndustryClassification;
import fpml.confirmation.OrganizationType;
import fpml.confirmation.PartyInformationModel;
import fpml.confirmation.Region;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyInformationModelOnlyExistsValidator implements ValidatorWithArg<PartyInformationModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyInformationModel> ValidationResult<PartyInformationModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("classification", ExistenceChecker.isSet((List<? extends IndustryClassification>) o.getClassification()))
				.put("creditRating", ExistenceChecker.isSet((List<? extends CreditRating>) o.getCreditRating()))
				.put("country", ExistenceChecker.isSet((CountryCode) o.getCountry()))
				.put("region", ExistenceChecker.isSet((List<? extends Region>) o.getRegion()))
				.put("jurisdiction", ExistenceChecker.isSet((List<? extends GoverningLaw>) o.getJurisdiction()))
				.put("organizationType", ExistenceChecker.isSet((OrganizationType) o.getOrganizationType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyInformationModel", ValidationType.ONLY_EXISTS, "PartyInformationModel", path, "");
		}
		return failure("PartyInformationModel", ValidationType.ONLY_EXISTS, "PartyInformationModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

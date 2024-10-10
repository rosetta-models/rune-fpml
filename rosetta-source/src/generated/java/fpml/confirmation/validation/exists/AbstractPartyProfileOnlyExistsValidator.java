package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractPartyProfile;
import fpml.confirmation.PartyProfileDocumentation;
import fpml.confirmation.PartyProfileIdentifier;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RelatedParty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AbstractPartyProfileOnlyExistsValidator implements ValidatorWithArg<AbstractPartyProfile, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AbstractPartyProfile> ValidationResult<AbstractPartyProfile> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyProfileIdentifier", ExistenceChecker.isSet((List<? extends PartyProfileIdentifier>) o.getPartyProfileIdentifier()))
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("documentation", ExistenceChecker.isSet((PartyProfileDocumentation) o.getDocumentation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AbstractPartyProfile", ValidationType.ONLY_EXISTS, "AbstractPartyProfile", path, "");
		}
		return failure("AbstractPartyProfile", ValidationType.ONLY_EXISTS, "AbstractPartyProfile", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

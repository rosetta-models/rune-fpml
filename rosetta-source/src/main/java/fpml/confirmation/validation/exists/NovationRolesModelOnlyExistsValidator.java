package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccountReference;
import fpml.confirmation.NovationRolesModel;
import fpml.confirmation.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NovationRolesModelOnlyExistsValidator implements ValidatorWithArg<NovationRolesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NovationRolesModel> ValidationResult<NovationRolesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("transferor", ExistenceChecker.isSet((PartyReference) o.getTransferor()))
				.put("transferorAccount", ExistenceChecker.isSet((AccountReference) o.getTransferorAccount()))
				.put("transferee", ExistenceChecker.isSet((PartyReference) o.getTransferee()))
				.put("otherTransferee", ExistenceChecker.isSet((PartyReference) o.getOtherTransferee()))
				.put("transfereeAccount", ExistenceChecker.isSet((AccountReference) o.getTransfereeAccount()))
				.put("otherTransfereeAccount", ExistenceChecker.isSet((AccountReference) o.getOtherTransfereeAccount()))
				.put("remainingParty", ExistenceChecker.isSet((PartyReference) o.getRemainingParty()))
				.put("remainingPartyAccount", ExistenceChecker.isSet((AccountReference) o.getRemainingPartyAccount()))
				.put("otherRemainingParty", ExistenceChecker.isSet((PartyReference) o.getOtherRemainingParty()))
				.put("otherRemainingPartyAccount", ExistenceChecker.isSet((AccountReference) o.getOtherRemainingPartyAccount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NovationRolesModel", ValidationType.ONLY_EXISTS, "NovationRolesModel", path, "");
		}
		return failure("NovationRolesModel", ValidationType.ONLY_EXISTS, "NovationRolesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DealRolesModel;
import fpml.confirmation.DealRolesModelSequence;
import fpml.confirmation.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DealRolesModelOnlyExistsValidator implements ValidatorWithArg<DealRolesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DealRolesModel> ValidationResult<DealRolesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("issuerPartyReference", ExistenceChecker.isSet((PartyReference) o.getIssuerPartyReference()))
				.put("guarantorPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getGuarantorPartyReference()))
				.put("agentPartyReference", ExistenceChecker.isSet((PartyReference) o.getAgentPartyReference()))
				.put("dealRolesModelSequence", ExistenceChecker.isSet((DealRolesModelSequence) o.getDealRolesModelSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DealRolesModel", ValidationType.ONLY_EXISTS, "DealRolesModel", path, "");
		}
		return failure("DealRolesModel", ValidationType.ONLY_EXISTS, "DealRolesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

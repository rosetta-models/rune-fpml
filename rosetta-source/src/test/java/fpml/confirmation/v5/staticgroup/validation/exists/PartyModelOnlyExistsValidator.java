package fpml.confirmation.v5.staticgroup.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.v5.staticgroup.PartyId;
import fpml.confirmation.v5.staticgroup.PartyModel;
import fpml.confirmation.v5.staticgroup.PartyName;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyModelOnlyExistsValidator implements ValidatorWithArg<PartyModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyModel> ValidationResult<PartyModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyId", ExistenceChecker.isSet((List<? extends PartyId>) o.getPartyId()))
				.put("partyName", ExistenceChecker.isSet((PartyName) o.getPartyName()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyModel", ValidationType.ONLY_EXISTS, "PartyModel", path, "");
		}
		return failure("PartyModel", ValidationType.ONLY_EXISTS, "PartyModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

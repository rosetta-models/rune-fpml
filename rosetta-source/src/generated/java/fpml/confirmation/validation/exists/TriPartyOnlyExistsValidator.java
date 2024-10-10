package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralProfile;
import fpml.confirmation.CollateralType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.TriParty;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TriPartyOnlyExistsValidator implements ValidatorWithArg<TriParty, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TriParty> ValidationResult<TriParty> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("triPartyAgent", ExistenceChecker.isSet((PartyReference) o.getTriPartyAgent()))
				.put("collateralProfile", ExistenceChecker.isSet((CollateralProfile) o.getCollateralProfile()))
				.put("collateralType", ExistenceChecker.isSet((CollateralType) o.getCollateralType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TriParty", ValidationType.ONLY_EXISTS, "TriParty", path, "");
		}
		return failure("TriParty", ValidationType.ONLY_EXISTS, "TriParty", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

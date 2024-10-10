package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralPartyAndAccountReferencesModel;
import fpml.confirmation.ProposedCollateralAllocation;
import fpml.confirmation.ProposedCollateralAllocationChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ProposedCollateralAllocationOnlyExistsValidator implements ValidatorWithArg<ProposedCollateralAllocation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ProposedCollateralAllocation> ValidationResult<ProposedCollateralAllocation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collateralPartyAndAccountReferencesModel", ExistenceChecker.isSet((CollateralPartyAndAccountReferencesModel) o.getCollateralPartyAndAccountReferencesModel()))
				.put("proposedCollateralAllocationChoice", ExistenceChecker.isSet((List<? extends ProposedCollateralAllocationChoice>) o.getProposedCollateralAllocationChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ProposedCollateralAllocation", ValidationType.ONLY_EXISTS, "ProposedCollateralAllocation", path, "");
		}
		return failure("ProposedCollateralAllocation", ValidationType.ONLY_EXISTS, "ProposedCollateralAllocation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

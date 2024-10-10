package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ContractId;
import fpml.confirmation.VersionHistoryModel;
import fpml.confirmation.VersionedContractId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VersionedContractIdOnlyExistsValidator implements ValidatorWithArg<VersionedContractId, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VersionedContractId> ValidationResult<VersionedContractId> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("contractId", ExistenceChecker.isSet((ContractId) o.getContractId()))
				.put("versionHistoryModel", ExistenceChecker.isSet((VersionHistoryModel) o.getVersionHistoryModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VersionedContractId", ValidationType.ONLY_EXISTS, "VersionedContractId", path, "");
		}
		return failure("VersionedContractId", ValidationType.ONLY_EXISTS, "VersionedContractId", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

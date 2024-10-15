package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Allocation;
import fpml.confirmation.Allocations;
import fpml.confirmation.PartyReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AllocationsOnlyExistsValidator implements ValidatorWithArg<Allocations, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Allocations> ValidationResult<Allocations> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("allocatingPartyReference", ExistenceChecker.isSet((PartyReference) o.getAllocatingPartyReference()))
				.put("allocation", ExistenceChecker.isSet((List<? extends Allocation>) o.getAllocation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Allocations", ValidationType.ONLY_EXISTS, "Allocations", path, "");
		}
		return failure("Allocations", ValidationType.ONLY_EXISTS, "Allocations", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

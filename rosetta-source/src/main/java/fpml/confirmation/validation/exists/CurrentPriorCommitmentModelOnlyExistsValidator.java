package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CurrentPriorCommitmentModel;
import fpml.confirmation.FacilityCommitment;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CurrentPriorCommitmentModelOnlyExistsValidator implements ValidatorWithArg<CurrentPriorCommitmentModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CurrentPriorCommitmentModel> ValidationResult<CurrentPriorCommitmentModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commitment", ExistenceChecker.isSet((FacilityCommitment) o.getCommitment()))
				.put("priorCommitment", ExistenceChecker.isSet((FacilityCommitment) o.getPriorCommitment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CurrentPriorCommitmentModel", ValidationType.ONLY_EXISTS, "CurrentPriorCommitmentModel", path, "");
		}
		return failure("CurrentPriorCommitmentModel", ValidationType.ONLY_EXISTS, "CurrentPriorCommitmentModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CurrentPriorCommitmentModel;
import fpml.confirmation.FacilityPosition;
import fpml.confirmation.FacilityReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityPositionOnlyExistsValidator implements ValidatorWithArg<FacilityPosition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityPosition> ValidationResult<FacilityPosition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("currentPriorCommitmentModel", ExistenceChecker.isSet((CurrentPriorCommitmentModel) o.getCurrentPriorCommitmentModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityPosition", ValidationType.ONLY_EXISTS, "FacilityPosition", path, "");
		}
		return failure("FacilityPosition", ValidationType.ONLY_EXISTS, "FacilityPosition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

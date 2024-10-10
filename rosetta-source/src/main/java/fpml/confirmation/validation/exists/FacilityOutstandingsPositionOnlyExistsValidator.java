package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CurrentPriorCommitmentModel;
import fpml.confirmation.FacilityOutstandingsPosition;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.OutstandingsPosition;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityOutstandingsPositionOnlyExistsValidator implements ValidatorWithArg<FacilityOutstandingsPosition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityOutstandingsPosition> ValidationResult<FacilityOutstandingsPosition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityReference", ExistenceChecker.isSet((FacilityReference) o.getFacilityReference()))
				.put("currentPriorCommitmentModel", ExistenceChecker.isSet((CurrentPriorCommitmentModel) o.getCurrentPriorCommitmentModel()))
				.put("outstandingsPosition", ExistenceChecker.isSet((List<? extends OutstandingsPosition>) o.getOutstandingsPosition()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityOutstandingsPosition", ValidationType.ONLY_EXISTS, "FacilityOutstandingsPosition", path, "");
		}
		return failure("FacilityOutstandingsPosition", ValidationType.ONLY_EXISTS, "FacilityOutstandingsPosition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

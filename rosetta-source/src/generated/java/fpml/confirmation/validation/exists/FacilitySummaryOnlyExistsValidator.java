package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.FacilityDatesModel;
import fpml.confirmation.FacilityRolesModel;
import fpml.confirmation.FacilitySummary;
import fpml.confirmation.InstrumentId;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilitySummaryOnlyExistsValidator implements ValidatorWithArg<FacilitySummary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilitySummary> ValidationResult<FacilitySummary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("facilityRolesModel", ExistenceChecker.isSet((FacilityRolesModel) o.getFacilityRolesModel()))
				.put("facilityDatesModel", ExistenceChecker.isSet((FacilityDatesModel) o.getFacilityDatesModel()))
				.put("facilityCommitmentModel", ExistenceChecker.isSet((FacilityCommitmentModel) o.getFacilityCommitmentModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilitySummary", ValidationType.ONLY_EXISTS, "FacilitySummary", path, "");
		}
		return failure("FacilitySummary", ValidationType.ONLY_EXISTS, "FacilitySummary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

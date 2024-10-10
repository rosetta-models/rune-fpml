package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityDetailsModel;
import fpml.confirmation.FacilityLoanContractDetailsModel;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityLoanContractDetailsModelOnlyExistsValidator implements ValidatorWithArg<FacilityLoanContractDetailsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityLoanContractDetailsModel> ValidationResult<FacilityLoanContractDetailsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityDetailsModel", ExistenceChecker.isSet((FacilityDetailsModel) o.getFacilityDetailsModel()))
				.put("facilityLoanContractDetailsModelChoice0", ExistenceChecker.isSet((List<? extends FacilityLoanContractDetailsModelChoice0>) o.getFacilityLoanContractDetailsModelChoice0()))
				.put("facilityLoanContractDetailsModelChoice1", ExistenceChecker.isSet((List<? extends FacilityLoanContractDetailsModelChoice1>) o.getFacilityLoanContractDetailsModelChoice1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityLoanContractDetailsModel", ValidationType.ONLY_EXISTS, "FacilityLoanContractDetailsModel", path, "");
		}
		return failure("FacilityLoanContractDetailsModel", ValidationType.ONLY_EXISTS, "FacilityLoanContractDetailsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

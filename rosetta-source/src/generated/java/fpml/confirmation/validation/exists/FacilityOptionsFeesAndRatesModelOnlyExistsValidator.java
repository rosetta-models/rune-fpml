package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingFeeOption;
import fpml.confirmation.AccruingPikOption;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice;
import fpml.confirmation.FacilityRatesModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityOptionsFeesAndRatesModelOnlyExistsValidator implements ValidatorWithArg<FacilityOptionsFeesAndRatesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityOptionsFeesAndRatesModel> ValidationResult<FacilityOptionsFeesAndRatesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityOptionsFeesAndRatesModelChoice", ExistenceChecker.isSet((List<? extends FacilityOptionsFeesAndRatesModelChoice>) o.getFacilityOptionsFeesAndRatesModelChoice()))
				.put("accruingPikOption", ExistenceChecker.isSet((AccruingPikOption) o.getAccruingPikOption()))
				.put("accruingFeeOption", ExistenceChecker.isSet((List<? extends AccruingFeeOption>) o.getAccruingFeeOption()))
				.put("facilityRatesModel", ExistenceChecker.isSet((FacilityRatesModel) o.getFacilityRatesModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityOptionsFeesAndRatesModel", ValidationType.ONLY_EXISTS, "FacilityOptionsFeesAndRatesModel", path, "");
		}
		return failure("FacilityOptionsFeesAndRatesModel", ValidationType.ONLY_EXISTS, "FacilityOptionsFeesAndRatesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

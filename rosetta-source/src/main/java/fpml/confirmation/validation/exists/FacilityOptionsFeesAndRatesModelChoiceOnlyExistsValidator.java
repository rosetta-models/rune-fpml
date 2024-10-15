package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice;
import fpml.confirmation.FixedRateOption;
import fpml.confirmation.FloatingRateOption;
import fpml.confirmation.LcOption;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityOptionsFeesAndRatesModelChoiceOnlyExistsValidator implements ValidatorWithArg<FacilityOptionsFeesAndRatesModelChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityOptionsFeesAndRatesModelChoice> ValidationResult<FacilityOptionsFeesAndRatesModelChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedRateOption", ExistenceChecker.isSet((FixedRateOption) o.getFixedRateOption()))
				.put("floatingRateOption", ExistenceChecker.isSet((FloatingRateOption) o.getFloatingRateOption()))
				.put("lcOption", ExistenceChecker.isSet((LcOption) o.getLcOption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityOptionsFeesAndRatesModelChoice", ValidationType.ONLY_EXISTS, "FacilityOptionsFeesAndRatesModelChoice", path, "");
		}
		return failure("FacilityOptionsFeesAndRatesModelChoice", ValidationType.ONLY_EXISTS, "FacilityOptionsFeesAndRatesModelChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

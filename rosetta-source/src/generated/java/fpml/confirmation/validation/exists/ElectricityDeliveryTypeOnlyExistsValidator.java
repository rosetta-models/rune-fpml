package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDeliveryFirm;
import fpml.confirmation.ElectricityDeliverySystemFirm;
import fpml.confirmation.ElectricityDeliveryType;
import fpml.confirmation.ElectricityDeliveryUnitFirm;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityDeliveryTypeOnlyExistsValidator implements ValidatorWithArg<ElectricityDeliveryType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityDeliveryType> ValidationResult<ElectricityDeliveryType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("firm", ExistenceChecker.isSet((ElectricityDeliveryFirm) o.getFirm()))
				.put("nonFirm", ExistenceChecker.isSet((Boolean) o.getNonFirm()))
				.put("systemFirm", ExistenceChecker.isSet((ElectricityDeliverySystemFirm) o.getSystemFirm()))
				.put("unitFirm", ExistenceChecker.isSet((ElectricityDeliveryUnitFirm) o.getUnitFirm()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityDeliveryType", ValidationType.ONLY_EXISTS, "ElectricityDeliveryType", path, "");
		}
		return failure("ElectricityDeliveryType", ValidationType.ONLY_EXISTS, "ElectricityDeliveryType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

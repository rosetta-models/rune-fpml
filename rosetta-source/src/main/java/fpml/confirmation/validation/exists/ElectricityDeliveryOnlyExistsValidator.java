package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDelivery;
import fpml.confirmation.ElectricityDeliverySequence0;
import fpml.confirmation.ElectricityDeliverySequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityDeliveryOnlyExistsValidator implements ValidatorWithArg<ElectricityDelivery, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityDelivery> ValidationResult<ElectricityDelivery> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("electricityDeliverySequence0", ExistenceChecker.isSet((ElectricityDeliverySequence0) o.getElectricityDeliverySequence0()))
				.put("electricityDeliverySequence1", ExistenceChecker.isSet((ElectricityDeliverySequence1) o.getElectricityDeliverySequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityDelivery", ValidationType.ONLY_EXISTS, "ElectricityDelivery", path, "");
		}
		return failure("ElectricityDelivery", ValidationType.ONLY_EXISTS, "ElectricityDelivery", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

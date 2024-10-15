package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDeliveryPoint;
import fpml.confirmation.ElectricityDeliverySequence0;
import fpml.confirmation.ElectricityDeliveryType;
import fpml.confirmation.ElectricityTransmissionContingency;
import fpml.confirmation.InterconnectionPoint;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityDeliverySequence0OnlyExistsValidator implements ValidatorWithArg<ElectricityDeliverySequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityDeliverySequence0> ValidationResult<ElectricityDeliverySequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryPoint", ExistenceChecker.isSet((ElectricityDeliveryPoint) o.getDeliveryPoint()))
				.put("deliveryType", ExistenceChecker.isSet((ElectricityDeliveryType) o.getDeliveryType()))
				.put("transmissionContingency", ExistenceChecker.isSet((ElectricityTransmissionContingency) o.getTransmissionContingency()))
				.put("interconnectionPoint", ExistenceChecker.isSet((InterconnectionPoint) o.getInterconnectionPoint()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityDeliverySequence0", ValidationType.ONLY_EXISTS, "ElectricityDeliverySequence0", path, "");
		}
		return failure("ElectricityDeliverySequence0", ValidationType.ONLY_EXISTS, "ElectricityDeliverySequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

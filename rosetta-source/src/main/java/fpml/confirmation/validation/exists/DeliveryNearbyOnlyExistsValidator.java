package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DeliveryNearby;
import fpml.confirmation.DeliveryNearbyTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DeliveryNearbyOnlyExistsValidator implements ValidatorWithArg<DeliveryNearby, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DeliveryNearby> ValidationResult<DeliveryNearby> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryNearbyMultiplier", ExistenceChecker.isSet((Integer) o.getDeliveryNearbyMultiplier()))
				.put("deliveryNearbyType", ExistenceChecker.isSet((DeliveryNearbyTypeEnum) o.getDeliveryNearbyType()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DeliveryNearby", ValidationType.ONLY_EXISTS, "DeliveryNearby", path, "");
		}
		return failure("DeliveryNearby", ValidationType.ONLY_EXISTS, "DeliveryNearby", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

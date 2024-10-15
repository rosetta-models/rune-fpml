package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalDelivery;
import fpml.confirmation.CoalDeliveryPoint;
import fpml.confirmation.CommodityUSCoalDeliveryModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CoalDeliveryOnlyExistsValidator implements ValidatorWithArg<CoalDelivery, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CoalDelivery> ValidationResult<CoalDelivery> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryPoint", ExistenceChecker.isSet((CoalDeliveryPoint) o.getDeliveryPoint()))
				.put("deliveryAtSource", ExistenceChecker.isSet((Boolean) o.getDeliveryAtSource()))
				.put("commodityUSCoalDeliveryModel", ExistenceChecker.isSet((CommodityUSCoalDeliveryModel) o.getCommodityUSCoalDeliveryModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CoalDelivery", ValidationType.ONLY_EXISTS, "CoalDelivery", path, "");
		}
		return failure("CoalDelivery", ValidationType.ONLY_EXISTS, "CoalDelivery", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

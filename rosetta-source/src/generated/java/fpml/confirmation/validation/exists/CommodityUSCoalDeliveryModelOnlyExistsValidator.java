package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalTransportationEquipment;
import fpml.confirmation.CommodityDeliveryRisk;
import fpml.confirmation.CommodityUSCoalDeliveryModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityUSCoalDeliveryModelOnlyExistsValidator implements ValidatorWithArg<CommodityUSCoalDeliveryModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityUSCoalDeliveryModel> ValidationResult<CommodityUSCoalDeliveryModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quantityVariationAdjustment", ExistenceChecker.isSet((Boolean) o.getQuantityVariationAdjustment()))
				.put("transportationEquipment", ExistenceChecker.isSet((CoalTransportationEquipment) o.getTransportationEquipment()))
				.put("risk", ExistenceChecker.isSet((CommodityDeliveryRisk) o.getRisk()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityUSCoalDeliveryModel", ValidationType.ONLY_EXISTS, "CommodityUSCoalDeliveryModel", path, "");
		}
		return failure("CommodityUSCoalDeliveryModel", ValidationType.ONLY_EXISTS, "CommodityUSCoalDeliveryModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

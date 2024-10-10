package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPeriods;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.Metal;
import fpml.confirmation.MetalDelivery;
import fpml.confirmation.MetalPhysicalLeg;
import fpml.confirmation.PayerReceiverModel;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MetalPhysicalLegOnlyExistsValidator implements ValidatorWithArg<MetalPhysicalLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MetalPhysicalLeg> ValidationResult<MetalPhysicalLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("metal", ExistenceChecker.isSet((Metal) o.getMetal()))
				.put("deliveryPeriods", ExistenceChecker.isSet((CommodityDeliveryPeriods) o.getDeliveryPeriods()))
				.put("deliveryConditions", ExistenceChecker.isSet((MetalDelivery) o.getDeliveryConditions()))
				.put("commodityFixedPhysicalQuantityModel", ExistenceChecker.isSet((CommodityFixedPhysicalQuantityModel) o.getCommodityFixedPhysicalQuantityModel()))
				.put("conversionFactor", ExistenceChecker.isSet((BigDecimal) o.getConversionFactor()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MetalPhysicalLeg", ValidationType.ONLY_EXISTS, "MetalPhysicalLeg", path, "");
		}
		return failure("MetalPhysicalLeg", ValidationType.ONLY_EXISTS, "MetalPhysicalLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

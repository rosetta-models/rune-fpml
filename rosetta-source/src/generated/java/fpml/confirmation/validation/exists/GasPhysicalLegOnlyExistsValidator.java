package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasDelivery;
import fpml.confirmation.GasDeliveryPeriods;
import fpml.confirmation.GasPhysicalLeg;
import fpml.confirmation.GasPhysicalQuantity;
import fpml.confirmation.GasProduct;
import fpml.confirmation.PayerReceiverModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasPhysicalLegOnlyExistsValidator implements ValidatorWithArg<GasPhysicalLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasPhysicalLeg> ValidationResult<GasPhysicalLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("deliveryPeriods", ExistenceChecker.isSet((GasDeliveryPeriods) o.getDeliveryPeriods()))
				.put("gas", ExistenceChecker.isSet((GasProduct) o.getGas()))
				.put("deliveryConditions", ExistenceChecker.isSet((GasDelivery) o.getDeliveryConditions()))
				.put("deliveryQuantity", ExistenceChecker.isSet((GasPhysicalQuantity) o.getDeliveryQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasPhysicalLeg", ValidationType.ONLY_EXISTS, "GasPhysicalLeg", path, "");
		}
		return failure("GasPhysicalLeg", ValidationType.ONLY_EXISTS, "GasPhysicalLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

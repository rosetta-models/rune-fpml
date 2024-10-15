package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.ElectricityDeliverySequence1;
import fpml.confirmation.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityDeliverySequence1OnlyExistsValidator implements ValidatorWithArg<ElectricityDeliverySequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityDeliverySequence1> ValidationResult<ElectricityDeliverySequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryZone", ExistenceChecker.isSet((CommodityDeliveryPoint) o.getDeliveryZone()))
				.put("electingPartyReference", ExistenceChecker.isSet((PartyReference) o.getElectingPartyReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityDeliverySequence1", ValidationType.ONLY_EXISTS, "ElectricityDeliverySequence1", path, "");
		}
		return failure("ElectricityDeliverySequence1", ValidationType.ONLY_EXISTS, "ElectricityDeliverySequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

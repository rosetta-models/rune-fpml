package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantity;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantitySchedule;
import fpml.confirmation.ElectricityPhysicalQuantity;
import fpml.confirmation.UnitQuantity;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityPhysicalQuantityOnlyExistsValidator implements ValidatorWithArg<ElectricityPhysicalQuantity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityPhysicalQuantity> ValidationResult<ElectricityPhysicalQuantity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("physicalQuantity", ExistenceChecker.isSet((List<? extends ElectricityPhysicalDeliveryQuantity>) o.getPhysicalQuantity()))
				.put("physicalQuantitySchedule", ExistenceChecker.isSet((List<? extends ElectricityPhysicalDeliveryQuantitySchedule>) o.getPhysicalQuantitySchedule()))
				.put("totalPhysicalQuantity", ExistenceChecker.isSet((UnitQuantity) o.getTotalPhysicalQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityPhysicalQuantity", ValidationType.ONLY_EXISTS, "ElectricityPhysicalQuantity", path, "");
		}
		return failure("ElectricityPhysicalQuantity", ValidationType.ONLY_EXISTS, "ElectricityPhysicalQuantity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

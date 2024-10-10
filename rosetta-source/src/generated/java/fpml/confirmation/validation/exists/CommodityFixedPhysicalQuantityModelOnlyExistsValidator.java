package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityPhysicalQuantitySchedule;
import fpml.confirmation.UnitQuantity;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFixedPhysicalQuantityModelOnlyExistsValidator implements ValidatorWithArg<CommodityFixedPhysicalQuantityModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFixedPhysicalQuantityModel> ValidationResult<CommodityFixedPhysicalQuantityModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("physicalQuantity", ExistenceChecker.isSet((CommodityNotionalQuantity) o.getPhysicalQuantity()))
				.put("physicalQuantitySchedule", ExistenceChecker.isSet((CommodityPhysicalQuantitySchedule) o.getPhysicalQuantitySchedule()))
				.put("totalPhysicalQuantity", ExistenceChecker.isSet((UnitQuantity) o.getTotalPhysicalQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFixedPhysicalQuantityModel", ValidationType.ONLY_EXISTS, "CommodityFixedPhysicalQuantityModel", path, "");
		}
		return failure("CommodityFixedPhysicalQuantityModel", ValidationType.ONLY_EXISTS, "CommodityFixedPhysicalQuantityModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

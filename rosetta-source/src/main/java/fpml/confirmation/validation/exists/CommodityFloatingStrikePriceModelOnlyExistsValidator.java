package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import fpml.confirmation.FloatingStrikePrice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityFloatingStrikePriceModelOnlyExistsValidator implements ValidatorWithArg<CommodityFloatingStrikePriceModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityFloatingStrikePriceModel> ValidationResult<CommodityFloatingStrikePriceModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("floatingStrikePricePerUnit", ExistenceChecker.isSet((FloatingStrikePrice) o.getFloatingStrikePricePerUnit()))
				.put("floatingStrikePricePerUnitSchedule", ExistenceChecker.isSet((CommodityCalculationPeriodsSchedule) o.getFloatingStrikePricePerUnitSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityFloatingStrikePriceModel", ValidationType.ONLY_EXISTS, "CommodityFloatingStrikePriceModel", path, "");
		}
		return failure("CommodityFloatingStrikePriceModel", ValidationType.ONLY_EXISTS, "CommodityFloatingStrikePriceModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

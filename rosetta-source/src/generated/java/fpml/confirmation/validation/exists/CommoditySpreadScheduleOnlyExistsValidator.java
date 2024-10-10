package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommoditySpread;
import fpml.confirmation.CommoditySpreadSchedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommoditySpreadScheduleOnlyExistsValidator implements ValidatorWithArg<CommoditySpreadSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommoditySpreadSchedule> ValidationResult<CommoditySpreadSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("spreadStep", ExistenceChecker.isSet((List<? extends CommoditySpread>) o.getSpreadStep()))
				.put("commodityCalculationPeriodsPointerModel", ExistenceChecker.isSet((CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommoditySpreadSchedule", ValidationType.ONLY_EXISTS, "CommoditySpreadSchedule", path, "");
		}
		return failure("CommoditySpreadSchedule", ValidationType.ONLY_EXISTS, "CommoditySpreadSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

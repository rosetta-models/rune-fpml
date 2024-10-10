package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityNotionalQuantitySchedule;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantitySchedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityNotionalQuantityScheduleOnlyExistsValidator implements ValidatorWithArg<CommodityNotionalQuantitySchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityNotionalQuantitySchedule> ValidationResult<CommodityNotionalQuantitySchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalStep", ExistenceChecker.isSet((List<? extends CommodityNotionalQuantity>) o.getNotionalStep()))
				.put("settlementPeriodsNotionalQuantitySchedule", ExistenceChecker.isSet((List<? extends CommoditySettlementPeriodsNotionalQuantitySchedule>) o.getSettlementPeriodsNotionalQuantitySchedule()))
				.put("commodityCalculationPeriodsPointerModel", ExistenceChecker.isSet((CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityNotionalQuantitySchedule", ValidationType.ONLY_EXISTS, "CommodityNotionalQuantitySchedule", path, "");
		}
		return failure("CommodityNotionalQuantitySchedule", ValidationType.ONLY_EXISTS, "CommodityNotionalQuantitySchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

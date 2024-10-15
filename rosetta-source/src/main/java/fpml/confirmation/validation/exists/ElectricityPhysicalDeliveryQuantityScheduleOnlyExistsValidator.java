package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantitySchedule;
import fpml.confirmation.SettlementPeriodsReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ElectricityPhysicalDeliveryQuantityScheduleOnlyExistsValidator implements ValidatorWithArg<ElectricityPhysicalDeliveryQuantitySchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ElectricityPhysicalDeliveryQuantitySchedule> ValidationResult<ElectricityPhysicalDeliveryQuantitySchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quantityStep", ExistenceChecker.isSet((List<? extends CommodityNotionalQuantity>) o.getQuantityStep()))
				.put("commodityDeliveryPeriodsPointerModel", ExistenceChecker.isSet((CommodityDeliveryPeriodsPointerModel) o.getCommodityDeliveryPeriodsPointerModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("settlementPeriodsReference", ExistenceChecker.isSet((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ElectricityPhysicalDeliveryQuantitySchedule", ValidationType.ONLY_EXISTS, "ElectricityPhysicalDeliveryQuantitySchedule", path, "");
		}
		return failure("ElectricityPhysicalDeliveryQuantitySchedule", ValidationType.ONLY_EXISTS, "ElectricityPhysicalDeliveryQuantitySchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

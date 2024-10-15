package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import fpml.confirmation.SettlementPeriodsSchedule;
import fpml.confirmation.SettlementPeriodsStep;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementPeriodsScheduleOnlyExistsValidator implements ValidatorWithArg<SettlementPeriodsSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementPeriodsSchedule> ValidationResult<SettlementPeriodsSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementPeriodsStep", ExistenceChecker.isSet((List<? extends SettlementPeriodsStep>) o.getSettlementPeriodsStep()))
				.put("commodityDeliveryPeriodsPointerModel", ExistenceChecker.isSet((CommodityDeliveryPeriodsPointerModel) o.getCommodityDeliveryPeriodsPointerModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementPeriodsSchedule", ValidationType.ONLY_EXISTS, "SettlementPeriodsSchedule", path, "");
		}
		return failure("SettlementPeriodsSchedule", ValidationType.ONLY_EXISTS, "SettlementPeriodsSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

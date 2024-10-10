package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.GasDeliveryPeriods;
import fpml.confirmation.GasDeliveryPeriodsSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasDeliveryPeriodsOnlyExistsValidator implements ValidatorWithArg<GasDeliveryPeriods, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasDeliveryPeriods> ValidationResult<GasDeliveryPeriods> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("periods", ExistenceChecker.isSet((AdjustableDates) o.getPeriods()))
				.put("periodsSchedule", ExistenceChecker.isSet((CommodityCalculationPeriodsSchedule) o.getPeriodsSchedule()))
				.put("commodityCalculationPeriodsPointerModel", ExistenceChecker.isSet((CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("gasDeliveryPeriodsSequence", ExistenceChecker.isSet((GasDeliveryPeriodsSequence) o.getGasDeliveryPeriodsSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasDeliveryPeriods", ValidationType.ONLY_EXISTS, "GasDeliveryPeriods", path, "");
		}
		return failure("GasDeliveryPeriods", ValidationType.ONLY_EXISTS, "GasDeliveryPeriods", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

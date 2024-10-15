package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsSchedule;
import fpml.confirmation.PeriodExtendedEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityCalculationPeriodsScheduleOnlyExistsValidator implements ValidatorWithArg<CommodityCalculationPeriodsSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityCalculationPeriodsSchedule> ValidationResult<CommodityCalculationPeriodsSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("periodMultiplier", ExistenceChecker.isSet((Integer) o.getPeriodMultiplier()))
				.put("period", ExistenceChecker.isSet((PeriodExtendedEnum) o.getPeriod()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("balanceOfFirstPeriod", ExistenceChecker.isSet((Boolean) o.getBalanceOfFirstPeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityCalculationPeriodsSchedule", ValidationType.ONLY_EXISTS, "CommodityCalculationPeriodsSchedule", path, "");
		}
		return failure("CommodityCalculationPeriodsSchedule", ValidationType.ONLY_EXISTS, "CommodityCalculationPeriodsSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

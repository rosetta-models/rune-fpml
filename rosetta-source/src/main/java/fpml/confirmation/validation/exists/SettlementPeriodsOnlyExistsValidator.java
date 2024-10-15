package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBusinessCalendar;
import fpml.confirmation.DayOfWeekExtEnum;
import fpml.confirmation.OffsetPrevailingTime;
import fpml.confirmation.SettlementPeriodDurationEnum;
import fpml.confirmation.SettlementPeriods;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementPeriodsOnlyExistsValidator implements ValidatorWithArg<SettlementPeriods, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementPeriods> ValidationResult<SettlementPeriods> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("duration", ExistenceChecker.isSet((SettlementPeriodDurationEnum) o.getDuration()))
				.put("applicableDay", ExistenceChecker.isSet((List<DayOfWeekExtEnum>) o.getApplicableDay()))
				.put("startTime", ExistenceChecker.isSet((OffsetPrevailingTime) o.getStartTime()))
				.put("endTime", ExistenceChecker.isSet((OffsetPrevailingTime) o.getEndTime()))
				.put("timeDuration", ExistenceChecker.isSet((LocalTime) o.getTimeDuration()))
				.put("excludeHolidays", ExistenceChecker.isSet((CommodityBusinessCalendar) o.getExcludeHolidays()))
				.put("includeHolidays", ExistenceChecker.isSet((CommodityBusinessCalendar) o.getIncludeHolidays()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementPeriods", ValidationType.ONLY_EXISTS, "SettlementPeriods", path, "");
		}
		return failure("SettlementPeriods", ValidationType.ONLY_EXISTS, "SettlementPeriods", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

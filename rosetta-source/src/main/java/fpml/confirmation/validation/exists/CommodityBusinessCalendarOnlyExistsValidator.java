package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBusinessCalendar;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBusinessCalendarOnlyExistsValidator implements ValidatorWithArg<CommodityBusinessCalendar, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBusinessCalendar> ValidationResult<CommodityBusinessCalendar> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("commodityBusinessCalendarScheme", ExistenceChecker.isSet((String) o.getCommodityBusinessCalendarScheme()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBusinessCalendar", ValidationType.ONLY_EXISTS, "CommodityBusinessCalendar", path, "");
		}
		return failure("CommodityBusinessCalendar", ValidationType.ONLY_EXISTS, "CommodityBusinessCalendar", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

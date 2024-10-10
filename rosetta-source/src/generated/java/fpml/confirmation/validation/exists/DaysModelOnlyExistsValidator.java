package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.CommodityDayTypeEnum;
import fpml.confirmation.DaysModel;
import fpml.confirmation.DaysModelSequence0;
import fpml.confirmation.DaysModelSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DaysModelOnlyExistsValidator implements ValidatorWithArg<DaysModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DaysModel> ValidationResult<DaysModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dayType", ExistenceChecker.isSet((CommodityDayTypeEnum) o.getDayType()))
				.put("daysModelSequence0", ExistenceChecker.isSet((DaysModelSequence0) o.getDaysModelSequence0()))
				.put("daysModelSequence1", ExistenceChecker.isSet((DaysModelSequence1) o.getDaysModelSequence1()))
				.put("businessDayConvention", ExistenceChecker.isSet((BusinessDayConventionEnum) o.getBusinessDayConvention()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DaysModel", ValidationType.ONLY_EXISTS, "DaysModel", path, "");
		}
		return failure("DaysModel", ValidationType.ONLY_EXISTS, "DaysModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

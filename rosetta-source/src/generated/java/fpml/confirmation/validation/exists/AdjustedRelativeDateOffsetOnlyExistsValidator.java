package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustedRelativeDateOffset;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.DateReference;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.PeriodEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdjustedRelativeDateOffsetOnlyExistsValidator implements ValidatorWithArg<AdjustedRelativeDateOffset, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdjustedRelativeDateOffset> ValidationResult<AdjustedRelativeDateOffset> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("periodMultiplier", ExistenceChecker.isSet((Integer) o.getPeriodMultiplier()))
				.put("period", ExistenceChecker.isSet((PeriodEnum) o.getPeriod()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("dayType", ExistenceChecker.isSet((DayTypeEnum) o.getDayType()))
				.put("businessDayConvention", ExistenceChecker.isSet((BusinessDayConventionEnum) o.getBusinessDayConvention()))
				.put("businessCentersOrReferenceModel", ExistenceChecker.isSet((BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel()))
				.put("dateRelativeTo", ExistenceChecker.isSet((DateReference) o.getDateRelativeTo()))
				.put("adjustedDate", ExistenceChecker.isSet((IdentifiedDate) o.getAdjustedDate()))
				.put("relativeDateAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getRelativeDateAdjustments()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdjustedRelativeDateOffset", ValidationType.ONLY_EXISTS, "AdjustedRelativeDateOffset", path, "");
		}
		return failure("AdjustedRelativeDateOffset", ValidationType.ONLY_EXISTS, "AdjustedRelativeDateOffset", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

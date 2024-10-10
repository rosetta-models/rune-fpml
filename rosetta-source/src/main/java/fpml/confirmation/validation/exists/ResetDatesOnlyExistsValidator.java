package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.CalculationPeriodDatesReference;
import fpml.confirmation.Offset;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.ResetDates;
import fpml.confirmation.ResetFrequency;
import fpml.confirmation.ResetRelativeToEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ResetDatesOnlyExistsValidator implements ValidatorWithArg<ResetDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ResetDates> ValidationResult<ResetDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationPeriodDatesReference", ExistenceChecker.isSet((CalculationPeriodDatesReference) o.getCalculationPeriodDatesReference()))
				.put("resetRelativeTo", ExistenceChecker.isSet((ResetRelativeToEnum) o.getResetRelativeTo()))
				.put("initialFixingDate", ExistenceChecker.isSet((RelativeDateOffset) o.getInitialFixingDate()))
				.put("fixingDates", ExistenceChecker.isSet((RelativeDateOffset) o.getFixingDates()))
				.put("rateCutOffDaysOffset", ExistenceChecker.isSet((Offset) o.getRateCutOffDaysOffset()))
				.put("resetFrequency", ExistenceChecker.isSet((ResetFrequency) o.getResetFrequency()))
				.put("resetDatesAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getResetDatesAdjustments()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ResetDates", ValidationType.ONLY_EXISTS, "ResetDates", path, "");
		}
		return failure("ResetDates", ValidationType.ONLY_EXISTS, "ResetDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

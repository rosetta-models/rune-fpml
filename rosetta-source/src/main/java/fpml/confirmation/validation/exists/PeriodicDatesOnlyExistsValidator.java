package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.PeriodicDates;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PeriodicDatesOnlyExistsValidator implements ValidatorWithArg<PeriodicDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PeriodicDates> ValidationResult<PeriodicDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationStartDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCalculationStartDate()))
				.put("calculationEndDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getCalculationEndDate()))
				.put("calculationPeriodFrequency", ExistenceChecker.isSet((CalculationPeriodFrequency) o.getCalculationPeriodFrequency()))
				.put("calculationPeriodDatesAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getCalculationPeriodDatesAdjustments()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PeriodicDates", ValidationType.ONLY_EXISTS, "PeriodicDates", path, "");
		}
		return failure("PeriodicDates", ValidationType.ONLY_EXISTS, "PeriodicDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

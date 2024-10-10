package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.InterestLegCalculationPeriodDates;
import fpml.confirmation.InterestLegResetDates;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestLegCalculationPeriodDatesOnlyExistsValidator implements ValidatorWithArg<InterestLegCalculationPeriodDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestLegCalculationPeriodDates> ValidationResult<InterestLegCalculationPeriodDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("interestLegResetDates", ExistenceChecker.isSet((InterestLegResetDates) o.getInterestLegResetDates()))
				.put("interestLegPaymentDates", ExistenceChecker.isSet((AdjustableRelativeOrPeriodicDates2) o.getInterestLegPaymentDates()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestLegCalculationPeriodDates", ValidationType.ONLY_EXISTS, "InterestLegCalculationPeriodDates", path, "");
		}
		return failure("InterestLegCalculationPeriodDates", ValidationType.ONLY_EXISTS, "InterestLegCalculationPeriodDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

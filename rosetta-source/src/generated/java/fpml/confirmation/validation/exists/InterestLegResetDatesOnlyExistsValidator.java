package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset;
import fpml.confirmation.InterestLegCalculationPeriodDatesReference;
import fpml.confirmation.InterestLegResetDates;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.ResetFrequency;
import fpml.confirmation.ResetRelativeToEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestLegResetDatesOnlyExistsValidator implements ValidatorWithArg<InterestLegResetDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestLegResetDates> ValidationResult<InterestLegResetDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationPeriodDatesReference", ExistenceChecker.isSet((InterestLegCalculationPeriodDatesReference) o.getCalculationPeriodDatesReference()))
				.put("resetRelativeTo", ExistenceChecker.isSet((ResetRelativeToEnum) o.getResetRelativeTo()))
				.put("resetFrequency", ExistenceChecker.isSet((ResetFrequency) o.getResetFrequency()))
				.put("initialFixingDate", ExistenceChecker.isSet((RelativeDateOffset) o.getInitialFixingDate()))
				.put("fixingDates", ExistenceChecker.isSet((AdjustableDatesOrRelativeDateOffset) o.getFixingDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestLegResetDates", ValidationType.ONLY_EXISTS, "InterestLegResetDates", path, "");
		}
		return failure("InterestLegResetDates", ValidationType.ONLY_EXISTS, "InterestLegResetDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

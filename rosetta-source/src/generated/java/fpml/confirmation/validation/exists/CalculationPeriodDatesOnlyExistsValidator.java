package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.AdjustedRelativeDateOffset;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.CalculationPeriodDates;
import fpml.confirmation.CalculationPeriodFrequency;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.StubPeriodTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CalculationPeriodDatesOnlyExistsValidator implements ValidatorWithArg<CalculationPeriodDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CalculationPeriodDates> ValidationResult<CalculationPeriodDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableDate) o.getEffectiveDate()))
				.put("relativeEffectiveDate", ExistenceChecker.isSet((AdjustedRelativeDateOffset) o.getRelativeEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableDate) o.getTerminationDate()))
				.put("relativeTerminationDate", ExistenceChecker.isSet((RelativeDateOffset) o.getRelativeTerminationDate()))
				.put("calculationPeriodDatesAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getCalculationPeriodDatesAdjustments()))
				.put("firstPeriodStartDate", ExistenceChecker.isSet((AdjustableDate) o.getFirstPeriodStartDate()))
				.put("firstRegularPeriodStartDate", ExistenceChecker.isSet((Date) o.getFirstRegularPeriodStartDate()))
				.put("firstCompoundingPeriodEndDate", ExistenceChecker.isSet((Date) o.getFirstCompoundingPeriodEndDate()))
				.put("lastRegularPeriodEndDate", ExistenceChecker.isSet((Date) o.getLastRegularPeriodEndDate()))
				.put("stubPeriodType", ExistenceChecker.isSet((StubPeriodTypeEnum) o.getStubPeriodType()))
				.put("calculationPeriodFrequency", ExistenceChecker.isSet((CalculationPeriodFrequency) o.getCalculationPeriodFrequency()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationPeriodDates", ValidationType.ONLY_EXISTS, "CalculationPeriodDates", path, "");
		}
		return failure("CalculationPeriodDates", ValidationType.ONLY_EXISTS, "CalculationPeriodDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

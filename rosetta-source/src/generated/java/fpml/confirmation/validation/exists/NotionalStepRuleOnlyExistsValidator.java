package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriodDatesReference;
import fpml.confirmation.Frequency;
import fpml.confirmation.NotionalStepRule;
import fpml.confirmation.NotionalStepRuleSequence;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NotionalStepRuleOnlyExistsValidator implements ValidatorWithArg<NotionalStepRule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NotionalStepRule> ValidationResult<NotionalStepRule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationPeriodDatesReference", ExistenceChecker.isSet((CalculationPeriodDatesReference) o.getCalculationPeriodDatesReference()))
				.put("stepFrequency", ExistenceChecker.isSet((Frequency) o.getStepFrequency()))
				.put("firstNotionalStepDate", ExistenceChecker.isSet((Date) o.getFirstNotionalStepDate()))
				.put("lastNotionalStepDate", ExistenceChecker.isSet((Date) o.getLastNotionalStepDate()))
				.put("notionalStepAmount", ExistenceChecker.isSet((BigDecimal) o.getNotionalStepAmount()))
				.put("notionalStepRuleSequence", ExistenceChecker.isSet((NotionalStepRuleSequence) o.getNotionalStepRuleSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NotionalStepRule", ValidationType.ONLY_EXISTS, "NotionalStepRule", path, "");
		}
		return failure("NotionalStepRule", ValidationType.ONLY_EXISTS, "NotionalStepRule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

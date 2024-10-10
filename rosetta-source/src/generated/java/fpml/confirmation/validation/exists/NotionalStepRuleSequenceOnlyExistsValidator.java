package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NotionalStepRuleSequence;
import fpml.confirmation.StepRelativeToEnum;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NotionalStepRuleSequenceOnlyExistsValidator implements ValidatorWithArg<NotionalStepRuleSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NotionalStepRuleSequence> ValidationResult<NotionalStepRuleSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalStepRate", ExistenceChecker.isSet((BigDecimal) o.getNotionalStepRate()))
				.put("stepRelativeTo", ExistenceChecker.isSet((StepRelativeToEnum) o.getStepRelativeTo()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NotionalStepRuleSequence", ValidationType.ONLY_EXISTS, "NotionalStepRuleSequence", path, "");
		}
		return failure("NotionalStepRuleSequence", ValidationType.ONLY_EXISTS, "NotionalStepRuleSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

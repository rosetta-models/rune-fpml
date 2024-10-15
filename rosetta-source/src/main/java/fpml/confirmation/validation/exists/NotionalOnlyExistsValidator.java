package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.Notional;
import fpml.confirmation.NotionalStepRule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NotionalOnlyExistsValidator implements ValidatorWithArg<Notional, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Notional> ValidationResult<Notional> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalStepSchedule", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalStepSchedule()))
				.put("notionalStepParameters", ExistenceChecker.isSet((NotionalStepRule) o.getNotionalStepParameters()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Notional", ValidationType.ONLY_EXISTS, "Notional", path, "");
		}
		return failure("Notional", ValidationType.ONLY_EXISTS, "Notional", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Money;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.OptionExerciseAmountsSequence0;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseAmountsSequence0OnlyExistsValidator implements ValidatorWithArg<OptionExerciseAmountsSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExerciseAmountsSequence0> ValidationResult<OptionExerciseAmountsSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalReference", ExistenceChecker.isSet((NotionalReference) o.getNotionalReference()))
				.put("exerciseInNotionalAmount", ExistenceChecker.isSet((Money) o.getExerciseInNotionalAmount()))
				.put("outstandingNotionalAmount", ExistenceChecker.isSet((Money) o.getOutstandingNotionalAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExerciseAmountsSequence0", ValidationType.ONLY_EXISTS, "OptionExerciseAmountsSequence0", path, "");
		}
		return failure("OptionExerciseAmountsSequence0", ValidationType.ONLY_EXISTS, "OptionExerciseAmountsSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

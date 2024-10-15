package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmounts;
import fpml.confirmation.OptionExerciseAmountsSequence0;
import fpml.confirmation.OptionExerciseAmountsSequence1;
import fpml.confirmation.OptionExerciseAmountsSequence2;
import fpml.confirmation.OptionExerciseAmountsSequence3;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseAmountsOnlyExistsValidator implements ValidatorWithArg<OptionExerciseAmounts, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExerciseAmounts> ValidationResult<OptionExerciseAmounts> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("optionExerciseAmountsSequence0", ExistenceChecker.isSet((OptionExerciseAmountsSequence0) o.getOptionExerciseAmountsSequence0()))
				.put("optionExerciseAmountsSequence1", ExistenceChecker.isSet((OptionExerciseAmountsSequence1) o.getOptionExerciseAmountsSequence1()))
				.put("optionExerciseAmountsSequence2", ExistenceChecker.isSet((OptionExerciseAmountsSequence2) o.getOptionExerciseAmountsSequence2()))
				.put("optionExerciseAmountsSequence3", ExistenceChecker.isSet((OptionExerciseAmountsSequence3) o.getOptionExerciseAmountsSequence3()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExerciseAmounts", ValidationType.ONLY_EXISTS, "OptionExerciseAmounts", path, "");
		}
		return failure("OptionExerciseAmounts", ValidationType.ONLY_EXISTS, "OptionExerciseAmounts", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

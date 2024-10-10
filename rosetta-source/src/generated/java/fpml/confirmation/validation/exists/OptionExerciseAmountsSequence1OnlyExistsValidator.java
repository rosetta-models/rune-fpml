package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.OptionExerciseAmountsSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseAmountsSequence1OnlyExistsValidator implements ValidatorWithArg<OptionExerciseAmountsSequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExerciseAmountsSequence1> ValidationResult<OptionExerciseAmountsSequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalScheduleReference", ExistenceChecker.isSet((NotionalReference) o.getNotionalScheduleReference()))
				.put("exerciseInNotionalSchedule", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getExerciseInNotionalSchedule()))
				.put("outstandingNotionalSchedule", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getOutstandingNotionalSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExerciseAmountsSequence1", ValidationType.ONLY_EXISTS, "OptionExerciseAmountsSequence1", path, "");
		}
		return failure("OptionExerciseAmountsSequence1", ValidationType.ONLY_EXISTS, "OptionExerciseAmountsSequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

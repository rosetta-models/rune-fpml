package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExerciseActionEnum;
import fpml.confirmation.OptionExerciseAmountModel;
import fpml.confirmation.OptionExerciseAmountModelSequence0;
import fpml.confirmation.OptionExerciseAmountModelSequence1;
import fpml.confirmation.OptionExerciseAmountModelSequence2;
import fpml.confirmation.OptionExerciseAmounts;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseAmountModelOnlyExistsValidator implements ValidatorWithArg<OptionExerciseAmountModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExerciseAmountModel> ValidationResult<OptionExerciseAmountModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("exerciseAction", ExistenceChecker.isSet((ExerciseActionEnum) o.getExerciseAction()))
				.put("expiry", ExistenceChecker.isSet((Boolean) o.getExpiry()))
				.put("fullExercise", ExistenceChecker.isSet((Boolean) o.getFullExercise()))
				.put("optionExerciseAmountModelSequence0", ExistenceChecker.isSet((OptionExerciseAmountModelSequence0) o.getOptionExerciseAmountModelSequence0()))
				.put("optionExerciseAmountModelSequence1", ExistenceChecker.isSet((OptionExerciseAmountModelSequence1) o.getOptionExerciseAmountModelSequence1()))
				.put("optionExerciseAmountModelSequence2", ExistenceChecker.isSet((OptionExerciseAmountModelSequence2) o.getOptionExerciseAmountModelSequence2()))
				.put("specifiedExercise", ExistenceChecker.isSet((List<? extends OptionExerciseAmounts>) o.getSpecifiedExercise()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExerciseAmountModel", ValidationType.ONLY_EXISTS, "OptionExerciseAmountModel", path, "");
		}
		return failure("OptionExerciseAmountModel", ValidationType.ONLY_EXISTS, "OptionExerciseAmountModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

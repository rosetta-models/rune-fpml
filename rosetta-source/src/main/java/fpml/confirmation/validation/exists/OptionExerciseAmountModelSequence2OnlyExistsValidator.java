package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmountModelSequence2;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseAmountModelSequence2OnlyExistsValidator implements ValidatorWithArg<OptionExerciseAmountModelSequence2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExerciseAmountModelSequence2> ValidationResult<OptionExerciseAmountModelSequence2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("exerciseInNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getExerciseInNumberOfUnits()))
				.put("outstandingNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfUnits()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExerciseAmountModelSequence2", ValidationType.ONLY_EXISTS, "OptionExerciseAmountModelSequence2", path, "");
		}
		return failure("OptionExerciseAmountModelSequence2", ValidationType.ONLY_EXISTS, "OptionExerciseAmountModelSequence2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

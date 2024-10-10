package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NumberOfOptionsReference;
import fpml.confirmation.OptionExerciseAmountsSequence2;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseAmountsSequence2OnlyExistsValidator implements ValidatorWithArg<OptionExerciseAmountsSequence2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExerciseAmountsSequence2> ValidationResult<OptionExerciseAmountsSequence2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("numberOfOptionsReference", ExistenceChecker.isSet((NumberOfOptionsReference) o.getNumberOfOptionsReference()))
				.put("exerciseInNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getExerciseInNumberOfOptions()))
				.put("outstandingNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfOptions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExerciseAmountsSequence2", ValidationType.ONLY_EXISTS, "OptionExerciseAmountsSequence2", path, "");
		}
		return failure("OptionExerciseAmountsSequence2", ValidationType.ONLY_EXISTS, "OptionExerciseAmountsSequence2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

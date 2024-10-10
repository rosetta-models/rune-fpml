package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityMultipleExercise;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityMultipleExerciseOnlyExistsValidator implements ValidatorWithArg<EquityMultipleExercise, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityMultipleExercise> ValidationResult<EquityMultipleExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("integralMultipleExercise", ExistenceChecker.isSet((BigDecimal) o.getIntegralMultipleExercise()))
				.put("minimumNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getMinimumNumberOfOptions()))
				.put("maximumNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getMaximumNumberOfOptions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityMultipleExercise", ValidationType.ONLY_EXISTS, "EquityMultipleExercise", path, "");
		}
		return failure("EquityMultipleExercise", ValidationType.ONLY_EXISTS, "EquityMultipleExercise", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

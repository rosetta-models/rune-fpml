package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NumberOfUnitsReference;
import fpml.confirmation.OptionExerciseAmountsSequence3;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionExerciseAmountsSequence3OnlyExistsValidator implements ValidatorWithArg<OptionExerciseAmountsSequence3, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionExerciseAmountsSequence3> ValidationResult<OptionExerciseAmountsSequence3> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("numberOfUnitsReference", ExistenceChecker.isSet((NumberOfUnitsReference) o.getNumberOfUnitsReference()))
				.put("exerciseInNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getExerciseInNumberOfUnits()))
				.put("outstandingNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfUnits()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionExerciseAmountsSequence3", ValidationType.ONLY_EXISTS, "OptionExerciseAmountsSequence3", path, "");
		}
		return failure("OptionExerciseAmountsSequence3", ValidationType.ONLY_EXISTS, "OptionExerciseAmountsSequence3", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.PartialExerciseModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartialExerciseModelOnlyExistsValidator implements ValidatorWithArg<PartialExerciseModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartialExerciseModel> ValidationResult<PartialExerciseModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalReference", ExistenceChecker.isSet((List<? extends NotionalReference>) o.getNotionalReference()))
				.put("integralMultipleAmount", ExistenceChecker.isSet((BigDecimal) o.getIntegralMultipleAmount()))
				.put("minimumNotionalAmount", ExistenceChecker.isSet((BigDecimal) o.getMinimumNotionalAmount()))
				.put("minimumNumberOfOptions", ExistenceChecker.isSet((Integer) o.getMinimumNumberOfOptions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartialExerciseModel", ValidationType.ONLY_EXISTS, "PartialExerciseModel", path, "");
		}
		return failure("PartialExerciseModel", ValidationType.ONLY_EXISTS, "PartialExerciseModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

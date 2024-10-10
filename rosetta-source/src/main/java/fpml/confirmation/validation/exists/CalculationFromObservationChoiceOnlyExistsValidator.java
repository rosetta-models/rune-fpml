package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.CalculationFromObservationChoiceSequence;
import fpml.confirmation.DeterminationMethod;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CalculationFromObservationChoiceOnlyExistsValidator implements ValidatorWithArg<CalculationFromObservationChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CalculationFromObservationChoice> ValidationResult<CalculationFromObservationChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationFromObservationChoiceSequence", ExistenceChecker.isSet((CalculationFromObservationChoiceSequence) o.getCalculationFromObservationChoiceSequence()))
				.put("initialLevelSource", ExistenceChecker.isSet((DeterminationMethod) o.getInitialLevelSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationFromObservationChoice", ValidationType.ONLY_EXISTS, "CalculationFromObservationChoice", path, "");
		}
		return failure("CalculationFromObservationChoice", ValidationType.ONLY_EXISTS, "CalculationFromObservationChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

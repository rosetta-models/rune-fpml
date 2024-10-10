package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeeLegChoiceSequence0;
import fpml.confirmation.InitialPayment;
import fpml.confirmation.PeriodicPayment;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FeeLegChoiceSequence0OnlyExistsValidator implements ValidatorWithArg<FeeLegChoiceSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FeeLegChoiceSequence0> ValidationResult<FeeLegChoiceSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initialPayment", ExistenceChecker.isSet((InitialPayment) o.getInitialPayment()))
				.put("periodicPayment", ExistenceChecker.isSet((PeriodicPayment) o.getPeriodicPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FeeLegChoiceSequence0", ValidationType.ONLY_EXISTS, "FeeLegChoiceSequence0", path, "");
		}
		return failure("FeeLegChoiceSequence0", ValidationType.ONLY_EXISTS, "FeeLegChoiceSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

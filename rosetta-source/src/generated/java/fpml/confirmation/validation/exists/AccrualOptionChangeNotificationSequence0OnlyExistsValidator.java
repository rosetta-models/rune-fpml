package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualOptionChangeNotificationSequence0;
import fpml.confirmation.FixedRateOptionChange;
import fpml.confirmation.FloatingRateOptionChange;
import fpml.confirmation.LoanContract;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AccrualOptionChangeNotificationSequence0OnlyExistsValidator implements ValidatorWithArg<AccrualOptionChangeNotificationSequence0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AccrualOptionChangeNotificationSequence0> ValidationResult<AccrualOptionChangeNotificationSequence0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedRateOptionChange", ExistenceChecker.isSet((FixedRateOptionChange) o.getFixedRateOptionChange()))
				.put("floatingRateOptionChange", ExistenceChecker.isSet((FloatingRateOptionChange) o.getFloatingRateOptionChange()))
				.put("contract", ExistenceChecker.isSet((List<? extends LoanContract>) o.getContract()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AccrualOptionChangeNotificationSequence0", ValidationType.ONLY_EXISTS, "AccrualOptionChangeNotificationSequence0", path, "");
		}
		return failure("AccrualOptionChangeNotificationSequence0", ValidationType.ONLY_EXISTS, "AccrualOptionChangeNotificationSequence0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

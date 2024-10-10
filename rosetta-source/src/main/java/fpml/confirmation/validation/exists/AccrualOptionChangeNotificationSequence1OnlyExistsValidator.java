package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccrualOptionChangeNotificationSequence1;
import fpml.confirmation.LcOptionChange;
import fpml.confirmation.LetterOfCredit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AccrualOptionChangeNotificationSequence1OnlyExistsValidator implements ValidatorWithArg<AccrualOptionChangeNotificationSequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AccrualOptionChangeNotificationSequence1> ValidationResult<AccrualOptionChangeNotificationSequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("lcOptionChange", ExistenceChecker.isSet((LcOptionChange) o.getLcOptionChange()))
				.put("letterOfCredit", ExistenceChecker.isSet((List<? extends LetterOfCredit>) o.getLetterOfCredit()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AccrualOptionChangeNotificationSequence1", ValidationType.ONLY_EXISTS, "AccrualOptionChangeNotificationSequence1", path, "");
		}
		return failure("AccrualOptionChangeNotificationSequence1", ValidationType.ONLY_EXISTS, "AccrualOptionChangeNotificationSequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

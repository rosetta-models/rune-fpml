package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionEvent;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.OptionExpiry;
import fpml.confirmation.OptionsEventsBaseModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OptionsEventsBaseModelOnlyExistsValidator implements ValidatorWithArg<OptionsEventsBaseModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OptionsEventsBaseModel> ValidationResult<OptionsEventsBaseModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("optionExercise", ExistenceChecker.isSet((OptionExercise) o.getOptionExercise()))
				.put("optionExpiry", ExistenceChecker.isSet((List<? extends OptionExpiry>) o.getOptionExpiry()))
				.put("optionEvent", ExistenceChecker.isSet((OptionEvent) o.getOptionEvent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionsEventsBaseModel", ValidationType.ONLY_EXISTS, "OptionsEventsBaseModel", path, "");
		}
		return failure("OptionsEventsBaseModel", ValidationType.ONLY_EXISTS, "OptionsEventsBaseModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

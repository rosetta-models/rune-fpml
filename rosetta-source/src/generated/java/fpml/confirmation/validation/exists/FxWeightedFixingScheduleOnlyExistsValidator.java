package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxWeightedFixingSchedule;
import fpml.confirmation.FxWeightedFixingScheduleSequence0;
import fpml.confirmation.FxWeightedFixingScheduleSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxWeightedFixingScheduleOnlyExistsValidator implements ValidatorWithArg<FxWeightedFixingSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxWeightedFixingSchedule> ValidationResult<FxWeightedFixingSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxWeightedFixingScheduleSequence0", ExistenceChecker.isSet((FxWeightedFixingScheduleSequence0) o.getFxWeightedFixingScheduleSequence0()))
				.put("fxWeightedFixingScheduleSequence1", ExistenceChecker.isSet((FxWeightedFixingScheduleSequence1) o.getFxWeightedFixingScheduleSequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxWeightedFixingSchedule", ValidationType.ONLY_EXISTS, "FxWeightedFixingSchedule", path, "");
		}
		return failure("FxWeightedFixingSchedule", ValidationType.ONLY_EXISTS, "FxWeightedFixingSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFixingSchedule;
import fpml.confirmation.FxFixingScheduleSequence0;
import fpml.confirmation.FxFixingScheduleSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxFixingScheduleOnlyExistsValidator implements ValidatorWithArg<FxFixingSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxFixingSchedule> ValidationResult<FxFixingSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxFixingScheduleSequence0", ExistenceChecker.isSet((FxFixingScheduleSequence0) o.getFxFixingScheduleSequence0()))
				.put("fxFixingScheduleSequence1", ExistenceChecker.isSet((FxFixingScheduleSequence1) o.getFxFixingScheduleSequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxFixingSchedule", ValidationType.ONLY_EXISTS, "FxFixingSchedule", path, "");
		}
		return failure("FxFixingSchedule", ValidationType.ONLY_EXISTS, "FxFixingSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

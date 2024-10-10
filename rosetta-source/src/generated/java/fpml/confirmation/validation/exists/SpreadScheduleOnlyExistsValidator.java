package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SpreadSchedule;
import fpml.confirmation.SpreadScheduleType;
import fpml.confirmation.Step;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SpreadScheduleOnlyExistsValidator implements ValidatorWithArg<SpreadSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SpreadSchedule> ValidationResult<SpreadSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initialValue", ExistenceChecker.isSet((BigDecimal) o.getInitialValue()))
				.put("step", ExistenceChecker.isSet((List<? extends Step>) o.getStep()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("type", ExistenceChecker.isSet((SpreadScheduleType) o.getType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SpreadSchedule", ValidationType.ONLY_EXISTS, "SpreadSchedule", path, "");
		}
		return failure("SpreadSchedule", ValidationType.ONLY_EXISTS, "SpreadSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

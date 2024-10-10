package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ParametricScheduleModel;
import fpml.confirmation.ParametricScheduleModelSequence0;
import fpml.confirmation.ParametricScheduleModelSequence1;
import fpml.confirmation.ParametricScheduleModelSequence2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ParametricScheduleModelOnlyExistsValidator implements ValidatorWithArg<ParametricScheduleModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ParametricScheduleModel> ValidationResult<ParametricScheduleModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("parametricScheduleModelSequence0", ExistenceChecker.isSet((ParametricScheduleModelSequence0) o.getParametricScheduleModelSequence0()))
				.put("endDate", ExistenceChecker.isSet((Date) o.getEndDate()))
				.put("parametricScheduleModelSequence1", ExistenceChecker.isSet((ParametricScheduleModelSequence1) o.getParametricScheduleModelSequence1()))
				.put("parametricScheduleModelSequence2", ExistenceChecker.isSet((ParametricScheduleModelSequence2) o.getParametricScheduleModelSequence2()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ParametricScheduleModel", ValidationType.ONLY_EXISTS, "ParametricScheduleModel", path, "");
		}
		return failure("ParametricScheduleModel", ValidationType.ONLY_EXISTS, "ParametricScheduleModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDateOffset;
import fpml.confirmation.FxScheduleSequence1;
import fpml.confirmation.ParametricScheduleModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxScheduleSequence1OnlyExistsValidator implements ValidatorWithArg<FxScheduleSequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxScheduleSequence1> ValidationResult<FxScheduleSequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("parametricScheduleModel", ExistenceChecker.isSet((ParametricScheduleModel) o.getParametricScheduleModel()))
				.put("dateOffset", ExistenceChecker.isSet((FxDateOffset) o.getDateOffset()))
				.put("adjustedDate", ExistenceChecker.isSet((List<Date>) o.getAdjustedDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxScheduleSequence1", ValidationType.ONLY_EXISTS, "FxScheduleSequence1", path, "");
		}
		return failure("FxScheduleSequence1", ValidationType.ONLY_EXISTS, "FxScheduleSequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

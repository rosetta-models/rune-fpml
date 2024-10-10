package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.FxFixingScheduleSimple;
import fpml.confirmation.FxFixingScheduleSimpleSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxFixingScheduleSimpleOnlyExistsValidator implements ValidatorWithArg<FxFixingScheduleSimple, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxFixingScheduleSimple> ValidationResult<FxFixingScheduleSimple> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxFixingScheduleSimpleSequence", ExistenceChecker.isSet((FxFixingScheduleSimpleSequence) o.getFxFixingScheduleSimpleSequence()))
				.put("endDate", ExistenceChecker.isSet((Date) o.getEndDate()))
				.put("dayType", ExistenceChecker.isSet((DayTypeEnum) o.getDayType()))
				.put("businessCentersOrReferenceModel", ExistenceChecker.isSet((BusinessCentersOrReferenceModel) o.getBusinessCentersOrReferenceModel()))
				.put("fixingDate", ExistenceChecker.isSet((List<Date>) o.getFixingDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxFixingScheduleSimple", ValidationType.ONLY_EXISTS, "FxFixingScheduleSimple", path, "");
		}
		return failure("FxFixingScheduleSimple", ValidationType.ONLY_EXISTS, "FxFixingScheduleSimple", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

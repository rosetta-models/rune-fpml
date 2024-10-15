package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RateTreatmentEnum;
import fpml.confirmation.Schedule;
import fpml.confirmation.SpreadSchedule;
import fpml.confirmation.StrikeSchedule;
import fpml.confirmation.StubFloatingRate;
import fpml.confirmation.StubFloatingRateIndexModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class StubFloatingRateOnlyExistsValidator implements ValidatorWithArg<StubFloatingRate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends StubFloatingRate> ValidationResult<StubFloatingRate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("stubFloatingRateIndexModel", ExistenceChecker.isSet((StubFloatingRateIndexModel) o.getStubFloatingRateIndexModel()))
				.put("floatingRateMultiplierSchedule", ExistenceChecker.isSet((Schedule) o.getFloatingRateMultiplierSchedule()))
				.put("spreadSchedule", ExistenceChecker.isSet((List<? extends SpreadSchedule>) o.getSpreadSchedule()))
				.put("rateTreatment", ExistenceChecker.isSet((RateTreatmentEnum) o.getRateTreatment()))
				.put("capRateSchedule", ExistenceChecker.isSet((List<? extends StrikeSchedule>) o.getCapRateSchedule()))
				.put("floorRateSchedule", ExistenceChecker.isSet((List<? extends StrikeSchedule>) o.getFloorRateSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("StubFloatingRate", ValidationType.ONLY_EXISTS, "StubFloatingRate", path, "");
		}
		return failure("StubFloatingRate", ValidationType.ONLY_EXISTS, "StubFloatingRate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

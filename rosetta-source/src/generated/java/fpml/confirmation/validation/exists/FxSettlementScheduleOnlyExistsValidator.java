package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxScheduleSequence0;
import fpml.confirmation.FxScheduleSequence1;
import fpml.confirmation.FxSettlementSchedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxSettlementScheduleOnlyExistsValidator implements ValidatorWithArg<FxSettlementSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxSettlementSchedule> ValidationResult<FxSettlementSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxScheduleSequence0", ExistenceChecker.isSet((FxScheduleSequence0) o.getFxScheduleSequence0()))
				.put("fxScheduleSequence1", ExistenceChecker.isSet((FxScheduleSequence1) o.getFxScheduleSequence1()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("finalSettlementDate", ExistenceChecker.isSet((Date) o.getFinalSettlementDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxSettlementSchedule", ValidationType.ONLY_EXISTS, "FxSettlementSchedule", path, "");
		}
		return failure("FxSettlementSchedule", ValidationType.ONLY_EXISTS, "FxSettlementSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

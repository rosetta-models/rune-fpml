package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrual;
import fpml.confirmation.FxAccrualRegion;
import fpml.confirmation.FxFixingSchedule;
import fpml.confirmation.FxRateObservable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualOnlyExistsValidator implements ValidatorWithArg<FxAccrual, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrual> ValidationResult<FxAccrual> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observable", ExistenceChecker.isSet((List<? extends FxRateObservable>) o.getObservable()))
				.put("accrualRegion", ExistenceChecker.isSet((List<? extends FxAccrualRegion>) o.getAccrualRegion()))
				.put("fixingSchedule", ExistenceChecker.isSet((FxFixingSchedule) o.getFixingSchedule()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrual", ValidationType.ONLY_EXISTS, "FxAccrual", path, "");
		}
		return failure("FxAccrual", ValidationType.ONLY_EXISTS, "FxAccrual", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

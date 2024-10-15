package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualRegion;
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.FxAccrualRegionSequence0;
import fpml.confirmation.FxAccrualRegionSequence1;
import fpml.confirmation.FxRateObservableReference;
import fpml.confirmation.Schedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualRegionOnlyExistsValidator implements ValidatorWithArg<FxAccrualRegion, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualRegion> ValidationResult<FxAccrualRegion> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observableReference", ExistenceChecker.isSet((FxRateObservableReference) o.getObservableReference()))
				.put("fxAccrualRegionBoundModel", ExistenceChecker.isSet((FxAccrualRegionBoundModel) o.getFxAccrualRegionBoundModel()))
				.put("fxAccrualRegionSequence0", ExistenceChecker.isSet((FxAccrualRegionSequence0) o.getFxAccrualRegionSequence0()))
				.put("endDate", ExistenceChecker.isSet((Date) o.getEndDate()))
				.put("accrualFactor", ExistenceChecker.isSet((Schedule) o.getAccrualFactor()))
				.put("fxAccrualRegionSequence1", ExistenceChecker.isSet((FxAccrualRegionSequence1) o.getFxAccrualRegionSequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualRegion", ValidationType.ONLY_EXISTS, "FxAccrualRegion", path, "");
		}
		return failure("FxAccrualRegion", ValidationType.ONLY_EXISTS, "FxAccrualRegion", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

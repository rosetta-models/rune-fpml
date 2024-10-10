package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAsianFeatureSequence;
import fpml.confirmation.FxAverageRateObservationSchedule;
import fpml.confirmation.FxRateObservationModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAsianFeatureSequenceOnlyExistsValidator implements ValidatorWithArg<FxAsianFeatureSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAsianFeatureSequence> ValidationResult<FxAsianFeatureSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observationSchedule", ExistenceChecker.isSet((FxAverageRateObservationSchedule) o.getObservationSchedule()))
				.put("fxRateObservationModel", ExistenceChecker.isSet((FxRateObservationModel) o.getFxRateObservationModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAsianFeatureSequence", ValidationType.ONLY_EXISTS, "FxAsianFeatureSequence", path, "");
		}
		return failure("FxAsianFeatureSequence", ValidationType.ONLY_EXISTS, "FxAsianFeatureSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

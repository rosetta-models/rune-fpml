package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxBarrierFeatureSequenceSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxBarrierFeatureSequenceSequenceOnlyExistsValidator implements ValidatorWithArg<FxBarrierFeatureSequenceSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxBarrierFeatureSequenceSequence> ValidationResult<FxBarrierFeatureSequenceSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observationEndDate", ExistenceChecker.isSet((Date) o.getObservationEndDate()))
				.put("observationEndTime", ExistenceChecker.isSet((BusinessCenterTime) o.getObservationEndTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxBarrierFeatureSequenceSequence", ValidationType.ONLY_EXISTS, "FxBarrierFeatureSequenceSequence", path, "");
		}
		return failure("FxBarrierFeatureSequenceSequence", ValidationType.ONLY_EXISTS, "FxBarrierFeatureSequenceSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

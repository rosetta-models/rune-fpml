package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasDeliveryPeriodsSequence;
import fpml.confirmation.PrevailingTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GasDeliveryPeriodsSequenceOnlyExistsValidator implements ValidatorWithArg<GasDeliveryPeriodsSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GasDeliveryPeriodsSequence> ValidationResult<GasDeliveryPeriodsSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("supplyStartTime", ExistenceChecker.isSet((PrevailingTime) o.getSupplyStartTime()))
				.put("supplyEndTime", ExistenceChecker.isSet((PrevailingTime) o.getSupplyEndTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GasDeliveryPeriodsSequence", ValidationType.ONLY_EXISTS, "GasDeliveryPeriodsSequence", path, "");
		}
		return failure("GasDeliveryPeriodsSequence", ValidationType.ONLY_EXISTS, "GasDeliveryPeriodsSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

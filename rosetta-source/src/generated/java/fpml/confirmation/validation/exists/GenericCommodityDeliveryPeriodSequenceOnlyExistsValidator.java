package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericCommodityDeliveryPeriodSequence;
import fpml.confirmation.OffsetPrevailingTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericCommodityDeliveryPeriodSequenceOnlyExistsValidator implements ValidatorWithArg<GenericCommodityDeliveryPeriodSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericCommodityDeliveryPeriodSequence> ValidationResult<GenericCommodityDeliveryPeriodSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("startTime", ExistenceChecker.isSet((OffsetPrevailingTime) o.getStartTime()))
				.put("endTime", ExistenceChecker.isSet((OffsetPrevailingTime) o.getEndTime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericCommodityDeliveryPeriodSequence", ValidationType.ONLY_EXISTS, "GenericCommodityDeliveryPeriodSequence", path, "");
		}
		return failure("GenericCommodityDeliveryPeriodSequence", ValidationType.ONLY_EXISTS, "GenericCommodityDeliveryPeriodSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

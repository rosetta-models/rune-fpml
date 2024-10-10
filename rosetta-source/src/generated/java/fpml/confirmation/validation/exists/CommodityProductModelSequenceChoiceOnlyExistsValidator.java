package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityProductModelSequenceChoice;
import fpml.confirmation.DeliveryDatesEnum;
import fpml.confirmation.DeliveryNearby;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityProductModelSequenceChoiceOnlyExistsValidator implements ValidatorWithArg<CommodityProductModelSequenceChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityProductModelSequenceChoice> ValidationResult<CommodityProductModelSequenceChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryDates", ExistenceChecker.isSet((DeliveryDatesEnum) o.getDeliveryDates()))
				.put("deliveryNearby", ExistenceChecker.isSet((DeliveryNearby) o.getDeliveryNearby()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityProductModelSequenceChoice", ValidationType.ONLY_EXISTS, "CommodityProductModelSequenceChoice", path, "");
		}
		return failure("CommodityProductModelSequenceChoice", ValidationType.ONLY_EXISTS, "CommodityProductModelSequenceChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

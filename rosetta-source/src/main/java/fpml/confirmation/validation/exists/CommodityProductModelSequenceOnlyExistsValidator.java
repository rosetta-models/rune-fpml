package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.CommodityProductModelSequence;
import fpml.confirmation.CommodityProductModelSequenceChoice;
import fpml.confirmation.Offset;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityProductModelSequenceOnlyExistsValidator implements ValidatorWithArg<CommodityProductModelSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityProductModelSequence> ValidationResult<CommodityProductModelSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodityProductModelSequenceChoice", ExistenceChecker.isSet((CommodityProductModelSequenceChoice) o.getCommodityProductModelSequenceChoice()))
				.put("deliveryDate", ExistenceChecker.isSet((AdjustableDate) o.getDeliveryDate()))
				.put("deliveryDateYearMonth", ExistenceChecker.isSet((Integer) o.getDeliveryDateYearMonth()))
				.put("deliveryDateRollConvention", ExistenceChecker.isSet((Offset) o.getDeliveryDateRollConvention()))
				.put("deliveryDateExpirationConvention", ExistenceChecker.isSet((Offset) o.getDeliveryDateExpirationConvention()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityProductModelSequence", ValidationType.ONLY_EXISTS, "CommodityProductModelSequence", path, "");
		}
		return failure("CommodityProductModelSequence", ValidationType.ONLY_EXISTS, "CommodityProductModelSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

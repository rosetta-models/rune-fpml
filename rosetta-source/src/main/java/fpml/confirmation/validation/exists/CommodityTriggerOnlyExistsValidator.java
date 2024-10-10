package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityTrigger;
import fpml.confirmation.CommodityTriggerSequence;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.TriggerTypeEnum;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityTriggerOnlyExistsValidator implements ValidatorWithArg<CommodityTrigger, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityTrigger> ValidationResult<CommodityTrigger> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodityTriggerSequence", ExistenceChecker.isSet((CommodityTriggerSequence) o.getCommodityTriggerSequence()))
				.put("levelPercentage", ExistenceChecker.isSet((BigDecimal) o.getLevelPercentage()))
				.put("levelPrice", ExistenceChecker.isSet((FixedPrice) o.getLevelPrice()))
				.put("triggerType", ExistenceChecker.isSet((TriggerTypeEnum) o.getTriggerType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityTrigger", ValidationType.ONLY_EXISTS, "CommodityTrigger", path, "");
		}
		return failure("CommodityTrigger", ValidationType.ONLY_EXISTS, "CommodityTrigger", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

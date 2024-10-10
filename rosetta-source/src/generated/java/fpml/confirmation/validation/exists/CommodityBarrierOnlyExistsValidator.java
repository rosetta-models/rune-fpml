package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBarrier;
import fpml.confirmation.CommodityKnockEnum;
import fpml.confirmation.CommodityTrigger;
import fpml.confirmation.PositiveMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBarrierOnlyExistsValidator implements ValidatorWithArg<CommodityBarrier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBarrier> ValidationResult<CommodityBarrier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("knock", ExistenceChecker.isSet((CommodityKnockEnum) o.getKnock()))
				.put("featurePaymentAmount", ExistenceChecker.isSet((PositiveMoney) o.getFeaturePaymentAmount()))
				.put("trigger", ExistenceChecker.isSet((CommodityTrigger) o.getTrigger()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBarrier", ValidationType.ONLY_EXISTS, "CommodityBarrier", path, "");
		}
		return failure("CommodityBarrier", ValidationType.ONLY_EXISTS, "CommodityBarrier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

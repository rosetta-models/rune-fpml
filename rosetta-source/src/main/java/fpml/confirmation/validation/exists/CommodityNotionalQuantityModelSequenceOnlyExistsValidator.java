package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityNotionalQuantityModelSequence;
import fpml.confirmation.CommodityNotionalQuantitySchedule;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantity;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityNotionalQuantityModelSequenceOnlyExistsValidator implements ValidatorWithArg<CommodityNotionalQuantityModelSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityNotionalQuantityModelSequence> ValidationResult<CommodityNotionalQuantityModelSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalQuantitySchedule", ExistenceChecker.isSet((CommodityNotionalQuantitySchedule) o.getNotionalQuantitySchedule()))
				.put("notionalQuantity", ExistenceChecker.isSet((CommodityNotionalQuantity) o.getNotionalQuantity()))
				.put("settlementPeriodsNotionalQuantity", ExistenceChecker.isSet((List<? extends CommoditySettlementPeriodsNotionalQuantity>) o.getSettlementPeriodsNotionalQuantity()))
				.put("totalNotionalQuantity", ExistenceChecker.isSet((BigDecimal) o.getTotalNotionalQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityNotionalQuantityModelSequence", ValidationType.ONLY_EXISTS, "CommodityNotionalQuantityModelSequence", path, "");
		}
		return failure("CommodityNotionalQuantityModelSequence", ValidationType.ONLY_EXISTS, "CommodityNotionalQuantityModelSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

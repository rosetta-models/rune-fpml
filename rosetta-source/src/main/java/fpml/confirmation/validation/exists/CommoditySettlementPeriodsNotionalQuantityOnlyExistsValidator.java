package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantity;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.SettlementPeriodsReference;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommoditySettlementPeriodsNotionalQuantityOnlyExistsValidator implements ValidatorWithArg<CommoditySettlementPeriodsNotionalQuantity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommoditySettlementPeriodsNotionalQuantity> ValidationResult<CommoditySettlementPeriodsNotionalQuantity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("quantityUnit", ExistenceChecker.isSet((QuantityUnit) o.getQuantityUnit()))
				.put("quantityFrequency", ExistenceChecker.isSet((CommodityQuantityFrequency) o.getQuantityFrequency()))
				.put("quantity", ExistenceChecker.isSet((BigDecimal) o.getQuantity()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("settlementPeriodsReference", ExistenceChecker.isSet((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommoditySettlementPeriodsNotionalQuantity", ValidationType.ONLY_EXISTS, "CommoditySettlementPeriodsNotionalQuantity", path, "");
		}
		return failure("CommoditySettlementPeriodsNotionalQuantity", ValidationType.ONLY_EXISTS, "CommoditySettlementPeriodsNotionalQuantity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

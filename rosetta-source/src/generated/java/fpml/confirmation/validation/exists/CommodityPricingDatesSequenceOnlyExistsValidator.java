package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPricingDatesSequence;
import fpml.confirmation.CommodityPricingDatesSequenceSequence;
import fpml.confirmation.Lag;
import fpml.confirmation.SettlementPeriods;
import fpml.confirmation.SettlementPeriodsReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPricingDatesSequenceOnlyExistsValidator implements ValidatorWithArg<CommodityPricingDatesSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPricingDatesSequence> ValidationResult<CommodityPricingDatesSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("lag", ExistenceChecker.isSet((Lag) o.getLag()))
				.put("commodityPricingDatesSequenceSequence", ExistenceChecker.isSet((CommodityPricingDatesSequenceSequence) o.getCommodityPricingDatesSequenceSequence()))
				.put("settlementPeriods", ExistenceChecker.isSet((List<? extends SettlementPeriods>) o.getSettlementPeriods()))
				.put("settlementPeriodsReference", ExistenceChecker.isSet((List<? extends SettlementPeriodsReference>) o.getSettlementPeriodsReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPricingDatesSequence", ValidationType.ONLY_EXISTS, "CommodityPricingDatesSequence", path, "");
		}
		return failure("CommodityPricingDatesSequence", ValidationType.ONLY_EXISTS, "CommodityPricingDatesSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

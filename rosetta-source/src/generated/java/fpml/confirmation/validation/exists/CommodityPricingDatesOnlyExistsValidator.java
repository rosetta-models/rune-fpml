package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommodityPricingDatesSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPricingDatesOnlyExistsValidator implements ValidatorWithArg<CommodityPricingDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPricingDates> ValidationResult<CommodityPricingDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commodityCalculationPeriodsPointerModel", ExistenceChecker.isSet((CommodityCalculationPeriodsPointerModel) o.getCommodityCalculationPeriodsPointerModel()))
				.put("commodityPricingDatesSequence", ExistenceChecker.isSet((CommodityPricingDatesSequence) o.getCommodityPricingDatesSequence()))
				.put("pricingDates", ExistenceChecker.isSet((List<? extends AdjustableDates>) o.getPricingDates()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPricingDates", ValidationType.ONLY_EXISTS, "CommodityPricingDates", path, "");
		}
		return failure("CommodityPricingDates", ValidationType.ONLY_EXISTS, "CommodityPricingDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

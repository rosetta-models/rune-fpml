package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommodityReturnCalculation;
import fpml.confirmation.CommodityReturnCalculationFormulaEnum;
import fpml.confirmation.CommodityValuationDates;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityReturnCalculationOnlyExistsValidator implements ValidatorWithArg<CommodityReturnCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityReturnCalculation> ValidationResult<CommodityReturnCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("formula", ExistenceChecker.isSet((CommodityReturnCalculationFormulaEnum) o.getFormula()))
				.put("pricingDates", ExistenceChecker.isSet((CommodityPricingDates) o.getPricingDates()))
				.put("valuationDates", ExistenceChecker.isSet((CommodityValuationDates) o.getValuationDates()))
				.put("initialPrice", ExistenceChecker.isSet((BigDecimal) o.getInitialPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityReturnCalculation", ValidationType.ONLY_EXISTS, "CommodityReturnCalculation", path, "");
		}
		return failure("CommodityReturnCalculation", ValidationType.ONLY_EXISTS, "CommodityReturnCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.CommodityFx;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.CommoditySpread;
import fpml.confirmation.CommoditySpreadSchedule;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.Rounding;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingLegCalculationOnlyExistsValidator implements ValidatorWithArg<FloatingLegCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingLegCalculation> ValidationResult<FloatingLegCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pricingDates", ExistenceChecker.isSet((CommodityPricingDates) o.getPricingDates()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.put("conversionFactor", ExistenceChecker.isSet((BigDecimal) o.getConversionFactor()))
				.put("rounding", ExistenceChecker.isSet((Rounding) o.getRounding()))
				.put("spread", ExistenceChecker.isSet((CommoditySpread) o.getSpread()))
				.put("spreadSchedule", ExistenceChecker.isSet((List<? extends CommoditySpreadSchedule>) o.getSpreadSchedule()))
				.put("spreadPercentage", ExistenceChecker.isSet((BigDecimal) o.getSpreadPercentage()))
				.put("fx", ExistenceChecker.isSet((CommodityFx) o.getFx()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingLegCalculation", ValidationType.ONLY_EXISTS, "FloatingLegCalculation", path, "");
		}
		return failure("FloatingLegCalculation", ValidationType.ONLY_EXISTS, "FloatingLegCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

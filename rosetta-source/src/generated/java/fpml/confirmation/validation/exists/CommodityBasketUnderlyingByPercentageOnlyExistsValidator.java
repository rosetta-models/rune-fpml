package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityBasketUnderlyingByPercentage;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.PayerReceiverEnum;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBasketUnderlyingByPercentageOnlyExistsValidator implements ValidatorWithArg<CommodityBasketUnderlyingByPercentage, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBasketUnderlyingByPercentage> ValidationResult<CommodityBasketUnderlyingByPercentage> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("direction", ExistenceChecker.isSet((PayerReceiverEnum) o.getDirection()))
				.put("commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("pricingDates", ExistenceChecker.isSet((CommodityPricingDates) o.getPricingDates()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("constituentWeight", ExistenceChecker.isSet((BigDecimal) o.getConstituentWeight()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBasketUnderlyingByPercentage", ValidationType.ONLY_EXISTS, "CommodityBasketUnderlyingByPercentage", path, "");
		}
		return failure("CommodityBasketUnderlyingByPercentage", ValidationType.ONLY_EXISTS, "CommodityBasketUnderlyingByPercentage", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

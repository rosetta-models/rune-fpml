package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityFixedPriceModel;
import fpml.confirmation.CommodityFreightFlatRateModel;
import fpml.confirmation.CommodityNotionalQuantityModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.FixedPriceLeg;
import fpml.confirmation.PayerReceiverModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FixedPriceLegOnlyExistsValidator implements ValidatorWithArg<FixedPriceLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FixedPriceLeg> ValidationResult<FixedPriceLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("commodityCalculationPeriodsModel", ExistenceChecker.isSet((CommodityCalculationPeriodsModel) o.getCommodityCalculationPeriodsModel()))
				.put("commodityFixedPriceModel", ExistenceChecker.isSet((CommodityFixedPriceModel) o.getCommodityFixedPriceModel()))
				.put("commodityNotionalQuantityModel", ExistenceChecker.isSet((CommodityNotionalQuantityModel) o.getCommodityNotionalQuantityModel()))
				.put("commodityPaymentDatesModel", ExistenceChecker.isSet((CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel()))
				.put("commodityFreightFlatRateModel", ExistenceChecker.isSet((CommodityFreightFlatRateModel) o.getCommodityFreightFlatRateModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FixedPriceLeg", ValidationType.ONLY_EXISTS, "FixedPriceLeg", path, "");
		}
		return failure("FixedPriceLeg", ValidationType.ONLY_EXISTS, "FixedPriceLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

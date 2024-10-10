package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.AveragePriceLeg;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.FloatingLegCalculation;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.QuantityReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AveragePriceLegOnlyExistsValidator implements ValidatorWithArg<AveragePriceLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AveragePriceLeg> ValidationResult<AveragePriceLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("commodityCalculationPeriodsModel", ExistenceChecker.isSet((CommodityCalculationPeriodsModel) o.getCommodityCalculationPeriodsModel()))
				.put("commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("quantityReference", ExistenceChecker.isSet((QuantityReference) o.getQuantityReference()))
				.put("pricingStartDate", ExistenceChecker.isSet((AdjustableDate) o.getPricingStartDate()))
				.put("calculation", ExistenceChecker.isSet((FloatingLegCalculation) o.getCalculation()))
				.put("commodityPaymentDatesModel", ExistenceChecker.isSet((CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AveragePriceLeg", ValidationType.ONLY_EXISTS, "AveragePriceLeg", path, "");
		}
		return failure("AveragePriceLeg", ValidationType.ONLY_EXISTS, "AveragePriceLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

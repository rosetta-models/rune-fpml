package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityCalculationPeriodsModel;
import fpml.confirmation.CommodityNotionalAmount;
import fpml.confirmation.CommodityNotionalAmountReference;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.CommodityReturnCalculation;
import fpml.confirmation.CommodityReturnLeg;
import fpml.confirmation.CommodityUnderlyerChoiceModel;
import fpml.confirmation.PayerReceiverModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityReturnLegOnlyExistsValidator implements ValidatorWithArg<CommodityReturnLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityReturnLeg> ValidationResult<CommodityReturnLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("commodityCalculationPeriodsModel", ExistenceChecker.isSet((CommodityCalculationPeriodsModel) o.getCommodityCalculationPeriodsModel()))
				.put("commodityPaymentDatesModel", ExistenceChecker.isSet((CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel()))
				.put("commodityUnderlyerChoiceModel", ExistenceChecker.isSet((CommodityUnderlyerChoiceModel) o.getCommodityUnderlyerChoiceModel()))
				.put("notionalAmount", ExistenceChecker.isSet((CommodityNotionalAmount) o.getNotionalAmount()))
				.put("notionalAmountReference", ExistenceChecker.isSet((CommodityNotionalAmountReference) o.getNotionalAmountReference()))
				.put("commodityReturnCalculation", ExistenceChecker.isSet((CommodityReturnCalculation) o.getCommodityReturnCalculation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityReturnLeg", ValidationType.ONLY_EXISTS, "CommodityReturnLeg", path, "");
		}
		return failure("CommodityReturnLeg", ValidationType.ONLY_EXISTS, "CommodityReturnLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPaymentDatesModel;
import fpml.confirmation.FixedPrice;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonPeriodicFixedPriceLeg;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.QuantityReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonPeriodicFixedPriceLegOnlyExistsValidator implements ValidatorWithArg<NonPeriodicFixedPriceLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonPeriodicFixedPriceLeg> ValidationResult<NonPeriodicFixedPriceLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("fixedPrice", ExistenceChecker.isSet((FixedPrice) o.getFixedPrice()))
				.put("totalPrice", ExistenceChecker.isSet((NonNegativeMoney) o.getTotalPrice()))
				.put("quantityReference", ExistenceChecker.isSet((QuantityReference) o.getQuantityReference()))
				.put("commodityPaymentDatesModel", ExistenceChecker.isSet((CommodityPaymentDatesModel) o.getCommodityPaymentDatesModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonPeriodicFixedPriceLeg", ValidationType.ONLY_EXISTS, "NonPeriodicFixedPriceLeg", path, "");
		}
		return failure("NonPeriodicFixedPriceLeg", ValidationType.ONLY_EXISTS, "NonPeriodicFixedPriceLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

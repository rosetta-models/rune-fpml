package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityPremium;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityPremiumOnlyExistsValidator implements ValidatorWithArg<CommodityPremium, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityPremium> ValidationResult<CommodityPremium> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getPaymentDate()))
				.put("paymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPaymentAmount()))
				.put("premiumPerUnit", ExistenceChecker.isSet((NonNegativeMoney) o.getPremiumPerUnit()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityPremium", ValidationType.ONLY_EXISTS, "CommodityPremium", path, "");
		}
		return failure("CommodityPremium", ValidationType.ONLY_EXISTS, "CommodityPremium", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

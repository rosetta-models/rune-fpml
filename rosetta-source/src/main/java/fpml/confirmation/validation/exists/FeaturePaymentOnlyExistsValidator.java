package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.Currency;
import fpml.confirmation.FeaturePayment;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.TimeTypeEnum;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FeaturePaymentOnlyExistsValidator implements ValidatorWithArg<FeaturePayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FeaturePayment> ValidationResult<FeaturePayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("levelPercentage", ExistenceChecker.isSet((BigDecimal) o.getLevelPercentage()))
				.put("amount", ExistenceChecker.isSet((BigDecimal) o.getAmount()))
				.put("time", ExistenceChecker.isSet((TimeTypeEnum) o.getTime()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("featurePaymentDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getFeaturePaymentDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FeaturePayment", ValidationType.ONLY_EXISTS, "FeaturePayment", path, "");
		}
		return failure("FeaturePayment", ValidationType.ONLY_EXISTS, "FeaturePayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

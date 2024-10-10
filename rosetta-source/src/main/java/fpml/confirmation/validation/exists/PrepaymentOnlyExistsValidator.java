package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Prepayment;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PrepaymentOnlyExistsValidator implements ValidatorWithArg<Prepayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Prepayment> ValidationResult<Prepayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("prePayment", ExistenceChecker.isSet((Boolean) o.getPrePayment()))
				.put("prePaymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPrePaymentAmount()))
				.put("prePaymentDate", ExistenceChecker.isSet((AdjustableDate) o.getPrePaymentDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PrePayment", ValidationType.ONLY_EXISTS, "PrePayment", path, "");
		}
		return failure("PrePayment", ValidationType.ONLY_EXISTS, "PrePayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

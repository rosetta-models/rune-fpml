package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.Money;
import fpml.confirmation.PaymentDetail;
import fpml.confirmation.PaymentDetailSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PaymentDetailOnlyExistsValidator implements ValidatorWithArg<PaymentDetail, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PaymentDetail> ValidationResult<PaymentDetail> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getPaymentDate()))
				.put("paymentAmount", ExistenceChecker.isSet((Money) o.getPaymentAmount()))
				.put("paymentDetailSequence", ExistenceChecker.isSet((PaymentDetailSequence) o.getPaymentDetailSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PaymentDetail", ValidationType.ONLY_EXISTS, "PaymentDetail", path, "");
		}
		return failure("PaymentDetail", ValidationType.ONLY_EXISTS, "PaymentDetail", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

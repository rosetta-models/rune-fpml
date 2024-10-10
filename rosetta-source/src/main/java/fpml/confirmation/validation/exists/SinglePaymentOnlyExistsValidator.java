package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Money;
import fpml.confirmation.SinglePayment;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SinglePaymentOnlyExistsValidator implements ValidatorWithArg<SinglePayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SinglePayment> ValidationResult<SinglePayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("adjustablePaymentDate", ExistenceChecker.isSet((Date) o.getAdjustablePaymentDate()))
				.put("adjustedPaymentDate", ExistenceChecker.isSet((Date) o.getAdjustedPaymentDate()))
				.put("fixedAmount", ExistenceChecker.isSet((Money) o.getFixedAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SinglePayment", ValidationType.ONLY_EXISTS, "SinglePayment", path, "");
		}
		return failure("SinglePayment", ValidationType.ONLY_EXISTS, "SinglePayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

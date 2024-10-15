package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.PaymentProjection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PaymentProjectionOnlyExistsValidator implements ValidatorWithArg<PaymentProjection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PaymentProjection> ValidationResult<PaymentProjection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("nextPaymentDate", ExistenceChecker.isSet((Date) o.getNextPaymentDate()))
				.put("projectedAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getProjectedAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PaymentProjection", ValidationType.ONLY_EXISTS, "PaymentProjection", path, "");
		}
		return failure("PaymentProjection", ValidationType.ONLY_EXISTS, "PaymentProjection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

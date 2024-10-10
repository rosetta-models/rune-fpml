package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdditionalPaymentAmount;
import fpml.confirmation.Formula;
import fpml.confirmation.NonNegativeMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdditionalPaymentAmountOnlyExistsValidator implements ValidatorWithArg<AdditionalPaymentAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdditionalPaymentAmount> ValidationResult<AdditionalPaymentAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("paymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPaymentAmount()))
				.put("formula", ExistenceChecker.isSet((Formula) o.getFormula()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdditionalPaymentAmount", ValidationType.ONLY_EXISTS, "AdditionalPaymentAmount", path, "");
		}
		return failure("AdditionalPaymentAmount", ValidationType.ONLY_EXISTS, "AdditionalPaymentAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

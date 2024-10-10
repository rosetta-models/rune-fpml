package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendDateReferenceEnum;
import fpml.confirmation.DividendPaymentDateSequence;
import fpml.confirmation.Offset;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DividendPaymentDateSequenceOnlyExistsValidator implements ValidatorWithArg<DividendPaymentDateSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DividendPaymentDateSequence> ValidationResult<DividendPaymentDateSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dividendDateReference", ExistenceChecker.isSet((DividendDateReferenceEnum) o.getDividendDateReference()))
				.put("paymentDateOffset", ExistenceChecker.isSet((Offset) o.getPaymentDateOffset()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendPaymentDateSequence", ValidationType.ONLY_EXISTS, "DividendPaymentDateSequence", path, "");
		}
		return failure("DividendPaymentDateSequence", ValidationType.ONLY_EXISTS, "DividendPaymentDateSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

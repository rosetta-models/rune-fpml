package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustedPaymentDates;
import fpml.confirmation.Money;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdjustedPaymentDatesOnlyExistsValidator implements ValidatorWithArg<AdjustedPaymentDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AdjustedPaymentDates> ValidationResult<AdjustedPaymentDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("adjustedPaymentDate", ExistenceChecker.isSet((Date) o.getAdjustedPaymentDate()))
				.put("paymentAmount", ExistenceChecker.isSet((Money) o.getPaymentAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdjustedPaymentDates", ValidationType.ONLY_EXISTS, "AdjustedPaymentDates", path, "");
		}
		return failure("AdjustedPaymentDates", ValidationType.ONLY_EXISTS, "AdjustedPaymentDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

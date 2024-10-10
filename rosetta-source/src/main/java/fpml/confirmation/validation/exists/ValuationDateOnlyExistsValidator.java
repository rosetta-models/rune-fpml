package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MultipleValuationDates;
import fpml.confirmation.SingleValuationDate;
import fpml.confirmation.ValuationDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ValuationDateOnlyExistsValidator implements ValidatorWithArg<ValuationDate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ValuationDate> ValidationResult<ValuationDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("singleValuationDate", ExistenceChecker.isSet((SingleValuationDate) o.getSingleValuationDate()))
				.put("multipleValuationDates", ExistenceChecker.isSet((MultipleValuationDates) o.getMultipleValuationDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuationDate", ValidationType.ONLY_EXISTS, "ValuationDate", path, "");
		}
		return failure("ValuationDate", ValidationType.ONLY_EXISTS, "ValuationDate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

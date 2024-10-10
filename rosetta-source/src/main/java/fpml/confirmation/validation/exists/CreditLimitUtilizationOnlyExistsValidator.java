package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditLimitUtilization;
import fpml.confirmation.CreditLimitUtilizationPosition;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditLimitUtilizationOnlyExistsValidator implements ValidatorWithArg<CreditLimitUtilization, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditLimitUtilization> ValidationResult<CreditLimitUtilization> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("executed", ExistenceChecker.isSet((CreditLimitUtilizationPosition) o.getExecuted()))
				.put("pending", ExistenceChecker.isSet((CreditLimitUtilizationPosition) o.getPending()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditLimitUtilization", ValidationType.ONLY_EXISTS, "CreditLimitUtilization", path, "");
		}
		return failure("CreditLimitUtilization", ValidationType.ONLY_EXISTS, "CreditLimitUtilization", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

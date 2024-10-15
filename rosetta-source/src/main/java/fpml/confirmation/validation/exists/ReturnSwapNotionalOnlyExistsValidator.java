package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.DeterminationMethodReference;
import fpml.confirmation.NotionalAmount;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.ReturnSwapNotionalAmountReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnSwapNotionalOnlyExistsValidator implements ValidatorWithArg<ReturnSwapNotional, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnSwapNotional> ValidationResult<ReturnSwapNotional> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("relativeNotionalAmount", ExistenceChecker.isSet((ReturnSwapNotionalAmountReference) o.getRelativeNotionalAmount()))
				.put("relativeDeterminationMethod", ExistenceChecker.isSet((DeterminationMethodReference) o.getRelativeDeterminationMethod()))
				.put("determinationMethod", ExistenceChecker.isSet((DeterminationMethod) o.getDeterminationMethod()))
				.put("notionalAmount", ExistenceChecker.isSet((NotionalAmount) o.getNotionalAmount()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnSwapNotional", ValidationType.ONLY_EXISTS, "ReturnSwapNotional", path, "");
		}
		return failure("ReturnSwapNotional", ValidationType.ONLY_EXISTS, "ReturnSwapNotional", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

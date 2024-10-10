package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrincipalExchanges;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PrincipalExchangesOnlyExistsValidator implements ValidatorWithArg<PrincipalExchanges, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PrincipalExchanges> ValidationResult<PrincipalExchanges> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initialExchange", ExistenceChecker.isSet((Boolean) o.getInitialExchange()))
				.put("finalExchange", ExistenceChecker.isSet((Boolean) o.getFinalExchange()))
				.put("intermediateExchange", ExistenceChecker.isSet((Boolean) o.getIntermediateExchange()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PrincipalExchanges", ValidationType.ONLY_EXISTS, "PrincipalExchanges", path, "");
		}
		return failure("PrincipalExchanges", ValidationType.ONLY_EXISTS, "PrincipalExchanges", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

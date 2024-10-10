package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RSAKeyValueType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RSAKeyValueTypeOnlyExistsValidator implements ValidatorWithArg<RSAKeyValueType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RSAKeyValueType> ValidationResult<RSAKeyValueType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("modulus", ExistenceChecker.isSet((String) o.getModulus()))
				.put("exponent", ExistenceChecker.isSet((String) o.getExponent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RSAKeyValueType", ValidationType.ONLY_EXISTS, "RSAKeyValueType", path, "");
		}
		return failure("RSAKeyValueType", ValidationType.ONLY_EXISTS, "RSAKeyValueType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

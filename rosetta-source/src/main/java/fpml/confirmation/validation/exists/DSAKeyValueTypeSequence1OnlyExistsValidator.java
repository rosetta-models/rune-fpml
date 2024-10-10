package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DSAKeyValueTypeSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DSAKeyValueTypeSequence1OnlyExistsValidator implements ValidatorWithArg<DSAKeyValueTypeSequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DSAKeyValueTypeSequence1> ValidationResult<DSAKeyValueTypeSequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("seed", ExistenceChecker.isSet((String) o.getSeed()))
				.put("pgenCounter", ExistenceChecker.isSet((String) o.getPgenCounter()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DSAKeyValueTypeSequence1", ValidationType.ONLY_EXISTS, "DSAKeyValueTypeSequence1", path, "");
		}
		return failure("DSAKeyValueTypeSequence1", ValidationType.ONLY_EXISTS, "DSAKeyValueTypeSequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

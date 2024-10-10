package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.X509Data;
import fpml.confirmation.X509DataTypeSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class X509DataOnlyExistsValidator implements ValidatorWithArg<X509Data, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends X509Data> ValidationResult<X509Data> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("x509DataTypeSequence", ExistenceChecker.isSet((List<? extends X509DataTypeSequence>) o.getX509DataTypeSequence()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("X509Data", ValidationType.ONLY_EXISTS, "X509Data", path, "");
		}
		return failure("X509Data", ValidationType.ONLY_EXISTS, "X509Data", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

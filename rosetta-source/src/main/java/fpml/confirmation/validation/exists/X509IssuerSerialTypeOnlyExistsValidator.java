package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.X509IssuerSerialType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class X509IssuerSerialTypeOnlyExistsValidator implements ValidatorWithArg<X509IssuerSerialType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends X509IssuerSerialType> ValidationResult<X509IssuerSerialType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("x509IssuerName", ExistenceChecker.isSet((String) o.getX509IssuerName()))
				.put("x509SerialNumber", ExistenceChecker.isSet((Integer) o.getX509SerialNumber()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("X509IssuerSerialType", ValidationType.ONLY_EXISTS, "X509IssuerSerialType", path, "");
		}
		return failure("X509IssuerSerialType", ValidationType.ONLY_EXISTS, "X509IssuerSerialType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

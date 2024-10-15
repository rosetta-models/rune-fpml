package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.X509DataTypeSequence;
import fpml.confirmation.X509IssuerSerialType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class X509DataTypeSequenceOnlyExistsValidator implements ValidatorWithArg<X509DataTypeSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends X509DataTypeSequence> ValidationResult<X509DataTypeSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("x509IssuerSerial", ExistenceChecker.isSet((X509IssuerSerialType) o.getX509IssuerSerial()))
				.put("x509SKI", ExistenceChecker.isSet((String) o.getX509SKI()))
				.put("x509SubjectName", ExistenceChecker.isSet((String) o.getX509SubjectName()))
				.put("x509Certificate", ExistenceChecker.isSet((String) o.getX509Certificate()))
				.put("x509CRL", ExistenceChecker.isSet((String) o.getX509CRL()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("X509DataTypeSequence", ValidationType.ONLY_EXISTS, "X509DataTypeSequence", path, "");
		}
		return failure("X509DataTypeSequence", ValidationType.ONLY_EXISTS, "X509DataTypeSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

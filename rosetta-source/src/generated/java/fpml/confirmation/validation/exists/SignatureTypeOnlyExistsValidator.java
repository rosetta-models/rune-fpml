package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.KeyInfoType;
import fpml.confirmation.ObjectType;
import fpml.confirmation.SignatureType;
import fpml.confirmation.SignatureValueType;
import fpml.confirmation.SignedInfoType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SignatureTypeOnlyExistsValidator implements ValidatorWithArg<SignatureType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SignatureType> ValidationResult<SignatureType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("signedInfo", ExistenceChecker.isSet((SignedInfoType) o.getSignedInfo()))
				.put("signatureValue", ExistenceChecker.isSet((SignatureValueType) o.getSignatureValue()))
				.put("keyInfo", ExistenceChecker.isSet((KeyInfoType) o.getKeyInfo()))
				.put("object", ExistenceChecker.isSet((List<? extends ObjectType>) o.getObject()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SignatureType", ValidationType.ONLY_EXISTS, "SignatureType", path, "");
		}
		return failure("SignatureType", ValidationType.ONLY_EXISTS, "SignatureType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

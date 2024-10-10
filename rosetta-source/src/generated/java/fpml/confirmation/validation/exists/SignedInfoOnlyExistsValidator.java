package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CanonicalizationMethodType;
import fpml.confirmation.ReferenceType;
import fpml.confirmation.SignatureMethodType;
import fpml.confirmation.SignedInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SignedInfoOnlyExistsValidator implements ValidatorWithArg<SignedInfo, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SignedInfo> ValidationResult<SignedInfo> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("canonicalizationMethod", ExistenceChecker.isSet((CanonicalizationMethodType) o.getCanonicalizationMethod()))
				.put("signatureMethod", ExistenceChecker.isSet((SignatureMethodType) o.getSignatureMethod()))
				.put("reference", ExistenceChecker.isSet((List<? extends ReferenceType>) o.getReference()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SignedInfo", ValidationType.ONLY_EXISTS, "SignedInfo", path, "");
		}
		return failure("SignedInfo", ValidationType.ONLY_EXISTS, "SignedInfo", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

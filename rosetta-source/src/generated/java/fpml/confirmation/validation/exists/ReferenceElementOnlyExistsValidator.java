package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DigestMethodType;
import fpml.confirmation.ReferenceElement;
import fpml.confirmation.TransformsType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReferenceElementOnlyExistsValidator implements ValidatorWithArg<ReferenceElement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReferenceElement> ValidationResult<ReferenceElement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("transforms", ExistenceChecker.isSet((TransformsType) o.getTransforms()))
				.put("digestMethod", ExistenceChecker.isSet((DigestMethodType) o.getDigestMethod()))
				.put("digestValue", ExistenceChecker.isSet((String) o.getDigestValue()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("uri", ExistenceChecker.isSet((String) o.getUri()))
				.put("type", ExistenceChecker.isSet((String) o.getType_()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReferenceElement", ValidationType.ONLY_EXISTS, "ReferenceElement", path, "");
		}
		return failure("ReferenceElement", ValidationType.ONLY_EXISTS, "ReferenceElement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Object;
import fpml.confirmation.ObjectTypeSequence;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ObjectOnlyExistsValidator implements ValidatorWithArg<Object, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Object> ValidationResult<Object> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("objectTypeSequence", ExistenceChecker.isSet((List<? extends ObjectTypeSequence>) o.getObjectTypeSequence()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("mimeType", ExistenceChecker.isSet((String) o.getMimeType()))
				.put("encoding", ExistenceChecker.isSet((String) o.getEncoding()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Object", ValidationType.ONLY_EXISTS, "Object", path, "");
		}
		return failure("Object", ValidationType.ONLY_EXISTS, "Object", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

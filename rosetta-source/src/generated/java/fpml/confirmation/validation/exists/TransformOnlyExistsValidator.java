package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Transform;
import fpml.confirmation.TransformTypeChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TransformOnlyExistsValidator implements ValidatorWithArg<Transform, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Transform> ValidationResult<Transform> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("transformTypeChoice", ExistenceChecker.isSet((List<? extends TransformTypeChoice>) o.getTransformTypeChoice()))
				.put("algorithm", ExistenceChecker.isSet((String) o.getAlgorithm()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Transform", ValidationType.ONLY_EXISTS, "Transform", path, "");
		}
		return failure("Transform", ValidationType.ONLY_EXISTS, "Transform", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

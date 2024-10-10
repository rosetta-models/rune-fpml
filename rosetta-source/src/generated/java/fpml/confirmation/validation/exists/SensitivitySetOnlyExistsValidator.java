package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Sensitivity;
import fpml.confirmation.SensitivitySet;
import fpml.confirmation.SensitivitySetDefinitionReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SensitivitySetOnlyExistsValidator implements ValidatorWithArg<SensitivitySet, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SensitivitySet> ValidationResult<SensitivitySet> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("definitionReference", ExistenceChecker.isSet((SensitivitySetDefinitionReference) o.getDefinitionReference()))
				.put("sensitivity", ExistenceChecker.isSet((List<? extends Sensitivity>) o.getSensitivity()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SensitivitySet", ValidationType.ONLY_EXISTS, "SensitivitySet", path, "");
		}
		return failure("SensitivitySet", ValidationType.ONLY_EXISTS, "SensitivitySet", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

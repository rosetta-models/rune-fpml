package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UtilizationModel;
import fpml.confirmation.UtilizationModelSequence0;
import fpml.confirmation.UtilizationModelSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class UtilizationModelOnlyExistsValidator implements ValidatorWithArg<UtilizationModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends UtilizationModel> ValidationResult<UtilizationModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("utilizationModelSequence0", ExistenceChecker.isSet((UtilizationModelSequence0) o.getUtilizationModelSequence0()))
				.put("utilizationModelSequence1", ExistenceChecker.isSet((UtilizationModelSequence1) o.getUtilizationModelSequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("UtilizationModel", ValidationType.ONLY_EXISTS, "UtilizationModel", path, "");
		}
		return failure("UtilizationModel", ValidationType.ONLY_EXISTS, "UtilizationModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Lag;
import fpml.confirmation.LagOrReferenceModel;
import fpml.confirmation.LagReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LagOrReferenceModelOnlyExistsValidator implements ValidatorWithArg<LagOrReferenceModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LagOrReferenceModel> ValidationResult<LagOrReferenceModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("lag", ExistenceChecker.isSet((Lag) o.getLag()))
				.put("lagReference", ExistenceChecker.isSet((LagReference) o.getLagReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LagOrReferenceModel", ValidationType.ONLY_EXISTS, "LagOrReferenceModel", path, "");
		}
		return failure("LagOrReferenceModel", ValidationType.ONLY_EXISTS, "LagOrReferenceModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

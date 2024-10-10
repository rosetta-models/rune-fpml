package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationId;
import fpml.confirmation.CorrelationIdModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CorrelationIdModelOnlyExistsValidator implements ValidatorWithArg<CorrelationIdModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CorrelationIdModel> ValidationResult<CorrelationIdModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("correlationId", ExistenceChecker.isSet((CorrelationId) o.getCorrelationId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CorrelationIdModel", ValidationType.ONLY_EXISTS, "CorrelationIdModel", path, "");
		}
		return failure("CorrelationIdModel", ValidationType.ONLY_EXISTS, "CorrelationIdModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

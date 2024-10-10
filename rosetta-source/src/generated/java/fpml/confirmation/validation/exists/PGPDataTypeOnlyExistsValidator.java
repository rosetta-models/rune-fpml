package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PGPDataType;
import fpml.confirmation.PGPDataTypeSequence0;
import fpml.confirmation.PGPDataTypeSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PGPDataTypeOnlyExistsValidator implements ValidatorWithArg<PGPDataType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PGPDataType> ValidationResult<PGPDataType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pgpDataTypeSequence0", ExistenceChecker.isSet((PGPDataTypeSequence0) o.getPgpDataTypeSequence0()))
				.put("pgpDataTypeSequence1", ExistenceChecker.isSet((PGPDataTypeSequence1) o.getPgpDataTypeSequence1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PGPDataType", ValidationType.ONLY_EXISTS, "PGPDataType", path, "");
		}
		return failure("PGPDataType", ValidationType.ONLY_EXISTS, "PGPDataType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

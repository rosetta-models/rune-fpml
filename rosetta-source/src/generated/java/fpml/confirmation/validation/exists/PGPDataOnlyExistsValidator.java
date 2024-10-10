package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PGPData;
import fpml.confirmation.PGPDataTypeSequence0;
import fpml.confirmation.PGPDataTypeSequence1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PGPDataOnlyExistsValidator implements ValidatorWithArg<PGPData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PGPData> ValidationResult<PGPData> validate(RosettaPath path, T2 o, Set<String> fields) {
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
			return success("PGPData", ValidationType.ONLY_EXISTS, "PGPData", path, "");
		}
		return failure("PGPData", ValidationType.ONLY_EXISTS, "PGPData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationAmountsOldModel;
import fpml.confirmation.NovationAmountsOldModelSequence0;
import fpml.confirmation.NovationAmountsOldModelSequence1;
import fpml.confirmation.NovationAmountsOldModelSequence2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NovationAmountsOldModelOnlyExistsValidator implements ValidatorWithArg<NovationAmountsOldModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NovationAmountsOldModel> ValidationResult<NovationAmountsOldModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("novationAmountsOldModelSequence0", ExistenceChecker.isSet((NovationAmountsOldModelSequence0) o.getNovationAmountsOldModelSequence0()))
				.put("novationAmountsOldModelSequence1", ExistenceChecker.isSet((NovationAmountsOldModelSequence1) o.getNovationAmountsOldModelSequence1()))
				.put("novationAmountsOldModelSequence2", ExistenceChecker.isSet((NovationAmountsOldModelSequence2) o.getNovationAmountsOldModelSequence2()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NovationAmountsOldModel", ValidationType.ONLY_EXISTS, "NovationAmountsOldModel", path, "");
		}
		return failure("NovationAmountsOldModel", ValidationType.ONLY_EXISTS, "NovationAmountsOldModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationAmountsOldModelSequence1;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NovationAmountsOldModelSequence1OnlyExistsValidator implements ValidatorWithArg<NovationAmountsOldModelSequence1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NovationAmountsOldModelSequence1> ValidationResult<NovationAmountsOldModelSequence1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("novatedNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getNovatedNumberOfOptions()))
				.put("remainingNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getRemainingNumberOfOptions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NovationAmountsOldModelSequence1", ValidationType.ONLY_EXISTS, "NovationAmountsOldModelSequence1", path, "");
		}
		return failure("NovationAmountsOldModelSequence1", ValidationType.ONLY_EXISTS, "NovationAmountsOldModelSequence1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

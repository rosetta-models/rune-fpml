package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.EquityExpirationModel;
import fpml.confirmation.EquityExpirationModelSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityExpirationModelOnlyExistsValidator implements ValidatorWithArg<EquityExpirationModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityExpirationModel> ValidationResult<EquityExpirationModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("equityExpirationModelSequence", ExistenceChecker.isSet((EquityExpirationModelSequence) o.getEquityExpirationModelSequence()))
				.put("expirationTimeDetermination", ExistenceChecker.isSet((DeterminationMethod) o.getExpirationTimeDetermination()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityExpirationModel", ValidationType.ONLY_EXISTS, "EquityExpirationModel", path, "");
		}
		return failure("EquityExpirationModel", ValidationType.ONLY_EXISTS, "EquityExpirationModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

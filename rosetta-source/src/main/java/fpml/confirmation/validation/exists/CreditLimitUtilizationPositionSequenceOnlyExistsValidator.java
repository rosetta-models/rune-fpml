package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditLimitUtilizationPositionSequence;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditLimitUtilizationPositionSequenceOnlyExistsValidator implements ValidatorWithArg<CreditLimitUtilizationPositionSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditLimitUtilizationPositionSequence> ValidationResult<CreditLimitUtilizationPositionSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("short", ExistenceChecker.isSet((BigDecimal) o.getShort()))
				.put("long", ExistenceChecker.isSet((BigDecimal) o.getLong()))
				.put("global", ExistenceChecker.isSet((BigDecimal) o.getGlobal()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditLimitUtilizationPositionSequence", ValidationType.ONLY_EXISTS, "CreditLimitUtilizationPositionSequence", path, "");
		}
		return failure("CreditLimitUtilizationPositionSequence", ValidationType.ONLY_EXISTS, "CreditLimitUtilizationPositionSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

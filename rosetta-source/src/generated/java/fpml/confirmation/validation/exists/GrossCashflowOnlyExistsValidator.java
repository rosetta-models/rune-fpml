package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashflowType;
import fpml.confirmation.GrossCashflow;
import fpml.confirmation.GrossCashflowSequence;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GrossCashflowOnlyExistsValidator implements ValidatorWithArg<GrossCashflow, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GrossCashflow> ValidationResult<GrossCashflow> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("grossCashflowSequence", ExistenceChecker.isSet((GrossCashflowSequence) o.getGrossCashflowSequence()))
				.put("cashflowType", ExistenceChecker.isSet((CashflowType) o.getCashflowType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GrossCashflow", ValidationType.ONLY_EXISTS, "GrossCashflow", path, "");
		}
		return failure("GrossCashflow", ValidationType.ONLY_EXISTS, "GrossCashflow", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

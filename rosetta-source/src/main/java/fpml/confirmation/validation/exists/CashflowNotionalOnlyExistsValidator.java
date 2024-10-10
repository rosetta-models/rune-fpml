package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashflowNotional;
import fpml.confirmation.Currency;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CashflowNotionalOnlyExistsValidator implements ValidatorWithArg<CashflowNotional, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CashflowNotional> ValidationResult<CashflowNotional> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("units", ExistenceChecker.isSet((String) o.getUnits()))
				.put("amount", ExistenceChecker.isSet((BigDecimal) o.getAmount()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CashflowNotional", ValidationType.ONLY_EXISTS, "CashflowNotional", path, "");
		}
		return failure("CashflowNotional", ValidationType.ONLY_EXISTS, "CashflowNotional", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

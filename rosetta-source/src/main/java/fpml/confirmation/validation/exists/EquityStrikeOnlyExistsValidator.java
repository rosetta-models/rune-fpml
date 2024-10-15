package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Currency;
import fpml.confirmation.EquityStrike;
import fpml.confirmation.EquityStrikeSequence;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EquityStrikeOnlyExistsValidator implements ValidatorWithArg<EquityStrike, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EquityStrike> ValidationResult<EquityStrike> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("strikePrice", ExistenceChecker.isSet((BigDecimal) o.getStrikePrice()))
				.put("equityStrikeSequence", ExistenceChecker.isSet((EquityStrikeSequence) o.getEquityStrikeSequence()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityStrike", ValidationType.ONLY_EXISTS, "EquityStrike", path, "");
		}
		return failure("EquityStrike", ValidationType.ONLY_EXISTS, "EquityStrike", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

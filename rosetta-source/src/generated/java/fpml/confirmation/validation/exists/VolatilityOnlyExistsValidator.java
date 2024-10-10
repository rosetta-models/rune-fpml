package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.Volatility;
import fpml.confirmation.VolatilityCap;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VolatilityOnlyExistsValidator implements ValidatorWithArg<Volatility, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Volatility> ValidationResult<Volatility> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationFromObservationChoice", ExistenceChecker.isSet((CalculationFromObservationChoice) o.getCalculationFromObservationChoice()))
				.put("closingLevel", ExistenceChecker.isSet((Boolean) o.getClosingLevel()))
				.put("expiringLevel", ExistenceChecker.isSet((Boolean) o.getExpiringLevel()))
				.put("expectedN", ExistenceChecker.isSet((Integer) o.getExpectedN()))
				.put("volatilityCap", ExistenceChecker.isSet((VolatilityCap) o.getVolatilityCap()))
				.put("volatilityStrikePrice", ExistenceChecker.isSet((BigDecimal) o.getVolatilityStrikePrice()))
				.put("vegaNotionalAmount", ExistenceChecker.isSet((BigDecimal) o.getVegaNotionalAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Volatility", ValidationType.ONLY_EXISTS, "Volatility", path, "");
		}
		return failure("Volatility", ValidationType.ONLY_EXISTS, "Volatility", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

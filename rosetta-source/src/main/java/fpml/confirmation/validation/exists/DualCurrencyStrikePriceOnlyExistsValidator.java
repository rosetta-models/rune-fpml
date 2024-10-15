package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DualCurrencyStrikePrice;
import fpml.confirmation.DualCurrencyStrikeQuoteBasisEnum;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DualCurrencyStrikePriceOnlyExistsValidator implements ValidatorWithArg<DualCurrencyStrikePrice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DualCurrencyStrikePrice> ValidationResult<DualCurrencyStrikePrice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.put("strikeQuoteBasis", ExistenceChecker.isSet((DualCurrencyStrikeQuoteBasisEnum) o.getStrikeQuoteBasis()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DualCurrencyStrikePrice", ValidationType.ONLY_EXISTS, "DualCurrencyStrikePrice", path, "");
		}
		return failure("DualCurrencyStrikePrice", ValidationType.ONLY_EXISTS, "DualCurrencyStrikePrice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

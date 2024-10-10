package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Money;
import fpml.confirmation.PrincipalExchange;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PrincipalExchangeOnlyExistsValidator implements ValidatorWithArg<PrincipalExchange, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PrincipalExchange> ValidationResult<PrincipalExchange> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("unadjustedPrincipalExchangeDate", ExistenceChecker.isSet((Date) o.getUnadjustedPrincipalExchangeDate()))
				.put("adjustedPrincipalExchangeDate", ExistenceChecker.isSet((Date) o.getAdjustedPrincipalExchangeDate()))
				.put("principalExchangeAmount", ExistenceChecker.isSet((BigDecimal) o.getPrincipalExchangeAmount()))
				.put("discountFactor", ExistenceChecker.isSet((BigDecimal) o.getDiscountFactor()))
				.put("presentValuePrincipalExchangeAmount", ExistenceChecker.isSet((Money) o.getPresentValuePrincipalExchangeAmount()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PrincipalExchange", ValidationType.ONLY_EXISTS, "PrincipalExchange", path, "");
		}
		return failure("PrincipalExchange", ValidationType.ONLY_EXISTS, "PrincipalExchange", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

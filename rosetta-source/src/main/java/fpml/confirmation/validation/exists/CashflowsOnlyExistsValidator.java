package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Cashflows;
import fpml.confirmation.PaymentCalculationPeriod;
import fpml.confirmation.PrincipalExchange;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CashflowsOnlyExistsValidator implements ValidatorWithArg<Cashflows, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Cashflows> ValidationResult<Cashflows> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashflowsMatchParameters", ExistenceChecker.isSet((Boolean) o.getCashflowsMatchParameters()))
				.put("principalExchange", ExistenceChecker.isSet((List<? extends PrincipalExchange>) o.getPrincipalExchange()))
				.put("paymentCalculationPeriod", ExistenceChecker.isSet((List<? extends PaymentCalculationPeriod>) o.getPaymentCalculationPeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Cashflows", ValidationType.ONLY_EXISTS, "Cashflows", path, "");
		}
		return failure("Cashflows", ValidationType.ONLY_EXISTS, "Cashflows", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

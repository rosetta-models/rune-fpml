package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriodAmount;
import fpml.confirmation.CalculationPeriodDates;
import fpml.confirmation.Cashflows;
import fpml.confirmation.Formula;
import fpml.confirmation.InterestRateStream;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentDates;
import fpml.confirmation.PrincipalExchanges;
import fpml.confirmation.ResetDates;
import fpml.confirmation.SettlementProvision;
import fpml.confirmation.StubCalculationPeriodAmount;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestRateStreamOnlyExistsValidator implements ValidatorWithArg<InterestRateStream, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestRateStream> ValidationResult<InterestRateStream> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("calculationPeriodDates", ExistenceChecker.isSet((CalculationPeriodDates) o.getCalculationPeriodDates()))
				.put("paymentDates", ExistenceChecker.isSet((PaymentDates) o.getPaymentDates()))
				.put("resetDates", ExistenceChecker.isSet((ResetDates) o.getResetDates()))
				.put("calculationPeriodAmount", ExistenceChecker.isSet((CalculationPeriodAmount) o.getCalculationPeriodAmount()))
				.put("stubCalculationPeriodAmount", ExistenceChecker.isSet((StubCalculationPeriodAmount) o.getStubCalculationPeriodAmount()))
				.put("principalExchanges", ExistenceChecker.isSet((PrincipalExchanges) o.getPrincipalExchanges()))
				.put("cashflows", ExistenceChecker.isSet((Cashflows) o.getCashflows()))
				.put("settlementProvision", ExistenceChecker.isSet((SettlementProvision) o.getSettlementProvision()))
				.put("formula", ExistenceChecker.isSet((Formula) o.getFormula()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestRateStream", ValidationType.ONLY_EXISTS, "InterestRateStream", path, "");
		}
		return failure("InterestRateStream", ValidationType.ONLY_EXISTS, "InterestRateStream", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.LoanTradePayment;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.Money;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PaymentType;
import fpml.confirmation.SettlementInformation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradePaymentOnlyExistsValidator implements ValidatorWithArg<LoanTradePayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradePayment> ValidationResult<LoanTradePayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerReceiverModel", ExistenceChecker.isSet((PayerReceiverModel) o.getPayerReceiverModel()))
				.put("paymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPaymentAmount()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableOrAdjustedDate) o.getPaymentDate()))
				.put("paymentType", ExistenceChecker.isSet((PaymentType) o.getPaymentType()))
				.put("settlementInformation", ExistenceChecker.isSet((SettlementInformation) o.getSettlementInformation()))
				.put("discountFactor", ExistenceChecker.isSet((BigDecimal) o.getDiscountFactor()))
				.put("presentValueAmount", ExistenceChecker.isSet((Money) o.getPresentValueAmount()))
				.put("href", ExistenceChecker.isSet((String) o.getHref()))
				.put("loanTradeReference", ExistenceChecker.isSet((List<? extends LoanTradeReference>) o.getLoanTradeReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradePayment", ValidationType.ONLY_EXISTS, "LoanTradePayment", path, "");
		}
		return failure("LoanTradePayment", ValidationType.ONLY_EXISTS, "LoanTradePayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

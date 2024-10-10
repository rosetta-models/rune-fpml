package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeTradedContract;
import fpml.confirmation.ReturnLegValuation;
import fpml.confirmation.ReturnLegValuationPrice;
import fpml.confirmation.ReturnSwapPaymentDates;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnLegValuationOnlyExistsValidator implements ValidatorWithArg<ReturnLegValuation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnLegValuation> ValidationResult<ReturnLegValuation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initialPrice", ExistenceChecker.isSet((ReturnLegValuationPrice) o.getInitialPrice()))
				.put("notionalReset", ExistenceChecker.isSet((Boolean) o.getNotionalReset()))
				.put("valuationPriceInterim", ExistenceChecker.isSet((ReturnLegValuationPrice) o.getValuationPriceInterim()))
				.put("valuationPriceFinal", ExistenceChecker.isSet((ReturnLegValuationPrice) o.getValuationPriceFinal()))
				.put("paymentDates", ExistenceChecker.isSet((ReturnSwapPaymentDates) o.getPaymentDates()))
				.put("exchangeTradedContractNearest", ExistenceChecker.isSet((ExchangeTradedContract) o.getExchangeTradedContractNearest()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnLegValuation", ValidationType.ONLY_EXISTS, "ReturnLegValuation", path, "");
		}
		return failure("ReturnLegValuation", ValidationType.ONLY_EXISTS, "ReturnLegValuation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AmountReference;
import fpml.confirmation.Commission;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.PriceSequence;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.ReturnLegValuationPrice;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnLegValuationPriceOnlyExistsValidator implements ValidatorWithArg<ReturnLegValuationPrice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnLegValuationPrice> ValidationResult<ReturnLegValuationPrice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("commission", ExistenceChecker.isSet((Commission) o.getCommission()))
				.put("priceSequence", ExistenceChecker.isSet((PriceSequence) o.getPriceSequence()))
				.put("amountRelativeTo", ExistenceChecker.isSet((AmountReference) o.getAmountRelativeTo()))
				.put("equityPriceModel", ExistenceChecker.isSet((EquityPriceModel) o.getEquityPriceModel()))
				.put("cleanNetPrice", ExistenceChecker.isSet((BigDecimal) o.getCleanNetPrice()))
				.put("quotationCharacteristics", ExistenceChecker.isSet((QuotationCharacteristics) o.getQuotationCharacteristics()))
				.put("valuationRules", ExistenceChecker.isSet((EquityValuation) o.getValuationRules()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnLegValuationPrice", ValidationType.ONLY_EXISTS, "ReturnLegValuationPrice", path, "");
		}
		return failure("ReturnLegValuationPrice", ValidationType.ONLY_EXISTS, "ReturnLegValuationPrice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

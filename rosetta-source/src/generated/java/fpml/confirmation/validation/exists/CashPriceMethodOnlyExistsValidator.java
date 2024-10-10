package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashPriceMethod;
import fpml.confirmation.CashSettlementReferenceBanks;
import fpml.confirmation.Currency;
import fpml.confirmation.QuotationRateTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CashPriceMethodOnlyExistsValidator implements ValidatorWithArg<CashPriceMethod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CashPriceMethod> ValidationResult<CashPriceMethod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashSettlementReferenceBanks", ExistenceChecker.isSet((CashSettlementReferenceBanks) o.getCashSettlementReferenceBanks()))
				.put("cashSettlementCurrency", ExistenceChecker.isSet((Currency) o.getCashSettlementCurrency()))
				.put("quotationRateType", ExistenceChecker.isSet((QuotationRateTypeEnum) o.getQuotationRateType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CashPriceMethod", ValidationType.ONLY_EXISTS, "CashPriceMethod", path, "");
		}
		return failure("CashPriceMethod", ValidationType.ONLY_EXISTS, "CashPriceMethod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

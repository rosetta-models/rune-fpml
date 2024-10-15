package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CashSettlementTerms;
import fpml.confirmation.Currency;
import fpml.confirmation.FixedRecoveryModel;
import fpml.confirmation.Money;
import fpml.confirmation.QuotationRateTypeEnum;
import fpml.confirmation.ValuationDate;
import fpml.confirmation.ValuationMethodEnum;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CashSettlementTermsOnlyExistsValidator implements ValidatorWithArg<CashSettlementTerms, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CashSettlementTerms> ValidationResult<CashSettlementTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementCurrency", ExistenceChecker.isSet((Currency) o.getSettlementCurrency()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("valuationDate", ExistenceChecker.isSet((ValuationDate) o.getValuationDate()))
				.put("valuationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getValuationTime()))
				.put("quotationMethod", ExistenceChecker.isSet((QuotationRateTypeEnum) o.getQuotationMethod()))
				.put("quotationAmount", ExistenceChecker.isSet((Money) o.getQuotationAmount()))
				.put("minimumQuotationAmount", ExistenceChecker.isSet((Money) o.getMinimumQuotationAmount()))
				.put("dealer", ExistenceChecker.isSet((List<String>) o.getDealer()))
				.put("cashSettlementBusinessDays", ExistenceChecker.isSet((Integer) o.getCashSettlementBusinessDays()))
				.put("fixedRecoveryModel", ExistenceChecker.isSet((FixedRecoveryModel) o.getFixedRecoveryModel()))
				.put("fixedSettlement", ExistenceChecker.isSet((Boolean) o.getFixedSettlement()))
				.put("accruedInterest", ExistenceChecker.isSet((Boolean) o.getAccruedInterest()))
				.put("valuationMethod", ExistenceChecker.isSet((ValuationMethodEnum) o.getValuationMethod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CashSettlementTerms", ValidationType.ONLY_EXISTS, "CashSettlementTerms", path, "");
		}
		return failure("CashSettlementTerms", ValidationType.ONLY_EXISTS, "CashSettlementTerms", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

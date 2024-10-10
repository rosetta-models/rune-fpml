package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.DeclaredCashAndCashEquivalentDividendPercentageModel;
import fpml.confirmation.DividendAmountTypeEnum;
import fpml.confirmation.DividendCompositionEnum;
import fpml.confirmation.DividendConditions;
import fpml.confirmation.DividendConditionsSequence;
import fpml.confirmation.DividendEntitlementEnum;
import fpml.confirmation.DividendPaymentDate;
import fpml.confirmation.DividendPeriodEnum;
import fpml.confirmation.InterestAccrualsCompoundingMethod;
import fpml.confirmation.NonCashDividendTreatmentEnum;
import fpml.confirmation.PartyReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DividendConditionsOnlyExistsValidator implements ValidatorWithArg<DividendConditions, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DividendConditions> ValidationResult<DividendConditions> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dividendReinvestment", ExistenceChecker.isSet((Boolean) o.getDividendReinvestment()))
				.put("dividendEntitlement", ExistenceChecker.isSet((DividendEntitlementEnum) o.getDividendEntitlement()))
				.put("dividendAmount", ExistenceChecker.isSet((DividendAmountTypeEnum) o.getDividendAmount()))
				.put("dividendPaymentDate", ExistenceChecker.isSet((DividendPaymentDate) o.getDividendPaymentDate()))
				.put("dividendConditionsSequence", ExistenceChecker.isSet((DividendConditionsSequence) o.getDividendConditionsSequence()))
				.put("dividendPeriod", ExistenceChecker.isSet((DividendPeriodEnum) o.getDividendPeriod()))
				.put("extraOrdinaryDividends", ExistenceChecker.isSet((PartyReference) o.getExtraOrdinaryDividends()))
				.put("excessDividendAmount", ExistenceChecker.isSet((DividendAmountTypeEnum) o.getExcessDividendAmount()))
				.put("currencyAndDeterminationMethodModel", ExistenceChecker.isSet((CurrencyAndDeterminationMethodModel) o.getCurrencyAndDeterminationMethodModel()))
				.put("dividendFxTriggerDate", ExistenceChecker.isSet((DividendPaymentDate) o.getDividendFxTriggerDate()))
				.put("interestAccrualsMethod", ExistenceChecker.isSet((InterestAccrualsCompoundingMethod) o.getInterestAccrualsMethod()))
				.put("numberOfIndexUnits", ExistenceChecker.isSet((BigDecimal) o.getNumberOfIndexUnits()))
				.put("declaredCashAndCashEquivalentDividendPercentageModel", ExistenceChecker.isSet((DeclaredCashAndCashEquivalentDividendPercentageModel) o.getDeclaredCashAndCashEquivalentDividendPercentageModel()))
				.put("nonCashDividendTreatment", ExistenceChecker.isSet((NonCashDividendTreatmentEnum) o.getNonCashDividendTreatment()))
				.put("dividendComposition", ExistenceChecker.isSet((DividendCompositionEnum) o.getDividendComposition()))
				.put("specialDividends", ExistenceChecker.isSet((Boolean) o.getSpecialDividends()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendConditions", ValidationType.ONLY_EXISTS, "DividendConditions", path, "");
		}
		return failure("DividendConditions", ValidationType.ONLY_EXISTS, "DividendConditions", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CashPriceMethod;
import fpml.confirmation.CashSettlement;
import fpml.confirmation.CashSettlementPaymentDate;
import fpml.confirmation.CrossCurrencyMethod;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.YieldCurveMethod;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CashSettlementOnlyExistsValidator implements ValidatorWithArg<CashSettlement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CashSettlement> ValidationResult<CashSettlement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashSettlementValuationTime", ExistenceChecker.isSet((BusinessCenterTime) o.getCashSettlementValuationTime()))
				.put("cashSettlementValuationDate", ExistenceChecker.isSet((RelativeDateOffset) o.getCashSettlementValuationDate()))
				.put("cashSettlementPaymentDate", ExistenceChecker.isSet((CashSettlementPaymentDate) o.getCashSettlementPaymentDate()))
				.put("cashPriceMethod", ExistenceChecker.isSet((CashPriceMethod) o.getCashPriceMethod()))
				.put("cashPriceAlternateMethod", ExistenceChecker.isSet((CashPriceMethod) o.getCashPriceAlternateMethod()))
				.put("parYieldCurveAdjustedMethod", ExistenceChecker.isSet((YieldCurveMethod) o.getParYieldCurveAdjustedMethod()))
				.put("zeroCouponYieldAdjustedMethod", ExistenceChecker.isSet((YieldCurveMethod) o.getZeroCouponYieldAdjustedMethod()))
				.put("parYieldCurveUnadjustedMethod", ExistenceChecker.isSet((YieldCurveMethod) o.getParYieldCurveUnadjustedMethod()))
				.put("crossCurrencyMethod", ExistenceChecker.isSet((CrossCurrencyMethod) o.getCrossCurrencyMethod()))
				.put("collateralizedCashPriceMethod", ExistenceChecker.isSet((YieldCurveMethod) o.getCollateralizedCashPriceMethod()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CashSettlement", ValidationType.ONLY_EXISTS, "CashSettlement", path, "");
		}
		return failure("CashSettlement", ValidationType.ONLY_EXISTS, "CashSettlement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

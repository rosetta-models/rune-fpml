package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuySellEnum;
import fpml.confirmation.LoanTradingAccrualSettlementEnum;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel;
import fpml.confirmation.LoanTradingDocTypeEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingCounterpartyCashSettlementRulesModelOnlyExistsValidator implements ValidatorWithArg<LoanTradingCounterpartyCashSettlementRulesModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingCounterpartyCashSettlementRulesModel> ValidationResult<LoanTradingCounterpartyCashSettlementRulesModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("documentationType", ExistenceChecker.isSet((LoanTradingDocTypeEnum) o.getDocumentationType()))
				.put("accrualSettlementType", ExistenceChecker.isSet((LoanTradingAccrualSettlementEnum) o.getAccrualSettlementType()))
				.put("delayedCompensationFlag", ExistenceChecker.isSet((Boolean) o.getDelayedCompensationFlag()))
				.put("nonRecurringFeesBenefactor", ExistenceChecker.isSet((BuySellEnum) o.getNonRecurringFeesBenefactor()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.ONLY_EXISTS, "LoanTradingCounterpartyCashSettlementRulesModel", path, "");
		}
		return failure("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.ONLY_EXISTS, "LoanTradingCounterpartyCashSettlementRulesModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

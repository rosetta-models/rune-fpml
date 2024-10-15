package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingAccruingFeeAccrual;
import fpml.confirmation.LoanTradingLetterOfCreditAccrual;
import fpml.confirmation.LoanTradingNonRecurringFee;
import fpml.confirmation.LoanTradingOutstandingsAccrual;
import fpml.confirmation.LoanTradingSettlementAccrualsModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingSettlementAccrualsModelOnlyExistsValidator implements ValidatorWithArg<LoanTradingSettlementAccrualsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingSettlementAccrualsModel> ValidationResult<LoanTradingSettlementAccrualsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accruingFee", ExistenceChecker.isSet((List<? extends LoanTradingAccruingFeeAccrual>) o.getAccruingFee()))
				.put("nonRecurringFee", ExistenceChecker.isSet((List<? extends LoanTradingNonRecurringFee>) o.getNonRecurringFee()))
				.put("interest", ExistenceChecker.isSet((List<? extends LoanTradingOutstandingsAccrual>) o.getInterest()))
				.put("letterOfCreditFee", ExistenceChecker.isSet((List<? extends LoanTradingLetterOfCreditAccrual>) o.getLetterOfCreditFee()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingSettlementAccrualsModel", ValidationType.ONLY_EXISTS, "LoanTradingSettlementAccrualsModel", path, "");
		}
		return failure("LoanTradingSettlementAccrualsModel", ValidationType.ONLY_EXISTS, "LoanTradingSettlementAccrualsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

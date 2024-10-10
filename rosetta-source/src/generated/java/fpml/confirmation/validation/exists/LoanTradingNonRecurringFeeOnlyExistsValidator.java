package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingNonRecurringFee;
import fpml.confirmation.LoanTradingNonRecurringFeeTypeEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NonRecurringMiscFeeType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingNonRecurringFeeOnlyExistsValidator implements ValidatorWithArg<LoanTradingNonRecurringFee, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingNonRecurringFee> ValidationResult<LoanTradingNonRecurringFee> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amount", ExistenceChecker.isSet((NonNegativeMoney) o.getAmount()))
				.put("feeType", ExistenceChecker.isSet((LoanTradingNonRecurringFeeTypeEnum) o.getFeeType()))
				.put("miscFeeType", ExistenceChecker.isSet((NonRecurringMiscFeeType) o.getMiscFeeType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingNonRecurringFee", ValidationType.ONLY_EXISTS, "LoanTradingNonRecurringFee", path, "");
		}
		return failure("LoanTradingNonRecurringFee", ValidationType.ONLY_EXISTS, "LoanTradingNonRecurringFee", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

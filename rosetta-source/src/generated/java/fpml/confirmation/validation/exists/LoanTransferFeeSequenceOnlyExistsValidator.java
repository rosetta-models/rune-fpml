package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTransferFeePaidByEnum;
import fpml.confirmation.LoanTransferFeeSequence;
import fpml.confirmation.NonNegativeMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTransferFeeSequenceOnlyExistsValidator implements ValidatorWithArg<LoanTransferFeeSequence, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTransferFeeSequence> ValidationResult<LoanTransferFeeSequence> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("paidBy", ExistenceChecker.isSet((LoanTransferFeePaidByEnum) o.getPaidBy()))
				.put("totalAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getTotalAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTransferFeeSequence", ValidationType.ONLY_EXISTS, "LoanTransferFeeSequence", path, "");
		}
		return failure("LoanTransferFeeSequence", ValidationType.ONLY_EXISTS, "LoanTransferFeeSequence", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

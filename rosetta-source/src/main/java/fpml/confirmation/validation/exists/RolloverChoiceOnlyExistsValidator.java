package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Borrowing;
import fpml.confirmation.CommitmentAdjustment;
import fpml.confirmation.InterestCapitalization;
import fpml.confirmation.LoanContractBaseRateSet;
import fpml.confirmation.LoanInterestPayment;
import fpml.confirmation.Repayment;
import fpml.confirmation.RolloverChoice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RolloverChoiceOnlyExistsValidator implements ValidatorWithArg<RolloverChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RolloverChoice> ValidationResult<RolloverChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("baseRateSet", ExistenceChecker.isSet((LoanContractBaseRateSet) o.getBaseRateSet()))
				.put("borrowing", ExistenceChecker.isSet((Borrowing) o.getBorrowing()))
				.put("commitmentAdjustment", ExistenceChecker.isSet((CommitmentAdjustment) o.getCommitmentAdjustment()))
				.put("interestCapitalization", ExistenceChecker.isSet((InterestCapitalization) o.getInterestCapitalization()))
				.put("interestPayment", ExistenceChecker.isSet((LoanInterestPayment) o.getInterestPayment()))
				.put("repayment", ExistenceChecker.isSet((Repayment) o.getRepayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RolloverChoice", ValidationType.ONLY_EXISTS, "RolloverChoice", path, "");
		}
		return failure("RolloverChoice", ValidationType.ONLY_EXISTS, "RolloverChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

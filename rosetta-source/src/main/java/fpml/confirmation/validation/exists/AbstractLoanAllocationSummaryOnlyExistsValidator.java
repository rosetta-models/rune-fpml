package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanAllocationSummary;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.Money;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AbstractLoanAllocationSummaryOnlyExistsValidator implements ValidatorWithArg<AbstractLoanAllocationSummary, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AbstractLoanAllocationSummary> ValidationResult<AbstractLoanAllocationSummary> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("allocationIdentifier", ExistenceChecker.isSet((LoanAllocationIdentifier) o.getAllocationIdentifier()))
				.put("amount", ExistenceChecker.isSet((Money) o.getAmount()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AbstractLoanAllocationSummary", ValidationType.ONLY_EXISTS, "AbstractLoanAllocationSummary", path, "");
		}
		return failure("AbstractLoanAllocationSummary", ValidationType.ONLY_EXISTS, "AbstractLoanAllocationSummary", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

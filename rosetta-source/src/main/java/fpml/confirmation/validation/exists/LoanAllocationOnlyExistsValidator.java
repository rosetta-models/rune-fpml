package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.LoanAllocation;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanAllocationPartiesModel;
import fpml.confirmation.Money;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanAllocationOnlyExistsValidator implements ValidatorWithArg<LoanAllocation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanAllocation> ValidationResult<LoanAllocation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("allocationIdentifier", ExistenceChecker.isSet((LoanAllocationIdentifier) o.getAllocationIdentifier()))
				.put("amount", ExistenceChecker.isSet((Money) o.getAmount()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("loanAllocationPartiesModel", ExistenceChecker.isSet((LoanAllocationPartiesModel) o.getLoanAllocationPartiesModel()))
				.put("buyerSellerModel", ExistenceChecker.isSet((BuyerSellerModel) o.getBuyerSellerModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanAllocation", ValidationType.ONLY_EXISTS, "LoanAllocation", path, "");
		}
		return failure("LoanAllocation", ValidationType.ONLY_EXISTS, "LoanAllocation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

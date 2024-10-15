package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractLcEvent;
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AccruingFeePayment;
import fpml.confirmation.AccruingPikPayment;
import fpml.confirmation.LoanBulkServicingNotificationChoice0;
import fpml.confirmation.NonRecurringFeePayment;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanBulkServicingNotificationChoice0OnlyExistsValidator implements ValidatorWithArg<LoanBulkServicingNotificationChoice0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanBulkServicingNotificationChoice0> ValidationResult<LoanBulkServicingNotificationChoice0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("facilityFeePaymentGroup", ExistenceChecker.isSet((NonRecurringFeePayment) o.getFacilityFeePaymentGroup()))
				.put("facilityEventGroup", ExistenceChecker.isSet((AbstractFacilityEvent) o.getFacilityEventGroup()))
				.put("accruingFeePayment", ExistenceChecker.isSet((AccruingFeePayment) o.getAccruingFeePayment()))
				.put("accruingPikPayment", ExistenceChecker.isSet((AccruingPikPayment) o.getAccruingPikPayment()))
				.put("loanContractEventGroup", ExistenceChecker.isSet((AbstractLoanContractEvent) o.getLoanContractEventGroup()))
				.put("lcEventGroup", ExistenceChecker.isSet((AbstractLcEvent) o.getLcEventGroup()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanBulkServicingNotificationChoice0", ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationChoice0", path, "");
		}
		return failure("LoanBulkServicingNotificationChoice0", ValidationType.ONLY_EXISTS, "LoanBulkServicingNotificationChoice0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

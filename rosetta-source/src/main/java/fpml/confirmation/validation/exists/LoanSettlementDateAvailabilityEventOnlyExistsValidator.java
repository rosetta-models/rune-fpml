package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.DateList;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationNoSettlePeriod;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanSettlementDateAvailabilityEvent;
import fpml.confirmation.LoanSettlementDateAvailabilityEventSequence;
import fpml.confirmation.Money;
import fpml.confirmation.PeriodModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanSettlementDateAvailabilityEventOnlyExistsValidator implements ValidatorWithArg<LoanSettlementDateAvailabilityEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanSettlementDateAvailabilityEvent> ValidationResult<LoanSettlementDateAvailabilityEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("parentEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getParentEventIdentifier()))
				.put("correctedEventIdentifier", ExistenceChecker.isSet((BusinessEventIdentifier) o.getCorrectedEventIdentifier()))
				.put("lenderAndCashDetailsModel", ExistenceChecker.isSet((LenderAndCashDetailsModel) o.getLenderAndCashDetailsModel()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("allocationReference", ExistenceChecker.isSet((List<? extends LoanAllocationReference>) o.getAllocationReference()))
				.put("amount", ExistenceChecker.isSet((List<? extends Money>) o.getAmount()))
				.put("specificDates", ExistenceChecker.isSet((DateList) o.getSpecificDates()))
				.put("periodModel", ExistenceChecker.isSet((PeriodModel) o.getPeriodModel()))
				.put("onOrAfterDate", ExistenceChecker.isSet((Date) o.getOnOrAfterDate()))
				.put("loanSettlementDateAvailabilityEventSequence", ExistenceChecker.isSet((LoanSettlementDateAvailabilityEventSequence) o.getLoanSettlementDateAvailabilityEventSequence()))
				.put("noSettlePeriod", ExistenceChecker.isSet((List<? extends LoanAllocationNoSettlePeriod>) o.getNoSettlePeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanSettlementDateAvailabilityEvent", ValidationType.ONLY_EXISTS, "LoanSettlementDateAvailabilityEvent", path, "");
		}
		return failure("LoanSettlementDateAvailabilityEvent", ValidationType.ONLY_EXISTS, "LoanSettlementDateAvailabilityEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

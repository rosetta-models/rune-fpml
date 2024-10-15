package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanAllocationSettlementTask;
import fpml.confirmation.LoanAllocationSettlementTaskType;
import fpml.confirmation.LoanTradingSettlementTaskDates;
import fpml.confirmation.LoanTradingSettlementTaskStatusEnum;
import fpml.confirmation.PartyReference;
import fpml.confirmation.TaskIdentifier;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanAllocationSettlementTaskOnlyExistsValidator implements ValidatorWithArg<LoanAllocationSettlementTask, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanAllocationSettlementTask> ValidationResult<LoanAllocationSettlementTask> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("taskIdentifier", ExistenceChecker.isSet((TaskIdentifier) o.getTaskIdentifier()))
				.put("parentTaskIdentifier", ExistenceChecker.isSet((TaskIdentifier) o.getParentTaskIdentifier()))
				.put("correctedTaskIdentifier", ExistenceChecker.isSet((TaskIdentifier) o.getCorrectedTaskIdentifier()))
				.put("responsibleParty", ExistenceChecker.isSet((PartyReference) o.getResponsibleParty()))
				.put("dates", ExistenceChecker.isSet((LoanTradingSettlementTaskDates) o.getDates()))
				.put("status", ExistenceChecker.isSet((LoanTradingSettlementTaskStatusEnum) o.getStatus()))
				.put("comment", ExistenceChecker.isSet((String) o.getComment()))
				.put("allocationReference", ExistenceChecker.isSet((LoanAllocationReference) o.getAllocationReference()))
				.put("_type", ExistenceChecker.isSet((LoanAllocationSettlementTaskType) o.get_type()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanAllocationSettlementTask", ValidationType.ONLY_EXISTS, "LoanAllocationSettlementTask", path, "");
		}
		return failure("LoanAllocationSettlementTask", ValidationType.ONLY_EXISTS, "LoanAllocationSettlementTask", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

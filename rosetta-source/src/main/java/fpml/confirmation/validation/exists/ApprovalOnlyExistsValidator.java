package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Approval;
import fpml.confirmation.ApprovalId;
import fpml.confirmation.ApprovalType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApprovalOnlyExistsValidator implements ValidatorWithArg<Approval, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Approval> ValidationResult<Approval> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("_type", ExistenceChecker.isSet((ApprovalType) o.get_type()))
				.put("status", ExistenceChecker.isSet((String) o.getStatus()))
				.put("approver", ExistenceChecker.isSet((PersonId) o.getApprover()))
				.put("approvingPartyReference", ExistenceChecker.isSet((PartyReference) o.getApprovingPartyReference()))
				.put("approvedPartyReference", ExistenceChecker.isSet((PartyReference) o.getApprovedPartyReference()))
				.put("approvalId", ExistenceChecker.isSet((ApprovalId) o.getApprovalId()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Approval", ValidationType.ONLY_EXISTS, "Approval", path, "");
		}
		return failure("Approval", ValidationType.ONLY_EXISTS, "Approval", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

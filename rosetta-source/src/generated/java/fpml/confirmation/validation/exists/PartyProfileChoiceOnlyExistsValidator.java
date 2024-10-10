package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApplicableCommunicationDetails;
import fpml.confirmation.ApplicableSettlementInstructionDetails;
import fpml.confirmation.PartyProfileChoice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyProfileChoiceOnlyExistsValidator implements ValidatorWithArg<PartyProfileChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyProfileChoice> ValidationResult<PartyProfileChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("communicationDetails", ExistenceChecker.isSet((ApplicableCommunicationDetails) o.getCommunicationDetails()))
				.put("settlementInstructionDetails", ExistenceChecker.isSet((ApplicableSettlementInstructionDetails) o.getSettlementInstructionDetails()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyProfileChoice", ValidationType.ONLY_EXISTS, "PartyProfileChoice", path, "");
		}
		return failure("PartyProfileChoice", ValidationType.ONLY_EXISTS, "PartyProfileChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

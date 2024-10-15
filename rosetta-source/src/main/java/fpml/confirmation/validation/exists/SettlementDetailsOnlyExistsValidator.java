package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Currency;
import fpml.confirmation.SettlementDetails;
import fpml.confirmation.SettlementInstruction;
import fpml.confirmation.SettlementInstructionId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementDetailsOnlyExistsValidator implements ValidatorWithArg<SettlementDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementDetails> ValidationResult<SettlementDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((SettlementInstructionId) o.getId()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("settlementInstruction", ExistenceChecker.isSet((SettlementInstruction) o.getSettlementInstruction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementDetails", ValidationType.ONLY_EXISTS, "SettlementDetails", path, "");
		}
		return failure("SettlementDetails", ValidationType.ONLY_EXISTS, "SettlementDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

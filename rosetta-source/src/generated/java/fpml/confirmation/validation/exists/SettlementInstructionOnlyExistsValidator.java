package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Beneficiary;
import fpml.confirmation.CorrespondentInformation;
import fpml.confirmation.IntermediaryInformation;
import fpml.confirmation.PartyReference;
import fpml.confirmation.SettlementInstruction;
import fpml.confirmation.SettlementMethod;
import fpml.confirmation.SplitSettlement;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementInstructionOnlyExistsValidator implements ValidatorWithArg<SettlementInstruction, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementInstruction> ValidationResult<SettlementInstruction> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementMethod", ExistenceChecker.isSet((SettlementMethod) o.getSettlementMethod()))
				.put("correspondentInformation", ExistenceChecker.isSet((CorrespondentInformation) o.getCorrespondentInformation()))
				.put("intermediaryInformation", ExistenceChecker.isSet((List<? extends IntermediaryInformation>) o.getIntermediaryInformation()))
				.put("beneficiaryBank", ExistenceChecker.isSet((Beneficiary) o.getBeneficiaryBank()))
				.put("beneficiary", ExistenceChecker.isSet((Beneficiary) o.getBeneficiary()))
				.put("depositoryPartyReference", ExistenceChecker.isSet((PartyReference) o.getDepositoryPartyReference()))
				.put("splitSettlement", ExistenceChecker.isSet((List<? extends SplitSettlement>) o.getSplitSettlement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementInstruction", ValidationType.ONLY_EXISTS, "SettlementInstruction", path, "");
		}
		return failure("SettlementInstruction", ValidationType.ONLY_EXISTS, "SettlementInstruction", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

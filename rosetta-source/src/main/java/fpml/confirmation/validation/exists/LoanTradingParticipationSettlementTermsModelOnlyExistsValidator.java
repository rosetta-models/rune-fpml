package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingParticipationSettlementTermsModel;
import fpml.confirmation.LoanTradingVotingRightsEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanTradingParticipationSettlementTermsModelOnlyExistsValidator implements ValidatorWithArg<LoanTradingParticipationSettlementTermsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanTradingParticipationSettlementTermsModel> ValidationResult<LoanTradingParticipationSettlementTermsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collateralRequiredFlag", ExistenceChecker.isSet((Boolean) o.getCollateralRequiredFlag()))
				.put("votingRights", ExistenceChecker.isSet((LoanTradingVotingRightsEnum) o.getVotingRights()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanTradingParticipationSettlementTermsModel", ValidationType.ONLY_EXISTS, "LoanTradingParticipationSettlementTermsModel", path, "");
		}
		return failure("LoanTradingParticipationSettlementTermsModel", ValidationType.ONLY_EXISTS, "LoanTradingParticipationSettlementTermsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

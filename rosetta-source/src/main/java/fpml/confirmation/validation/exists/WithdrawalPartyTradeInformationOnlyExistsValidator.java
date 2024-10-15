package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.RelatedParty;
import fpml.confirmation.ReportingRegimeIdentifier;
import fpml.confirmation.WithdrawalPartyTradeInformation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WithdrawalPartyTradeInformationOnlyExistsValidator implements ValidatorWithArg<WithdrawalPartyTradeInformation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends WithdrawalPartyTradeInformation> ValidationResult<WithdrawalPartyTradeInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyAndAccountReferencesModel", ExistenceChecker.isSet((PartyAndAccountReferencesModel) o.getPartyAndAccountReferencesModel()))
				.put("relatedParty", ExistenceChecker.isSet((List<? extends RelatedParty>) o.getRelatedParty()))
				.put("reportingRegime", ExistenceChecker.isSet((List<? extends ReportingRegimeIdentifier>) o.getReportingRegime()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("WithdrawalPartyTradeInformation", ValidationType.ONLY_EXISTS, "WithdrawalPartyTradeInformation", path, "");
		}
		return failure("WithdrawalPartyTradeInformation", ValidationType.ONLY_EXISTS, "WithdrawalPartyTradeInformation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

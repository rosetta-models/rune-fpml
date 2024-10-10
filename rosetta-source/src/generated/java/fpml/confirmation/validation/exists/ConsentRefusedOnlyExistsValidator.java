package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApprovalType;
import fpml.confirmation.ConsentRefused;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.CreditLimitInformation;
import fpml.confirmation.EventsOrInfoModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import fpml.confirmation.PortfolioReferenceBaseModel;
import fpml.confirmation.Reason;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ConsentRefusedOnlyExistsValidator implements ValidatorWithArg<ConsentRefused, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ConsentRefused> ValidationResult<ConsentRefused> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((ResponseMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("correlationAndOptionalSequenceModel", ExistenceChecker.isSet((CorrelationAndOptionalSequenceModel) o.getCorrelationAndOptionalSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("type", ExistenceChecker.isSet((ApprovalType) o.getType()))
				.put("approver", ExistenceChecker.isSet((PersonId) o.getApprover()))
				.put("approvingPartyReference", ExistenceChecker.isSet((PartyReference) o.getApprovingPartyReference()))
				.put("portfolioReferenceBaseModel", ExistenceChecker.isSet((PortfolioReferenceBaseModel) o.getPortfolioReferenceBaseModel()))
				.put("eventsOrInfoModel", ExistenceChecker.isSet((EventsOrInfoModel) o.getEventsOrInfoModel()))
				.put("creditLimitInformation", ExistenceChecker.isSet((List<? extends CreditLimitInformation>) o.getCreditLimitInformation()))
				.put("partiesAndAccountsModel", ExistenceChecker.isSet((PartiesAndAccountsModel) o.getPartiesAndAccountsModel()))
				.put("reason", ExistenceChecker.isSet((List<? extends Reason>) o.getReason()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ConsentRefused", ValidationType.ONLY_EXISTS, "ConsentRefused", path, "");
		}
		return failure("ConsentRefused", ValidationType.ONLY_EXISTS, "ConsentRefused", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

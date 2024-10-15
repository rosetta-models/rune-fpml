package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Reason;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.VerificationStatus;
import fpml.confirmation.VerificationStatusNotification;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class VerificationStatusNotificationOnlyExistsValidator implements ValidatorWithArg<VerificationStatusNotification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends VerificationStatusNotification> ValidationResult<VerificationStatusNotification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("correlationAndSequenceModel", ExistenceChecker.isSet((CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("status", ExistenceChecker.isSet((VerificationStatus) o.getStatus()))
				.put("reason", ExistenceChecker.isSet((List<? extends Reason>) o.getReason()))
				.put("partyTradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getPartyTradeIdentifier()))
				.put("partiesAndAccountsModel", ExistenceChecker.isSet((PartiesAndAccountsModel) o.getPartiesAndAccountsModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("VerificationStatusNotification", ValidationType.ONLY_EXISTS, "VerificationStatusNotification", path, "");
		}
		return failure("VerificationStatusNotification", ValidationType.ONLY_EXISTS, "VerificationStatusNotification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

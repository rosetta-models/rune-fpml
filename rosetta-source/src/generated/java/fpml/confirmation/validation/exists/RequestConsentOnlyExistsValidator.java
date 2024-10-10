package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApprovalType;
import fpml.confirmation.CompressionModel;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.DeClear;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import fpml.confirmation.PortfolioReferenceModel;
import fpml.confirmation.RequestConsent;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.RequestedAction;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.ValidationModel;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RequestConsentOnlyExistsValidator implements ValidatorWithArg<RequestConsent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RequestConsent> ValidationResult<RequestConsent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("correlationAndSequenceModel", ExistenceChecker.isSet((CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("requestedAction", ExistenceChecker.isSet((RequestedAction) o.getRequestedAction()))
				.put("type", ExistenceChecker.isSet((ApprovalType) o.getType()))
				.put("approver", ExistenceChecker.isSet((PersonId) o.getApprover()))
				.put("approvingPartyReference", ExistenceChecker.isSet((PartyReference) o.getApprovingPartyReference()))
				.put("portfolioReferenceModel", ExistenceChecker.isSet((PortfolioReferenceModel) o.getPortfolioReferenceModel()))
				.put("compressionModel", ExistenceChecker.isSet((CompressionModel) o.getCompressionModel()))
				.put("tradingAndPostTradeEventsModel", ExistenceChecker.isSet((TradingAndPostTradeEventsModel) o.getTradingAndPostTradeEventsModel()))
				.put("deClear", ExistenceChecker.isSet((DeClear) o.getDeClear()))
				.put("eventValuationModel", ExistenceChecker.isSet((EventValuationModel) o.getEventValuationModel()))
				.put("partiesAndAccountsModel", ExistenceChecker.isSet((PartiesAndAccountsModel) o.getPartiesAndAccountsModel()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RequestConsent", ValidationType.ONLY_EXISTS, "RequestConsent", path, "");
		}
		return failure("RequestConsent", ValidationType.ONLY_EXISTS, "RequestConsent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

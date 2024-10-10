package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.FacilityLoanContractDetailsModel;
import fpml.confirmation.LoanAllocationPayment;
import fpml.confirmation.LoanAllocationSettlementEvent;
import fpml.confirmation.LoanAllocationSettlementNotification;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanAllocationSettlementNotificationOnlyExistsValidator implements ValidatorWithArg<LoanAllocationSettlementNotification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanAllocationSettlementNotification> ValidationResult<LoanAllocationSettlementNotification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validationModel", ExistenceChecker.isSet((ValidationModel) o.getValidationModel()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("correlationAndSequenceModel", ExistenceChecker.isSet((CorrelationAndSequenceModel) o.getCorrelationAndSequenceModel()))
				.put("onBehalfOfModel", ExistenceChecker.isSet((OnBehalfOfModel) o.getOnBehalfOfModel()))
				.put("noticeDate", ExistenceChecker.isSet((Date) o.getNoticeDate()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("role", ExistenceChecker.isSet((LoanTradingPartyRole) o.getRole()))
				.put("payment", ExistenceChecker.isSet((List<? extends LoanAllocationPayment>) o.getPayment()))
				.put("settlement", ExistenceChecker.isSet((List<? extends LoanAllocationSettlementEvent>) o.getSettlement()))
				.put("loanTradeAllocationDetailsModel", ExistenceChecker.isSet((List<? extends LoanTradeAllocationDetailsModel>) o.getLoanTradeAllocationDetailsModel()))
				.put("facilityLoanContractDetailsModel", ExistenceChecker.isSet((List<? extends FacilityLoanContractDetailsModel>) o.getFacilityLoanContractDetailsModel()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanAllocationSettlementNotification", ValidationType.ONLY_EXISTS, "LoanAllocationSettlementNotification", path, "");
		}
		return failure("LoanAllocationSettlementNotification", ValidationType.ONLY_EXISTS, "LoanAllocationSettlementNotification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.ApplicableAssets;
import fpml.confirmation.ApplicableCommunicationDetails;
import fpml.confirmation.ApplicableSettlementInstructionDetails;
import fpml.confirmation.ApplicableTransactionType;
import fpml.confirmation.AssociationToAssetIdentifier;
import fpml.confirmation.PartyProfileChoice;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class PartyProfileChoiceDeepPathUtil {
	public AssociationToAssetIdentifier chooseIdentifier(PartyProfileChoice partyProfileChoice) {
		final MapperS<ApplicableCommunicationDetails> communicationDetails = MapperS.of(partyProfileChoice).<ApplicableCommunicationDetails>map("getCommunicationDetails", _partyProfileChoice -> _partyProfileChoice.getCommunicationDetails());
		if (exists(communicationDetails).getOrDefault(false)) {
			return communicationDetails.<AssociationToAssetIdentifier>map("getIdentifier", applicableCommunicationDetails -> applicableCommunicationDetails.getIdentifier()).get();
		}
		final MapperS<ApplicableSettlementInstructionDetails> settlementInstructionDetails = MapperS.of(partyProfileChoice).<ApplicableSettlementInstructionDetails>map("getSettlementInstructionDetails", _partyProfileChoice -> _partyProfileChoice.getSettlementInstructionDetails());
		if (exists(settlementInstructionDetails).getOrDefault(false)) {
			return settlementInstructionDetails.<AssociationToAssetIdentifier>map("getIdentifier", applicableSettlementInstructionDetails -> applicableSettlementInstructionDetails.getIdentifier()).get();
		}
		return null;
	}
	
	public ApplicableAssets chooseApplicableAssets(PartyProfileChoice partyProfileChoice) {
		final MapperS<ApplicableCommunicationDetails> communicationDetails = MapperS.of(partyProfileChoice).<ApplicableCommunicationDetails>map("getCommunicationDetails", _partyProfileChoice -> _partyProfileChoice.getCommunicationDetails());
		if (exists(communicationDetails).getOrDefault(false)) {
			return communicationDetails.<ApplicableAssets>map("getApplicableAssets", applicableCommunicationDetails -> applicableCommunicationDetails.getApplicableAssets()).get();
		}
		final MapperS<ApplicableSettlementInstructionDetails> settlementInstructionDetails = MapperS.of(partyProfileChoice).<ApplicableSettlementInstructionDetails>map("getSettlementInstructionDetails", _partyProfileChoice -> _partyProfileChoice.getSettlementInstructionDetails());
		if (exists(settlementInstructionDetails).getOrDefault(false)) {
			return settlementInstructionDetails.<ApplicableAssets>map("getApplicableAssets", applicableSettlementInstructionDetails -> applicableSettlementInstructionDetails.getApplicableAssets()).get();
		}
		return null;
	}
	
	public List<ApplicableTransactionType> chooseApplicableTransactions(PartyProfileChoice partyProfileChoice) {
		final MapperS<ApplicableCommunicationDetails> communicationDetails = MapperS.of(partyProfileChoice).<ApplicableCommunicationDetails>map("getCommunicationDetails", _partyProfileChoice -> _partyProfileChoice.getCommunicationDetails());
		if (exists(communicationDetails).getOrDefault(false)) {
			return communicationDetails.<ApplicableTransactionType>mapC("getApplicableTransactions", applicableCommunicationDetails -> applicableCommunicationDetails.getApplicableTransactions()).getMulti();
		}
		final MapperS<ApplicableSettlementInstructionDetails> settlementInstructionDetails = MapperS.of(partyProfileChoice).<ApplicableSettlementInstructionDetails>map("getSettlementInstructionDetails", _partyProfileChoice -> _partyProfileChoice.getSettlementInstructionDetails());
		if (exists(settlementInstructionDetails).getOrDefault(false)) {
			return settlementInstructionDetails.<ApplicableTransactionType>mapC("getApplicableTransactions", applicableSettlementInstructionDetails -> applicableSettlementInstructionDetails.getApplicableTransactions()).getMulti();
		}
		return Collections.<ApplicableTransactionType>emptyList();
	}
	
}

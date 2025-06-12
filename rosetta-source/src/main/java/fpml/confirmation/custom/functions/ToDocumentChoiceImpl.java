package fpml.confirmation.custom.functions;

import fpml.confirmation.*;
import fpml.confirmation.custom.DocumentChoice;

public class ToDocumentChoiceImpl extends ToDocumentChoice {

    @Override
    protected DocumentChoice.DocumentChoiceBuilder doEvaluate(Document document) {
        DocumentChoice.DocumentChoiceBuilder builder = DocumentChoice.builder();
        if (document instanceof LoanNotificationAcknowledgement) {
            return builder.setLoanNotificationAcknowledgement(((LoanNotificationAcknowledgement) document));
        } else if (document instanceof LoanNotificationException) {
            return builder.setLoanNotificationException(((LoanNotificationException) document));
        } else if (document instanceof ExecutionAdviceException) {
            return builder.setExecutionAdviceException(((ExecutionAdviceException) document));
        } else if (document instanceof ClearingException) {
            return builder.setClearingException(((ClearingException) document));
        } else if (document instanceof VerificationStatusException) {
            return builder.setVerificationStatusException(((VerificationStatusException) document));
        } else if (document instanceof ConfirmationException) {
            return builder.setConfirmationException(((ConfirmationException) document));
        } else if (document instanceof CreditEventException) {
            return builder.setCreditEventException(((CreditEventException) document));
        } else if (document instanceof TradeReferenceInformationUpdateException) {
            return builder.setTradeReferenceInformationUpdateException(((TradeReferenceInformationUpdateException) document));
        } else if (document instanceof EventStatusException) {
            return builder.setEventStatusException(((EventStatusException) document));
        } else if (document instanceof ServiceNotificationException) {
            return builder.setServiceNotificationException(((ServiceNotificationException) document));
        } else if (document instanceof CollateralAllocationRejected) {
            return builder.setCollateralAllocationRejected(((CollateralAllocationRejected) document));
        } else if (document instanceof ClearingEligibilityException) {
            return builder.setClearingEligibilityException(((ClearingEligibilityException) document));
        } else if (document instanceof MessageRejected) {
            return builder.setMessageRejected(((MessageRejected) document));
        } else if (document instanceof ExecutionException) {
            return builder.setExecutionException(((ExecutionException) document));
        } else if (document instanceof AllocationException) {
            return builder.setAllocationException(((AllocationException) document));
        } else if (document instanceof MaturityException) {
            return builder.setMaturityException(((MaturityException) document));
        } else if (document instanceof TradeChangeAdviceException) {
            return builder.setTradeChangeAdviceException(((TradeChangeAdviceException) document));
        } else if (document instanceof ConsentException) {
            return builder.setConsentException(((ConsentException) document));
        } else if (document instanceof LoanAllocationNotification) {
            return builder.setLoanAllocationNotification(((LoanAllocationNotification) document));
        } else if (document instanceof RequestAllocation) {
            return builder.setRequestAllocation(((RequestAllocation) document));
        } else if (document instanceof ExecutionAdvice) {
            return builder.setExecutionAdvice(((ExecutionAdvice) document));
        } else if (document instanceof RequestClearingEligibility) {
            return builder.setRequestClearingEligibility(((RequestClearingEligibility) document));
        } else if (document instanceof RequestConfirmation) {
            return builder.setRequestConfirmation(((RequestConfirmation) document));
        } else if (document instanceof RequestCollateralAllocation) {
            return builder.setRequestCollateralAllocation(((RequestCollateralAllocation) document));
        } else if (document instanceof RequestConsent) {
            return builder.setRequestConsent(((RequestConsent) document));
        } else if (document instanceof LoanPartyProfileStatement) {
            return builder.setLoanPartyProfileStatement(((LoanPartyProfileStatement) document));
        } else if (document instanceof RequestTradeReferenceInformationUpdate) {
            return builder.setRequestTradeReferenceInformationUpdate(((RequestTradeReferenceInformationUpdate) document));
        } else if (document instanceof CreditEventNotification) {
            return builder.setCreditEventNotification(((CreditEventNotification) document));
        } else if (document instanceof RequestExecution) {
            return builder.setRequestExecution(((RequestExecution) document));
        } else if (document instanceof OptionExpirationNotification) {
            return builder.setOptionExpirationNotification(((OptionExpirationNotification) document));
        } else if (document instanceof ExecutionNotification) {
            return builder.setExecutionNotification(((ExecutionNotification) document));
        } else if (document instanceof TradeChangeAdvice) {
            return builder.setTradeChangeAdvice(((TradeChangeAdvice) document));
        } else if (document instanceof MaturityNotification) {
            return builder.setMaturityNotification(((MaturityNotification) document));
        } else if (document instanceof LoanContractNotification) {
            return builder.setLoanContractNotification(((LoanContractNotification) document));
        } else if (document instanceof LcNotification) {
            return builder.setLcNotification(((LcNotification) document));
        } else if (document instanceof LoanBulkServicingNotification) {
            return builder.setLoanBulkServicingNotification(((LoanBulkServicingNotification) document));
        } else if (document instanceof LoanLegalActionNotification) {
            return builder.setLoanLegalActionNotification(((LoanLegalActionNotification) document));
        } else if (document instanceof FacilityNotification) {
            return builder.setFacilityNotification(((FacilityNotification) document));
        } else if (document instanceof LoanCovenantObligationNotification) {
            return builder.setLoanCovenantObligationNotification(((LoanCovenantObligationNotification) document));
        } else if (document instanceof LoanTradeNotification) {
            return builder.setLoanTradeNotification(((LoanTradeNotification) document));
        } else if (document instanceof DealStatement) {
            return builder.setDealStatement(((DealStatement) document));
        } else if (document instanceof FacilityStatement) {
            return builder.setFacilityStatement(((FacilityStatement) document));
        } else if (document instanceof OutstandingContractsStatement) {
            return builder.setOutstandingContractsStatement(((OutstandingContractsStatement) document));
        } else if (document instanceof FacilityPositionStatement) {
            return builder.setFacilityPositionStatement(((FacilityPositionStatement) document));
        } else if (document instanceof LoanLegalActionStatement) {
            return builder.setLoanLegalActionStatement(((LoanLegalActionStatement) document));
        } else if (document instanceof RequestClearing) {
            return builder.setRequestClearing(((RequestClearing) document));
        } else if (document instanceof RequestRetransmission) {
            return builder.setRequestRetransmission(((RequestRetransmission) document));
        } else if (document instanceof RequestConfirmationRetracted) {
            return builder.setRequestConfirmationRetracted(((RequestConfirmationRetracted) document));
        } else if (document instanceof RequestConsentRetracted) {
            return builder.setRequestConsentRetracted(((RequestConsentRetracted) document));
        } else if (document instanceof RequestEventStatus) {
            return builder.setRequestEventStatus(((RequestEventStatus) document));
        } else if (document instanceof TradeChangeAdviceRetracted) {
            return builder.setTradeChangeAdviceRetracted(((TradeChangeAdviceRetracted) document));
        } else if (document instanceof CreditEventNotificationRetracted) {
            return builder.setCreditEventNotificationRetracted(((CreditEventNotificationRetracted) document));
        } else if (document instanceof RequestClearingRetracted) {
            return builder.setRequestClearingRetracted(((RequestClearingRetracted) document));
        } else if (document instanceof RequestExecutionRetracted) {
            return builder.setRequestExecutionRetracted(((RequestExecutionRetracted) document));
        } else if (document instanceof VerificationStatusNotification) {
            return builder.setVerificationStatusNotification(((VerificationStatusNotification) document));
        } else if (document instanceof ExecutionRetracted) {
            return builder.setExecutionRetracted(((ExecutionRetracted) document));
        } else if (document instanceof LoanNotificationRetracted) {
            return builder.setLoanNotificationRetracted(((LoanNotificationRetracted) document));
        } else if (document instanceof RequestAllocationRetracted) {
            return builder.setRequestAllocationRetracted(((RequestAllocationRetracted) document));
        } else if (document instanceof RequestTradeReferenceInformationUpdateRetracted) {
            return builder.setRequestTradeReferenceInformationUpdateRetracted(((RequestTradeReferenceInformationUpdateRetracted) document));
        } else if (document instanceof ExecutionAdviceRetracted) {
            return builder.setExecutionAdviceRetracted(((ExecutionAdviceRetracted) document));
        } else if (document instanceof CollateralAllocationAcknowledgement) {
            return builder.setCollateralAllocationAcknowledgement(((CollateralAllocationAcknowledgement) document));
        } else if (document instanceof CreditEventAcknowledgement) {
            return builder.setCreditEventAcknowledgement(((CreditEventAcknowledgement) document));
        } else if (document instanceof VerificationStatusAcknowledgement) {
            return builder.setVerificationStatusAcknowledgement(((VerificationStatusAcknowledgement) document));
        } else if (document instanceof ClearingEligibilityAcknowledgement) {
            return builder.setClearingEligibilityAcknowledgement(((ClearingEligibilityAcknowledgement) document));
        } else if (document instanceof AllocationRefused) {
            return builder.setAllocationRefused(((AllocationRefused) document));
        } else if (document instanceof ConfirmationDisputed) {
            return builder.setConfirmationDisputed(((ConfirmationDisputed) document));
        } else if (document instanceof ConsentRefused) {
            return builder.setConsentRefused(((ConsentRefused) document));
        } else if (document instanceof ConfirmationStatus) {
            return builder.setConfirmationStatus(((ConfirmationStatus) document));
        } else if (document instanceof AllocationApproved) {
            return builder.setAllocationApproved(((AllocationApproved) document));
        } else if (document instanceof ClearingEligibility) {
            return builder.setClearingEligibility(((ClearingEligibility) document));
        } else if (document instanceof MaturityAcknowledgement) {
            return builder.setMaturityAcknowledgement(((MaturityAcknowledgement) document));
        } else if (document instanceof ExecutionAdviceAcknowledgement) {
            return builder.setExecutionAdviceAcknowledgement(((ExecutionAdviceAcknowledgement) document));
        } else if (document instanceof ConfirmationAcknowledgement) {
            return builder.setConfirmationAcknowledgement(((ConfirmationAcknowledgement) document));
        } else if (document instanceof ClearingAcknowledgement) {
            return builder.setClearingAcknowledgement(((ClearingAcknowledgement) document));
        } else if (document instanceof ConsentAcknowledgement) {
            return builder.setConsentAcknowledgement(((ConsentAcknowledgement) document));
        } else if (document instanceof TradeReferenceInformationUpdateAcknowledgement) {
            return builder.setTradeReferenceInformationUpdateAcknowledgement(((TradeReferenceInformationUpdateAcknowledgement) document));
        } else if (document instanceof AllocationAcknowledgement) {
            return builder.setAllocationAcknowledgement(((AllocationAcknowledgement) document));
        } else if (document instanceof TradeChangeAdviceAcknowledgement) {
            return builder.setTradeChangeAdviceAcknowledgement(((TradeChangeAdviceAcknowledgement) document));
        } else if (document instanceof ExecutionAcknowledgement) {
            return builder.setExecutionAcknowledgement(((ExecutionAcknowledgement) document));
        } else if (document instanceof ConfirmationAgreed) {
            return builder.setConfirmationAgreed(((ConfirmationAgreed) document));
        } else if (document instanceof CollateralAllocationAccepted) {
            return builder.setCollateralAllocationAccepted(((CollateralAllocationAccepted) document));
        } else if (document instanceof EventStatusResponse) {
            return builder.setEventStatusResponse(((EventStatusResponse) document));
        } else if (document instanceof ConsentGranted) {
            return builder.setConsentGranted(((ConsentGranted) document));
        } else if (document instanceof ClearingConfirmed) {
            return builder.setClearingConfirmed(((ClearingConfirmed) document));
        } else if (document instanceof ClearingStatus) {
            return builder.setClearingStatus(((ClearingStatus) document));
        } else if (document instanceof ServiceNotification) {
            return builder.setServiceNotification(((ServiceNotification) document));
        } else if (document instanceof ClearingRefused) {
            return builder.setClearingRefused(((ClearingRefused) document));
        } else if (document instanceof ApprovalStatusNotification) {
            return builder.setApprovalStatusNotification(((ApprovalStatusNotification) document));
        } else if (document instanceof ValuationDocument) {
            return builder.setValuationDocument(((ValuationDocument) document));
        } else if (document instanceof DataDocument) {
            return builder.setDataDocument(((DataDocument) document));
        }
        return builder;
    }
}

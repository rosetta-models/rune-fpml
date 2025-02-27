package fpml.confirmation.custom.functions;

import fpml.confirmation.*;
import fpml.confirmation.custom.DocumentChoice;

public class ToDocumentChoiceImpl extends ToDocumentChoice {

    @Override
    protected DocumentChoice.DocumentChoiceBuilder doEvaluate(Document document) {
        DocumentChoice.DocumentChoiceBuilder builder = DocumentChoice.builder();
        if (document instanceof DataDocument) {
            return builder.setDataDocument(((DataDocument) document));
        } else if (document instanceof ClearingConfirmed) {
            return builder.setClearingConfirmed(((ClearingConfirmed) document));
        } else if (document instanceof ExecutionAdvice) {
            return builder.setExecutionAdvice(((ExecutionAdvice) document));
        } else if (document instanceof ExecutionAdviceRetracted) {
            return builder.setExecutionAdviceRetracted(((ExecutionAdviceRetracted) document));
        } else if (document instanceof ExecutionNotification) {
            return builder.setExecutionNotification(((ExecutionNotification) document));
        } else if (document instanceof RequestClearing) {
            return builder.setRequestClearing(((RequestClearing) document));
        } else if (document instanceof TradeChangeAdvice) {
            return builder.setTradeChangeAdvice(((TradeChangeAdvice) document));
        }
        return builder;
    }
}

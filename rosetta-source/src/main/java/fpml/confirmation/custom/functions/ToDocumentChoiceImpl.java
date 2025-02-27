package fpml.confirmation.custom.functions;

import fpml.confirmation.DataDocument;
import fpml.confirmation.Document;
import fpml.confirmation.ExecutionAdvice;
import fpml.confirmation.custom.DocumentChoice;

public class ToDocumentChoiceImpl extends ToDocumentChoice {

    @Override
    protected DocumentChoice.DocumentChoiceBuilder doEvaluate(Document document) {
        DocumentChoice.DocumentChoiceBuilder builder = DocumentChoice.builder();
        if (document instanceof DataDocument) {
            return builder.setDataDocument(((DataDocument) document));
        } else if (document instanceof ExecutionAdvice) {
            return builder.setExecutionAdvice(((ExecutionAdvice) document));
        }
        return builder;
    }
}

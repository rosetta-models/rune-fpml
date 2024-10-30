package fpml.mapping.functions;

import cdm.event.common.TransferExpression;
import cdm.event.common.TransferExpression.TransferExpressionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTransferExpression.MapTransferExpressionDefault.class)
public abstract class MapTransferExpression implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapScheduledTransfer mapScheduledTransfer;

	/**
	* @param fpmlDataDocument 
	* @return transferExpression 
	*/
	public TransferExpression evaluate(DataDocument fpmlDataDocument) {
		TransferExpression.TransferExpressionBuilder transferExpressionBuilder = doEvaluate(fpmlDataDocument);
		
		final TransferExpression transferExpression;
		if (transferExpressionBuilder == null) {
			transferExpression = null;
		} else {
			transferExpression = transferExpressionBuilder.build();
			objectValidator.validate(TransferExpression.class, transferExpression);
		}
		
		return transferExpression;
	}

	protected abstract TransferExpression.TransferExpressionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTransferExpressionDefault extends MapTransferExpression {
		@Override
		protected TransferExpression.TransferExpressionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TransferExpression.TransferExpressionBuilder transferExpression = TransferExpression.builder();
			return assignOutput(transferExpression, fpmlDataDocument);
		}
		
		protected TransferExpression.TransferExpressionBuilder assignOutput(TransferExpression.TransferExpressionBuilder transferExpression, DataDocument fpmlDataDocument) {
			transferExpression = toBuilder(TransferExpression.builder()
				.setPriceTransfer(null)
				.setScheduledTransfer(mapScheduledTransfer.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(transferExpression)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

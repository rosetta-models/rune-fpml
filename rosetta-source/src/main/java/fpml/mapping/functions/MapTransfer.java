package fpml.mapping.functions;

import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTransfer.MapTransferDefault.class)
public abstract class MapTransfer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapAsset mapAsset;
	@Inject protected MapIdentifierWithSchemeList mapIdentifierWithSchemeList;
	@Inject protected MapNonNegativeQuantity mapNonNegativeQuantity;
	@Inject protected MapPartyReferencePayerReceiver mapPartyReferencePayerReceiver;
	@Inject protected MapReset mapReset;
	@Inject protected MapSettlementOrigin mapSettlementOrigin;
	@Inject protected MapTransferExpression mapTransferExpression;

	/**
	* @param fpmlDataDocument 
	* @return transfer 
	*/
	public Transfer evaluate(DataDocument fpmlDataDocument) {
		Transfer.TransferBuilder transferBuilder = doEvaluate(fpmlDataDocument);
		
		final Transfer transfer;
		if (transferBuilder == null) {
			transfer = null;
		} else {
			transfer = transferBuilder.build();
			objectValidator.validate(Transfer.class, transfer);
		}
		
		return transfer;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTransferDefault extends MapTransfer {
		@Override
		protected Transfer.TransferBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Transfer.TransferBuilder transfer = Transfer.builder();
			return assignOutput(transfer, fpmlDataDocument);
		}
		
		protected Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder transfer, DataDocument fpmlDataDocument) {
			transfer = toBuilder(Transfer.builder()
				.setIdentifierValue(new ArrayList(mapIdentifierWithSchemeList.evaluate(fpmlDataDocument)))
				.setQuantity(mapNonNegativeQuantity.evaluate(fpmlDataDocument))
				.setAsset(mapAsset.evaluate(fpmlDataDocument))
				.setPayerReceiver(mapPartyReferencePayerReceiver.evaluate(fpmlDataDocument))
				.setSettlementDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(fpmlDataDocument))
				.setSettlementOrigin(mapSettlementOrigin.evaluate(fpmlDataDocument))
				.setResetOrigin(mapReset.evaluate(fpmlDataDocument))
				.setTransferExpression(mapTransferExpression.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(transfer)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

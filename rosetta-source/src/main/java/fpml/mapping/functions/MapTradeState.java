package fpml.mapping.functions;

import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTradeState.MapTradeStateDefault.class)
public abstract class MapTradeState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapObservationEventList mapObservationEventList;
	@Inject protected MapResetList mapResetList;
	@Inject protected MapState mapState;
	@Inject protected MapTrade mapTrade;
	@Inject protected MapTransferStateList mapTransferStateList;
	@Inject protected MapValuationList mapValuationList;

	/**
	* @param fpmlDataDocument 
	* @return tradeState 
	*/
	public TradeState evaluate(DataDocument fpmlDataDocument) {
		TradeState.TradeStateBuilder tradeStateBuilder = doEvaluate(fpmlDataDocument);
		
		final TradeState tradeState;
		if (tradeStateBuilder == null) {
			tradeState = null;
		} else {
			tradeState = tradeStateBuilder.build();
			objectValidator.validate(TradeState.class, tradeState);
		}
		
		return tradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTradeStateDefault extends MapTradeState {
		@Override
		protected TradeState.TradeStateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TradeState.TradeStateBuilder tradeState = TradeState.builder();
			return assignOutput(tradeState, fpmlDataDocument);
		}
		
		protected TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder tradeState, DataDocument fpmlDataDocument) {
			tradeState = toBuilder(TradeState.builder()
				.setTrade(mapTrade.evaluate(fpmlDataDocument))
				.setState(mapState.evaluate(fpmlDataDocument))
				.setResetHistory(new ArrayList(mapResetList.evaluate(fpmlDataDocument)))
				.setTransferHistory(new ArrayList(mapTransferStateList.evaluate(fpmlDataDocument)))
				.setObservationHistory(new ArrayList(mapObservationEventList.evaluate(fpmlDataDocument)))
				.setValuationHistory(new ArrayList(mapValuationList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(tradeState)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

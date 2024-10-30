package fpml.mapping.functions;

import cdm.event.common.Trade;
import cdm.event.common.Trade.TradeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTrade.MapTradeDefault.class)
public abstract class MapTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAccountList mapAccountList;
	@Inject protected MapAncillaryPartyList mapAncillaryPartyList;
	@Inject protected MapCollateral mapCollateral;
	@Inject protected MapContractDetails mapContractDetails;
	@Inject protected MapCounterpartyList mapCounterpartyList;
	@Inject protected MapExecutionDetails mapExecutionDetails;
	@Inject protected MapNonTransferableProduct mapNonTransferableProduct;
	@Inject protected MapPartyList mapPartyList;
	@Inject protected MapPartyRoleList mapPartyRoleList;
	@Inject protected MapTimeZone mapTimeZone;
	@Inject protected MapTradeIdentifierList mapTradeIdentifierList;
	@Inject protected MapTradeLotList mapTradeLotList;

	/**
	* @param fpmlDataDocument 
	* @return trade 
	*/
	public Trade evaluate(DataDocument fpmlDataDocument) {
		Trade.TradeBuilder tradeBuilder = doEvaluate(fpmlDataDocument);
		
		final Trade trade;
		if (tradeBuilder == null) {
			trade = null;
		} else {
			trade = tradeBuilder.build();
			objectValidator.validate(Trade.class, trade);
		}
		
		return trade;
	}

	protected abstract Trade.TradeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTradeDefault extends MapTrade {
		@Override
		protected Trade.TradeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Trade.TradeBuilder trade = Trade.builder();
			return assignOutput(trade, fpmlDataDocument);
		}
		
		protected Trade.TradeBuilder assignOutput(Trade.TradeBuilder trade, DataDocument fpmlDataDocument) {
			trade = toBuilder(Trade.builder()
				.setProduct(mapNonTransferableProduct.evaluate(fpmlDataDocument))
				.setTradeLot(new ArrayList(mapTradeLotList.evaluate(fpmlDataDocument)))
				.setCounterparty(new ArrayList(mapCounterpartyList.evaluate(fpmlDataDocument)))
				.setAncillaryParty(new ArrayList(mapAncillaryPartyList.evaluate(fpmlDataDocument)))
				.setAdjustment(null)
				.setTradeIdentifier(new ArrayList(mapTradeIdentifierList.evaluate(fpmlDataDocument)))
				.setTradeDateValue(null)
				.setTradeTimeValue(mapTimeZone.evaluate(fpmlDataDocument))
				.setParty(new ArrayList(mapPartyList.evaluate(fpmlDataDocument)))
				.setPartyRole(new ArrayList(mapPartyRoleList.evaluate(fpmlDataDocument)))
				.setExecutionDetails(mapExecutionDetails.evaluate(fpmlDataDocument))
				.setContractDetails(mapContractDetails.evaluate(fpmlDataDocument))
				.setClearedDate(null)
				.setCollateral(mapCollateral.evaluate(fpmlDataDocument))
				.setAccount(new ArrayList(mapAccountList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(trade)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

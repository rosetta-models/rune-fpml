package fpml.mapping.functions;

import cdm.product.template.Payout;
import cdm.product.template.Payout.PayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPayout.MapPayoutDefault.class)
public abstract class MapPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetPayoutList mapAssetPayoutList;
	@Inject protected MapCashflowList mapCashflowList;
	@Inject protected MapCommodityPayoutList mapCommodityPayoutList;
	@Inject protected MapCreditDefaultPayout mapCreditDefaultPayout;
	@Inject protected MapFixedPricePayoutList mapFixedPricePayoutList;
	@Inject protected MapInterestRatePayoutList mapInterestRatePayoutList;
	@Inject protected MapOptionPayoutList mapOptionPayoutList;
	@Inject protected MapPerformancePayoutList mapPerformancePayoutList;
	@Inject protected MapSettlementPayoutList mapSettlementPayoutList;

	/**
	* @param fpmlDataDocument 
	* @return payout 
	*/
	public Payout evaluate(DataDocument fpmlDataDocument) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlDataDocument);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPayoutDefault extends MapPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlDataDocument);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, DataDocument fpmlDataDocument) {
			payout = toBuilder(Payout.builder()
				.setInterestRatePayout(new ArrayList(mapInterestRatePayoutList.evaluate(fpmlDataDocument)))
				.setCreditDefaultPayout(mapCreditDefaultPayout.evaluate(fpmlDataDocument))
				.setOptionPayout(new ArrayList(mapOptionPayoutList.evaluate(fpmlDataDocument)))
				.setCommodityPayout(new ArrayList(mapCommodityPayoutList.evaluate(fpmlDataDocument)))
				.setSettlementPayout(new ArrayList(mapSettlementPayoutList.evaluate(fpmlDataDocument)))
				.setFixedPricePayout(new ArrayList(mapFixedPricePayoutList.evaluate(fpmlDataDocument)))
				.setCashflow(new ArrayList(mapCashflowList.evaluate(fpmlDataDocument)))
				.setPerformancePayout(new ArrayList(mapPerformancePayoutList.evaluate(fpmlDataDocument)))
				.setAssetPayout(new ArrayList(mapAssetPayoutList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

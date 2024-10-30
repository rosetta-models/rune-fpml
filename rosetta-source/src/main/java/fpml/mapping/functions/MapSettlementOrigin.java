package fpml.mapping.functions;

import cdm.event.common.SettlementOrigin;
import cdm.event.common.SettlementOrigin.SettlementOriginBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSettlementOrigin.MapSettlementOriginDefault.class)
public abstract class MapSettlementOrigin implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetPayout mapAssetPayout;
	@Inject protected MapCommodityPayout mapCommodityPayout;
	@Inject protected MapCreditDefaultPayout mapCreditDefaultPayout;
	@Inject protected MapFixedPricePayout mapFixedPricePayout;
	@Inject protected MapInterestRatePayout mapInterestRatePayout;
	@Inject protected MapOptionPayout mapOptionPayout;
	@Inject protected MapPerformancePayout mapPerformancePayout;
	@Inject protected MapSettlementPayout mapSettlementPayout;
	@Inject protected MapSettlementTerms mapSettlementTerms;

	/**
	* @param fpmlDataDocument 
	* @return settlementOrigin 
	*/
	public SettlementOrigin evaluate(DataDocument fpmlDataDocument) {
		SettlementOrigin.SettlementOriginBuilder settlementOriginBuilder = doEvaluate(fpmlDataDocument);
		
		final SettlementOrigin settlementOrigin;
		if (settlementOriginBuilder == null) {
			settlementOrigin = null;
		} else {
			settlementOrigin = settlementOriginBuilder.build();
			objectValidator.validate(SettlementOrigin.class, settlementOrigin);
		}
		
		return settlementOrigin;
	}

	protected abstract SettlementOrigin.SettlementOriginBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettlementOriginDefault extends MapSettlementOrigin {
		@Override
		protected SettlementOrigin.SettlementOriginBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SettlementOrigin.SettlementOriginBuilder settlementOrigin = SettlementOrigin.builder();
			return assignOutput(settlementOrigin, fpmlDataDocument);
		}
		
		protected SettlementOrigin.SettlementOriginBuilder assignOutput(SettlementOrigin.SettlementOriginBuilder settlementOrigin, DataDocument fpmlDataDocument) {
			settlementOrigin = toBuilder(SettlementOrigin.builder()
				.setCommodityPayoutValue(mapCommodityPayout.evaluate(fpmlDataDocument))
				.setCreditDefaultPayoutValue(mapCreditDefaultPayout.evaluate(fpmlDataDocument))
				.setSettlementPayoutValue(mapSettlementPayout.evaluate(fpmlDataDocument))
				.setInterestRatePayoutValue(mapInterestRatePayout.evaluate(fpmlDataDocument))
				.setOptionPayoutValue(mapOptionPayout.evaluate(fpmlDataDocument))
				.setAssetPayoutValue(mapAssetPayout.evaluate(fpmlDataDocument))
				.setSettlementTermsValue(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setPerformancePayoutValue(mapPerformancePayout.evaluate(fpmlDataDocument))
				.setFixedPricePayoutValue(mapFixedPricePayout.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(settlementOrigin)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

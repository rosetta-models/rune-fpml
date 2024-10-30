package fpml.mapping.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CommodityPayout.CommodityPayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityPayout.MapCommodityPayoutDefault.class)
public abstract class MapCommodityPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetDeliveryInformation mapAssetDeliveryInformation;
	@Inject protected MapAveragingCalculation mapAveragingCalculation;
	@Inject protected MapCalculationPeriodDates mapCalculationPeriodDates;
	@Inject protected MapCalculationSchedule mapCalculationSchedule;
	@Inject protected MapCommodity mapCommodity;
	@Inject protected MapCommodityPriceReturnTerms mapCommodityPriceReturnTerms;
	@Inject protected MapFxFeature mapFxFeature;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPaymentDates mapPaymentDates;
	@Inject protected MapPricingDates mapPricingDates;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;

	/**
	* @param fpmlDataDocument 
	* @return commodityPayout 
	*/
	public CommodityPayout evaluate(DataDocument fpmlDataDocument) {
		CommodityPayout.CommodityPayoutBuilder commodityPayoutBuilder = doEvaluate(fpmlDataDocument);
		
		final CommodityPayout commodityPayout;
		if (commodityPayoutBuilder == null) {
			commodityPayout = null;
		} else {
			commodityPayout = commodityPayoutBuilder.build();
			objectValidator.validate(CommodityPayout.class, commodityPayout);
		}
		
		return commodityPayout;
	}

	protected abstract CommodityPayout.CommodityPayoutBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCommodityPayoutDefault extends MapCommodityPayout {
		@Override
		protected CommodityPayout.CommodityPayoutBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CommodityPayout.CommodityPayoutBuilder commodityPayout = CommodityPayout.builder();
			return assignOutput(commodityPayout, fpmlDataDocument);
		}
		
		protected CommodityPayout.CommodityPayoutBuilder assignOutput(CommodityPayout.CommodityPayoutBuilder commodityPayout, DataDocument fpmlDataDocument) {
			commodityPayout = toBuilder(CommodityPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setAveragingFeature(mapAveragingCalculation.evaluate(fpmlDataDocument))
				.setCommodityPriceReturnTerms(mapCommodityPriceReturnTerms.evaluate(fpmlDataDocument))
				.setPricingDates(mapPricingDates.evaluate(fpmlDataDocument))
				.setSchedule(mapCalculationSchedule.evaluate(fpmlDataDocument))
				.setCalculationPeriodDates(mapCalculationPeriodDates.evaluate(fpmlDataDocument))
				.setPaymentDates(mapPaymentDates.evaluate(fpmlDataDocument))
				.setUnderlierValue(mapCommodity.evaluate(fpmlDataDocument))
				.setFxFeature(mapFxFeature.evaluate(fpmlDataDocument))
				.setDelivery(mapAssetDeliveryInformation.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(commodityPayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

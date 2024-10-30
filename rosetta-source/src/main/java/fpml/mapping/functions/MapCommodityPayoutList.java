package fpml.mapping.functions;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CommodityPayout.CommodityPayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommodityPayoutList.MapCommodityPayoutListDefault.class)
public abstract class MapCommodityPayoutList implements RosettaFunction {
	
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
	* @return commodityPayoutList 
	*/
	public List<? extends CommodityPayout> evaluate(DataDocument fpmlDataDocument) {
		List<CommodityPayout.CommodityPayoutBuilder> commodityPayoutListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CommodityPayout> commodityPayoutList;
		if (commodityPayoutListBuilder == null) {
			commodityPayoutList = null;
		} else {
			commodityPayoutList = commodityPayoutListBuilder.stream().map(CommodityPayout::build).collect(Collectors.toList());
			objectValidator.validate(CommodityPayout.class, commodityPayoutList);
		}
		
		return commodityPayoutList;
	}

	protected abstract List<CommodityPayout.CommodityPayoutBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCommodityPayoutListDefault extends MapCommodityPayoutList {
		@Override
		protected List<CommodityPayout.CommodityPayoutBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CommodityPayout.CommodityPayoutBuilder> commodityPayoutList = new ArrayList<>();
			return assignOutput(commodityPayoutList, fpmlDataDocument);
		}
		
		protected List<CommodityPayout.CommodityPayoutBuilder> assignOutput(List<CommodityPayout.CommodityPayoutBuilder> commodityPayoutList, DataDocument fpmlDataDocument) {
			commodityPayoutList.addAll(toBuilder(MapperC.<CommodityPayout>of(MapperS.of(CommodityPayout.builder()
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
				.build())).getMulti()));
			
			return Optional.ofNullable(commodityPayoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

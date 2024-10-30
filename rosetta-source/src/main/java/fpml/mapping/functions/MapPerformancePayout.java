package fpml.mapping.functions;

import cdm.product.template.PerformancePayout;
import cdm.product.template.PerformancePayout.PerformancePayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPerformancePayout.MapPerformancePayoutDefault.class)
public abstract class MapPerformancePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxFeatureList mapFxFeatureList;
	@Inject protected MapObservationTerms mapObservationTerms;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPaymentDates mapPaymentDates;
	@Inject protected MapPortfolioReturnTermsList mapPortfolioReturnTermsList;
	@Inject protected MapPriceScheduleList mapPriceScheduleList;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapReturnTerms mapReturnTerms;
	@Inject protected MapSettlementTerms mapSettlementTerms;
	@Inject protected MapUnderlier mapUnderlier;
	@Inject protected MapValuationDates mapValuationDates;

	/**
	* @param fpmlDataDocument 
	* @return performancePayout 
	*/
	public PerformancePayout evaluate(DataDocument fpmlDataDocument) {
		PerformancePayout.PerformancePayoutBuilder performancePayoutBuilder = doEvaluate(fpmlDataDocument);
		
		final PerformancePayout performancePayout;
		if (performancePayoutBuilder == null) {
			performancePayout = null;
		} else {
			performancePayout = performancePayoutBuilder.build();
			objectValidator.validate(PerformancePayout.class, performancePayout);
		}
		
		return performancePayout;
	}

	protected abstract PerformancePayout.PerformancePayoutBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPerformancePayoutDefault extends MapPerformancePayout {
		@Override
		protected PerformancePayout.PerformancePayoutBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PerformancePayout.PerformancePayoutBuilder performancePayout = PerformancePayout.builder();
			return assignOutput(performancePayout, fpmlDataDocument);
		}
		
		protected PerformancePayout.PerformancePayoutBuilder assignOutput(PerformancePayout.PerformancePayoutBuilder performancePayout, DataDocument fpmlDataDocument) {
			performancePayout = toBuilder(PerformancePayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setObservationTerms(mapObservationTerms.evaluate(fpmlDataDocument))
				.setValuationDates(mapValuationDates.evaluate(fpmlDataDocument))
				.setPaymentDates(mapPaymentDates.evaluate(fpmlDataDocument))
				.setUnderlier(mapUnderlier.evaluate(fpmlDataDocument))
				.setFxFeature(new ArrayList(mapFxFeatureList.evaluate(fpmlDataDocument)))
				.setReturnTerms(mapReturnTerms.evaluate(fpmlDataDocument))
				.setPortfolioReturnTerms(new ArrayList(mapPortfolioReturnTermsList.evaluate(fpmlDataDocument)))
				.setInitialValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setInterimValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setFinalValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(performancePayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

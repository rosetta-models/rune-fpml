package fpml.mapping.functions;

import cdm.product.template.PerformancePayout;
import cdm.product.template.PerformancePayout.PerformancePayoutBuilder;
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


@ImplementedBy(MapPerformancePayoutList.MapPerformancePayoutListDefault.class)
public abstract class MapPerformancePayoutList implements RosettaFunction {
	
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
	* @return performancePayoutList 
	*/
	public List<? extends PerformancePayout> evaluate(DataDocument fpmlDataDocument) {
		List<PerformancePayout.PerformancePayoutBuilder> performancePayoutListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PerformancePayout> performancePayoutList;
		if (performancePayoutListBuilder == null) {
			performancePayoutList = null;
		} else {
			performancePayoutList = performancePayoutListBuilder.stream().map(PerformancePayout::build).collect(Collectors.toList());
			objectValidator.validate(PerformancePayout.class, performancePayoutList);
		}
		
		return performancePayoutList;
	}

	protected abstract List<PerformancePayout.PerformancePayoutBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPerformancePayoutListDefault extends MapPerformancePayoutList {
		@Override
		protected List<PerformancePayout.PerformancePayoutBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PerformancePayout.PerformancePayoutBuilder> performancePayoutList = new ArrayList<>();
			return assignOutput(performancePayoutList, fpmlDataDocument);
		}
		
		protected List<PerformancePayout.PerformancePayoutBuilder> assignOutput(List<PerformancePayout.PerformancePayoutBuilder> performancePayoutList, DataDocument fpmlDataDocument) {
			performancePayoutList.addAll(toBuilder(MapperC.<PerformancePayout>of(MapperS.of(PerformancePayout.builder()
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
				.build())).getMulti()));
			
			return Optional.ofNullable(performancePayoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

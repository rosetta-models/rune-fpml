package fpml.mapping.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.InterestRatePayout.InterestRatePayoutBuilder;
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


@ImplementedBy(MapInterestRatePayoutList.MapInterestRatePayoutListDefault.class)
public abstract class MapInterestRatePayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapBondReference mapBondReference;
	@Inject protected MapCalculationPeriodDates mapCalculationPeriodDates;
	@Inject protected MapCashflowRepresentation mapCashflowRepresentation;
	@Inject protected MapDayCountFractionWithScheme mapDayCountFractionWithScheme;
	@Inject protected MapDiscountingMethod mapDiscountingMethod;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPaymentDates mapPaymentDates;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapRateSpecification mapRateSpecification;
	@Inject protected MapResetDates mapResetDates;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;
	@Inject protected MapStubPeriod mapStubPeriod;

	/**
	* @param fpmlDataDocument 
	* @return interestRatePayoutList 
	*/
	public List<? extends InterestRatePayout> evaluate(DataDocument fpmlDataDocument) {
		List<InterestRatePayout.InterestRatePayoutBuilder> interestRatePayoutListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends InterestRatePayout> interestRatePayoutList;
		if (interestRatePayoutListBuilder == null) {
			interestRatePayoutList = null;
		} else {
			interestRatePayoutList = interestRatePayoutListBuilder.stream().map(InterestRatePayout::build).collect(Collectors.toList());
			objectValidator.validate(InterestRatePayout.class, interestRatePayoutList);
		}
		
		return interestRatePayoutList;
	}

	protected abstract List<InterestRatePayout.InterestRatePayoutBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInterestRatePayoutListDefault extends MapInterestRatePayoutList {
		@Override
		protected List<InterestRatePayout.InterestRatePayoutBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<InterestRatePayout.InterestRatePayoutBuilder> interestRatePayoutList = new ArrayList<>();
			return assignOutput(interestRatePayoutList, fpmlDataDocument);
		}
		
		protected List<InterestRatePayout.InterestRatePayoutBuilder> assignOutput(List<InterestRatePayout.InterestRatePayoutBuilder> interestRatePayoutList, DataDocument fpmlDataDocument) {
			interestRatePayoutList.addAll(toBuilder(MapperC.<InterestRatePayout>of(MapperS.of(InterestRatePayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setRateSpecification(mapRateSpecification.evaluate(fpmlDataDocument))
				.setDayCountFractionValue(mapDayCountFractionWithScheme.evaluate(fpmlDataDocument))
				.setCalculationPeriodDates(mapCalculationPeriodDates.evaluate(fpmlDataDocument))
				.setPaymentDates(mapPaymentDates.evaluate(fpmlDataDocument))
				.setPaymentDate(mapAdjustableDate.evaluate(fpmlDataDocument))
				.setPaymentDelay(null)
				.setResetDates(mapResetDates.evaluate(fpmlDataDocument))
				.setDiscountingMethod(mapDiscountingMethod.evaluate(fpmlDataDocument))
				.setCompoundingMethod(null)
				.setCashflowRepresentation(mapCashflowRepresentation.evaluate(fpmlDataDocument))
				.setStubPeriod(mapStubPeriod.evaluate(fpmlDataDocument))
				.setBondReference(mapBondReference.evaluate(fpmlDataDocument))
				.setFixedAmount(null)
				.setFloatingAmount(null)
				.setSpreadCalculationMethod(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(interestRatePayoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

package fpml.mapping.functions;

import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.InterestRatePayout.InterestRatePayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInterestRatePayout.MapInterestRatePayoutDefault.class)
public abstract class MapInterestRatePayout implements RosettaFunction {
	
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
	* @return interestRatePayout 
	*/
	public InterestRatePayout evaluate(DataDocument fpmlDataDocument) {
		InterestRatePayout.InterestRatePayoutBuilder interestRatePayoutBuilder = doEvaluate(fpmlDataDocument);
		
		final InterestRatePayout interestRatePayout;
		if (interestRatePayoutBuilder == null) {
			interestRatePayout = null;
		} else {
			interestRatePayout = interestRatePayoutBuilder.build();
			objectValidator.validate(InterestRatePayout.class, interestRatePayout);
		}
		
		return interestRatePayout;
	}

	protected abstract InterestRatePayout.InterestRatePayoutBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInterestRatePayoutDefault extends MapInterestRatePayout {
		@Override
		protected InterestRatePayout.InterestRatePayoutBuilder doEvaluate(DataDocument fpmlDataDocument) {
			InterestRatePayout.InterestRatePayoutBuilder interestRatePayout = InterestRatePayout.builder();
			return assignOutput(interestRatePayout, fpmlDataDocument);
		}
		
		protected InterestRatePayout.InterestRatePayoutBuilder assignOutput(InterestRatePayout.InterestRatePayoutBuilder interestRatePayout, DataDocument fpmlDataDocument) {
			interestRatePayout = toBuilder(InterestRatePayout.builder()
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
				.build());
			
			return Optional.ofNullable(interestRatePayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

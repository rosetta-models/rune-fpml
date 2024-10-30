package fpml.mapping.functions;

import cdm.product.template.FixedPricePayout;
import cdm.product.template.FixedPricePayout.FixedPricePayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFixedPricePayout.MapFixedPricePayoutDefault.class)
public abstract class MapFixedPricePayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationSchedule mapCalculationSchedule;
	@Inject protected MapFixedPrice mapFixedPrice;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPaymentDates mapPaymentDates;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;

	/**
	* @param fpmlDataDocument 
	* @return fixedPricePayout 
	*/
	public FixedPricePayout evaluate(DataDocument fpmlDataDocument) {
		FixedPricePayout.FixedPricePayoutBuilder fixedPricePayoutBuilder = doEvaluate(fpmlDataDocument);
		
		final FixedPricePayout fixedPricePayout;
		if (fixedPricePayoutBuilder == null) {
			fixedPricePayout = null;
		} else {
			fixedPricePayout = fixedPricePayoutBuilder.build();
			objectValidator.validate(FixedPricePayout.class, fixedPricePayout);
		}
		
		return fixedPricePayout;
	}

	protected abstract FixedPricePayout.FixedPricePayoutBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFixedPricePayoutDefault extends MapFixedPricePayout {
		@Override
		protected FixedPricePayout.FixedPricePayoutBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FixedPricePayout.FixedPricePayoutBuilder fixedPricePayout = FixedPricePayout.builder();
			return assignOutput(fixedPricePayout, fpmlDataDocument);
		}
		
		protected FixedPricePayout.FixedPricePayoutBuilder assignOutput(FixedPricePayout.FixedPricePayoutBuilder fixedPricePayout, DataDocument fpmlDataDocument) {
			fixedPricePayout = toBuilder(FixedPricePayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setPaymentDates(mapPaymentDates.evaluate(fpmlDataDocument))
				.setFixedPrice(mapFixedPrice.evaluate(fpmlDataDocument))
				.setSchedule(mapCalculationSchedule.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(fixedPricePayout)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

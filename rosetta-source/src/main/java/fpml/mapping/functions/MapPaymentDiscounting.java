package fpml.mapping.functions;

import cdm.product.common.settlement.PaymentDiscounting;
import cdm.product.common.settlement.PaymentDiscounting.PaymentDiscountingBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPaymentDiscounting.MapPaymentDiscountingDefault.class)
public abstract class MapPaymentDiscounting implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return paymentDiscounting 
	*/
	public PaymentDiscounting evaluate(DataDocument fpmlDataDocument) {
		PaymentDiscounting.PaymentDiscountingBuilder paymentDiscountingBuilder = doEvaluate(fpmlDataDocument);
		
		final PaymentDiscounting paymentDiscounting;
		if (paymentDiscountingBuilder == null) {
			paymentDiscounting = null;
		} else {
			paymentDiscounting = paymentDiscountingBuilder.build();
			objectValidator.validate(PaymentDiscounting.class, paymentDiscounting);
		}
		
		return paymentDiscounting;
	}

	protected abstract PaymentDiscounting.PaymentDiscountingBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPaymentDiscountingDefault extends MapPaymentDiscounting {
		@Override
		protected PaymentDiscounting.PaymentDiscountingBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PaymentDiscounting.PaymentDiscountingBuilder paymentDiscounting = PaymentDiscounting.builder();
			return assignOutput(paymentDiscounting, fpmlDataDocument);
		}
		
		protected PaymentDiscounting.PaymentDiscountingBuilder assignOutput(PaymentDiscounting.PaymentDiscountingBuilder paymentDiscounting, DataDocument fpmlDataDocument) {
			paymentDiscounting = toBuilder(PaymentDiscounting.builder()
				.setDiscountFactor(null)
				.setPresentValueAmount(mapMoney.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(paymentDiscounting)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

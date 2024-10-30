package fpml.mapping.functions;

import cdm.product.common.schedule.PaymentDateSchedule;
import cdm.product.common.schedule.PaymentDateSchedule.PaymentDateScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPaymentDateSchedule.MapPaymentDateScheduleDefault.class)
public abstract class MapPaymentDateSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapAdjustableRelativeOrPeriodicDatesList mapAdjustableRelativeOrPeriodicDatesList;

	/**
	* @param fpmlDataDocument 
	* @return paymentDateSchedule 
	*/
	public PaymentDateSchedule evaluate(DataDocument fpmlDataDocument) {
		PaymentDateSchedule.PaymentDateScheduleBuilder paymentDateScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final PaymentDateSchedule paymentDateSchedule;
		if (paymentDateScheduleBuilder == null) {
			paymentDateSchedule = null;
		} else {
			paymentDateSchedule = paymentDateScheduleBuilder.build();
			objectValidator.validate(PaymentDateSchedule.class, paymentDateSchedule);
		}
		
		return paymentDateSchedule;
	}

	protected abstract PaymentDateSchedule.PaymentDateScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPaymentDateScheduleDefault extends MapPaymentDateSchedule {
		@Override
		protected PaymentDateSchedule.PaymentDateScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PaymentDateSchedule.PaymentDateScheduleBuilder paymentDateSchedule = PaymentDateSchedule.builder();
			return assignOutput(paymentDateSchedule, fpmlDataDocument);
		}
		
		protected PaymentDateSchedule.PaymentDateScheduleBuilder assignOutput(PaymentDateSchedule.PaymentDateScheduleBuilder paymentDateSchedule, DataDocument fpmlDataDocument) {
			paymentDateSchedule = toBuilder(PaymentDateSchedule.builder()
				.setInterimPaymentDates(new ArrayList(mapAdjustableRelativeOrPeriodicDatesList.evaluate(fpmlDataDocument)))
				.setFinalPaymentDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(paymentDateSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

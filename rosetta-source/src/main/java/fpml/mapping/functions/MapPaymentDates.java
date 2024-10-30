package fpml.mapping.functions;

import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.schedule.PaymentDates.PaymentDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPaymentDates.MapPaymentDatesDefault.class)
public abstract class MapPaymentDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapFrequency mapFrequency;
	@Inject protected MapOffset mapOffset;
	@Inject protected MapPaymentDateSchedule mapPaymentDateSchedule;

	/**
	* @param fpmlDataDocument 
	* @return paymentDates 
	*/
	public PaymentDates evaluate(DataDocument fpmlDataDocument) {
		PaymentDates.PaymentDatesBuilder paymentDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final PaymentDates paymentDates;
		if (paymentDatesBuilder == null) {
			paymentDates = null;
		} else {
			paymentDates = paymentDatesBuilder.build();
			objectValidator.validate(PaymentDates.class, paymentDates);
		}
		
		return paymentDates;
	}

	protected abstract PaymentDates.PaymentDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPaymentDatesDefault extends MapPaymentDates {
		@Override
		protected PaymentDates.PaymentDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PaymentDates.PaymentDatesBuilder paymentDates = PaymentDates.builder();
			return assignOutput(paymentDates, fpmlDataDocument);
		}
		
		protected PaymentDates.PaymentDatesBuilder assignOutput(PaymentDates.PaymentDatesBuilder paymentDates, DataDocument fpmlDataDocument) {
			paymentDates = toBuilder(PaymentDates.builder()
				.setPaymentFrequency(mapFrequency.evaluate(fpmlDataDocument))
				.setFirstPaymentDate(null)
				.setLastRegularPaymentDate(null)
				.setPaymentDateSchedule(mapPaymentDateSchedule.evaluate(fpmlDataDocument))
				.setPayRelativeTo(null)
				.setPaymentDaysOffset(mapOffset.evaluate(fpmlDataDocument))
				.setPaymentDatesAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(paymentDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

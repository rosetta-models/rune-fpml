package fpml.mapping.functions;

import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.schedule.PaymentDates.PaymentDatesBuilder;
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


@ImplementedBy(MapPaymentDatesList.MapPaymentDatesListDefault.class)
public abstract class MapPaymentDatesList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapFrequency mapFrequency;
	@Inject protected MapOffset mapOffset;
	@Inject protected MapPaymentDateSchedule mapPaymentDateSchedule;

	/**
	* @param fpmlDataDocument 
	* @return paymentDatesList 
	*/
	public List<? extends PaymentDates> evaluate(DataDocument fpmlDataDocument) {
		List<PaymentDates.PaymentDatesBuilder> paymentDatesListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PaymentDates> paymentDatesList;
		if (paymentDatesListBuilder == null) {
			paymentDatesList = null;
		} else {
			paymentDatesList = paymentDatesListBuilder.stream().map(PaymentDates::build).collect(Collectors.toList());
			objectValidator.validate(PaymentDates.class, paymentDatesList);
		}
		
		return paymentDatesList;
	}

	protected abstract List<PaymentDates.PaymentDatesBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPaymentDatesListDefault extends MapPaymentDatesList {
		@Override
		protected List<PaymentDates.PaymentDatesBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PaymentDates.PaymentDatesBuilder> paymentDatesList = new ArrayList<>();
			return assignOutput(paymentDatesList, fpmlDataDocument);
		}
		
		protected List<PaymentDates.PaymentDatesBuilder> assignOutput(List<PaymentDates.PaymentDatesBuilder> paymentDatesList, DataDocument fpmlDataDocument) {
			paymentDatesList.addAll(toBuilder(MapperC.<PaymentDates>of(MapperS.of(PaymentDates.builder()
				.setPaymentFrequency(mapFrequency.evaluate(fpmlDataDocument))
				.setFirstPaymentDate(null)
				.setLastRegularPaymentDate(null)
				.setPaymentDateSchedule(mapPaymentDateSchedule.evaluate(fpmlDataDocument))
				.setPayRelativeTo(null)
				.setPaymentDaysOffset(mapOffset.evaluate(fpmlDataDocument))
				.setPaymentDatesAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(paymentDatesList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

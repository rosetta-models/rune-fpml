package fpml.mapping.functions;

import cdm.product.common.schedule.DateRelativeToPaymentDates;
import cdm.product.common.schedule.DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateRelativeToPaymentDates.MapDateRelativeToPaymentDatesDefault.class)
public abstract class MapDateRelativeToPaymentDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPaymentDatesList mapPaymentDatesList;

	/**
	* @param fpmlDataDocument 
	* @return dateRelativeToPaymentDates 
	*/
	public DateRelativeToPaymentDates evaluate(DataDocument fpmlDataDocument) {
		DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder dateRelativeToPaymentDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final DateRelativeToPaymentDates dateRelativeToPaymentDates;
		if (dateRelativeToPaymentDatesBuilder == null) {
			dateRelativeToPaymentDates = null;
		} else {
			dateRelativeToPaymentDates = dateRelativeToPaymentDatesBuilder.build();
			objectValidator.validate(DateRelativeToPaymentDates.class, dateRelativeToPaymentDates);
		}
		
		return dateRelativeToPaymentDates;
	}

	protected abstract DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDateRelativeToPaymentDatesDefault extends MapDateRelativeToPaymentDates {
		@Override
		protected DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder dateRelativeToPaymentDates = DateRelativeToPaymentDates.builder();
			return assignOutput(dateRelativeToPaymentDates, fpmlDataDocument);
		}
		
		protected DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder assignOutput(DateRelativeToPaymentDates.DateRelativeToPaymentDatesBuilder dateRelativeToPaymentDates, DataDocument fpmlDataDocument) {
			dateRelativeToPaymentDates = toBuilder(DateRelativeToPaymentDates.builder()
				.setPaymentDatesReferenceValue(new ArrayList(mapPaymentDatesList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(dateRelativeToPaymentDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

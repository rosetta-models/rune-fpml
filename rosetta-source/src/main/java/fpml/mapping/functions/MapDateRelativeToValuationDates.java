package fpml.mapping.functions;

import cdm.product.common.schedule.DateRelativeToValuationDates;
import cdm.product.common.schedule.DateRelativeToValuationDates.DateRelativeToValuationDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateRelativeToValuationDates.MapDateRelativeToValuationDatesDefault.class)
public abstract class MapDateRelativeToValuationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPerformanceValuationDatesList mapPerformanceValuationDatesList;

	/**
	* @param fpmlDataDocument 
	* @return dateRelativeToValuationDates 
	*/
	public DateRelativeToValuationDates evaluate(DataDocument fpmlDataDocument) {
		DateRelativeToValuationDates.DateRelativeToValuationDatesBuilder dateRelativeToValuationDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final DateRelativeToValuationDates dateRelativeToValuationDates;
		if (dateRelativeToValuationDatesBuilder == null) {
			dateRelativeToValuationDates = null;
		} else {
			dateRelativeToValuationDates = dateRelativeToValuationDatesBuilder.build();
			objectValidator.validate(DateRelativeToValuationDates.class, dateRelativeToValuationDates);
		}
		
		return dateRelativeToValuationDates;
	}

	protected abstract DateRelativeToValuationDates.DateRelativeToValuationDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDateRelativeToValuationDatesDefault extends MapDateRelativeToValuationDates {
		@Override
		protected DateRelativeToValuationDates.DateRelativeToValuationDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DateRelativeToValuationDates.DateRelativeToValuationDatesBuilder dateRelativeToValuationDates = DateRelativeToValuationDates.builder();
			return assignOutput(dateRelativeToValuationDates, fpmlDataDocument);
		}
		
		protected DateRelativeToValuationDates.DateRelativeToValuationDatesBuilder assignOutput(DateRelativeToValuationDates.DateRelativeToValuationDatesBuilder dateRelativeToValuationDates, DataDocument fpmlDataDocument) {
			dateRelativeToValuationDates = toBuilder(DateRelativeToValuationDates.builder()
				.setValuationDatesReferenceValue(new ArrayList(mapPerformanceValuationDatesList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(dateRelativeToValuationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

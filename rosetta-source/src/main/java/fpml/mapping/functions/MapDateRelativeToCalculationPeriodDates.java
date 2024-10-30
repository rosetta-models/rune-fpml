package fpml.mapping.functions;

import cdm.product.common.schedule.DateRelativeToCalculationPeriodDates;
import cdm.product.common.schedule.DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateRelativeToCalculationPeriodDates.MapDateRelativeToCalculationPeriodDatesDefault.class)
public abstract class MapDateRelativeToCalculationPeriodDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationPeriodDatesList mapCalculationPeriodDatesList;

	/**
	* @param fpmlDataDocument 
	* @return dateRelativeToCalculationPeriodDates 
	*/
	public DateRelativeToCalculationPeriodDates evaluate(DataDocument fpmlDataDocument) {
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder dateRelativeToCalculationPeriodDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final DateRelativeToCalculationPeriodDates dateRelativeToCalculationPeriodDates;
		if (dateRelativeToCalculationPeriodDatesBuilder == null) {
			dateRelativeToCalculationPeriodDates = null;
		} else {
			dateRelativeToCalculationPeriodDates = dateRelativeToCalculationPeriodDatesBuilder.build();
			objectValidator.validate(DateRelativeToCalculationPeriodDates.class, dateRelativeToCalculationPeriodDates);
		}
		
		return dateRelativeToCalculationPeriodDates;
	}

	protected abstract DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDateRelativeToCalculationPeriodDatesDefault extends MapDateRelativeToCalculationPeriodDates {
		@Override
		protected DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder dateRelativeToCalculationPeriodDates = DateRelativeToCalculationPeriodDates.builder();
			return assignOutput(dateRelativeToCalculationPeriodDates, fpmlDataDocument);
		}
		
		protected DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder assignOutput(DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder dateRelativeToCalculationPeriodDates, DataDocument fpmlDataDocument) {
			dateRelativeToCalculationPeriodDates = toBuilder(DateRelativeToCalculationPeriodDates.builder()
				.setCalculationPeriodDatesReferenceValue(new ArrayList(mapCalculationPeriodDatesList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(dateRelativeToCalculationPeriodDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

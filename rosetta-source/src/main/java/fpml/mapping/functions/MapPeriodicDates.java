package fpml.mapping.functions;

import cdm.base.datetime.PeriodicDates;
import cdm.base.datetime.PeriodicDates.PeriodicDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPeriodicDates.MapPeriodicDatesDefault.class)
public abstract class MapPeriodicDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapCalculationPeriodFrequency mapCalculationPeriodFrequency;

	/**
	* @param fpmlDataDocument 
	* @return periodicDates 
	*/
	public PeriodicDates evaluate(DataDocument fpmlDataDocument) {
		PeriodicDates.PeriodicDatesBuilder periodicDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final PeriodicDates periodicDates;
		if (periodicDatesBuilder == null) {
			periodicDates = null;
		} else {
			periodicDates = periodicDatesBuilder.build();
			objectValidator.validate(PeriodicDates.class, periodicDates);
		}
		
		return periodicDates;
	}

	protected abstract PeriodicDates.PeriodicDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPeriodicDatesDefault extends MapPeriodicDates {
		@Override
		protected PeriodicDates.PeriodicDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PeriodicDates.PeriodicDatesBuilder periodicDates = PeriodicDates.builder();
			return assignOutput(periodicDates, fpmlDataDocument);
		}
		
		protected PeriodicDates.PeriodicDatesBuilder assignOutput(PeriodicDates.PeriodicDatesBuilder periodicDates, DataDocument fpmlDataDocument) {
			periodicDates = toBuilder(PeriodicDates.builder()
				.setStartDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setEndDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setPeriodFrequency(mapCalculationPeriodFrequency.evaluate(fpmlDataDocument))
				.setPeriodDatesAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setDayType(null)
				.build());
			
			return Optional.ofNullable(periodicDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

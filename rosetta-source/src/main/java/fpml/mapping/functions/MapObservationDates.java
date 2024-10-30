package fpml.mapping.functions;

import cdm.product.common.schedule.ObservationDates;
import cdm.product.common.schedule.ObservationDates.ObservationDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapObservationDates.MapObservationDatesDefault.class)
public abstract class MapObservationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapObservationSchedule mapObservationSchedule;
	@Inject protected MapParametricDates mapParametricDates;
	@Inject protected MapPeriodicDates mapPeriodicDates;

	/**
	* @param fpmlDataDocument 
	* @return observationDates 
	*/
	public ObservationDates evaluate(DataDocument fpmlDataDocument) {
		ObservationDates.ObservationDatesBuilder observationDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final ObservationDates observationDates;
		if (observationDatesBuilder == null) {
			observationDates = null;
		} else {
			observationDates = observationDatesBuilder.build();
			objectValidator.validate(ObservationDates.class, observationDates);
		}
		
		return observationDates;
	}

	protected abstract ObservationDates.ObservationDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservationDatesDefault extends MapObservationDates {
		@Override
		protected ObservationDates.ObservationDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ObservationDates.ObservationDatesBuilder observationDates = ObservationDates.builder();
			return assignOutput(observationDates, fpmlDataDocument);
		}
		
		protected ObservationDates.ObservationDatesBuilder assignOutput(ObservationDates.ObservationDatesBuilder observationDates, DataDocument fpmlDataDocument) {
			observationDates = toBuilder(ObservationDates.builder()
				.setObservationSchedule(mapObservationSchedule.evaluate(fpmlDataDocument))
				.setPeriodicSchedule(mapPeriodicDates.evaluate(fpmlDataDocument))
				.setParametricDates(mapParametricDates.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(observationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

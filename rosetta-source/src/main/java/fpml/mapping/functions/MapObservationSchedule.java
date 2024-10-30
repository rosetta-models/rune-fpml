package fpml.mapping.functions;

import cdm.product.common.schedule.ObservationSchedule;
import cdm.product.common.schedule.ObservationSchedule.ObservationScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapObservationSchedule.MapObservationScheduleDefault.class)
public abstract class MapObservationSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapObservationDateList mapObservationDateList;

	/**
	* @param fpmlDataDocument 
	* @return observationSchedule 
	*/
	public ObservationSchedule evaluate(DataDocument fpmlDataDocument) {
		ObservationSchedule.ObservationScheduleBuilder observationScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final ObservationSchedule observationSchedule;
		if (observationScheduleBuilder == null) {
			observationSchedule = null;
		} else {
			observationSchedule = observationScheduleBuilder.build();
			objectValidator.validate(ObservationSchedule.class, observationSchedule);
		}
		
		return observationSchedule;
	}

	protected abstract ObservationSchedule.ObservationScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservationScheduleDefault extends MapObservationSchedule {
		@Override
		protected ObservationSchedule.ObservationScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ObservationSchedule.ObservationScheduleBuilder observationSchedule = ObservationSchedule.builder();
			return assignOutput(observationSchedule, fpmlDataDocument);
		}
		
		protected ObservationSchedule.ObservationScheduleBuilder assignOutput(ObservationSchedule.ObservationScheduleBuilder observationSchedule, DataDocument fpmlDataDocument) {
			observationSchedule = toBuilder(ObservationSchedule.builder()
				.setObservationDate(new ArrayList(mapObservationDateList.evaluate(fpmlDataDocument)))
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(observationSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

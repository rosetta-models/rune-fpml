package fpml.mapping.functions;

import cdm.observable.event.TriggerEvent;
import cdm.observable.event.TriggerEvent.TriggerEventBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTriggerEvent.MapTriggerEventDefault.class)
public abstract class MapTriggerEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAveragingScheduleList mapAveragingScheduleList;
	@Inject protected MapDateList mapDateList;
	@Inject protected MapFeaturePayment mapFeaturePayment;
	@Inject protected MapTrigger mapTrigger;

	/**
	* @param fpmlDataDocument 
	* @return triggerEvent 
	*/
	public TriggerEvent evaluate(DataDocument fpmlDataDocument) {
		TriggerEvent.TriggerEventBuilder triggerEventBuilder = doEvaluate(fpmlDataDocument);
		
		final TriggerEvent triggerEvent;
		if (triggerEventBuilder == null) {
			triggerEvent = null;
		} else {
			triggerEvent = triggerEventBuilder.build();
			objectValidator.validate(TriggerEvent.class, triggerEvent);
		}
		
		return triggerEvent;
	}

	protected abstract TriggerEvent.TriggerEventBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTriggerEventDefault extends MapTriggerEvent {
		@Override
		protected TriggerEvent.TriggerEventBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TriggerEvent.TriggerEventBuilder triggerEvent = TriggerEvent.builder();
			return assignOutput(triggerEvent, fpmlDataDocument);
		}
		
		protected TriggerEvent.TriggerEventBuilder assignOutput(TriggerEvent.TriggerEventBuilder triggerEvent, DataDocument fpmlDataDocument) {
			triggerEvent = toBuilder(TriggerEvent.builder()
				.setSchedule(new ArrayList(mapAveragingScheduleList.evaluate(fpmlDataDocument)))
				.setTriggerDates(mapDateList.evaluate(fpmlDataDocument))
				.setTrigger(mapTrigger.evaluate(fpmlDataDocument))
				.setFeaturePayment(mapFeaturePayment.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(triggerEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

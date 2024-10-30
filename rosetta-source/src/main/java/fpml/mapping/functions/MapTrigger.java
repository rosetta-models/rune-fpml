package fpml.mapping.functions;

import cdm.observable.event.Trigger;
import cdm.observable.event.Trigger.TriggerBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTrigger.MapTriggerDefault.class)
public abstract class MapTrigger implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditEvents mapCreditEvents;
	@Inject protected MapPriceScheduleList mapPriceScheduleList;

	/**
	* @param fpmlDataDocument 
	* @return trigger 
	*/
	public Trigger evaluate(DataDocument fpmlDataDocument) {
		Trigger.TriggerBuilder triggerBuilder = doEvaluate(fpmlDataDocument);
		
		final Trigger trigger;
		if (triggerBuilder == null) {
			trigger = null;
		} else {
			trigger = triggerBuilder.build();
			objectValidator.validate(Trigger.class, trigger);
		}
		
		return trigger;
	}

	protected abstract Trigger.TriggerBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTriggerDefault extends MapTrigger {
		@Override
		protected Trigger.TriggerBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Trigger.TriggerBuilder trigger = Trigger.builder();
			return assignOutput(trigger, fpmlDataDocument);
		}
		
		protected Trigger.TriggerBuilder assignOutput(Trigger.TriggerBuilder trigger, DataDocument fpmlDataDocument) {
			trigger = toBuilder(Trigger.builder()
				.setLevel(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setCreditEvents(mapCreditEvents.evaluate(fpmlDataDocument))
				.setCreditEventsReferenceValue(mapCreditEvents.evaluate(fpmlDataDocument))
				.setTriggerType(null)
				.setTriggerTimeType(null)
				.build());
			
			return Optional.ofNullable(trigger)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

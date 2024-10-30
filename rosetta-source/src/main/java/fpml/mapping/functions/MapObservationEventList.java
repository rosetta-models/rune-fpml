package fpml.mapping.functions;

import cdm.event.common.ObservationEvent;
import cdm.event.common.ObservationEvent.ObservationEventBuilder;
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


@ImplementedBy(MapObservationEventList.MapObservationEventListDefault.class)
public abstract class MapObservationEventList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCorporateAction mapCorporateAction;
	@Inject protected MapCreditEvent mapCreditEvent;

	/**
	* @param fpmlDataDocument 
	* @return observationEventList 
	*/
	public List<? extends ObservationEvent> evaluate(DataDocument fpmlDataDocument) {
		List<ObservationEvent.ObservationEventBuilder> observationEventListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ObservationEvent> observationEventList;
		if (observationEventListBuilder == null) {
			observationEventList = null;
		} else {
			observationEventList = observationEventListBuilder.stream().map(ObservationEvent::build).collect(Collectors.toList());
			objectValidator.validate(ObservationEvent.class, observationEventList);
		}
		
		return observationEventList;
	}

	protected abstract List<ObservationEvent.ObservationEventBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservationEventListDefault extends MapObservationEventList {
		@Override
		protected List<ObservationEvent.ObservationEventBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ObservationEvent.ObservationEventBuilder> observationEventList = new ArrayList<>();
			return assignOutput(observationEventList, fpmlDataDocument);
		}
		
		protected List<ObservationEvent.ObservationEventBuilder> assignOutput(List<ObservationEvent.ObservationEventBuilder> observationEventList, DataDocument fpmlDataDocument) {
			observationEventList.addAll(toBuilder(MapperC.<ObservationEvent>of(MapperS.of(ObservationEvent.builder()
				.setCreditEvent(mapCreditEvent.evaluate(fpmlDataDocument))
				.setCorporateAction(mapCorporateAction.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(observationEventList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

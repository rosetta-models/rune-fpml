package fpml.mapping.functions;

import cdm.observable.event.Observation;
import cdm.observable.event.Observation.ObservationBuilder;
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


@ImplementedBy(MapObservationList.MapObservationListDefault.class)
public abstract class MapObservationList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapObservationIdentifier mapObservationIdentifier;
	@Inject protected MapPrice mapPrice;

	/**
	* @param fpmlDataDocument 
	* @return observationList 
	*/
	public List<? extends Observation> evaluate(DataDocument fpmlDataDocument) {
		List<Observation.ObservationBuilder> observationListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Observation> observationList;
		if (observationListBuilder == null) {
			observationList = null;
		} else {
			observationList = observationListBuilder.stream().map(Observation::build).collect(Collectors.toList());
			objectValidator.validate(Observation.class, observationList);
		}
		
		return observationList;
	}

	protected abstract List<Observation.ObservationBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservationListDefault extends MapObservationList {
		@Override
		protected List<Observation.ObservationBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Observation.ObservationBuilder> observationList = new ArrayList<>();
			return assignOutput(observationList, fpmlDataDocument);
		}
		
		protected List<Observation.ObservationBuilder> assignOutput(List<Observation.ObservationBuilder> observationList, DataDocument fpmlDataDocument) {
			observationList.addAll(toBuilder(MapperC.<Observation>of(MapperS.of(Observation.builder()
				.setObservedValue(mapPrice.evaluate(fpmlDataDocument))
				.setObservationIdentifier(mapObservationIdentifier.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(observationList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

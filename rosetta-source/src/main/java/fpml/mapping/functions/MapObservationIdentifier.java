package fpml.mapping.functions;

import cdm.observable.event.ObservationIdentifier;
import cdm.observable.event.ObservationIdentifier.ObservationIdentifierBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapObservationIdentifier.MapObservationIdentifierDefault.class)
public abstract class MapObservationIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDeterminationMethodology mapDeterminationMethodology;
	@Inject protected MapInformationSource mapInformationSource;
	@Inject protected MapObservable mapObservable;
	@Inject protected MapTimeZone mapTimeZone;

	/**
	* @param fpmlDataDocument 
	* @return observationIdentifier 
	*/
	public ObservationIdentifier evaluate(DataDocument fpmlDataDocument) {
		ObservationIdentifier.ObservationIdentifierBuilder observationIdentifierBuilder = doEvaluate(fpmlDataDocument);
		
		final ObservationIdentifier observationIdentifier;
		if (observationIdentifierBuilder == null) {
			observationIdentifier = null;
		} else {
			observationIdentifier = observationIdentifierBuilder.build();
			objectValidator.validate(ObservationIdentifier.class, observationIdentifier);
		}
		
		return observationIdentifier;
	}

	protected abstract ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservationIdentifierDefault extends MapObservationIdentifier {
		@Override
		protected ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ObservationIdentifier.ObservationIdentifierBuilder observationIdentifier = ObservationIdentifier.builder();
			return assignOutput(observationIdentifier, fpmlDataDocument);
		}
		
		protected ObservationIdentifier.ObservationIdentifierBuilder assignOutput(ObservationIdentifier.ObservationIdentifierBuilder observationIdentifier, DataDocument fpmlDataDocument) {
			observationIdentifier = toBuilder(ObservationIdentifier.builder()
				.setObservable(mapObservable.evaluate(fpmlDataDocument))
				.setObservationDate(null)
				.setObservationTime(mapTimeZone.evaluate(fpmlDataDocument))
				.setInformationSource(mapInformationSource.evaluate(fpmlDataDocument))
				.setDeterminationMethodology(mapDeterminationMethodology.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(observationIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

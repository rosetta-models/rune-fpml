package fpml.mapping.functions;

import cdm.observable.asset.calculatedrate.ObservationParameters;
import cdm.observable.asset.calculatedrate.ObservationParameters.ObservationParametersBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapObservationParameters.MapObservationParametersDefault.class)
public abstract class MapObservationParameters implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return observationParameters 
	*/
	public ObservationParameters evaluate(DataDocument fpmlDataDocument) {
		ObservationParameters.ObservationParametersBuilder observationParametersBuilder = doEvaluate(fpmlDataDocument);
		
		final ObservationParameters observationParameters;
		if (observationParametersBuilder == null) {
			observationParameters = null;
		} else {
			observationParameters = observationParametersBuilder.build();
			objectValidator.validate(ObservationParameters.class, observationParameters);
		}
		
		return observationParameters;
	}

	protected abstract ObservationParameters.ObservationParametersBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservationParametersDefault extends MapObservationParameters {
		@Override
		protected ObservationParameters.ObservationParametersBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ObservationParameters.ObservationParametersBuilder observationParameters = ObservationParameters.builder();
			return assignOutput(observationParameters, fpmlDataDocument);
		}
		
		protected ObservationParameters.ObservationParametersBuilder assignOutput(ObservationParameters.ObservationParametersBuilder observationParameters, DataDocument fpmlDataDocument) {
			observationParameters = toBuilder(ObservationParameters.builder()
				.setObservationCapRate(null)
				.setObservationFloorRate(null)
				.build());
			
			return Optional.ofNullable(observationParameters)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

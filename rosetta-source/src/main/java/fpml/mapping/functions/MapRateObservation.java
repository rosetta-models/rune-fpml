package fpml.mapping.functions;

import cdm.observable.asset.RateObservation;
import cdm.observable.asset.RateObservation.RateObservationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRateObservation.MapRateObservationDefault.class)
public abstract class MapRateObservation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected fpml.mapping.functions.MapRateObservation mapRateObservation;

	/**
	* @param fpmlDataDocument 
	* @return rateObservation 
	*/
	public RateObservation evaluate(DataDocument fpmlDataDocument) {
		RateObservation.RateObservationBuilder rateObservationBuilder = doEvaluate(fpmlDataDocument);
		
		final RateObservation rateObservation;
		if (rateObservationBuilder == null) {
			rateObservation = null;
		} else {
			rateObservation = rateObservationBuilder.build();
			objectValidator.validate(RateObservation.class, rateObservation);
		}
		
		return rateObservation;
	}

	protected abstract RateObservation.RateObservationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRateObservationDefault extends MapRateObservation {
		@Override
		protected RateObservation.RateObservationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			RateObservation.RateObservationBuilder rateObservation = RateObservation.builder();
			return assignOutput(rateObservation, fpmlDataDocument);
		}
		
		protected RateObservation.RateObservationBuilder assignOutput(RateObservation.RateObservationBuilder rateObservation, DataDocument fpmlDataDocument) {
			rateObservation = toBuilder(RateObservation.builder()
				.setResetDate(null)
				.setAdjustedFixingDate(null)
				.setObservedRate(null)
				.setTreatedRate(null)
				.setObservationWeight(null)
				.setRateReferenceValue(mapRateObservation.evaluate(fpmlDataDocument))
				.setForecastRate(null)
				.setTreatedForecastRate(null)
				.build());
			
			return Optional.ofNullable(rateObservation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

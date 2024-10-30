package fpml.mapping.functions;

import cdm.observable.asset.calculatedrate.ObservationShiftCalculation;
import cdm.observable.asset.calculatedrate.ObservationShiftCalculation.ObservationShiftCalculationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapObservationShiftCalculation.MapObservationShiftCalculationDefault.class)
public abstract class MapObservationShiftCalculation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;

	/**
	* @param fpmlDataDocument 
	* @return observationShiftCalculation 
	*/
	public ObservationShiftCalculation evaluate(DataDocument fpmlDataDocument) {
		ObservationShiftCalculation.ObservationShiftCalculationBuilder observationShiftCalculationBuilder = doEvaluate(fpmlDataDocument);
		
		final ObservationShiftCalculation observationShiftCalculation;
		if (observationShiftCalculationBuilder == null) {
			observationShiftCalculation = null;
		} else {
			observationShiftCalculation = observationShiftCalculationBuilder.build();
			objectValidator.validate(ObservationShiftCalculation.class, observationShiftCalculation);
		}
		
		return observationShiftCalculation;
	}

	protected abstract ObservationShiftCalculation.ObservationShiftCalculationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObservationShiftCalculationDefault extends MapObservationShiftCalculation {
		@Override
		protected ObservationShiftCalculation.ObservationShiftCalculationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ObservationShiftCalculation.ObservationShiftCalculationBuilder observationShiftCalculation = ObservationShiftCalculation.builder();
			return assignOutput(observationShiftCalculation, fpmlDataDocument);
		}
		
		protected ObservationShiftCalculation.ObservationShiftCalculationBuilder assignOutput(ObservationShiftCalculation.ObservationShiftCalculationBuilder observationShiftCalculation, DataDocument fpmlDataDocument) {
			observationShiftCalculation = toBuilder(ObservationShiftCalculation.builder()
				.setOffsetDays(null)
				.setCalculationBase(null)
				.setAdditionalBusinessDays(mapBusinessCenters.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(observationShiftCalculation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

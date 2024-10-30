package fpml.mapping.functions;

import cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters;
import cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFloatingRateCalculationParameters.MapFloatingRateCalculationParametersDefault.class)
public abstract class MapFloatingRateCalculationParameters implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapObservationParameters mapObservationParameters;
	@Inject protected MapObservationShiftCalculation mapObservationShiftCalculation;
	@Inject protected MapOffsetCalculation mapOffsetCalculation;

	/**
	* @param fpmlDataDocument 
	* @return floatingRateCalculationParameters 
	*/
	public FloatingRateCalculationParameters evaluate(DataDocument fpmlDataDocument) {
		FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder floatingRateCalculationParametersBuilder = doEvaluate(fpmlDataDocument);
		
		final FloatingRateCalculationParameters floatingRateCalculationParameters;
		if (floatingRateCalculationParametersBuilder == null) {
			floatingRateCalculationParameters = null;
		} else {
			floatingRateCalculationParameters = floatingRateCalculationParametersBuilder.build();
			objectValidator.validate(FloatingRateCalculationParameters.class, floatingRateCalculationParameters);
		}
		
		return floatingRateCalculationParameters;
	}

	protected abstract FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFloatingRateCalculationParametersDefault extends MapFloatingRateCalculationParameters {
		@Override
		protected FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder floatingRateCalculationParameters = FloatingRateCalculationParameters.builder();
			return assignOutput(floatingRateCalculationParameters, fpmlDataDocument);
		}
		
		protected FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder assignOutput(FloatingRateCalculationParameters.FloatingRateCalculationParametersBuilder floatingRateCalculationParameters, DataDocument fpmlDataDocument) {
			floatingRateCalculationParameters = toBuilder(FloatingRateCalculationParameters.builder()
				.setCalculationMethod(null)
				.setObservationShiftCalculation(mapObservationShiftCalculation.evaluate(fpmlDataDocument))
				.setLookbackCalculation(mapOffsetCalculation.evaluate(fpmlDataDocument))
				.setLockoutCalculation(mapOffsetCalculation.evaluate(fpmlDataDocument))
				.setApplicableBusinessDays(mapBusinessCenters.evaluate(fpmlDataDocument))
				.setObservationParameters(mapObservationParameters.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(floatingRateCalculationParameters)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

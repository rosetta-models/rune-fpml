package fpml.mapping.functions;

import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.FloatingRateSpecification.FloatingRateSpecificationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFloatingRateSpecification.MapFloatingRateSpecificationDefault.class)
public abstract class MapFloatingRateSpecification implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFallbackRateParameters mapFallbackRateParameters;
	@Inject protected MapFloatingRateCalculationParameters mapFloatingRateCalculationParameters;
	@Inject protected MapFloatingRateIndex mapFloatingRateIndex;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapRateSchedule mapRateSchedule;
	@Inject protected MapRounding mapRounding;
	@Inject protected MapSpreadSchedule mapSpreadSchedule;
	@Inject protected MapStrikeSchedule mapStrikeSchedule;

	/**
	* @param fpmlDataDocument 
	* @return floatingRateSpecification 
	*/
	public FloatingRateSpecification evaluate(DataDocument fpmlDataDocument) {
		FloatingRateSpecification.FloatingRateSpecificationBuilder floatingRateSpecificationBuilder = doEvaluate(fpmlDataDocument);
		
		final FloatingRateSpecification floatingRateSpecification;
		if (floatingRateSpecificationBuilder == null) {
			floatingRateSpecification = null;
		} else {
			floatingRateSpecification = floatingRateSpecificationBuilder.build();
			objectValidator.validate(FloatingRateSpecification.class, floatingRateSpecification);
		}
		
		return floatingRateSpecification;
	}

	protected abstract FloatingRateSpecification.FloatingRateSpecificationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFloatingRateSpecificationDefault extends MapFloatingRateSpecification {
		@Override
		protected FloatingRateSpecification.FloatingRateSpecificationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FloatingRateSpecification.FloatingRateSpecificationBuilder floatingRateSpecification = FloatingRateSpecification.builder();
			return assignOutput(floatingRateSpecification, fpmlDataDocument);
		}
		
		protected FloatingRateSpecification.FloatingRateSpecificationBuilder assignOutput(FloatingRateSpecification.FloatingRateSpecificationBuilder floatingRateSpecification, DataDocument fpmlDataDocument) {
			floatingRateSpecification = toBuilder(FloatingRateSpecification.builder()
				.setRateOptionValue(mapFloatingRateIndex.evaluate(fpmlDataDocument))
				.setSpreadSchedule(mapSpreadSchedule.evaluate(fpmlDataDocument))
				.setCapRateSchedule(mapStrikeSchedule.evaluate(fpmlDataDocument))
				.setFloorRateSchedule(mapStrikeSchedule.evaluate(fpmlDataDocument))
				.setFloatingRateMultiplierSchedule(mapRateSchedule.evaluate(fpmlDataDocument))
				.setRateTreatment(null)
				.setCalculationParameters(mapFloatingRateCalculationParameters.evaluate(fpmlDataDocument))
				.setFallbackRate(mapFallbackRateParameters.evaluate(fpmlDataDocument))
				.setInitialRate(mapPrice.evaluate(fpmlDataDocument))
				.setFinalRateRounding(mapRounding.evaluate(fpmlDataDocument))
				.setAveragingMethod(null)
				.setNegativeInterestRateTreatment(null)
				.build());
			
			return Optional.ofNullable(floatingRateSpecification)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

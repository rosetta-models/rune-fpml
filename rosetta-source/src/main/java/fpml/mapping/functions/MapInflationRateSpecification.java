package fpml.mapping.functions;

import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InflationRateSpecification.InflationRateSpecificationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInflationRateSpecification.MapInflationRateSpecificationDefault.class)
public abstract class MapInflationRateSpecification implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFallbackRateParameters mapFallbackRateParameters;
	@Inject protected MapFloatingRateCalculationParameters mapFloatingRateCalculationParameters;
	@Inject protected MapFloatingRateIndex mapFloatingRateIndex;
	@Inject protected MapIndexSourceWithScheme mapIndexSourceWithScheme;
	@Inject protected MapInterpolationMethodWithScheme mapInterpolationMethodWithScheme;
	@Inject protected MapMainPublicationWithScheme mapMainPublicationWithScheme;
	@Inject protected MapOffset mapOffset;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapRateSchedule mapRateSchedule;
	@Inject protected MapRounding mapRounding;
	@Inject protected MapSpreadSchedule mapSpreadSchedule;
	@Inject protected MapStrikeSchedule mapStrikeSchedule;

	/**
	* @param fpmlDataDocument 
	* @return inflationRateSpecification 
	*/
	public InflationRateSpecification evaluate(DataDocument fpmlDataDocument) {
		InflationRateSpecification.InflationRateSpecificationBuilder inflationRateSpecificationBuilder = doEvaluate(fpmlDataDocument);
		
		final InflationRateSpecification inflationRateSpecification;
		if (inflationRateSpecificationBuilder == null) {
			inflationRateSpecification = null;
		} else {
			inflationRateSpecification = inflationRateSpecificationBuilder.build();
			objectValidator.validate(InflationRateSpecification.class, inflationRateSpecification);
		}
		
		return inflationRateSpecification;
	}

	protected abstract InflationRateSpecification.InflationRateSpecificationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInflationRateSpecificationDefault extends MapInflationRateSpecification {
		@Override
		protected InflationRateSpecification.InflationRateSpecificationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			InflationRateSpecification.InflationRateSpecificationBuilder inflationRateSpecification = InflationRateSpecification.builder();
			return assignOutput(inflationRateSpecification, fpmlDataDocument);
		}
		
		protected InflationRateSpecification.InflationRateSpecificationBuilder assignOutput(InflationRateSpecification.InflationRateSpecificationBuilder inflationRateSpecification, DataDocument fpmlDataDocument) {
			inflationRateSpecification = toBuilder(InflationRateSpecification.builder()
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
				.setInflationLag(mapOffset.evaluate(fpmlDataDocument))
				.setIndexSourceValue(mapIndexSourceWithScheme.evaluate(fpmlDataDocument))
				.setMainPublicationValue(mapMainPublicationWithScheme.evaluate(fpmlDataDocument))
				.setInterpolationMethodValue(mapInterpolationMethodWithScheme.evaluate(fpmlDataDocument))
				.setInitialIndexLevel(null)
				.setFallbackBondApplicable(null)
				.setCalculationMethod(null)
				.setCalculationStyle(null)
				.setFinalPrincipalExchangeCalculation(null)
				.build());
			
			return Optional.ofNullable(inflationRateSpecification)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

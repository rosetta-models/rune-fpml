package fpml.mapping.functions;

import cdm.observable.asset.calculatedrate.FallbackRateParameters;
import cdm.observable.asset.calculatedrate.FallbackRateParameters.FallbackRateParametersBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFallbackRateParameters.MapFallbackRateParametersDefault.class)
public abstract class MapFallbackRateParameters implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFloatingRateCalculationParameters mapFloatingRateCalculationParameters;

	/**
	* @param fpmlDataDocument 
	* @return fallbackRateParameters 
	*/
	public FallbackRateParameters evaluate(DataDocument fpmlDataDocument) {
		FallbackRateParameters.FallbackRateParametersBuilder fallbackRateParametersBuilder = doEvaluate(fpmlDataDocument);
		
		final FallbackRateParameters fallbackRateParameters;
		if (fallbackRateParametersBuilder == null) {
			fallbackRateParameters = null;
		} else {
			fallbackRateParameters = fallbackRateParametersBuilder.build();
			objectValidator.validate(FallbackRateParameters.class, fallbackRateParameters);
		}
		
		return fallbackRateParameters;
	}

	protected abstract FallbackRateParameters.FallbackRateParametersBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFallbackRateParametersDefault extends MapFallbackRateParameters {
		@Override
		protected FallbackRateParameters.FallbackRateParametersBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FallbackRateParameters.FallbackRateParametersBuilder fallbackRateParameters = FallbackRateParameters.builder();
			return assignOutput(fallbackRateParameters, fpmlDataDocument);
		}
		
		protected FallbackRateParameters.FallbackRateParametersBuilder assignOutput(FallbackRateParameters.FallbackRateParametersBuilder fallbackRateParameters, DataDocument fpmlDataDocument) {
			fallbackRateParameters = toBuilder(FallbackRateParameters.builder()
				.setFloatingRateIndex(null)
				.setEffectiveDate(null)
				.setCalculationParameters(mapFloatingRateCalculationParameters.evaluate(fpmlDataDocument))
				.setSpreadAdjustment(null)
				.build());
			
			return Optional.ofNullable(fallbackRateParameters)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

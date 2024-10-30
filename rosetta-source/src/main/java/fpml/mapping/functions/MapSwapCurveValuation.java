package fpml.mapping.functions;

import cdm.observable.asset.SwapCurveValuation;
import cdm.observable.asset.SwapCurveValuation.SwapCurveValuationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwapCurveValuation.MapSwapCurveValuationDefault.class)
public abstract class MapSwapCurveValuation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlDataDocument 
	* @return swapCurveValuation 
	*/
	public SwapCurveValuation evaluate(DataDocument fpmlDataDocument) {
		SwapCurveValuation.SwapCurveValuationBuilder swapCurveValuationBuilder = doEvaluate(fpmlDataDocument);
		
		final SwapCurveValuation swapCurveValuation;
		if (swapCurveValuationBuilder == null) {
			swapCurveValuation = null;
		} else {
			swapCurveValuation = swapCurveValuationBuilder.build();
			objectValidator.validate(SwapCurveValuation.class, swapCurveValuation);
		}
		
		return swapCurveValuation;
	}

	protected abstract SwapCurveValuation.SwapCurveValuationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSwapCurveValuationDefault extends MapSwapCurveValuation {
		@Override
		protected SwapCurveValuation.SwapCurveValuationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SwapCurveValuation.SwapCurveValuationBuilder swapCurveValuation = SwapCurveValuation.builder();
			return assignOutput(swapCurveValuation, fpmlDataDocument);
		}
		
		protected SwapCurveValuation.SwapCurveValuationBuilder assignOutput(SwapCurveValuation.SwapCurveValuationBuilder swapCurveValuation, DataDocument fpmlDataDocument) {
			swapCurveValuation = toBuilder(SwapCurveValuation.builder()
				.setFloatingRateIndex(null)
				.setIndexTenor(mapPeriod.evaluate(fpmlDataDocument))
				.setSpread(null)
				.setSide(null)
				.build());
			
			return Optional.ofNullable(swapCurveValuation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

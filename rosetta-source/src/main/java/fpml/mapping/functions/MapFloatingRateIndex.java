package fpml.mapping.functions;

import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.FloatingRateIndex.FloatingRateIndexBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFloatingRateIndex.MapFloatingRateIndexDefault.class)
public abstract class MapFloatingRateIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInflationIndex mapInflationIndex;
	@Inject protected MapInterestRateIndex mapInterestRateIndex;

	/**
	* @param fpmlDataDocument 
	* @return floatingRateIndex 
	*/
	public FloatingRateIndex evaluate(DataDocument fpmlDataDocument) {
		FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndexBuilder = doEvaluate(fpmlDataDocument);
		
		final FloatingRateIndex floatingRateIndex;
		if (floatingRateIndexBuilder == null) {
			floatingRateIndex = null;
		} else {
			floatingRateIndex = floatingRateIndexBuilder.build();
			objectValidator.validate(FloatingRateIndex.class, floatingRateIndex);
		}
		
		return floatingRateIndex;
	}

	protected abstract FloatingRateIndex.FloatingRateIndexBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFloatingRateIndexDefault extends MapFloatingRateIndex {
		@Override
		protected FloatingRateIndex.FloatingRateIndexBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex = FloatingRateIndex.builder();
			return assignOutput(floatingRateIndex, fpmlDataDocument);
		}
		
		protected FloatingRateIndex.FloatingRateIndexBuilder assignOutput(FloatingRateIndex.FloatingRateIndexBuilder floatingRateIndex, DataDocument fpmlDataDocument) {
			floatingRateIndex = toBuilder(FloatingRateIndex.builder()
				.setInterestRateIndex(mapInterestRateIndex.evaluate(fpmlDataDocument))
				.setInflationIndex(mapInflationIndex.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(floatingRateIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

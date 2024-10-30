package fpml.mapping.functions;

import cdm.product.template.StrategyFeature;
import cdm.product.template.StrategyFeature.StrategyFeatureBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStrategyFeature.MapStrategyFeatureDefault.class)
public abstract class MapStrategyFeature implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalendarSpread mapCalendarSpread;
	@Inject protected MapStrikeSpread mapStrikeSpread;

	/**
	* @param fpmlDataDocument 
	* @return strategyFeature 
	*/
	public StrategyFeature evaluate(DataDocument fpmlDataDocument) {
		StrategyFeature.StrategyFeatureBuilder strategyFeatureBuilder = doEvaluate(fpmlDataDocument);
		
		final StrategyFeature strategyFeature;
		if (strategyFeatureBuilder == null) {
			strategyFeature = null;
		} else {
			strategyFeature = strategyFeatureBuilder.build();
			objectValidator.validate(StrategyFeature.class, strategyFeature);
		}
		
		return strategyFeature;
	}

	protected abstract StrategyFeature.StrategyFeatureBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapStrategyFeatureDefault extends MapStrategyFeature {
		@Override
		protected StrategyFeature.StrategyFeatureBuilder doEvaluate(DataDocument fpmlDataDocument) {
			StrategyFeature.StrategyFeatureBuilder strategyFeature = StrategyFeature.builder();
			return assignOutput(strategyFeature, fpmlDataDocument);
		}
		
		protected StrategyFeature.StrategyFeatureBuilder assignOutput(StrategyFeature.StrategyFeatureBuilder strategyFeature, DataDocument fpmlDataDocument) {
			strategyFeature = toBuilder(StrategyFeature.builder()
				.setStrikeSpread(mapStrikeSpread.evaluate(fpmlDataDocument))
				.setCalendarSpread(mapCalendarSpread.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(strategyFeature)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

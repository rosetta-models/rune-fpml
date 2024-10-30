package fpml.mapping.functions;

import cdm.product.asset.FloatingRateDefinition;
import cdm.product.asset.FloatingRateDefinition.FloatingRateDefinitionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFloatingRateDefinition.MapFloatingRateDefinitionDefault.class)
public abstract class MapFloatingRateDefinition implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRateObservationList mapRateObservationList;
	@Inject protected MapStrikeList mapStrikeList;

	/**
	* @param fpmlDataDocument 
	* @return floatingRateDefinition 
	*/
	public FloatingRateDefinition evaluate(DataDocument fpmlDataDocument) {
		FloatingRateDefinition.FloatingRateDefinitionBuilder floatingRateDefinitionBuilder = doEvaluate(fpmlDataDocument);
		
		final FloatingRateDefinition floatingRateDefinition;
		if (floatingRateDefinitionBuilder == null) {
			floatingRateDefinition = null;
		} else {
			floatingRateDefinition = floatingRateDefinitionBuilder.build();
			objectValidator.validate(FloatingRateDefinition.class, floatingRateDefinition);
		}
		
		return floatingRateDefinition;
	}

	protected abstract FloatingRateDefinition.FloatingRateDefinitionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFloatingRateDefinitionDefault extends MapFloatingRateDefinition {
		@Override
		protected FloatingRateDefinition.FloatingRateDefinitionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FloatingRateDefinition.FloatingRateDefinitionBuilder floatingRateDefinition = FloatingRateDefinition.builder();
			return assignOutput(floatingRateDefinition, fpmlDataDocument);
		}
		
		protected FloatingRateDefinition.FloatingRateDefinitionBuilder assignOutput(FloatingRateDefinition.FloatingRateDefinitionBuilder floatingRateDefinition, DataDocument fpmlDataDocument) {
			floatingRateDefinition = toBuilder(FloatingRateDefinition.builder()
				.setCalculatedRate(null)
				.setRateObservation(new ArrayList(mapRateObservationList.evaluate(fpmlDataDocument)))
				.setFloatingRateMultiplier(null)
				.setSpread(null)
				.setCapRate(new ArrayList(mapStrikeList.evaluate(fpmlDataDocument)))
				.setFloorRate(new ArrayList(mapStrikeList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(floatingRateDefinition)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

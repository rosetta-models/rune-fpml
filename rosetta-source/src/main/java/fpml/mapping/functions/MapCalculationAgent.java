package fpml.mapping.functions;

import cdm.observable.asset.CalculationAgent;
import cdm.observable.asset.CalculationAgent.CalculationAgentBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCalculationAgent.MapCalculationAgentDefault.class)
public abstract class MapCalculationAgent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationAgentBusinessCenterWithScheme mapCalculationAgentBusinessCenterWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return calculationAgent 
	*/
	public CalculationAgent evaluate(DataDocument fpmlDataDocument) {
		CalculationAgent.CalculationAgentBuilder calculationAgentBuilder = doEvaluate(fpmlDataDocument);
		
		final CalculationAgent calculationAgent;
		if (calculationAgentBuilder == null) {
			calculationAgent = null;
		} else {
			calculationAgent = calculationAgentBuilder.build();
			objectValidator.validate(CalculationAgent.class, calculationAgent);
		}
		
		return calculationAgent;
	}

	protected abstract CalculationAgent.CalculationAgentBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCalculationAgentDefault extends MapCalculationAgent {
		@Override
		protected CalculationAgent.CalculationAgentBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CalculationAgent.CalculationAgentBuilder calculationAgent = CalculationAgent.builder();
			return assignOutput(calculationAgent, fpmlDataDocument);
		}
		
		protected CalculationAgent.CalculationAgentBuilder assignOutput(CalculationAgent.CalculationAgentBuilder calculationAgent, DataDocument fpmlDataDocument) {
			calculationAgent = toBuilder(CalculationAgent.builder()
				.setCalculationAgentParty(null)
				.setCalculationAgentPartyEnum(null)
				.setCalculationAgentBusinessCenterValue(mapCalculationAgentBusinessCenterWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(calculationAgent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

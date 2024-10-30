package fpml.mapping.functions;

import cdm.legaldocumentation.common.ClosedState;
import cdm.legaldocumentation.common.ClosedState.ClosedStateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapClosedState.MapClosedStateDefault.class)
public abstract class MapClosedState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return closedState 
	*/
	public ClosedState evaluate(DataDocument fpmlDataDocument) {
		ClosedState.ClosedStateBuilder closedStateBuilder = doEvaluate(fpmlDataDocument);
		
		final ClosedState closedState;
		if (closedStateBuilder == null) {
			closedState = null;
		} else {
			closedState = closedStateBuilder.build();
			objectValidator.validate(ClosedState.class, closedState);
		}
		
		return closedState;
	}

	protected abstract ClosedState.ClosedStateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapClosedStateDefault extends MapClosedState {
		@Override
		protected ClosedState.ClosedStateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ClosedState.ClosedStateBuilder closedState = ClosedState.builder();
			return assignOutput(closedState, fpmlDataDocument);
		}
		
		protected ClosedState.ClosedStateBuilder assignOutput(ClosedState.ClosedStateBuilder closedState, DataDocument fpmlDataDocument) {
			closedState = toBuilder(ClosedState.builder()
				.setState(null)
				.setActivityDate(null)
				.setEffectiveDate(null)
				.setLastPaymentDate(null)
				.build());
			
			return Optional.ofNullable(closedState)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

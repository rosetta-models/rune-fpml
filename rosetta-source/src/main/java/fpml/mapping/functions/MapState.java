package fpml.mapping.functions;

import cdm.event.common.State;
import cdm.event.common.State.StateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapState.MapStateDefault.class)
public abstract class MapState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapClosedState mapClosedState;

	/**
	* @param fpmlDataDocument 
	* @return state 
	*/
	public State evaluate(DataDocument fpmlDataDocument) {
		State.StateBuilder stateBuilder = doEvaluate(fpmlDataDocument);
		
		final State state;
		if (stateBuilder == null) {
			state = null;
		} else {
			state = stateBuilder.build();
			objectValidator.validate(State.class, state);
		}
		
		return state;
	}

	protected abstract State.StateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapStateDefault extends MapState {
		@Override
		protected State.StateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			State.StateBuilder state = State.builder();
			return assignOutput(state, fpmlDataDocument);
		}
		
		protected State.StateBuilder assignOutput(State.StateBuilder state, DataDocument fpmlDataDocument) {
			state = toBuilder(State.builder()
				.setClosedState(mapClosedState.evaluate(fpmlDataDocument))
				.setPositionState(null)
				.build());
			
			return Optional.ofNullable(state)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

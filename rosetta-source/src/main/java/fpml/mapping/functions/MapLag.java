package fpml.mapping.functions;

import cdm.product.common.schedule.Lag;
import cdm.product.common.schedule.Lag.LagBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapLag.MapLagDefault.class)
public abstract class MapLag implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapOffset mapOffset;

	/**
	* @param fpmlDataDocument 
	* @return lag 
	*/
	public Lag evaluate(DataDocument fpmlDataDocument) {
		Lag.LagBuilder lagBuilder = doEvaluate(fpmlDataDocument);
		
		final Lag lag;
		if (lagBuilder == null) {
			lag = null;
		} else {
			lag = lagBuilder.build();
			objectValidator.validate(Lag.class, lag);
		}
		
		return lag;
	}

	protected abstract Lag.LagBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapLagDefault extends MapLag {
		@Override
		protected Lag.LagBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Lag.LagBuilder lag = Lag.builder();
			return assignOutput(lag, fpmlDataDocument);
		}
		
		protected Lag.LagBuilder assignOutput(Lag.LagBuilder lag, DataDocument fpmlDataDocument) {
			lag = toBuilder(Lag.builder()
				.setLagDuration(mapOffset.evaluate(fpmlDataDocument))
				.setFirstObservationDateOffset(mapOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(lag)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

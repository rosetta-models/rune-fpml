package fpml.mapping.functions;

import cdm.product.template.Barrier;
import cdm.product.template.Barrier.BarrierBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBarrier.MapBarrierDefault.class)
public abstract class MapBarrier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTriggerEvent mapTriggerEvent;

	/**
	* @param fpmlDataDocument 
	* @return barrier 
	*/
	public Barrier evaluate(DataDocument fpmlDataDocument) {
		Barrier.BarrierBuilder barrierBuilder = doEvaluate(fpmlDataDocument);
		
		final Barrier barrier;
		if (barrierBuilder == null) {
			barrier = null;
		} else {
			barrier = barrierBuilder.build();
			objectValidator.validate(Barrier.class, barrier);
		}
		
		return barrier;
	}

	protected abstract Barrier.BarrierBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBarrierDefault extends MapBarrier {
		@Override
		protected Barrier.BarrierBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Barrier.BarrierBuilder barrier = Barrier.builder();
			return assignOutput(barrier, fpmlDataDocument);
		}
		
		protected Barrier.BarrierBuilder assignOutput(Barrier.BarrierBuilder barrier, DataDocument fpmlDataDocument) {
			barrier = toBuilder(Barrier.builder()
				.setBarrierCap(mapTriggerEvent.evaluate(fpmlDataDocument))
				.setBarrierFloor(mapTriggerEvent.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(barrier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

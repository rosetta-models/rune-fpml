package fpml.mapping.functions;

import cdm.product.asset.FloatingAmountEvents;
import cdm.product.asset.FloatingAmountEvents.FloatingAmountEventsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFloatingAmountEvents.MapFloatingAmountEventsDefault.class)
public abstract class MapFloatingAmountEvents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdditionalFixedPayments mapAdditionalFixedPayments;
	@Inject protected MapFloatingAmountProvisions mapFloatingAmountProvisions;
	@Inject protected MapInterestShortFall mapInterestShortFall;

	/**
	* @param fpmlDataDocument 
	* @return floatingAmountEvents 
	*/
	public FloatingAmountEvents evaluate(DataDocument fpmlDataDocument) {
		FloatingAmountEvents.FloatingAmountEventsBuilder floatingAmountEventsBuilder = doEvaluate(fpmlDataDocument);
		
		final FloatingAmountEvents floatingAmountEvents;
		if (floatingAmountEventsBuilder == null) {
			floatingAmountEvents = null;
		} else {
			floatingAmountEvents = floatingAmountEventsBuilder.build();
			objectValidator.validate(FloatingAmountEvents.class, floatingAmountEvents);
		}
		
		return floatingAmountEvents;
	}

	protected abstract FloatingAmountEvents.FloatingAmountEventsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFloatingAmountEventsDefault extends MapFloatingAmountEvents {
		@Override
		protected FloatingAmountEvents.FloatingAmountEventsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			FloatingAmountEvents.FloatingAmountEventsBuilder floatingAmountEvents = FloatingAmountEvents.builder();
			return assignOutput(floatingAmountEvents, fpmlDataDocument);
		}
		
		protected FloatingAmountEvents.FloatingAmountEventsBuilder assignOutput(FloatingAmountEvents.FloatingAmountEventsBuilder floatingAmountEvents, DataDocument fpmlDataDocument) {
			floatingAmountEvents = toBuilder(FloatingAmountEvents.builder()
				.setFailureToPayPrincipal(null)
				.setInterestShortfall(mapInterestShortFall.evaluate(fpmlDataDocument))
				.setWritedown(null)
				.setImpliedWritedown(null)
				.setFloatingAmountProvisions(mapFloatingAmountProvisions.evaluate(fpmlDataDocument))
				.setAdditionalFixedPayments(mapAdditionalFixedPayments.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(floatingAmountEvents)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

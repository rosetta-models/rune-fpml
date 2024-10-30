package fpml.mapping.functions;

import cdm.observable.event.CreditEvents;
import cdm.observable.event.CreditEvents.CreditEventsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditEvents.MapCreditEventsDefault.class)
public abstract class MapCreditEvents implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditEventNotice mapCreditEventNotice;
	@Inject protected MapFailureToPay mapFailureToPay;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapRestructuring mapRestructuring;

	/**
	* @param fpmlDataDocument 
	* @return creditEvents 
	*/
	public CreditEvents evaluate(DataDocument fpmlDataDocument) {
		CreditEvents.CreditEventsBuilder creditEventsBuilder = doEvaluate(fpmlDataDocument);
		
		final CreditEvents creditEvents;
		if (creditEventsBuilder == null) {
			creditEvents = null;
		} else {
			creditEvents = creditEventsBuilder.build();
			objectValidator.validate(CreditEvents.class, creditEvents);
		}
		
		return creditEvents;
	}

	protected abstract CreditEvents.CreditEventsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCreditEventsDefault extends MapCreditEvents {
		@Override
		protected CreditEvents.CreditEventsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CreditEvents.CreditEventsBuilder creditEvents = CreditEvents.builder();
			return assignOutput(creditEvents, fpmlDataDocument);
		}
		
		protected CreditEvents.CreditEventsBuilder assignOutput(CreditEvents.CreditEventsBuilder creditEvents, DataDocument fpmlDataDocument) {
			creditEvents = toBuilder(CreditEvents.builder()
				.setBankruptcy(null)
				.setFailureToPay(mapFailureToPay.evaluate(fpmlDataDocument))
				.setFailureToPayPrincipal(null)
				.setFailureToPayInterest(null)
				.setObligationDefault(null)
				.setObligationAcceleration(null)
				.setRepudiationMoratorium(null)
				.setRestructuring(mapRestructuring.evaluate(fpmlDataDocument))
				.setGovernmentalIntervention(null)
				.setDistressedRatingsDowngrade(null)
				.setMaturityExtension(null)
				.setWritedown(null)
				.setImpliedWritedown(null)
				.setDefaultRequirement(mapMoney.evaluate(fpmlDataDocument))
				.setCreditEventNotice(mapCreditEventNotice.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(creditEvents)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

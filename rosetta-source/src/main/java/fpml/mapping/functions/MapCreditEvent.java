package fpml.mapping.functions;

import cdm.event.common.CreditEvent;
import cdm.event.common.CreditEvent.CreditEventBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditEvent.MapCreditEventDefault.class)
public abstract class MapCreditEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPrice mapPrice;
	@Inject protected MapReferenceInformation mapReferenceInformation;
	@Inject protected MapResourceList mapResourceList;

	/**
	* @param fpmlDataDocument 
	* @return creditEvent 
	*/
	public CreditEvent evaluate(DataDocument fpmlDataDocument) {
		CreditEvent.CreditEventBuilder creditEventBuilder = doEvaluate(fpmlDataDocument);
		
		final CreditEvent creditEvent;
		if (creditEventBuilder == null) {
			creditEvent = null;
		} else {
			creditEvent = creditEventBuilder.build();
			objectValidator.validate(CreditEvent.class, creditEvent);
		}
		
		return creditEvent;
	}

	protected abstract CreditEvent.CreditEventBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCreditEventDefault extends MapCreditEvent {
		@Override
		protected CreditEvent.CreditEventBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CreditEvent.CreditEventBuilder creditEvent = CreditEvent.builder();
			return assignOutput(creditEvent, fpmlDataDocument);
		}
		
		protected CreditEvent.CreditEventBuilder assignOutput(CreditEvent.CreditEventBuilder creditEvent, DataDocument fpmlDataDocument) {
			creditEvent = toBuilder(CreditEvent.builder()
				.setCreditEventType(null)
				.setEventDeterminationDate(null)
				.setAuctionDate(null)
				.setFinalPrice(mapPrice.evaluate(fpmlDataDocument))
				.setRecoveryPercent(null)
				.setPubliclyAvailableInformation(new ArrayList(mapResourceList.evaluate(fpmlDataDocument)))
				.setReferenceInformation(mapReferenceInformation.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(creditEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

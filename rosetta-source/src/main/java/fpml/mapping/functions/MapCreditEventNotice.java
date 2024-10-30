package fpml.mapping.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.observable.event.CreditEventNotice;
import cdm.observable.event.CreditEventNotice.CreditEventNoticeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditEventNotice.MapCreditEventNoticeDefault.class)
public abstract class MapCreditEventNotice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPubliclyAvailableInformation mapPubliclyAvailableInformation;

	/**
	* @param fpmlDataDocument 
	* @return creditEventNotice 
	*/
	public CreditEventNotice evaluate(DataDocument fpmlDataDocument) {
		CreditEventNotice.CreditEventNoticeBuilder creditEventNoticeBuilder = doEvaluate(fpmlDataDocument);
		
		final CreditEventNotice creditEventNotice;
		if (creditEventNoticeBuilder == null) {
			creditEventNotice = null;
		} else {
			creditEventNotice = creditEventNoticeBuilder.build();
			objectValidator.validate(CreditEventNotice.class, creditEventNotice);
		}
		
		return creditEventNotice;
	}

	protected abstract CreditEventNotice.CreditEventNoticeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCreditEventNoticeDefault extends MapCreditEventNotice {
		@Override
		protected CreditEventNotice.CreditEventNoticeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CreditEventNotice.CreditEventNoticeBuilder creditEventNotice = CreditEventNotice.builder();
			return assignOutput(creditEventNotice, fpmlDataDocument);
		}
		
		protected CreditEventNotice.CreditEventNoticeBuilder assignOutput(CreditEventNotice.CreditEventNoticeBuilder creditEventNotice, DataDocument fpmlDataDocument) {
			creditEventNotice = toBuilder(CreditEventNotice.builder()
				.setNotifyingParty(Collections.<CounterpartyRoleEnum>emptyList())
				.setBusinessCenter(null)
				.setPubliclyAvailableInformation(mapPubliclyAvailableInformation.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(creditEventNotice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

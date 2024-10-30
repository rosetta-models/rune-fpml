package fpml.mapping.functions;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPartyReferencePayerReceiver.MapPartyReferencePayerReceiverDefault.class)
public abstract class MapPartyReferencePayerReceiver implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAccount mapAccount;
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return partyReferencePayerReceiver 
	*/
	public PartyReferencePayerReceiver evaluate(DataDocument fpmlDataDocument) {
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder partyReferencePayerReceiverBuilder = doEvaluate(fpmlDataDocument);
		
		final PartyReferencePayerReceiver partyReferencePayerReceiver;
		if (partyReferencePayerReceiverBuilder == null) {
			partyReferencePayerReceiver = null;
		} else {
			partyReferencePayerReceiver = partyReferencePayerReceiverBuilder.build();
			objectValidator.validate(PartyReferencePayerReceiver.class, partyReferencePayerReceiver);
		}
		
		return partyReferencePayerReceiver;
	}

	protected abstract PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPartyReferencePayerReceiverDefault extends MapPartyReferencePayerReceiver {
		@Override
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder partyReferencePayerReceiver = PartyReferencePayerReceiver.builder();
			return assignOutput(partyReferencePayerReceiver, fpmlDataDocument);
		}
		
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder assignOutput(PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder partyReferencePayerReceiver, DataDocument fpmlDataDocument) {
			partyReferencePayerReceiver = toBuilder(PartyReferencePayerReceiver.builder()
				.setPayerPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setPayerAccountReferenceValue(mapAccount.evaluate(fpmlDataDocument))
				.setReceiverPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setReceiverAccountReferenceValue(mapAccount.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(partyReferencePayerReceiver)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

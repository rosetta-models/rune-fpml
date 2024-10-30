package fpml.mapping.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party.PartyBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapParty.MapPartyDefault.class)
public abstract class MapParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAccount mapAccount;
	@Inject protected MapBusinessUnitList mapBusinessUnitList;
	@Inject protected MapContactInformation mapContactInformation;
	@Inject protected MapNameWithScheme mapNameWithScheme;
	@Inject protected MapNaturalPersonList mapNaturalPersonList;
	@Inject protected MapNaturalPersonRoleList mapNaturalPersonRoleList;
	@Inject protected MapPartyIdentifierList mapPartyIdentifierList;

	/**
	* @param fpmlDataDocument 
	* @return party 
	*/
	public Party evaluate(DataDocument fpmlDataDocument) {
		Party.PartyBuilder partyBuilder = doEvaluate(fpmlDataDocument);
		
		final Party party;
		if (partyBuilder == null) {
			party = null;
		} else {
			party = partyBuilder.build();
			objectValidator.validate(Party.class, party);
		}
		
		return party;
	}

	protected abstract Party.PartyBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPartyDefault extends MapParty {
		@Override
		protected Party.PartyBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, fpmlDataDocument);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, DataDocument fpmlDataDocument) {
			party = toBuilder(Party.builder()
				.setPartyId(new ArrayList(mapPartyIdentifierList.evaluate(fpmlDataDocument)))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setBusinessUnit(new ArrayList(mapBusinessUnitList.evaluate(fpmlDataDocument)))
				.setPerson(new ArrayList(mapNaturalPersonList.evaluate(fpmlDataDocument)))
				.setPersonRole(new ArrayList(mapNaturalPersonRoleList.evaluate(fpmlDataDocument)))
				.setAccount(mapAccount.evaluate(fpmlDataDocument))
				.setContactInformation(mapContactInformation.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

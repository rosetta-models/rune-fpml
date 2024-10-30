package fpml.mapping.functions;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPartyRole.MapPartyRoleDefault.class)
public abstract class MapPartyRole implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return partyRole 
	*/
	public PartyRole evaluate(DataDocument fpmlDataDocument) {
		PartyRole.PartyRoleBuilder partyRoleBuilder = doEvaluate(fpmlDataDocument);
		
		final PartyRole partyRole;
		if (partyRoleBuilder == null) {
			partyRole = null;
		} else {
			partyRole = partyRoleBuilder.build();
			objectValidator.validate(PartyRole.class, partyRole);
		}
		
		return partyRole;
	}

	protected abstract PartyRole.PartyRoleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPartyRoleDefault extends MapPartyRole {
		@Override
		protected PartyRole.PartyRoleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PartyRole.PartyRoleBuilder partyRole = PartyRole.builder();
			return assignOutput(partyRole, fpmlDataDocument);
		}
		
		protected PartyRole.PartyRoleBuilder assignOutput(PartyRole.PartyRoleBuilder partyRole, DataDocument fpmlDataDocument) {
			partyRole = toBuilder(PartyRole.builder()
				.setPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setRole(null)
				.setOwnershipPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(partyRole)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

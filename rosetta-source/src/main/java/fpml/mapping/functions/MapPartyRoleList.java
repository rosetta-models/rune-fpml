package fpml.mapping.functions;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPartyRoleList.MapPartyRoleListDefault.class)
public abstract class MapPartyRoleList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return partyRoleList 
	*/
	public List<? extends PartyRole> evaluate(DataDocument fpmlDataDocument) {
		List<PartyRole.PartyRoleBuilder> partyRoleListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PartyRole> partyRoleList;
		if (partyRoleListBuilder == null) {
			partyRoleList = null;
		} else {
			partyRoleList = partyRoleListBuilder.stream().map(PartyRole::build).collect(Collectors.toList());
			objectValidator.validate(PartyRole.class, partyRoleList);
		}
		
		return partyRoleList;
	}

	protected abstract List<PartyRole.PartyRoleBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPartyRoleListDefault extends MapPartyRoleList {
		@Override
		protected List<PartyRole.PartyRoleBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PartyRole.PartyRoleBuilder> partyRoleList = new ArrayList<>();
			return assignOutput(partyRoleList, fpmlDataDocument);
		}
		
		protected List<PartyRole.PartyRoleBuilder> assignOutput(List<PartyRole.PartyRoleBuilder> partyRoleList, DataDocument fpmlDataDocument) {
			partyRoleList.addAll(toBuilder(MapperC.<PartyRole>of(MapperS.of(PartyRole.builder()
				.setPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setRole(null)
				.setOwnershipPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(partyRoleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

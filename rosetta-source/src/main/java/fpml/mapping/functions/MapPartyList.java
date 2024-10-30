package fpml.mapping.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party.PartyBuilder;
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


@ImplementedBy(MapPartyList.MapPartyListDefault.class)
public abstract class MapPartyList implements RosettaFunction {
	
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
	* @return partyList 
	*/
	public List<? extends Party> evaluate(DataDocument fpmlDataDocument) {
		List<Party.PartyBuilder> partyListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Party> partyList;
		if (partyListBuilder == null) {
			partyList = null;
		} else {
			partyList = partyListBuilder.stream().map(Party::build).collect(Collectors.toList());
			objectValidator.validate(Party.class, partyList);
		}
		
		return partyList;
	}

	protected abstract List<Party.PartyBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPartyListDefault extends MapPartyList {
		@Override
		protected List<Party.PartyBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Party.PartyBuilder> partyList = new ArrayList<>();
			return assignOutput(partyList, fpmlDataDocument);
		}
		
		protected List<Party.PartyBuilder> assignOutput(List<Party.PartyBuilder> partyList, DataDocument fpmlDataDocument) {
			partyList.addAll(toBuilder(MapperC.<Party>of(MapperS.of(Party.builder()
				.setPartyId(new ArrayList(mapPartyIdentifierList.evaluate(fpmlDataDocument)))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setBusinessUnit(new ArrayList(mapBusinessUnitList.evaluate(fpmlDataDocument)))
				.setPerson(new ArrayList(mapNaturalPersonList.evaluate(fpmlDataDocument)))
				.setPersonRole(new ArrayList(mapNaturalPersonRoleList.evaluate(fpmlDataDocument)))
				.setAccount(mapAccount.evaluate(fpmlDataDocument))
				.setContactInformation(mapContactInformation.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(partyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

package fpml.mapping.functions;

import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifier.PartyIdentifierBuilder;
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


@ImplementedBy(MapPartyIdentifierList.MapPartyIdentifierListDefault.class)
public abstract class MapPartyIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIdentifierWithScheme mapIdentifierWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return partyIdentifierList 
	*/
	public List<? extends PartyIdentifier> evaluate(DataDocument fpmlDataDocument) {
		List<PartyIdentifier.PartyIdentifierBuilder> partyIdentifierListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PartyIdentifier> partyIdentifierList;
		if (partyIdentifierListBuilder == null) {
			partyIdentifierList = null;
		} else {
			partyIdentifierList = partyIdentifierListBuilder.stream().map(PartyIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(PartyIdentifier.class, partyIdentifierList);
		}
		
		return partyIdentifierList;
	}

	protected abstract List<PartyIdentifier.PartyIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPartyIdentifierListDefault extends MapPartyIdentifierList {
		@Override
		protected List<PartyIdentifier.PartyIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PartyIdentifier.PartyIdentifierBuilder> partyIdentifierList = new ArrayList<>();
			return assignOutput(partyIdentifierList, fpmlDataDocument);
		}
		
		protected List<PartyIdentifier.PartyIdentifierBuilder> assignOutput(List<PartyIdentifier.PartyIdentifierBuilder> partyIdentifierList, DataDocument fpmlDataDocument) {
			partyIdentifierList.addAll(toBuilder(MapperC.<PartyIdentifier>of(MapperS.of(PartyIdentifier.builder()
				.setIdentifierValue(mapIdentifierWithScheme.evaluate(fpmlDataDocument))
				.setIdentifierType(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(partyIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

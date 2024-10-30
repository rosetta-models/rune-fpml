package fpml.mapping.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryParty.AncillaryPartyBuilder;
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


@ImplementedBy(MapAncillaryPartyList.MapAncillaryPartyListDefault.class)
public abstract class MapAncillaryPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPartyList mapPartyList;

	/**
	* @param fpmlDataDocument 
	* @return ancillaryPartyList 
	*/
	public List<? extends AncillaryParty> evaluate(DataDocument fpmlDataDocument) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AncillaryParty> ancillaryPartyList;
		if (ancillaryPartyListBuilder == null) {
			ancillaryPartyList = null;
		} else {
			ancillaryPartyList = ancillaryPartyListBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryPartyList);
		}
		
		return ancillaryPartyList;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAncillaryPartyListDefault extends MapAncillaryPartyList {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList = new ArrayList<>();
			return assignOutput(ancillaryPartyList, fpmlDataDocument);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList, DataDocument fpmlDataDocument) {
			ancillaryPartyList.addAll(toBuilder(MapperC.<AncillaryParty>of(MapperS.of(AncillaryParty.builder()
				.setRole(null)
				.setPartyReferenceValue(new ArrayList(mapPartyList.evaluate(fpmlDataDocument)))
				.setOnBehalfOf(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(ancillaryPartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

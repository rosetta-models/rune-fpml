package fpml.mapping.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Counterparty.CounterpartyBuilder;
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


@ImplementedBy(MapCounterpartyList.MapCounterpartyListDefault.class)
public abstract class MapCounterpartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return counterpartyList 
	*/
	public List<? extends Counterparty> evaluate(DataDocument fpmlDataDocument) {
		List<Counterparty.CounterpartyBuilder> counterpartyListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Counterparty> counterpartyList;
		if (counterpartyListBuilder == null) {
			counterpartyList = null;
		} else {
			counterpartyList = counterpartyListBuilder.stream().map(Counterparty::build).collect(Collectors.toList());
			objectValidator.validate(Counterparty.class, counterpartyList);
		}
		
		return counterpartyList;
	}

	protected abstract List<Counterparty.CounterpartyBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCounterpartyListDefault extends MapCounterpartyList {
		@Override
		protected List<Counterparty.CounterpartyBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Counterparty.CounterpartyBuilder> counterpartyList = new ArrayList<>();
			return assignOutput(counterpartyList, fpmlDataDocument);
		}
		
		protected List<Counterparty.CounterpartyBuilder> assignOutput(List<Counterparty.CounterpartyBuilder> counterpartyList, DataDocument fpmlDataDocument) {
			counterpartyList.addAll(toBuilder(MapperC.<Counterparty>of(MapperS.of(Counterparty.builder()
				.setRole(null)
				.setPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(counterpartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

package fpml.mapping.functions;

import cdm.event.common.TradeIdentifier;
import cdm.event.common.TradeIdentifier.TradeIdentifierBuilder;
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


@ImplementedBy(MapTradeIdentifierList.MapTradeIdentifierListDefault.class)
public abstract class MapTradeIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssignedIdentifierList mapAssignedIdentifierList;
	@Inject protected MapIssuerWithScheme mapIssuerWithScheme;
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return tradeIdentifierList 
	*/
	public List<? extends TradeIdentifier> evaluate(DataDocument fpmlDataDocument) {
		List<TradeIdentifier.TradeIdentifierBuilder> tradeIdentifierListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends TradeIdentifier> tradeIdentifierList;
		if (tradeIdentifierListBuilder == null) {
			tradeIdentifierList = null;
		} else {
			tradeIdentifierList = tradeIdentifierListBuilder.stream().map(TradeIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(TradeIdentifier.class, tradeIdentifierList);
		}
		
		return tradeIdentifierList;
	}

	protected abstract List<TradeIdentifier.TradeIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTradeIdentifierListDefault extends MapTradeIdentifierList {
		@Override
		protected List<TradeIdentifier.TradeIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<TradeIdentifier.TradeIdentifierBuilder> tradeIdentifierList = new ArrayList<>();
			return assignOutput(tradeIdentifierList, fpmlDataDocument);
		}
		
		protected List<TradeIdentifier.TradeIdentifierBuilder> assignOutput(List<TradeIdentifier.TradeIdentifierBuilder> tradeIdentifierList, DataDocument fpmlDataDocument) {
			tradeIdentifierList.addAll(toBuilder(MapperC.<TradeIdentifier>of(MapperS.of(TradeIdentifier.builder()
				.setIssuerReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setIssuerValue(mapIssuerWithScheme.evaluate(fpmlDataDocument))
				.setAssignedIdentifier(new ArrayList(mapAssignedIdentifierList.evaluate(fpmlDataDocument)))
				.setIdentifierType(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(tradeIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

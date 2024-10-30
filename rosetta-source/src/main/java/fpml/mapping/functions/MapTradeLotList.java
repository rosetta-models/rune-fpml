package fpml.mapping.functions;

import cdm.product.template.TradeLot;
import cdm.product.template.TradeLot.TradeLotBuilder;
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


@ImplementedBy(MapTradeLotList.MapTradeLotListDefault.class)
public abstract class MapTradeLotList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIdentifierList mapIdentifierList;
	@Inject protected MapPriceQuantityList mapPriceQuantityList;

	/**
	* @param fpmlDataDocument 
	* @return tradeLotList 
	*/
	public List<? extends TradeLot> evaluate(DataDocument fpmlDataDocument) {
		List<TradeLot.TradeLotBuilder> tradeLotListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends TradeLot> tradeLotList;
		if (tradeLotListBuilder == null) {
			tradeLotList = null;
		} else {
			tradeLotList = tradeLotListBuilder.stream().map(TradeLot::build).collect(Collectors.toList());
			objectValidator.validate(TradeLot.class, tradeLotList);
		}
		
		return tradeLotList;
	}

	protected abstract List<TradeLot.TradeLotBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTradeLotListDefault extends MapTradeLotList {
		@Override
		protected List<TradeLot.TradeLotBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<TradeLot.TradeLotBuilder> tradeLotList = new ArrayList<>();
			return assignOutput(tradeLotList, fpmlDataDocument);
		}
		
		protected List<TradeLot.TradeLotBuilder> assignOutput(List<TradeLot.TradeLotBuilder> tradeLotList, DataDocument fpmlDataDocument) {
			tradeLotList.addAll(toBuilder(MapperC.<TradeLot>of(MapperS.of(TradeLot.builder()
				.setLotIdentifier(new ArrayList(mapIdentifierList.evaluate(fpmlDataDocument)))
				.setPriceQuantity(new ArrayList(mapPriceQuantityList.evaluate(fpmlDataDocument)))
				.build())).getMulti()));
			
			return Optional.ofNullable(tradeLotList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

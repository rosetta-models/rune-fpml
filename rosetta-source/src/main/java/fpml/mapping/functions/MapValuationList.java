package fpml.mapping.functions;

import cdm.event.common.Valuation;
import cdm.event.common.Valuation.ValuationBuilder;
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


@ImplementedBy(MapValuationList.MapValuationListDefault.class)
public abstract class MapValuationList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoney mapMoney;
	@Inject protected MapPrice mapPrice;

	/**
	* @param fpmlDataDocument 
	* @return valuationList 
	*/
	public List<? extends Valuation> evaluate(DataDocument fpmlDataDocument) {
		List<Valuation.ValuationBuilder> valuationListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Valuation> valuationList;
		if (valuationListBuilder == null) {
			valuationList = null;
		} else {
			valuationList = valuationListBuilder.stream().map(Valuation::build).collect(Collectors.toList());
			objectValidator.validate(Valuation.class, valuationList);
		}
		
		return valuationList;
	}

	protected abstract List<Valuation.ValuationBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapValuationListDefault extends MapValuationList {
		@Override
		protected List<Valuation.ValuationBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Valuation.ValuationBuilder> valuationList = new ArrayList<>();
			return assignOutput(valuationList, fpmlDataDocument);
		}
		
		protected List<Valuation.ValuationBuilder> assignOutput(List<Valuation.ValuationBuilder> valuationList, DataDocument fpmlDataDocument) {
			valuationList.addAll(toBuilder(MapperC.<Valuation>of(MapperS.of(Valuation.builder()
				.setAmount(mapMoney.evaluate(fpmlDataDocument))
				.setTimestamp(null)
				.setMethod(null)
				.setSource(null)
				.setDelta(null)
				.setValuationTiming(null)
				.setPriceComponent(mapPrice.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(valuationList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

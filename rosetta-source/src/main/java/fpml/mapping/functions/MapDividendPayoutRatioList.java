package fpml.mapping.functions;

import cdm.product.asset.DividendPayoutRatio;
import cdm.product.asset.DividendPayoutRatio.DividendPayoutRatioBuilder;
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


@ImplementedBy(MapDividendPayoutRatioList.MapDividendPayoutRatioListDefault.class)
public abstract class MapDividendPayoutRatioList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBasketConstituent mapBasketConstituent;

	/**
	* @param fpmlDataDocument 
	* @return dividendPayoutRatioList 
	*/
	public List<? extends DividendPayoutRatio> evaluate(DataDocument fpmlDataDocument) {
		List<DividendPayoutRatio.DividendPayoutRatioBuilder> dividendPayoutRatioListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends DividendPayoutRatio> dividendPayoutRatioList;
		if (dividendPayoutRatioListBuilder == null) {
			dividendPayoutRatioList = null;
		} else {
			dividendPayoutRatioList = dividendPayoutRatioListBuilder.stream().map(DividendPayoutRatio::build).collect(Collectors.toList());
			objectValidator.validate(DividendPayoutRatio.class, dividendPayoutRatioList);
		}
		
		return dividendPayoutRatioList;
	}

	protected abstract List<DividendPayoutRatio.DividendPayoutRatioBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDividendPayoutRatioListDefault extends MapDividendPayoutRatioList {
		@Override
		protected List<DividendPayoutRatio.DividendPayoutRatioBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<DividendPayoutRatio.DividendPayoutRatioBuilder> dividendPayoutRatioList = new ArrayList<>();
			return assignOutput(dividendPayoutRatioList, fpmlDataDocument);
		}
		
		protected List<DividendPayoutRatio.DividendPayoutRatioBuilder> assignOutput(List<DividendPayoutRatio.DividendPayoutRatioBuilder> dividendPayoutRatioList, DataDocument fpmlDataDocument) {
			dividendPayoutRatioList.addAll(toBuilder(MapperC.<DividendPayoutRatio>of(MapperS.of(DividendPayoutRatio.builder()
				.setTotalRatio(null)
				.setCashRatio(null)
				.setNonCashRatio(null)
				.setBasketConstituentValue(mapBasketConstituent.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(dividendPayoutRatioList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

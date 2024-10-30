package fpml.mapping.functions;

import cdm.product.asset.DividendPeriod;
import cdm.product.asset.DividendPeriod.DividendPeriodBuilder;
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


@ImplementedBy(MapDividendPeriodList.MapDividendPeriodListDefault.class)
public abstract class MapDividendPeriodList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBasketConstituent mapBasketConstituent;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapDividendPaymentDate mapDividendPaymentDate;

	/**
	* @param fpmlDataDocument 
	* @return dividendPeriodList 
	*/
	public List<? extends DividendPeriod> evaluate(DataDocument fpmlDataDocument) {
		List<DividendPeriod.DividendPeriodBuilder> dividendPeriodListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends DividendPeriod> dividendPeriodList;
		if (dividendPeriodListBuilder == null) {
			dividendPeriodList = null;
		} else {
			dividendPeriodList = dividendPeriodListBuilder.stream().map(DividendPeriod::build).collect(Collectors.toList());
			objectValidator.validate(DividendPeriod.class, dividendPeriodList);
		}
		
		return dividendPeriodList;
	}

	protected abstract List<DividendPeriod.DividendPeriodBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDividendPeriodListDefault extends MapDividendPeriodList {
		@Override
		protected List<DividendPeriod.DividendPeriodBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<DividendPeriod.DividendPeriodBuilder> dividendPeriodList = new ArrayList<>();
			return assignOutput(dividendPeriodList, fpmlDataDocument);
		}
		
		protected List<DividendPeriod.DividendPeriodBuilder> assignOutput(List<DividendPeriod.DividendPeriodBuilder> dividendPeriodList, DataDocument fpmlDataDocument) {
			dividendPeriodList.addAll(toBuilder(MapperC.<DividendPeriod>of(MapperS.of(DividendPeriod.builder()
				.setStartDate(mapDividendPaymentDate.evaluate(fpmlDataDocument))
				.setEndDate(mapDividendPaymentDate.evaluate(fpmlDataDocument))
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setBasketConstituentValue(mapBasketConstituent.evaluate(fpmlDataDocument))
				.setDividendPaymentDate(mapDividendPaymentDate.evaluate(fpmlDataDocument))
				.setDividendValuationDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(dividendPeriodList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

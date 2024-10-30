package fpml.mapping.functions;

import cdm.product.common.schedule.CalculationPeriod;
import cdm.product.common.schedule.CalculationPeriod.CalculationPeriodBuilder;
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


@ImplementedBy(MapCalculationPeriodList.MapCalculationPeriodListDefault.class)
public abstract class MapCalculationPeriodList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFloatingRateDefinition mapFloatingRateDefinition;
	@Inject protected MapFxLinkedNotionalAmount mapFxLinkedNotionalAmount;
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return calculationPeriodList 
	*/
	public List<? extends CalculationPeriod> evaluate(DataDocument fpmlDataDocument) {
		List<CalculationPeriod.CalculationPeriodBuilder> calculationPeriodListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CalculationPeriod> calculationPeriodList;
		if (calculationPeriodListBuilder == null) {
			calculationPeriodList = null;
		} else {
			calculationPeriodList = calculationPeriodListBuilder.stream().map(CalculationPeriod::build).collect(Collectors.toList());
			objectValidator.validate(CalculationPeriod.class, calculationPeriodList);
		}
		
		return calculationPeriodList;
	}

	protected abstract List<CalculationPeriod.CalculationPeriodBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCalculationPeriodListDefault extends MapCalculationPeriodList {
		@Override
		protected List<CalculationPeriod.CalculationPeriodBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CalculationPeriod.CalculationPeriodBuilder> calculationPeriodList = new ArrayList<>();
			return assignOutput(calculationPeriodList, fpmlDataDocument);
		}
		
		protected List<CalculationPeriod.CalculationPeriodBuilder> assignOutput(List<CalculationPeriod.CalculationPeriodBuilder> calculationPeriodList, DataDocument fpmlDataDocument) {
			calculationPeriodList.addAll(toBuilder(MapperC.<CalculationPeriod>of(MapperS.of(CalculationPeriod.builder()
				.setAdjustedStartDate(null)
				.setAdjustedEndDate(null)
				.setUnadjustedStartDate(null)
				.setUnadjustedEndDate(null)
				.setCalculationPeriodNumberOfDays(null)
				.setNotionalAmount(null)
				.setFxLinkedNotionalAmount(mapFxLinkedNotionalAmount.evaluate(fpmlDataDocument))
				.setFloatingRateDefinition(mapFloatingRateDefinition.evaluate(fpmlDataDocument))
				.setFixedRate(null)
				.setDayCountYearFraction(null)
				.setForecastAmount(mapMoney.evaluate(fpmlDataDocument))
				.setForecastRate(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(calculationPeriodList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

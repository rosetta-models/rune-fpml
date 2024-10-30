package fpml.mapping.functions;

import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.CalculationPeriodDates.CalculationPeriodDatesBuilder;
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


@ImplementedBy(MapCalculationPeriodDatesList.MapCalculationPeriodDatesListDefault.class)
public abstract class MapCalculationPeriodDatesList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapCalculationPeriodFrequency mapCalculationPeriodFrequency;

	/**
	* @param fpmlDataDocument 
	* @return calculationPeriodDatesList 
	*/
	public List<? extends CalculationPeriodDates> evaluate(DataDocument fpmlDataDocument) {
		List<CalculationPeriodDates.CalculationPeriodDatesBuilder> calculationPeriodDatesListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CalculationPeriodDates> calculationPeriodDatesList;
		if (calculationPeriodDatesListBuilder == null) {
			calculationPeriodDatesList = null;
		} else {
			calculationPeriodDatesList = calculationPeriodDatesListBuilder.stream().map(CalculationPeriodDates::build).collect(Collectors.toList());
			objectValidator.validate(CalculationPeriodDates.class, calculationPeriodDatesList);
		}
		
		return calculationPeriodDatesList;
	}

	protected abstract List<CalculationPeriodDates.CalculationPeriodDatesBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCalculationPeriodDatesListDefault extends MapCalculationPeriodDatesList {
		@Override
		protected List<CalculationPeriodDates.CalculationPeriodDatesBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CalculationPeriodDates.CalculationPeriodDatesBuilder> calculationPeriodDatesList = new ArrayList<>();
			return assignOutput(calculationPeriodDatesList, fpmlDataDocument);
		}
		
		protected List<CalculationPeriodDates.CalculationPeriodDatesBuilder> assignOutput(List<CalculationPeriodDates.CalculationPeriodDatesBuilder> calculationPeriodDatesList, DataDocument fpmlDataDocument) {
			calculationPeriodDatesList.addAll(toBuilder(MapperC.<CalculationPeriodDates>of(MapperS.of(CalculationPeriodDates.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setCalculationPeriodDatesAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setFirstPeriodStartDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setFirstRegularPeriodStartDate(null)
				.setFirstCompoundingPeriodEndDate(null)
				.setLastRegularPeriodEndDate(null)
				.setStubPeriodType(null)
				.setCalculationPeriodFrequency(mapCalculationPeriodFrequency.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(calculationPeriodDatesList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

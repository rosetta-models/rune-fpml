package fpml.mapping.functions;

import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.CalculationPeriodDates.CalculationPeriodDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCalculationPeriodDates.MapCalculationPeriodDatesDefault.class)
public abstract class MapCalculationPeriodDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapCalculationPeriodFrequency mapCalculationPeriodFrequency;

	/**
	* @param fpmlDataDocument 
	* @return calculationPeriodDates 
	*/
	public CalculationPeriodDates evaluate(DataDocument fpmlDataDocument) {
		CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final CalculationPeriodDates calculationPeriodDates;
		if (calculationPeriodDatesBuilder == null) {
			calculationPeriodDates = null;
		} else {
			calculationPeriodDates = calculationPeriodDatesBuilder.build();
			objectValidator.validate(CalculationPeriodDates.class, calculationPeriodDates);
		}
		
		return calculationPeriodDates;
	}

	protected abstract CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCalculationPeriodDatesDefault extends MapCalculationPeriodDates {
		@Override
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates = CalculationPeriodDates.builder();
			return assignOutput(calculationPeriodDates, fpmlDataDocument);
		}
		
		protected CalculationPeriodDates.CalculationPeriodDatesBuilder assignOutput(CalculationPeriodDates.CalculationPeriodDatesBuilder calculationPeriodDates, DataDocument fpmlDataDocument) {
			calculationPeriodDates = toBuilder(CalculationPeriodDates.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setCalculationPeriodDatesAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setFirstPeriodStartDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setFirstRegularPeriodStartDate(null)
				.setFirstCompoundingPeriodEndDate(null)
				.setLastRegularPeriodEndDate(null)
				.setStubPeriodType(null)
				.setCalculationPeriodFrequency(mapCalculationPeriodFrequency.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(calculationPeriodDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

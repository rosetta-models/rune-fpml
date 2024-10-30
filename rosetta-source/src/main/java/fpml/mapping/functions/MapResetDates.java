package fpml.mapping.functions;

import cdm.product.common.schedule.ResetDates;
import cdm.product.common.schedule.ResetDates.ResetDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapResetDates.MapResetDatesDefault.class)
public abstract class MapResetDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapCalculationPeriodDates mapCalculationPeriodDates;
	@Inject protected MapInitialFixingDate mapInitialFixingDate;
	@Inject protected MapOffset mapOffset;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;
	@Inject protected MapResetFrequency mapResetFrequency;

	/**
	* @param fpmlDataDocument 
	* @return resetDates 
	*/
	public ResetDates evaluate(DataDocument fpmlDataDocument) {
		ResetDates.ResetDatesBuilder resetDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final ResetDates resetDates;
		if (resetDatesBuilder == null) {
			resetDates = null;
		} else {
			resetDates = resetDatesBuilder.build();
			objectValidator.validate(ResetDates.class, resetDates);
		}
		
		return resetDates;
	}

	protected abstract ResetDates.ResetDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapResetDatesDefault extends MapResetDates {
		@Override
		protected ResetDates.ResetDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ResetDates.ResetDatesBuilder resetDates = ResetDates.builder();
			return assignOutput(resetDates, fpmlDataDocument);
		}
		
		protected ResetDates.ResetDatesBuilder assignOutput(ResetDates.ResetDatesBuilder resetDates, DataDocument fpmlDataDocument) {
			resetDates = toBuilder(ResetDates.builder()
				.setCalculationPeriodDatesReferenceValue(mapCalculationPeriodDates.evaluate(fpmlDataDocument))
				.setResetRelativeTo(null)
				.setInitialFixingDate(mapInitialFixingDate.evaluate(fpmlDataDocument))
				.setFixingDates(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.setFinalFixingDate(mapAdjustableDate.evaluate(fpmlDataDocument))
				.setRateCutOffDaysOffset(mapOffset.evaluate(fpmlDataDocument))
				.setResetFrequency(mapResetFrequency.evaluate(fpmlDataDocument))
				.setResetDatesAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(resetDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

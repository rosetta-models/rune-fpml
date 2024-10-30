package fpml.mapping.functions;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableRelativeOrPeriodicDates.MapAdjustableRelativeOrPeriodicDatesDefault.class)
public abstract class MapAdjustableRelativeOrPeriodicDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDates mapAdjustableDates;
	@Inject protected MapPeriodicDates mapPeriodicDates;
	@Inject protected MapRelativeDates mapRelativeDates;

	/**
	* @param fpmlDataDocument 
	* @return adjustableRelativeOrPeriodicDates 
	*/
	public AdjustableRelativeOrPeriodicDates evaluate(DataDocument fpmlDataDocument) {
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates;
		if (adjustableRelativeOrPeriodicDatesBuilder == null) {
			adjustableRelativeOrPeriodicDates = null;
		} else {
			adjustableRelativeOrPeriodicDates = adjustableRelativeOrPeriodicDatesBuilder.build();
			objectValidator.validate(AdjustableRelativeOrPeriodicDates.class, adjustableRelativeOrPeriodicDates);
		}
		
		return adjustableRelativeOrPeriodicDates;
	}

	protected abstract AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustableRelativeOrPeriodicDatesDefault extends MapAdjustableRelativeOrPeriodicDates {
		@Override
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates = AdjustableRelativeOrPeriodicDates.builder();
			return assignOutput(adjustableRelativeOrPeriodicDates, fpmlDataDocument);
		}
		
		protected AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder assignOutput(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder adjustableRelativeOrPeriodicDates, DataDocument fpmlDataDocument) {
			adjustableRelativeOrPeriodicDates = toBuilder(AdjustableRelativeOrPeriodicDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(fpmlDataDocument))
				.setRelativeDates(mapRelativeDates.evaluate(fpmlDataDocument))
				.setPeriodicDates(mapPeriodicDates.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(adjustableRelativeOrPeriodicDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

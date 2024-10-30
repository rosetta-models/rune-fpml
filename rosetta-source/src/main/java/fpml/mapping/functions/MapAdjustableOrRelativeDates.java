package fpml.mapping.functions;

import cdm.base.datetime.AdjustableOrRelativeDates;
import cdm.base.datetime.AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableOrRelativeDates.MapAdjustableOrRelativeDatesDefault.class)
public abstract class MapAdjustableOrRelativeDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDates mapAdjustableDates;
	@Inject protected MapRelativeDates mapRelativeDates;

	/**
	* @param fpmlDataDocument 
	* @return adjustableOrRelativeDates 
	*/
	public AdjustableOrRelativeDates evaluate(DataDocument fpmlDataDocument) {
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder adjustableOrRelativeDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final AdjustableOrRelativeDates adjustableOrRelativeDates;
		if (adjustableOrRelativeDatesBuilder == null) {
			adjustableOrRelativeDates = null;
		} else {
			adjustableOrRelativeDates = adjustableOrRelativeDatesBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDates.class, adjustableOrRelativeDates);
		}
		
		return adjustableOrRelativeDates;
	}

	protected abstract AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustableOrRelativeDatesDefault extends MapAdjustableOrRelativeDates {
		@Override
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder adjustableOrRelativeDates = AdjustableOrRelativeDates.builder();
			return assignOutput(adjustableOrRelativeDates, fpmlDataDocument);
		}
		
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder assignOutput(AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder adjustableOrRelativeDates, DataDocument fpmlDataDocument) {
			adjustableOrRelativeDates = toBuilder(AdjustableOrRelativeDates.builder()
				.setAdjustableDates(mapAdjustableDates.evaluate(fpmlDataDocument))
				.setRelativeDates(mapRelativeDates.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(adjustableOrRelativeDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

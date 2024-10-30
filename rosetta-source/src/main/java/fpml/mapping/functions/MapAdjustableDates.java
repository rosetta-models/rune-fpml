package fpml.mapping.functions;

import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.AdjustableDates.AdjustableDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.DataDocument;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableDates.MapAdjustableDatesDefault.class)
public abstract class MapAdjustableDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;

	/**
	* @param fpmlDataDocument 
	* @return adjustableDates 
	*/
	public AdjustableDates evaluate(DataDocument fpmlDataDocument) {
		AdjustableDates.AdjustableDatesBuilder adjustableDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final AdjustableDates adjustableDates;
		if (adjustableDatesBuilder == null) {
			adjustableDates = null;
		} else {
			adjustableDates = adjustableDatesBuilder.build();
			objectValidator.validate(AdjustableDates.class, adjustableDates);
		}
		
		return adjustableDates;
	}

	protected abstract AdjustableDates.AdjustableDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustableDatesDefault extends MapAdjustableDates {
		@Override
		protected AdjustableDates.AdjustableDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AdjustableDates.AdjustableDatesBuilder adjustableDates = AdjustableDates.builder();
			return assignOutput(adjustableDates, fpmlDataDocument);
		}
		
		protected AdjustableDates.AdjustableDatesBuilder assignOutput(AdjustableDates.AdjustableDatesBuilder adjustableDates, DataDocument fpmlDataDocument) {
			adjustableDates = toBuilder(AdjustableDates.builder()
				.setUnadjustedDate(Collections.<Date>emptyList())
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setAdjustedDateValue(Collections.<Date>emptyList())
				.build());
			
			return Optional.ofNullable(adjustableDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

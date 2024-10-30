package fpml.mapping.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableDate.AdjustableDateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableDate.MapAdjustableDateDefault.class)
public abstract class MapAdjustableDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;

	/**
	* @param fpmlDataDocument 
	* @return adjustableDate 
	*/
	public AdjustableDate evaluate(DataDocument fpmlDataDocument) {
		AdjustableDate.AdjustableDateBuilder adjustableDateBuilder = doEvaluate(fpmlDataDocument);
		
		final AdjustableDate adjustableDate;
		if (adjustableDateBuilder == null) {
			adjustableDate = null;
		} else {
			adjustableDate = adjustableDateBuilder.build();
			objectValidator.validate(AdjustableDate.class, adjustableDate);
		}
		
		return adjustableDate;
	}

	protected abstract AdjustableDate.AdjustableDateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustableDateDefault extends MapAdjustableDate {
		@Override
		protected AdjustableDate.AdjustableDateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AdjustableDate.AdjustableDateBuilder adjustableDate = AdjustableDate.builder();
			return assignOutput(adjustableDate, fpmlDataDocument);
		}
		
		protected AdjustableDate.AdjustableDateBuilder assignOutput(AdjustableDate.AdjustableDateBuilder adjustableDate, DataDocument fpmlDataDocument) {
			adjustableDate = toBuilder(AdjustableDate.builder()
				.setUnadjustedDate(null)
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setDateAdjustmentsReferenceValue(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setAdjustedDateValue(null)
				.build());
			
			return Optional.ofNullable(adjustableDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

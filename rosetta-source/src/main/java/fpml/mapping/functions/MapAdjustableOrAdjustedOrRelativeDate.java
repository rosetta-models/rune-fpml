package fpml.mapping.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableOrAdjustedOrRelativeDate.MapAdjustableOrAdjustedOrRelativeDateDefault.class)
public abstract class MapAdjustableOrAdjustedOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlDataDocument 
	* @return adjustableOrAdjustedOrRelativeDate 
	*/
	public AdjustableOrAdjustedOrRelativeDate evaluate(DataDocument fpmlDataDocument) {
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDateBuilder = doEvaluate(fpmlDataDocument);
		
		final AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate;
		if (adjustableOrAdjustedOrRelativeDateBuilder == null) {
			adjustableOrAdjustedOrRelativeDate = null;
		} else {
			adjustableOrAdjustedOrRelativeDate = adjustableOrAdjustedOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrAdjustedOrRelativeDate.class, adjustableOrAdjustedOrRelativeDate);
		}
		
		return adjustableOrAdjustedOrRelativeDate;
	}

	protected abstract AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustableOrAdjustedOrRelativeDateDefault extends MapAdjustableOrAdjustedOrRelativeDate {
		@Override
		protected AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDate = AdjustableOrAdjustedOrRelativeDate.builder();
			return assignOutput(adjustableOrAdjustedOrRelativeDate, fpmlDataDocument);
		}
		
		protected AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder assignOutput(AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDate, DataDocument fpmlDataDocument) {
			adjustableOrAdjustedOrRelativeDate = toBuilder(AdjustableOrAdjustedOrRelativeDate.builder()
				.setUnadjustedDate(null)
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setAdjustedDateValue(null)
				.setRelativeDate(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(adjustableOrAdjustedOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

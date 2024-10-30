package fpml.mapping.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustableOrRelativeDate.MapAdjustableOrRelativeDateDefault.class)
public abstract class MapAdjustableOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapAdjustedRelativeDateOffset mapAdjustedRelativeDateOffset;

	/**
	* @param fpmlDataDocument 
	* @return adjustableOrRelativeDate 
	*/
	public AdjustableOrRelativeDate evaluate(DataDocument fpmlDataDocument) {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDateBuilder = doEvaluate(fpmlDataDocument);
		
		final AdjustableOrRelativeDate adjustableOrRelativeDate;
		if (adjustableOrRelativeDateBuilder == null) {
			adjustableOrRelativeDate = null;
		} else {
			adjustableOrRelativeDate = adjustableOrRelativeDateBuilder.build();
			objectValidator.validate(AdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		}
		
		return adjustableOrRelativeDate;
	}

	protected abstract AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustableOrRelativeDateDefault extends MapAdjustableOrRelativeDate {
		@Override
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate = AdjustableOrRelativeDate.builder();
			return assignOutput(adjustableOrRelativeDate, fpmlDataDocument);
		}
		
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder assignOutput(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate, DataDocument fpmlDataDocument) {
			adjustableOrRelativeDate = toBuilder(AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapAdjustableDate.evaluate(fpmlDataDocument))
				.setRelativeDate(mapAdjustedRelativeDateOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(adjustableOrRelativeDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

package fpml.mapping.functions;

import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.base.datetime.AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAdjustedRelativeDateOffset.MapAdjustedRelativeDateOffsetDefault.class)
public abstract class MapAdjustedRelativeDateOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;

	/**
	* @param fpmlDataDocument 
	* @return adjustedRelativeDateOffset 
	*/
	public AdjustedRelativeDateOffset evaluate(DataDocument fpmlDataDocument) {
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffsetBuilder = doEvaluate(fpmlDataDocument);
		
		final AdjustedRelativeDateOffset adjustedRelativeDateOffset;
		if (adjustedRelativeDateOffsetBuilder == null) {
			adjustedRelativeDateOffset = null;
		} else {
			adjustedRelativeDateOffset = adjustedRelativeDateOffsetBuilder.build();
			objectValidator.validate(AdjustedRelativeDateOffset.class, adjustedRelativeDateOffset);
		}
		
		return adjustedRelativeDateOffset;
	}

	protected abstract AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustedRelativeDateOffsetDefault extends MapAdjustedRelativeDateOffset {
		@Override
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffset = AdjustedRelativeDateOffset.builder();
			return assignOutput(adjustedRelativeDateOffset, fpmlDataDocument);
		}
		
		protected AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder assignOutput(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder adjustedRelativeDateOffset, DataDocument fpmlDataDocument) {
			adjustedRelativeDateOffset = toBuilder(AdjustedRelativeDateOffset.builder()
				.setPeriodMultiplier(null)
				.setPeriod(null)
				.setDayType(null)
				.setBusinessDayConvention(null)
				.setBusinessCenters(mapBusinessCenters.evaluate(fpmlDataDocument))
				.setBusinessCentersReferenceValue(mapBusinessCenters.evaluate(fpmlDataDocument))
				.setDateRelativeToValue(null)
				.setAdjustedDate(null)
				.setRelativeDateAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(adjustedRelativeDateOffset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

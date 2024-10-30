package fpml.mapping.functions;

import cdm.base.datetime.RelativeDateOffset;
import cdm.base.datetime.RelativeDateOffset.RelativeDateOffsetBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRelativeDateOffset.MapRelativeDateOffsetDefault.class)
public abstract class MapRelativeDateOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;

	/**
	* @param fpmlDataDocument 
	* @return relativeDateOffset 
	*/
	public RelativeDateOffset evaluate(DataDocument fpmlDataDocument) {
		RelativeDateOffset.RelativeDateOffsetBuilder relativeDateOffsetBuilder = doEvaluate(fpmlDataDocument);
		
		final RelativeDateOffset relativeDateOffset;
		if (relativeDateOffsetBuilder == null) {
			relativeDateOffset = null;
		} else {
			relativeDateOffset = relativeDateOffsetBuilder.build();
			objectValidator.validate(RelativeDateOffset.class, relativeDateOffset);
		}
		
		return relativeDateOffset;
	}

	protected abstract RelativeDateOffset.RelativeDateOffsetBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRelativeDateOffsetDefault extends MapRelativeDateOffset {
		@Override
		protected RelativeDateOffset.RelativeDateOffsetBuilder doEvaluate(DataDocument fpmlDataDocument) {
			RelativeDateOffset.RelativeDateOffsetBuilder relativeDateOffset = RelativeDateOffset.builder();
			return assignOutput(relativeDateOffset, fpmlDataDocument);
		}
		
		protected RelativeDateOffset.RelativeDateOffsetBuilder assignOutput(RelativeDateOffset.RelativeDateOffsetBuilder relativeDateOffset, DataDocument fpmlDataDocument) {
			relativeDateOffset = toBuilder(RelativeDateOffset.builder()
				.setPeriodMultiplier(null)
				.setPeriod(null)
				.setDayType(null)
				.setBusinessDayConvention(null)
				.setBusinessCenters(mapBusinessCenters.evaluate(fpmlDataDocument))
				.setBusinessCentersReferenceValue(mapBusinessCenters.evaluate(fpmlDataDocument))
				.setDateRelativeToValue(null)
				.setAdjustedDate(null)
				.build());
			
			return Optional.ofNullable(relativeDateOffset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

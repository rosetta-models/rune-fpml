package fpml.mapping.functions;

import cdm.base.datetime.RelativeDates;
import cdm.base.datetime.RelativeDates.RelativeDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRelativeDates.MapRelativeDatesDefault.class)
public abstract class MapRelativeDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapDateRange mapDateRange;

	/**
	* @param fpmlDataDocument 
	* @return relativeDates 
	*/
	public RelativeDates evaluate(DataDocument fpmlDataDocument) {
		RelativeDates.RelativeDatesBuilder relativeDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final RelativeDates relativeDates;
		if (relativeDatesBuilder == null) {
			relativeDates = null;
		} else {
			relativeDates = relativeDatesBuilder.build();
			objectValidator.validate(RelativeDates.class, relativeDates);
		}
		
		return relativeDates;
	}

	protected abstract RelativeDates.RelativeDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRelativeDatesDefault extends MapRelativeDates {
		@Override
		protected RelativeDates.RelativeDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			RelativeDates.RelativeDatesBuilder relativeDates = RelativeDates.builder();
			return assignOutput(relativeDates, fpmlDataDocument);
		}
		
		protected RelativeDates.RelativeDatesBuilder assignOutput(RelativeDates.RelativeDatesBuilder relativeDates, DataDocument fpmlDataDocument) {
			relativeDates = toBuilder(RelativeDates.builder()
				.setPeriodMultiplier(null)
				.setPeriod(null)
				.setDayType(null)
				.setBusinessDayConvention(null)
				.setBusinessCenters(mapBusinessCenters.evaluate(fpmlDataDocument))
				.setBusinessCentersReferenceValue(mapBusinessCenters.evaluate(fpmlDataDocument))
				.setDateRelativeToValue(null)
				.setAdjustedDate(null)
				.setPeriodSkip(null)
				.setScheduleBounds(mapDateRange.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(relativeDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

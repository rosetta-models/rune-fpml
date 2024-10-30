package fpml.mapping.functions;

import cdm.base.datetime.PeriodRange;
import cdm.base.datetime.PeriodRange.PeriodRangeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPeriodRange.MapPeriodRangeDefault.class)
public abstract class MapPeriodRange implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriodBound mapPeriodBound;

	/**
	* @param fpmlDataDocument 
	* @return periodRange 
	*/
	public PeriodRange evaluate(DataDocument fpmlDataDocument) {
		PeriodRange.PeriodRangeBuilder periodRangeBuilder = doEvaluate(fpmlDataDocument);
		
		final PeriodRange periodRange;
		if (periodRangeBuilder == null) {
			periodRange = null;
		} else {
			periodRange = periodRangeBuilder.build();
			objectValidator.validate(PeriodRange.class, periodRange);
		}
		
		return periodRange;
	}

	protected abstract PeriodRange.PeriodRangeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPeriodRangeDefault extends MapPeriodRange {
		@Override
		protected PeriodRange.PeriodRangeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PeriodRange.PeriodRangeBuilder periodRange = PeriodRange.builder();
			return assignOutput(periodRange, fpmlDataDocument);
		}
		
		protected PeriodRange.PeriodRangeBuilder assignOutput(PeriodRange.PeriodRangeBuilder periodRange, DataDocument fpmlDataDocument) {
			periodRange = toBuilder(PeriodRange.builder()
				.setLowerBound(mapPeriodBound.evaluate(fpmlDataDocument))
				.setUpperBound(mapPeriodBound.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(periodRange)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

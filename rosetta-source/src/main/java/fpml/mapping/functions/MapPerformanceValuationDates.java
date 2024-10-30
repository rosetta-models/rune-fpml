package fpml.mapping.functions;

import cdm.observable.asset.PerformanceValuationDates;
import cdm.observable.asset.PerformanceValuationDates.PerformanceValuationDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPerformanceValuationDates.MapPerformanceValuationDatesDefault.class)
public abstract class MapPerformanceValuationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapAdjustableRelativeOrPeriodicDates mapAdjustableRelativeOrPeriodicDates;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;

	/**
	* @param fpmlDataDocument 
	* @return performanceValuationDates 
	*/
	public PerformanceValuationDates evaluate(DataDocument fpmlDataDocument) {
		PerformanceValuationDates.PerformanceValuationDatesBuilder performanceValuationDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final PerformanceValuationDates performanceValuationDates;
		if (performanceValuationDatesBuilder == null) {
			performanceValuationDates = null;
		} else {
			performanceValuationDates = performanceValuationDatesBuilder.build();
			objectValidator.validate(PerformanceValuationDates.class, performanceValuationDates);
		}
		
		return performanceValuationDates;
	}

	protected abstract PerformanceValuationDates.PerformanceValuationDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPerformanceValuationDatesDefault extends MapPerformanceValuationDates {
		@Override
		protected PerformanceValuationDates.PerformanceValuationDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PerformanceValuationDates.PerformanceValuationDatesBuilder performanceValuationDates = PerformanceValuationDates.builder();
			return assignOutput(performanceValuationDates, fpmlDataDocument);
		}
		
		protected PerformanceValuationDates.PerformanceValuationDatesBuilder assignOutput(PerformanceValuationDates.PerformanceValuationDatesBuilder performanceValuationDates, DataDocument fpmlDataDocument) {
			performanceValuationDates = toBuilder(PerformanceValuationDates.builder()
				.setDeterminationMethod(null)
				.setValuationDates(mapAdjustableRelativeOrPeriodicDates.evaluate(fpmlDataDocument))
				.setValuationDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setValuationTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setValuationTimeType(null)
				.build());
			
			return Optional.ofNullable(performanceValuationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

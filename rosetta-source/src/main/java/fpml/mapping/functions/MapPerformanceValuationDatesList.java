package fpml.mapping.functions;

import cdm.observable.asset.PerformanceValuationDates;
import cdm.observable.asset.PerformanceValuationDates.PerformanceValuationDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPerformanceValuationDatesList.MapPerformanceValuationDatesListDefault.class)
public abstract class MapPerformanceValuationDatesList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapAdjustableRelativeOrPeriodicDates mapAdjustableRelativeOrPeriodicDates;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;

	/**
	* @param fpmlDataDocument 
	* @return performanceValuationDatesList 
	*/
	public List<? extends PerformanceValuationDates> evaluate(DataDocument fpmlDataDocument) {
		List<PerformanceValuationDates.PerformanceValuationDatesBuilder> performanceValuationDatesListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PerformanceValuationDates> performanceValuationDatesList;
		if (performanceValuationDatesListBuilder == null) {
			performanceValuationDatesList = null;
		} else {
			performanceValuationDatesList = performanceValuationDatesListBuilder.stream().map(PerformanceValuationDates::build).collect(Collectors.toList());
			objectValidator.validate(PerformanceValuationDates.class, performanceValuationDatesList);
		}
		
		return performanceValuationDatesList;
	}

	protected abstract List<PerformanceValuationDates.PerformanceValuationDatesBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPerformanceValuationDatesListDefault extends MapPerformanceValuationDatesList {
		@Override
		protected List<PerformanceValuationDates.PerformanceValuationDatesBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PerformanceValuationDates.PerformanceValuationDatesBuilder> performanceValuationDatesList = new ArrayList<>();
			return assignOutput(performanceValuationDatesList, fpmlDataDocument);
		}
		
		protected List<PerformanceValuationDates.PerformanceValuationDatesBuilder> assignOutput(List<PerformanceValuationDates.PerformanceValuationDatesBuilder> performanceValuationDatesList, DataDocument fpmlDataDocument) {
			performanceValuationDatesList.addAll(toBuilder(MapperC.<PerformanceValuationDates>of(MapperS.of(PerformanceValuationDates.builder()
				.setDeterminationMethod(null)
				.setValuationDates(mapAdjustableRelativeOrPeriodicDates.evaluate(fpmlDataDocument))
				.setValuationDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setValuationTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setValuationTimeType(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(performanceValuationDatesList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

package fpml.mapping.functions;

import cdm.base.datetime.AveragingSchedule;
import cdm.base.datetime.AveragingSchedule.AveragingScheduleBuilder;
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


@ImplementedBy(MapAveragingScheduleList.MapAveragingScheduleListDefault.class)
public abstract class MapAveragingScheduleList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationPeriodFrequency mapCalculationPeriodFrequency;

	/**
	* @param fpmlDataDocument 
	* @return averagingScheduleList 
	*/
	public List<? extends AveragingSchedule> evaluate(DataDocument fpmlDataDocument) {
		List<AveragingSchedule.AveragingScheduleBuilder> averagingScheduleListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AveragingSchedule> averagingScheduleList;
		if (averagingScheduleListBuilder == null) {
			averagingScheduleList = null;
		} else {
			averagingScheduleList = averagingScheduleListBuilder.stream().map(AveragingSchedule::build).collect(Collectors.toList());
			objectValidator.validate(AveragingSchedule.class, averagingScheduleList);
		}
		
		return averagingScheduleList;
	}

	protected abstract List<AveragingSchedule.AveragingScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAveragingScheduleListDefault extends MapAveragingScheduleList {
		@Override
		protected List<AveragingSchedule.AveragingScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AveragingSchedule.AveragingScheduleBuilder> averagingScheduleList = new ArrayList<>();
			return assignOutput(averagingScheduleList, fpmlDataDocument);
		}
		
		protected List<AveragingSchedule.AveragingScheduleBuilder> assignOutput(List<AveragingSchedule.AveragingScheduleBuilder> averagingScheduleList, DataDocument fpmlDataDocument) {
			averagingScheduleList.addAll(toBuilder(MapperC.<AveragingSchedule>of(MapperS.of(AveragingSchedule.builder()
				.setStartDate(null)
				.setEndDate(null)
				.setAveragingPeriodFrequency(mapCalculationPeriodFrequency.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(averagingScheduleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}

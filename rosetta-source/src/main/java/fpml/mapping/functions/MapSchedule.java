package fpml.mapping.functions;

import cdm.base.math.Schedule;
import cdm.base.math.Schedule.ScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSchedule.MapScheduleDefault.class)
public abstract class MapSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDatedValueList mapDatedValueList;

	/**
	* @param fpmlDataDocument 
	* @return schedule 
	*/
	public Schedule evaluate(DataDocument fpmlDataDocument) {
		Schedule.ScheduleBuilder scheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final Schedule schedule;
		if (scheduleBuilder == null) {
			schedule = null;
		} else {
			schedule = scheduleBuilder.build();
			objectValidator.validate(Schedule.class, schedule);
		}
		
		return schedule;
	}

	protected abstract Schedule.ScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapScheduleDefault extends MapSchedule {
		@Override
		protected Schedule.ScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Schedule.ScheduleBuilder schedule = Schedule.builder();
			return assignOutput(schedule, fpmlDataDocument);
		}
		
		protected Schedule.ScheduleBuilder assignOutput(Schedule.ScheduleBuilder schedule, DataDocument fpmlDataDocument) {
			schedule = toBuilder(Schedule.builder()
				.setValue(null)
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(schedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

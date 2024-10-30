package fpml.mapping.functions;

import cdm.product.template.CalendarSpread;
import cdm.product.template.CalendarSpread.CalendarSpreadBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCalendarSpread.MapCalendarSpreadDefault.class)
public abstract class MapCalendarSpread implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;

	/**
	* @param fpmlDataDocument 
	* @return calendarSpread 
	*/
	public CalendarSpread evaluate(DataDocument fpmlDataDocument) {
		CalendarSpread.CalendarSpreadBuilder calendarSpreadBuilder = doEvaluate(fpmlDataDocument);
		
		final CalendarSpread calendarSpread;
		if (calendarSpreadBuilder == null) {
			calendarSpread = null;
		} else {
			calendarSpread = calendarSpreadBuilder.build();
			objectValidator.validate(CalendarSpread.class, calendarSpread);
		}
		
		return calendarSpread;
	}

	protected abstract CalendarSpread.CalendarSpreadBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCalendarSpreadDefault extends MapCalendarSpread {
		@Override
		protected CalendarSpread.CalendarSpreadBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CalendarSpread.CalendarSpreadBuilder calendarSpread = CalendarSpread.builder();
			return assignOutput(calendarSpread, fpmlDataDocument);
		}
		
		protected CalendarSpread.CalendarSpreadBuilder assignOutput(CalendarSpread.CalendarSpreadBuilder calendarSpread, DataDocument fpmlDataDocument) {
			calendarSpread = toBuilder(CalendarSpread.builder()
				.setExpirationDateTwo(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(calendarSpread)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

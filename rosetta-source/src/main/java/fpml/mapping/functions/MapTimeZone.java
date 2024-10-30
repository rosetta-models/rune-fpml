package fpml.mapping.functions;

import cdm.base.datetime.TimeZone;
import cdm.base.datetime.TimeZone.TimeZoneBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTimeZone.MapTimeZoneDefault.class)
public abstract class MapTimeZone implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLocationWithScheme mapLocationWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return timeZone 
	*/
	public TimeZone evaluate(DataDocument fpmlDataDocument) {
		TimeZone.TimeZoneBuilder timeZoneBuilder = doEvaluate(fpmlDataDocument);
		
		final TimeZone timeZone;
		if (timeZoneBuilder == null) {
			timeZone = null;
		} else {
			timeZone = timeZoneBuilder.build();
			objectValidator.validate(TimeZone.class, timeZone);
		}
		
		return timeZone;
	}

	protected abstract TimeZone.TimeZoneBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTimeZoneDefault extends MapTimeZone {
		@Override
		protected TimeZone.TimeZoneBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TimeZone.TimeZoneBuilder timeZone = TimeZone.builder();
			return assignOutput(timeZone, fpmlDataDocument);
		}
		
		protected TimeZone.TimeZoneBuilder assignOutput(TimeZone.TimeZoneBuilder timeZone, DataDocument fpmlDataDocument) {
			timeZone = toBuilder(TimeZone.builder()
				.setTime(null)
				.setLocationValue(mapLocationWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(timeZone)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

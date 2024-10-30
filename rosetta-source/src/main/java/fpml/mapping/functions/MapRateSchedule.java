package fpml.mapping.functions;

import cdm.product.common.schedule.RateSchedule;
import cdm.product.common.schedule.RateSchedule.RateScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRateSchedule.MapRateScheduleDefault.class)
public abstract class MapRateSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPriceSchedule mapPriceSchedule;

	/**
	* @param fpmlDataDocument 
	* @return rateSchedule 
	*/
	public RateSchedule evaluate(DataDocument fpmlDataDocument) {
		RateSchedule.RateScheduleBuilder rateScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final RateSchedule rateSchedule;
		if (rateScheduleBuilder == null) {
			rateSchedule = null;
		} else {
			rateSchedule = rateScheduleBuilder.build();
			objectValidator.validate(RateSchedule.class, rateSchedule);
		}
		
		return rateSchedule;
	}

	protected abstract RateSchedule.RateScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRateScheduleDefault extends MapRateSchedule {
		@Override
		protected RateSchedule.RateScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			RateSchedule.RateScheduleBuilder rateSchedule = RateSchedule.builder();
			return assignOutput(rateSchedule, fpmlDataDocument);
		}
		
		protected RateSchedule.RateScheduleBuilder assignOutput(RateSchedule.RateScheduleBuilder rateSchedule, DataDocument fpmlDataDocument) {
			rateSchedule = toBuilder(RateSchedule.builder()
				.setPriceValue(mapPriceSchedule.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(rateSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

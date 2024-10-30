package fpml.mapping.functions;

import cdm.base.datetime.Period;
import cdm.base.datetime.Period.PeriodBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPeriod.MapPeriodDefault.class)
public abstract class MapPeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return period 
	*/
	public Period evaluate(DataDocument fpmlDataDocument) {
		Period.PeriodBuilder periodBuilder = doEvaluate(fpmlDataDocument);
		
		final Period period;
		if (periodBuilder == null) {
			period = null;
		} else {
			period = periodBuilder.build();
			objectValidator.validate(Period.class, period);
		}
		
		return period;
	}

	protected abstract Period.PeriodBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPeriodDefault extends MapPeriod {
		@Override
		protected Period.PeriodBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Period.PeriodBuilder period = Period.builder();
			return assignOutput(period, fpmlDataDocument);
		}
		
		protected Period.PeriodBuilder assignOutput(Period.PeriodBuilder period, DataDocument fpmlDataDocument) {
			period = toBuilder(Period.builder()
				.setPeriodMultiplier(null)
				.setPeriod(null)
				.build());
			
			return Optional.ofNullable(period)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

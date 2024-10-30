package fpml.mapping.functions;

import cdm.base.datetime.PeriodBound;
import cdm.base.datetime.PeriodBound.PeriodBoundBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPeriodBound.MapPeriodBoundDefault.class)
public abstract class MapPeriodBound implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlDataDocument 
	* @return periodBound 
	*/
	public PeriodBound evaluate(DataDocument fpmlDataDocument) {
		PeriodBound.PeriodBoundBuilder periodBoundBuilder = doEvaluate(fpmlDataDocument);
		
		final PeriodBound periodBound;
		if (periodBoundBuilder == null) {
			periodBound = null;
		} else {
			periodBound = periodBoundBuilder.build();
			objectValidator.validate(PeriodBound.class, periodBound);
		}
		
		return periodBound;
	}

	protected abstract PeriodBound.PeriodBoundBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPeriodBoundDefault extends MapPeriodBound {
		@Override
		protected PeriodBound.PeriodBoundBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PeriodBound.PeriodBoundBuilder periodBound = PeriodBound.builder();
			return assignOutput(periodBound, fpmlDataDocument);
		}
		
		protected PeriodBound.PeriodBoundBuilder assignOutput(PeriodBound.PeriodBoundBuilder periodBound, DataDocument fpmlDataDocument) {
			periodBound = toBuilder(PeriodBound.builder()
				.setPeriod(mapPeriod.evaluate(fpmlDataDocument))
				.setInclusive(null)
				.build());
			
			return Optional.ofNullable(periodBound)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

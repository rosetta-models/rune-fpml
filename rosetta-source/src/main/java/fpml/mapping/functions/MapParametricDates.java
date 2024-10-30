package fpml.mapping.functions;

import cdm.base.datetime.DayOfWeekEnum;
import cdm.product.common.schedule.ParametricDates;
import cdm.product.common.schedule.ParametricDates.ParametricDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapParametricDates.MapParametricDatesDefault.class)
public abstract class MapParametricDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;
	@Inject protected MapLag mapLag;

	/**
	* @param fpmlDataDocument 
	* @return parametricDates 
	*/
	public ParametricDates evaluate(DataDocument fpmlDataDocument) {
		ParametricDates.ParametricDatesBuilder parametricDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final ParametricDates parametricDates;
		if (parametricDatesBuilder == null) {
			parametricDates = null;
		} else {
			parametricDates = parametricDatesBuilder.build();
			objectValidator.validate(ParametricDates.class, parametricDates);
		}
		
		return parametricDates;
	}

	protected abstract ParametricDates.ParametricDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapParametricDatesDefault extends MapParametricDates {
		@Override
		protected ParametricDates.ParametricDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ParametricDates.ParametricDatesBuilder parametricDates = ParametricDates.builder();
			return assignOutput(parametricDates, fpmlDataDocument);
		}
		
		protected ParametricDates.ParametricDatesBuilder assignOutput(ParametricDates.ParametricDatesBuilder parametricDates, DataDocument fpmlDataDocument) {
			parametricDates = toBuilder(ParametricDates.builder()
				.setDayType(null)
				.setDayDistribution(null)
				.setDayOfWeek(Collections.<DayOfWeekEnum>emptyList())
				.setDayFrequency(null)
				.setLag(mapLag.evaluate(fpmlDataDocument))
				.setBusinessCenters(mapBusinessCenters.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(parametricDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

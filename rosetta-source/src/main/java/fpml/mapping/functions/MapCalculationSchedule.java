package fpml.mapping.functions;

import cdm.product.template.CalculationSchedule;
import cdm.product.template.CalculationSchedule.CalculationScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCalculationSchedule.MapCalculationScheduleDefault.class)
public abstract class MapCalculationSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSchedulePeriodList mapSchedulePeriodList;

	/**
	* @param fpmlDataDocument 
	* @return calculationSchedule 
	*/
	public CalculationSchedule evaluate(DataDocument fpmlDataDocument) {
		CalculationSchedule.CalculationScheduleBuilder calculationScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final CalculationSchedule calculationSchedule;
		if (calculationScheduleBuilder == null) {
			calculationSchedule = null;
		} else {
			calculationSchedule = calculationScheduleBuilder.build();
			objectValidator.validate(CalculationSchedule.class, calculationSchedule);
		}
		
		return calculationSchedule;
	}

	protected abstract CalculationSchedule.CalculationScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCalculationScheduleDefault extends MapCalculationSchedule {
		@Override
		protected CalculationSchedule.CalculationScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CalculationSchedule.CalculationScheduleBuilder calculationSchedule = CalculationSchedule.builder();
			return assignOutput(calculationSchedule, fpmlDataDocument);
		}
		
		protected CalculationSchedule.CalculationScheduleBuilder assignOutput(CalculationSchedule.CalculationScheduleBuilder calculationSchedule, DataDocument fpmlDataDocument) {
			calculationSchedule = toBuilder(CalculationSchedule.builder()
				.setSchedulePeriod(new ArrayList(mapSchedulePeriodList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(calculationSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

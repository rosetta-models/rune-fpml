package fpml.mapping.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNonNegativeQuantitySchedule.MapNonNegativeQuantityScheduleDefault.class)
public abstract class MapNonNegativeQuantitySchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDatedValueList mapDatedValueList;
	@Inject protected MapFrequency mapFrequency;
	@Inject protected MapMeasure mapMeasure;
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return nonNegativeQuantitySchedule 
	*/
	public NonNegativeQuantitySchedule evaluate(DataDocument fpmlDataDocument) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantityScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final NonNegativeQuantitySchedule nonNegativeQuantitySchedule;
		if (nonNegativeQuantityScheduleBuilder == null) {
			nonNegativeQuantitySchedule = null;
		} else {
			nonNegativeQuantitySchedule = nonNegativeQuantityScheduleBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, nonNegativeQuantitySchedule);
		}
		
		return nonNegativeQuantitySchedule;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapNonNegativeQuantityScheduleDefault extends MapNonNegativeQuantitySchedule {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule = NonNegativeQuantitySchedule.builder();
			return assignOutput(nonNegativeQuantitySchedule, fpmlDataDocument);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder nonNegativeQuantitySchedule, DataDocument fpmlDataDocument) {
			nonNegativeQuantitySchedule = toBuilder(NonNegativeQuantitySchedule.builder()
				.setValue(null)
				.setUnit(mapUnitType.evaluate(fpmlDataDocument))
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.setMultiplier(mapMeasure.evaluate(fpmlDataDocument))
				.setFrequency(mapFrequency.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(nonNegativeQuantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

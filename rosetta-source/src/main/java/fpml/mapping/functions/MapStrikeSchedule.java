package fpml.mapping.functions;

import cdm.product.template.StrikeSchedule;
import cdm.product.template.StrikeSchedule.StrikeScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStrikeSchedule.MapStrikeScheduleDefault.class)
public abstract class MapStrikeSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPriceSchedule mapPriceSchedule;

	/**
	* @param fpmlDataDocument 
	* @return strikeSchedule 
	*/
	public StrikeSchedule evaluate(DataDocument fpmlDataDocument) {
		StrikeSchedule.StrikeScheduleBuilder strikeScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final StrikeSchedule strikeSchedule;
		if (strikeScheduleBuilder == null) {
			strikeSchedule = null;
		} else {
			strikeSchedule = strikeScheduleBuilder.build();
			objectValidator.validate(StrikeSchedule.class, strikeSchedule);
		}
		
		return strikeSchedule;
	}

	protected abstract StrikeSchedule.StrikeScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapStrikeScheduleDefault extends MapStrikeSchedule {
		@Override
		protected StrikeSchedule.StrikeScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			StrikeSchedule.StrikeScheduleBuilder strikeSchedule = StrikeSchedule.builder();
			return assignOutput(strikeSchedule, fpmlDataDocument);
		}
		
		protected StrikeSchedule.StrikeScheduleBuilder assignOutput(StrikeSchedule.StrikeScheduleBuilder strikeSchedule, DataDocument fpmlDataDocument) {
			strikeSchedule = toBuilder(StrikeSchedule.builder()
				.setPriceValue(mapPriceSchedule.evaluate(fpmlDataDocument))
				.setBuyer(null)
				.setSeller(null)
				.build());
			
			return Optional.ofNullable(strikeSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

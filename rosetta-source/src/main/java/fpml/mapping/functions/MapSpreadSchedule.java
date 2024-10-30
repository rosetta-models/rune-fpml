package fpml.mapping.functions;

import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.SpreadSchedule.SpreadScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSpreadSchedule.MapSpreadScheduleDefault.class)
public abstract class MapSpreadSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPriceSchedule mapPriceSchedule;
	@Inject protected MapSpreadScheduleTypeWithScheme mapSpreadScheduleTypeWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return spreadSchedule 
	*/
	public SpreadSchedule evaluate(DataDocument fpmlDataDocument) {
		SpreadSchedule.SpreadScheduleBuilder spreadScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final SpreadSchedule spreadSchedule;
		if (spreadScheduleBuilder == null) {
			spreadSchedule = null;
		} else {
			spreadSchedule = spreadScheduleBuilder.build();
			objectValidator.validate(SpreadSchedule.class, spreadSchedule);
		}
		
		return spreadSchedule;
	}

	protected abstract SpreadSchedule.SpreadScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSpreadScheduleDefault extends MapSpreadSchedule {
		@Override
		protected SpreadSchedule.SpreadScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SpreadSchedule.SpreadScheduleBuilder spreadSchedule = SpreadSchedule.builder();
			return assignOutput(spreadSchedule, fpmlDataDocument);
		}
		
		protected SpreadSchedule.SpreadScheduleBuilder assignOutput(SpreadSchedule.SpreadScheduleBuilder spreadSchedule, DataDocument fpmlDataDocument) {
			spreadSchedule = toBuilder(SpreadSchedule.builder()
				.setPriceValue(mapPriceSchedule.evaluate(fpmlDataDocument))
				.setSpreadScheduleTypeValue(mapSpreadScheduleTypeWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(spreadSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

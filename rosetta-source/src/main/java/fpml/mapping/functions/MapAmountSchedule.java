package fpml.mapping.functions;

import cdm.product.common.schedule.AmountSchedule;
import cdm.product.common.schedule.AmountSchedule.AmountScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAmountSchedule.MapAmountScheduleDefault.class)
public abstract class MapAmountSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrencyWithSchemeList mapCurrencyWithSchemeList;
	@Inject protected MapDatedValueList mapDatedValueList;

	/**
	* @param fpmlDataDocument 
	* @return amountSchedule 
	*/
	public AmountSchedule evaluate(DataDocument fpmlDataDocument) {
		AmountSchedule.AmountScheduleBuilder amountScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final AmountSchedule amountSchedule;
		if (amountScheduleBuilder == null) {
			amountSchedule = null;
		} else {
			amountSchedule = amountScheduleBuilder.build();
			objectValidator.validate(AmountSchedule.class, amountSchedule);
		}
		
		return amountSchedule;
	}

	protected abstract AmountSchedule.AmountScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAmountScheduleDefault extends MapAmountSchedule {
		@Override
		protected AmountSchedule.AmountScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AmountSchedule.AmountScheduleBuilder amountSchedule = AmountSchedule.builder();
			return assignOutput(amountSchedule, fpmlDataDocument);
		}
		
		protected AmountSchedule.AmountScheduleBuilder assignOutput(AmountSchedule.AmountScheduleBuilder amountSchedule, DataDocument fpmlDataDocument) {
			amountSchedule = toBuilder(AmountSchedule.builder()
				.setValue(null)
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.setCurrencyValue(mapCurrencyWithSchemeList.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(amountSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

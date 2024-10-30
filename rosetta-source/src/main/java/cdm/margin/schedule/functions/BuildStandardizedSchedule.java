package cdm.margin.schedule.functions;

import cdm.event.common.Trade;
import cdm.margin.schedule.StandardizedSchedule;
import cdm.margin.schedule.StandardizedSchedule.StandardizedScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(BuildStandardizedSchedule.BuildStandardizedScheduleDefault.class)
public abstract class BuildStandardizedSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected StandardizedScheduleAssetClass standardizedScheduleAssetClass;
	@Inject protected StandardizedScheduleDuration standardizedScheduleDuration;
	@Inject protected StandardizedScheduleNotional standardizedScheduleNotional;
	@Inject protected StandardizedScheduleNotionalCurrency standardizedScheduleNotionalCurrency;
	@Inject protected StandardizedScheduleProductClass standardizedScheduleProductClass;

	/**
	* @param trade 
	* @return standardizedSchedule 
	*/
	public StandardizedSchedule evaluate(Trade trade) {
		StandardizedSchedule.StandardizedScheduleBuilder standardizedScheduleBuilder = doEvaluate(trade);
		
		final StandardizedSchedule standardizedSchedule;
		if (standardizedScheduleBuilder == null) {
			standardizedSchedule = null;
		} else {
			standardizedSchedule = standardizedScheduleBuilder.build();
			objectValidator.validate(StandardizedSchedule.class, standardizedSchedule);
		}
		
		return standardizedSchedule;
	}

	protected abstract StandardizedSchedule.StandardizedScheduleBuilder doEvaluate(Trade trade);

	public static class BuildStandardizedScheduleDefault extends BuildStandardizedSchedule {
		@Override
		protected StandardizedSchedule.StandardizedScheduleBuilder doEvaluate(Trade trade) {
			StandardizedSchedule.StandardizedScheduleBuilder standardizedSchedule = StandardizedSchedule.builder();
			return assignOutput(standardizedSchedule, trade);
		}
		
		protected StandardizedSchedule.StandardizedScheduleBuilder assignOutput(StandardizedSchedule.StandardizedScheduleBuilder standardizedSchedule, Trade trade) {
			standardizedSchedule
				.setAssetClass(standardizedScheduleAssetClass.evaluate(trade));
			
			standardizedSchedule
				.setProductClass(standardizedScheduleProductClass.evaluate(trade));
			
			standardizedSchedule
				.setNotional(standardizedScheduleNotional.evaluate(trade));
			
			standardizedSchedule
				.setNotionalCurrency(standardizedScheduleNotionalCurrency.evaluate(trade));
			
			standardizedSchedule
				.setDurationInYears(standardizedScheduleDuration.evaluate(trade));
			
			return Optional.ofNullable(standardizedSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

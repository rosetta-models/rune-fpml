package cdm.margin.schedule.functions;

import cdm.base.math.Quantity;
import cdm.base.math.Quantity.QuantityBuilder;
import cdm.margin.schedule.StandardizedSchedule;
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetGrossInitialMarginFromStandardizedSchedule.GetGrossInitialMarginFromStandardizedScheduleDefault.class)
public abstract class GetGrossInitialMarginFromStandardizedSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetIMRequirement getIMRequirement;

	/**
	* @param standardizedSchedule 
	* @return grossInitialMargin 
	*/
	public Quantity evaluate(StandardizedSchedule standardizedSchedule) {
		Quantity.QuantityBuilder grossInitialMarginBuilder = doEvaluate(standardizedSchedule);
		
		final Quantity grossInitialMargin;
		if (grossInitialMarginBuilder == null) {
			grossInitialMargin = null;
		} else {
			grossInitialMargin = grossInitialMarginBuilder.build();
			objectValidator.validate(Quantity.class, grossInitialMargin);
		}
		
		return grossInitialMargin;
	}

	protected abstract Quantity.QuantityBuilder doEvaluate(StandardizedSchedule standardizedSchedule);

	protected abstract MapperS<BigDecimal> initialMarginRequirement(StandardizedSchedule standardizedSchedule);

	public static class GetGrossInitialMarginFromStandardizedScheduleDefault extends GetGrossInitialMarginFromStandardizedSchedule {
		@Override
		protected Quantity.QuantityBuilder doEvaluate(StandardizedSchedule standardizedSchedule) {
			Quantity.QuantityBuilder grossInitialMargin = Quantity.builder();
			return assignOutput(grossInitialMargin, standardizedSchedule);
		}
		
		protected Quantity.QuantityBuilder assignOutput(Quantity.QuantityBuilder grossInitialMargin, StandardizedSchedule standardizedSchedule) {
			grossInitialMargin
				.setValue(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(standardizedSchedule).<BigDecimal>map("getNotional", _standardizedSchedule -> _standardizedSchedule.getNotional()), initialMarginRequirement(standardizedSchedule)), MapperS.of(new BigDecimal("0.01"))).get());
			
			grossInitialMargin
				.getOrCreateUnit()
				.setCurrencyValue(MapperS.of(standardizedSchedule).<String>map("getNotionalCurrency", _standardizedSchedule -> _standardizedSchedule.getNotionalCurrency()).get());
			
			return Optional.ofNullable(grossInitialMargin)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<BigDecimal> initialMarginRequirement(StandardizedSchedule standardizedSchedule) {
			return MapperS.of(getIMRequirement.evaluate(MapperS.of(standardizedSchedule).<StandardizedScheduleAssetClassEnum>map("getAssetClass", _standardizedSchedule -> _standardizedSchedule.getAssetClass()).get(), MapperS.of(standardizedSchedule).<BigDecimal>map("getDurationInYears", _standardizedSchedule -> _standardizedSchedule.getDurationInYears()).get()));
		}
	}
}

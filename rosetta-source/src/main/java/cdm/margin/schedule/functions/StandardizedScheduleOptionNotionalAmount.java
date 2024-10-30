package cdm.margin.schedule.functions;

import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.observable.asset.Price;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleOptionNotionalAmount.StandardizedScheduleOptionNotionalAmountDefault.class)
public abstract class StandardizedScheduleOptionNotionalAmount implements RosettaFunction {

	/**
	* @param optionPayout 
	* @return amount 
	*/
	public BigDecimal evaluate(OptionPayout optionPayout) {
		BigDecimal amount = doEvaluate(optionPayout);
		
		return amount;
	}

	protected abstract BigDecimal doEvaluate(OptionPayout optionPayout);

	protected abstract MapperS<BigDecimal> strikePrice(OptionPayout optionPayout);

	protected abstract MapperS<BigDecimal> notionalQuantity(OptionPayout optionPayout);

	public static class StandardizedScheduleOptionNotionalAmountDefault extends StandardizedScheduleOptionNotionalAmount {
		@Override
		protected BigDecimal doEvaluate(OptionPayout optionPayout) {
			BigDecimal amount = null;
			return assignOutput(amount, optionPayout);
		}
		
		protected BigDecimal assignOutput(BigDecimal amount, OptionPayout optionPayout) {
			amount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(strikePrice(optionPayout), notionalQuantity(optionPayout)).get();
			
			return amount;
		}
		
		@Override
		protected MapperS<BigDecimal> strikePrice(OptionPayout optionPayout) {
			return MapperS.of(optionPayout).<OptionStrike>map("getStrike", _optionPayout -> _optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<BigDecimal>map("getValue", price -> price.getValue());
		}
		
		@Override
		protected MapperS<BigDecimal> notionalQuantity(OptionPayout optionPayout) {
			final MapperS<NonNegativeQuantitySchedule> thenArg = MapperS.of(optionPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _optionPayout -> _optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue());
			final MapperS<BigDecimal> ifThenElseResult;
			if (exists(thenArg.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
				ifThenElseResult = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(thenArg.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), thenArg.<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue()));
			} else {
				ifThenElseResult = thenArg.<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue());
			}
			return ifThenElseResult;
		}
	}
}

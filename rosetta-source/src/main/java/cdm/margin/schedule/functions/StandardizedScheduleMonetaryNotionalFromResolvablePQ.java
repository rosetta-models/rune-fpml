package cdm.margin.schedule.functions;

import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleMonetaryNotionalFromResolvablePQ.StandardizedScheduleMonetaryNotionalFromResolvablePQDefault.class)
public abstract class StandardizedScheduleMonetaryNotionalFromResolvablePQ implements RosettaFunction {

	/**
	* @param priceQuantity 
	* @return notional 
	*/
	public BigDecimal evaluate(ResolvablePriceQuantity priceQuantity) {
		BigDecimal notional = doEvaluate(priceQuantity);
		
		return notional;
	}

	protected abstract BigDecimal doEvaluate(ResolvablePriceQuantity priceQuantity);

	public static class StandardizedScheduleMonetaryNotionalFromResolvablePQDefault extends StandardizedScheduleMonetaryNotionalFromResolvablePQ {
		@Override
		protected BigDecimal doEvaluate(ResolvablePriceQuantity priceQuantity) {
			BigDecimal notional = null;
			return assignOutput(notional, priceQuantity);
		}
		
		protected BigDecimal assignOutput(BigDecimal notional, ResolvablePriceQuantity priceQuantity) {
			if (exists(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue())).and(exists(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()))).getOrDefault(false)) {
				if (exists(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
					notional = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<BigDecimal>map("getValue", measure -> measure.getValue())).get();
				} else {
					notional = MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()).get();
				}
			} else {
				notional = null;
			}
			
			return notional;
		}
	}
}

package cdm.margin.schedule.functions;

import cdm.base.math.Measure;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ.StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQDefault.class)
public abstract class StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ implements RosettaFunction {

	/**
	* @param priceQuantity 
	* @return notionalCurrency 
	*/
	public String evaluate(ResolvablePriceQuantity priceQuantity) {
		String notionalCurrency = doEvaluate(priceQuantity);
		
		return notionalCurrency;
	}

	protected abstract String doEvaluate(ResolvablePriceQuantity priceQuantity);

	public static class StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQDefault extends StandardizedScheduleMonetaryNotionalCurrencyFromResolvablePQ {
		@Override
		protected String doEvaluate(ResolvablePriceQuantity priceQuantity) {
			String notionalCurrency = null;
			return assignOutput(notionalCurrency, priceQuantity);
		}
		
		protected String assignOutput(String notionalCurrency, ResolvablePriceQuantity priceQuantity) {
			if (exists(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue())).and(exists(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()))).getOrDefault(false)) {
				if (exists(MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier())).getOrDefault(false)) {
					notionalCurrency = MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<Measure>map("getMultiplier", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getMultiplier()).<UnitType>map("getUnit", measure -> measure.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()).get();
				} else {
					notionalCurrency = MapperS.of(priceQuantity).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()).get();
				}
			} else {
				notionalCurrency = null;
			}
			
			return notionalCurrency;
		}
	}
}

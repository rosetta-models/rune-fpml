package fpml.enumeration.mapping.functions;

import cdm.base.datetime.DayTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDayTypeEnum.MapDayTypeEnumDefault.class)
public abstract class MapDayTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DayTypeEnum evaluate(String value) {
		DayTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DayTypeEnum doEvaluate(String value);

	public static class MapDayTypeEnumDefault extends MapDayTypeEnum {
		@Override
		protected DayTypeEnum doEvaluate(String value) {
			DayTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DayTypeEnum assignOutput(DayTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Business"), CardinalityOperator.All).get()) {
				result = DayTypeEnum.BUSINESS;
			} else if (areEqual(switchArgument, MapperS.of("CommodityBusiness"), CardinalityOperator.All).get()) {
				result = DayTypeEnum.BUSINESS;
			} else if (areEqual(switchArgument, MapperS.of("Calendar"), CardinalityOperator.All).get()) {
				result = DayTypeEnum.CALENDAR;
			} else if (areEqual(switchArgument, MapperS.of("CurrencyBusiness"), CardinalityOperator.All).get()) {
				result = DayTypeEnum.CURRENCY_BUSINESS;
			} else if (areEqual(switchArgument, MapperS.of("ExchangeBusiness"), CardinalityOperator.All).get()) {
				result = DayTypeEnum.EXCHANGE_BUSINESS;
			} else if (areEqual(switchArgument, MapperS.of("ScheduledTradingDay"), CardinalityOperator.All).get()) {
				result = DayTypeEnum.SCHEDULED_TRADING_DAY;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

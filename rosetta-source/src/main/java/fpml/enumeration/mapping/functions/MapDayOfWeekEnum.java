package fpml.enumeration.mapping.functions;

import cdm.base.datetime.DayOfWeekEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDayOfWeekEnum.MapDayOfWeekEnumDefault.class)
public abstract class MapDayOfWeekEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DayOfWeekEnum evaluate(String value) {
		DayOfWeekEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DayOfWeekEnum doEvaluate(String value);

	public static class MapDayOfWeekEnumDefault extends MapDayOfWeekEnum {
		@Override
		protected DayOfWeekEnum doEvaluate(String value) {
			DayOfWeekEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DayOfWeekEnum assignOutput(DayOfWeekEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("MON"), CardinalityOperator.All).get()) {
				result = DayOfWeekEnum.MON;
			} else if (areEqual(switchArgument, MapperS.of("TUE"), CardinalityOperator.All).get()) {
				result = DayOfWeekEnum.TUE;
			} else if (areEqual(switchArgument, MapperS.of("WED"), CardinalityOperator.All).get()) {
				result = DayOfWeekEnum.WED;
			} else if (areEqual(switchArgument, MapperS.of("THU"), CardinalityOperator.All).get()) {
				result = DayOfWeekEnum.THU;
			} else if (areEqual(switchArgument, MapperS.of("FRI"), CardinalityOperator.All).get()) {
				result = DayOfWeekEnum.FRI;
			} else if (areEqual(switchArgument, MapperS.of("SAT"), CardinalityOperator.All).get()) {
				result = DayOfWeekEnum.SAT;
			} else if (areEqual(switchArgument, MapperS.of("SUN"), CardinalityOperator.All).get()) {
				result = DayOfWeekEnum.SUN;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

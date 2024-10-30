package fpml.enumeration.mapping.functions;

import cdm.base.datetime.PeriodTimeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPeriodTimeEnum.MapPeriodTimeEnumDefault.class)
public abstract class MapPeriodTimeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PeriodTimeEnum evaluate(String value) {
		PeriodTimeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PeriodTimeEnum doEvaluate(String value);

	public static class MapPeriodTimeEnumDefault extends MapPeriodTimeEnum {
		@Override
		protected PeriodTimeEnum doEvaluate(String value) {
			PeriodTimeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PeriodTimeEnum assignOutput(PeriodTimeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Hour"), CardinalityOperator.All).get()) {
				result = PeriodTimeEnum.HOUR;
			} else if (areEqual(switchArgument, MapperS.of("Minute"), CardinalityOperator.All).get()) {
				result = PeriodTimeEnum.MINUTE;
			} else if (areEqual(switchArgument, MapperS.of("Second"), CardinalityOperator.All).get()) {
				result = PeriodTimeEnum.SECOND;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

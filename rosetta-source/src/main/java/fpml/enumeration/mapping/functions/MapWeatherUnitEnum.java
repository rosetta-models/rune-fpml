package fpml.enumeration.mapping.functions;

import cdm.base.math.WeatherUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapWeatherUnitEnum.MapWeatherUnitEnumDefault.class)
public abstract class MapWeatherUnitEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public WeatherUnitEnum evaluate(String value) {
		WeatherUnitEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract WeatherUnitEnum doEvaluate(String value);

	public static class MapWeatherUnitEnumDefault extends MapWeatherUnitEnum {
		@Override
		protected WeatherUnitEnum doEvaluate(String value) {
			WeatherUnitEnum result = null;
			return assignOutput(result, value);
		}
		
		protected WeatherUnitEnum assignOutput(WeatherUnitEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("CDD"), CardinalityOperator.All).get()) {
				result = WeatherUnitEnum.CDD;
			} else if (areEqual(switchArgument, MapperS.of("CPD"), CardinalityOperator.All).get()) {
				result = WeatherUnitEnum.CPD;
			} else if (areEqual(switchArgument, MapperS.of("HDD"), CardinalityOperator.All).get()) {
				result = WeatherUnitEnum.HDD;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.common.LengthUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapLengthUnitEnum.MapLengthUnitEnumDefault.class)
public abstract class MapLengthUnitEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public LengthUnitEnum evaluate(String value) {
		LengthUnitEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract LengthUnitEnum doEvaluate(String value);

	public static class MapLengthUnitEnumDefault extends MapLengthUnitEnum {
		@Override
		protected LengthUnitEnum doEvaluate(String value) {
			LengthUnitEnum result = null;
			return assignOutput(result, value);
		}
		
		protected LengthUnitEnum assignOutput(LengthUnitEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Pages"), CardinalityOperator.All).get()) {
				result = LengthUnitEnum.PAGES;
			} else if (areEqual(switchArgument, MapperS.of("TimeUnit"), CardinalityOperator.All).get()) {
				result = LengthUnitEnum.TIME_UNIT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

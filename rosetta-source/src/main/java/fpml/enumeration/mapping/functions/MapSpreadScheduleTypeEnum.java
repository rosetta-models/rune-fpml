package fpml.enumeration.mapping.functions;

import cdm.product.asset.SpreadScheduleTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapSpreadScheduleTypeEnum.MapSpreadScheduleTypeEnumDefault.class)
public abstract class MapSpreadScheduleTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public SpreadScheduleTypeEnum evaluate(String value) {
		SpreadScheduleTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract SpreadScheduleTypeEnum doEvaluate(String value);

	public static class MapSpreadScheduleTypeEnumDefault extends MapSpreadScheduleTypeEnum {
		@Override
		protected SpreadScheduleTypeEnum doEvaluate(String value) {
			SpreadScheduleTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected SpreadScheduleTypeEnum assignOutput(SpreadScheduleTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Long"), CardinalityOperator.All).get()) {
				result = SpreadScheduleTypeEnum.LONG;
			} else if (areEqual(switchArgument, MapperS.of("Short"), CardinalityOperator.All).get()) {
				result = SpreadScheduleTypeEnum.SHORT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

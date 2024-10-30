package fpml.enumeration.mapping.functions;

import cdm.event.common.ExecutionTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapExecutionTypeEnum.MapExecutionTypeEnumDefault.class)
public abstract class MapExecutionTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ExecutionTypeEnum evaluate(String value) {
		ExecutionTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ExecutionTypeEnum doEvaluate(String value);

	public static class MapExecutionTypeEnumDefault extends MapExecutionTypeEnum {
		@Override
		protected ExecutionTypeEnum doEvaluate(String value) {
			ExecutionTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ExecutionTypeEnum assignOutput(ExecutionTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Electronic"), CardinalityOperator.All).get()) {
				result = ExecutionTypeEnum.ELECTRONIC;
			} else if (areEqual(switchArgument, MapperS.of("Voice"), CardinalityOperator.All).get()) {
				result = ExecutionTypeEnum.OFF_FACILITY;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

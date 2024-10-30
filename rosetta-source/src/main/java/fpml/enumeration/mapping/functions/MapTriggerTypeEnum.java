package fpml.enumeration.mapping.functions;

import cdm.observable.event.TriggerTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapTriggerTypeEnum.MapTriggerTypeEnumDefault.class)
public abstract class MapTriggerTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public TriggerTypeEnum evaluate(String value) {
		TriggerTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract TriggerTypeEnum doEvaluate(String value);

	public static class MapTriggerTypeEnumDefault extends MapTriggerTypeEnum {
		@Override
		protected TriggerTypeEnum doEvaluate(String value) {
			TriggerTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected TriggerTypeEnum assignOutput(TriggerTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("EqualOrLess"), CardinalityOperator.All).get()) {
				result = TriggerTypeEnum.EQUAL_OR_LESS;
			} else if (areEqual(switchArgument, MapperS.of("EqualOrGreater"), CardinalityOperator.All).get()) {
				result = TriggerTypeEnum.EQUAL_OR_GREATER;
			} else if (areEqual(switchArgument, MapperS.of("Equal"), CardinalityOperator.All).get()) {
				result = TriggerTypeEnum.EQUAL;
			} else if (areEqual(switchArgument, MapperS.of("Less"), CardinalityOperator.All).get()) {
				result = TriggerTypeEnum.LESS;
			} else if (areEqual(switchArgument, MapperS.of("Greater"), CardinalityOperator.All).get()) {
				result = TriggerTypeEnum.GREATER;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

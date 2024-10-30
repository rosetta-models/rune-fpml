package fpml.enumeration.mapping.functions;

import cdm.observable.event.TriggerTimeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapTriggerTimeTypeEnum.MapTriggerTimeTypeEnumDefault.class)
public abstract class MapTriggerTimeTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public TriggerTimeTypeEnum evaluate(String value) {
		TriggerTimeTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract TriggerTimeTypeEnum doEvaluate(String value);

	public static class MapTriggerTimeTypeEnumDefault extends MapTriggerTimeTypeEnum {
		@Override
		protected TriggerTimeTypeEnum doEvaluate(String value) {
			TriggerTimeTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected TriggerTimeTypeEnum assignOutput(TriggerTimeTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Closing"), CardinalityOperator.All).get()) {
				result = TriggerTimeTypeEnum.CLOSING;
			} else if (areEqual(switchArgument, MapperS.of("Anytime"), CardinalityOperator.All).get()) {
				result = TriggerTimeTypeEnum.ANYTIME;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

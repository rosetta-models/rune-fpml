package fpml.enumeration.mapping.functions;

import cdm.observable.event.RestructuringEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapRestructuringEnum.MapRestructuringEnumDefault.class)
public abstract class MapRestructuringEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public RestructuringEnum evaluate(String value) {
		RestructuringEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract RestructuringEnum doEvaluate(String value);

	public static class MapRestructuringEnumDefault extends MapRestructuringEnum {
		@Override
		protected RestructuringEnum doEvaluate(String value) {
			RestructuringEnum result = null;
			return assignOutput(result, value);
		}
		
		protected RestructuringEnum assignOutput(RestructuringEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ModModR"), CardinalityOperator.All).get()) {
				result = RestructuringEnum.MOD_MOD_R;
			} else if (areEqual(switchArgument, MapperS.of("ModR"), CardinalityOperator.All).get()) {
				result = RestructuringEnum.MOD_R;
			} else if (areEqual(switchArgument, MapperS.of("R"), CardinalityOperator.All).get()) {
				result = RestructuringEnum.R;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

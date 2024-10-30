package fpml.enumeration.mapping.functions;

import cdm.observable.asset.InterpolationMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapInterpolationMethodEnum.MapInterpolationMethodEnumDefault.class)
public abstract class MapInterpolationMethodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public InterpolationMethodEnum evaluate(String value) {
		InterpolationMethodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract InterpolationMethodEnum doEvaluate(String value);

	public static class MapInterpolationMethodEnumDefault extends MapInterpolationMethodEnum {
		@Override
		protected InterpolationMethodEnum doEvaluate(String value) {
			InterpolationMethodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected InterpolationMethodEnum assignOutput(InterpolationMethodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("LinearZeroYield"), CardinalityOperator.All).get()) {
				result = InterpolationMethodEnum.LINEAR_ZERO_YIELD;
			} else if (areEqual(switchArgument, MapperS.of("None"), CardinalityOperator.All).get()) {
				result = InterpolationMethodEnum.NONE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

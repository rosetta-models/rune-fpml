package fpml.enumeration.mapping.functions;

import cdm.base.math.RoundingDirectionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapRoundingDirectionEnum.MapRoundingDirectionEnumDefault.class)
public abstract class MapRoundingDirectionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public RoundingDirectionEnum evaluate(String value) {
		RoundingDirectionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract RoundingDirectionEnum doEvaluate(String value);

	public static class MapRoundingDirectionEnumDefault extends MapRoundingDirectionEnum {
		@Override
		protected RoundingDirectionEnum doEvaluate(String value) {
			RoundingDirectionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected RoundingDirectionEnum assignOutput(RoundingDirectionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Up"), CardinalityOperator.All).get()) {
				result = RoundingDirectionEnum.UP;
			} else if (areEqual(switchArgument, MapperS.of("Down"), CardinalityOperator.All).get()) {
				result = RoundingDirectionEnum.DOWN;
			} else if (areEqual(switchArgument, MapperS.of("Nearest"), CardinalityOperator.All).get()) {
				result = RoundingDirectionEnum.NEAREST;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

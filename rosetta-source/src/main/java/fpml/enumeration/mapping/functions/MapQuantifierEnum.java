package fpml.enumeration.mapping.functions;

import cdm.base.math.QuantifierEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapQuantifierEnum.MapQuantifierEnumDefault.class)
public abstract class MapQuantifierEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public QuantifierEnum evaluate(String value) {
		QuantifierEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract QuantifierEnum doEvaluate(String value);

	public static class MapQuantifierEnumDefault extends MapQuantifierEnum {
		@Override
		protected QuantifierEnum doEvaluate(String value) {
			QuantifierEnum result = null;
			return assignOutput(result, value);
		}
		
		protected QuantifierEnum assignOutput(QuantifierEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("All"), CardinalityOperator.All).get()) {
				result = QuantifierEnum.ALL;
			} else if (areEqual(switchArgument, MapperS.of("Any"), CardinalityOperator.All).get()) {
				result = QuantifierEnum.ANY;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.product.asset.InterestShortfallCapEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapInterestShortfallCapEnum.MapInterestShortfallCapEnumDefault.class)
public abstract class MapInterestShortfallCapEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public InterestShortfallCapEnum evaluate(String value) {
		InterestShortfallCapEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract InterestShortfallCapEnum doEvaluate(String value);

	public static class MapInterestShortfallCapEnumDefault extends MapInterestShortfallCapEnum {
		@Override
		protected InterestShortfallCapEnum doEvaluate(String value) {
			InterestShortfallCapEnum result = null;
			return assignOutput(result, value);
		}
		
		protected InterestShortfallCapEnum assignOutput(InterestShortfallCapEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Fixed"), CardinalityOperator.All).get()) {
				result = InterestShortfallCapEnum.FIXED;
			} else if (areEqual(switchArgument, MapperS.of("Variable"), CardinalityOperator.All).get()) {
				result = InterestShortfallCapEnum.VARIABLE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

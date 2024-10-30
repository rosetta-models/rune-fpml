package fpml.enumeration.mapping.functions;

import cdm.product.asset.CompoundingMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCompoundingMethodEnum.MapCompoundingMethodEnumDefault.class)
public abstract class MapCompoundingMethodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CompoundingMethodEnum evaluate(String value) {
		CompoundingMethodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CompoundingMethodEnum doEvaluate(String value);

	public static class MapCompoundingMethodEnumDefault extends MapCompoundingMethodEnum {
		@Override
		protected CompoundingMethodEnum doEvaluate(String value) {
			CompoundingMethodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CompoundingMethodEnum assignOutput(CompoundingMethodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Flat"), CardinalityOperator.All).get()) {
				result = CompoundingMethodEnum.FLAT;
			} else if (areEqual(switchArgument, MapperS.of("None"), CardinalityOperator.All).get()) {
				result = CompoundingMethodEnum.NONE;
			} else if (areEqual(switchArgument, MapperS.of("Straight"), CardinalityOperator.All).get()) {
				result = CompoundingMethodEnum.STRAIGHT;
			} else if (areEqual(switchArgument, MapperS.of("SpreadExclusive"), CardinalityOperator.All).get()) {
				result = CompoundingMethodEnum.SPREAD_EXCLUSIVE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

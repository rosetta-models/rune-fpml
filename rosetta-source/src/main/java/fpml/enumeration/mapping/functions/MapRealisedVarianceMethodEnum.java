package fpml.enumeration.mapping.functions;

import cdm.product.asset.RealisedVarianceMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapRealisedVarianceMethodEnum.MapRealisedVarianceMethodEnumDefault.class)
public abstract class MapRealisedVarianceMethodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public RealisedVarianceMethodEnum evaluate(String value) {
		RealisedVarianceMethodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract RealisedVarianceMethodEnum doEvaluate(String value);

	public static class MapRealisedVarianceMethodEnumDefault extends MapRealisedVarianceMethodEnum {
		@Override
		protected RealisedVarianceMethodEnum doEvaluate(String value) {
			RealisedVarianceMethodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected RealisedVarianceMethodEnum assignOutput(RealisedVarianceMethodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Previous"), CardinalityOperator.All).get()) {
				result = RealisedVarianceMethodEnum.PREVIOUS;
			} else if (areEqual(switchArgument, MapperS.of("Last"), CardinalityOperator.All).get()) {
				result = RealisedVarianceMethodEnum.LAST;
			} else if (areEqual(switchArgument, MapperS.of("Both"), CardinalityOperator.All).get()) {
				result = RealisedVarianceMethodEnum.BOTH;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

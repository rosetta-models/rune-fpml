package fpml.enumeration.mapping.functions;

import cdm.base.math.AveragingWeightingMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapAveragingWeightingMethodEnum.MapAveragingWeightingMethodEnumDefault.class)
public abstract class MapAveragingWeightingMethodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public AveragingWeightingMethodEnum evaluate(String value) {
		AveragingWeightingMethodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract AveragingWeightingMethodEnum doEvaluate(String value);

	public static class MapAveragingWeightingMethodEnumDefault extends MapAveragingWeightingMethodEnum {
		@Override
		protected AveragingWeightingMethodEnum doEvaluate(String value) {
			AveragingWeightingMethodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected AveragingWeightingMethodEnum assignOutput(AveragingWeightingMethodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Unweighted"), CardinalityOperator.All).get()) {
				result = AveragingWeightingMethodEnum.UNWEIGHTED;
			} else if (areEqual(switchArgument, MapperS.of("Arithmetic"), CardinalityOperator.All).get()) {
				result = AveragingWeightingMethodEnum.UNWEIGHTED;
			} else if (areEqual(switchArgument, MapperS.of("Geometric"), CardinalityOperator.All).get()) {
				result = AveragingWeightingMethodEnum.UNWEIGHTED;
			} else if (areEqual(switchArgument, MapperS.of("Harmonic"), CardinalityOperator.All).get()) {
				result = AveragingWeightingMethodEnum.UNWEIGHTED;
			} else if (areEqual(switchArgument, MapperS.of("Weighted"), CardinalityOperator.All).get()) {
				result = AveragingWeightingMethodEnum.WEIGHTED;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

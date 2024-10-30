package fpml.enumeration.mapping.functions;

import cdm.base.math.AveragingCalculationMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapAveragingCalculationMethodEnum.MapAveragingCalculationMethodEnumDefault.class)
public abstract class MapAveragingCalculationMethodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public AveragingCalculationMethodEnum evaluate(String value) {
		AveragingCalculationMethodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract AveragingCalculationMethodEnum doEvaluate(String value);

	public static class MapAveragingCalculationMethodEnumDefault extends MapAveragingCalculationMethodEnum {
		@Override
		protected AveragingCalculationMethodEnum doEvaluate(String value) {
			AveragingCalculationMethodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected AveragingCalculationMethodEnum assignOutput(AveragingCalculationMethodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Unweighted"), CardinalityOperator.All).get()) {
				result = AveragingCalculationMethodEnum.ARITHMETIC;
			} else if (areEqual(switchArgument, MapperS.of("Weighted"), CardinalityOperator.All).get()) {
				result = AveragingCalculationMethodEnum.ARITHMETIC;
			} else if (areEqual(switchArgument, MapperS.of("Arithmetic"), CardinalityOperator.All).get()) {
				result = AveragingCalculationMethodEnum.ARITHMETIC;
			} else if (areEqual(switchArgument, MapperS.of("Geometric"), CardinalityOperator.All).get()) {
				result = AveragingCalculationMethodEnum.GEOMETRIC;
			} else if (areEqual(switchArgument, MapperS.of("Harmonic"), CardinalityOperator.All).get()) {
				result = AveragingCalculationMethodEnum.HARMONIC;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

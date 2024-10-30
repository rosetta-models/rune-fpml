package fpml.enumeration.mapping.functions;

import cdm.observable.asset.calculatedrate.CalculationMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCalculationMethodEnum.MapCalculationMethodEnumDefault.class)
public abstract class MapCalculationMethodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CalculationMethodEnum evaluate(String value) {
		CalculationMethodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CalculationMethodEnum doEvaluate(String value);

	public static class MapCalculationMethodEnumDefault extends MapCalculationMethodEnum {
		@Override
		protected CalculationMethodEnum doEvaluate(String value) {
			CalculationMethodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CalculationMethodEnum assignOutput(CalculationMethodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Averaging"), CardinalityOperator.All).get()) {
				result = CalculationMethodEnum.AVERAGING;
			} else if (areEqual(switchArgument, MapperS.of("Compounding"), CardinalityOperator.All).get()) {
				result = CalculationMethodEnum.COMPOUNDING;
			} else if (areEqual(switchArgument, MapperS.of("CompoundedIndex"), CardinalityOperator.All).get()) {
				result = CalculationMethodEnum.COMPOUNDED_INDEX;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

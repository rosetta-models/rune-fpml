package fpml.enumeration.mapping.functions;

import cdm.product.common.schedule.ResetRelativeToEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapResetRelativeToEnum.MapResetRelativeToEnumDefault.class)
public abstract class MapResetRelativeToEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ResetRelativeToEnum evaluate(String value) {
		ResetRelativeToEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ResetRelativeToEnum doEvaluate(String value);

	public static class MapResetRelativeToEnumDefault extends MapResetRelativeToEnum {
		@Override
		protected ResetRelativeToEnum doEvaluate(String value) {
			ResetRelativeToEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ResetRelativeToEnum assignOutput(ResetRelativeToEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("CalculationPeriodStartDate"), CardinalityOperator.All).get()) {
				result = ResetRelativeToEnum.CALCULATION_PERIOD_START_DATE;
			} else if (areEqual(switchArgument, MapperS.of("CalculationPeriodEndDate"), CardinalityOperator.All).get()) {
				result = ResetRelativeToEnum.CALCULATION_PERIOD_END_DATE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

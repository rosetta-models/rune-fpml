package fpml.enumeration.mapping.functions;

import cdm.product.common.schedule.PayRelativeToEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPayRelativeToEnum.MapPayRelativeToEnumDefault.class)
public abstract class MapPayRelativeToEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PayRelativeToEnum evaluate(String value) {
		PayRelativeToEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PayRelativeToEnum doEvaluate(String value);

	public static class MapPayRelativeToEnumDefault extends MapPayRelativeToEnum {
		@Override
		protected PayRelativeToEnum doEvaluate(String value) {
			PayRelativeToEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PayRelativeToEnum assignOutput(PayRelativeToEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("CalculationPeriodStartDate"), CardinalityOperator.All).get()) {
				result = PayRelativeToEnum.CALCULATION_PERIOD_START_DATE;
			} else if (areEqual(switchArgument, MapperS.of("CalculationPeriodEndDate"), CardinalityOperator.All).get()) {
				result = PayRelativeToEnum.CALCULATION_PERIOD_END_DATE;
			} else if (areEqual(switchArgument, MapperS.of("LastPricingDate"), CardinalityOperator.All).get()) {
				result = PayRelativeToEnum.LAST_PRICING_DATE;
			} else if (areEqual(switchArgument, MapperS.of("ResetDate"), CardinalityOperator.All).get()) {
				result = PayRelativeToEnum.RESET_DATE;
			} else if (areEqual(switchArgument, MapperS.of("ValuationDate"), CardinalityOperator.All).get()) {
				result = PayRelativeToEnum.VALUATION_DATE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

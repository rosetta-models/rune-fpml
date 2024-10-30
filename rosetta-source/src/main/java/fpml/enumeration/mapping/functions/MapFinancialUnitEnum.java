package fpml.enumeration.mapping.functions;

import cdm.base.math.FinancialUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapFinancialUnitEnum.MapFinancialUnitEnumDefault.class)
public abstract class MapFinancialUnitEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public FinancialUnitEnum evaluate(String value) {
		FinancialUnitEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract FinancialUnitEnum doEvaluate(String value);

	public static class MapFinancialUnitEnumDefault extends MapFinancialUnitEnum {
		@Override
		protected FinancialUnitEnum doEvaluate(String value) {
			FinancialUnitEnum result = null;
			return assignOutput(result, value);
		}
		
		protected FinancialUnitEnum assignOutput(FinancialUnitEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("IndexUnits"), CardinalityOperator.All).get()) {
				result = FinancialUnitEnum.INDEX_UNIT;
			} else if (areEqual(switchArgument, MapperS.of("LogNormalVolatility"), CardinalityOperator.All).get()) {
				result = FinancialUnitEnum.LOG_NORMAL_VOLATILITY;
			} else if (areEqual(switchArgument, MapperS.of("Shares"), CardinalityOperator.All).get()) {
				result = FinancialUnitEnum.SHARE;
			} else if (areEqual(switchArgument, MapperS.of("ValuePerDay"), CardinalityOperator.All).get()) {
				result = FinancialUnitEnum.VALUE_PER_DAY;
			} else if (areEqual(switchArgument, MapperS.of("ValuePerPercent"), CardinalityOperator.All).get()) {
				result = FinancialUnitEnum.VALUE_PER_PERCENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

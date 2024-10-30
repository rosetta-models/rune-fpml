package fpml.enumeration.mapping.functions;

import cdm.product.asset.DividendPeriodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDividendPeriodEnum.MapDividendPeriodEnumDefault.class)
public abstract class MapDividendPeriodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DividendPeriodEnum evaluate(String value) {
		DividendPeriodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DividendPeriodEnum doEvaluate(String value);

	public static class MapDividendPeriodEnumDefault extends MapDividendPeriodEnum {
		@Override
		protected DividendPeriodEnum doEvaluate(String value) {
			DividendPeriodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DividendPeriodEnum assignOutput(DividendPeriodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("FirstPeriod"), CardinalityOperator.All).get()) {
				result = DividendPeriodEnum.FIRST_PERIOD;
			} else if (areEqual(switchArgument, MapperS.of("SecondPeriod"), CardinalityOperator.All).get()) {
				result = DividendPeriodEnum.SECOND_PERIOD;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.product.common.NotionalAdjustmentEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapNotionalAdjustmentEnum.MapNotionalAdjustmentEnumDefault.class)
public abstract class MapNotionalAdjustmentEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public NotionalAdjustmentEnum evaluate(String value) {
		NotionalAdjustmentEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract NotionalAdjustmentEnum doEvaluate(String value);

	public static class MapNotionalAdjustmentEnumDefault extends MapNotionalAdjustmentEnum {
		@Override
		protected NotionalAdjustmentEnum doEvaluate(String value) {
			NotionalAdjustmentEnum result = null;
			return assignOutput(result, value);
		}
		
		protected NotionalAdjustmentEnum assignOutput(NotionalAdjustmentEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Execution"), CardinalityOperator.All).get()) {
				result = NotionalAdjustmentEnum.EXECUTION;
			} else if (areEqual(switchArgument, MapperS.of("PortfolioRebalancing"), CardinalityOperator.All).get()) {
				result = NotionalAdjustmentEnum.PORTFOLIO_REBALANCING;
			} else if (areEqual(switchArgument, MapperS.of("Standard"), CardinalityOperator.All).get()) {
				result = NotionalAdjustmentEnum.STANDARD;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.observable.asset.QuotationStyleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapQuotationStyleEnum.MapQuotationStyleEnumDefault.class)
public abstract class MapQuotationStyleEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public QuotationStyleEnum evaluate(String value) {
		QuotationStyleEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract QuotationStyleEnum doEvaluate(String value);

	public static class MapQuotationStyleEnumDefault extends MapQuotationStyleEnum {
		@Override
		protected QuotationStyleEnum doEvaluate(String value) {
			QuotationStyleEnum result = null;
			return assignOutput(result, value);
		}
		
		protected QuotationStyleEnum assignOutput(QuotationStyleEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("PointsUpFront"), CardinalityOperator.All).get()) {
				result = QuotationStyleEnum.POINTS_UP_FRONT;
			} else if (areEqual(switchArgument, MapperS.of("TradedSpread"), CardinalityOperator.All).get()) {
				result = QuotationStyleEnum.TRADED_SPREAD;
			} else if (areEqual(switchArgument, MapperS.of("Price"), CardinalityOperator.All).get()) {
				result = QuotationStyleEnum.PRICE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.observable.asset.PriceExpressionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPriceExpressionEnum.MapPriceExpressionEnumDefault.class)
public abstract class MapPriceExpressionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PriceExpressionEnum evaluate(String value) {
		PriceExpressionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PriceExpressionEnum doEvaluate(String value);

	public static class MapPriceExpressionEnumDefault extends MapPriceExpressionEnum {
		@Override
		protected PriceExpressionEnum doEvaluate(String value) {
			PriceExpressionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PriceExpressionEnum assignOutput(PriceExpressionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AbsoluteTerms"), CardinalityOperator.All).get()) {
				result = PriceExpressionEnum.ABSOLUTE_TERMS;
			} else if (areEqual(switchArgument, MapperS.of("PercentageOfNotional"), CardinalityOperator.All).get()) {
				result = PriceExpressionEnum.PERCENTAGE_OF_NOTIONAL;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

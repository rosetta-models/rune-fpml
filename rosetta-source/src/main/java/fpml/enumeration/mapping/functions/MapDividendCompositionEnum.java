package fpml.enumeration.mapping.functions;

import cdm.product.asset.DividendCompositionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDividendCompositionEnum.MapDividendCompositionEnumDefault.class)
public abstract class MapDividendCompositionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DividendCompositionEnum evaluate(String value) {
		DividendCompositionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DividendCompositionEnum doEvaluate(String value);

	public static class MapDividendCompositionEnumDefault extends MapDividendCompositionEnum {
		@Override
		protected DividendCompositionEnum doEvaluate(String value) {
			DividendCompositionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DividendCompositionEnum assignOutput(DividendCompositionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("EquityAmountReceiverElection"), CardinalityOperator.All).get()) {
				result = DividendCompositionEnum.EQUITY_AMOUNT_RECEIVER_ELECTION;
			} else if (areEqual(switchArgument, MapperS.of("CalculationAgentElection"), CardinalityOperator.All).get()) {
				result = DividendCompositionEnum.CALCULATION_AGENT_ELECTION;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

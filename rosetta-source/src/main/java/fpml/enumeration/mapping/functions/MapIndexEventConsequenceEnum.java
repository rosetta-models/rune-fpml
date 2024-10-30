package fpml.enumeration.mapping.functions;

import cdm.observable.event.IndexEventConsequenceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapIndexEventConsequenceEnum.MapIndexEventConsequenceEnumDefault.class)
public abstract class MapIndexEventConsequenceEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public IndexEventConsequenceEnum evaluate(String value) {
		IndexEventConsequenceEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract IndexEventConsequenceEnum doEvaluate(String value);

	public static class MapIndexEventConsequenceEnumDefault extends MapIndexEventConsequenceEnum {
		@Override
		protected IndexEventConsequenceEnum doEvaluate(String value) {
			IndexEventConsequenceEnum result = null;
			return assignOutput(result, value);
		}
		
		protected IndexEventConsequenceEnum assignOutput(IndexEventConsequenceEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("CalculationAgentAdjustment"), CardinalityOperator.All).get()) {
				result = IndexEventConsequenceEnum.CALCULATION_AGENT_ADJUSTMENT;
			} else if (areEqual(switchArgument, MapperS.of("NegotiatedCloseOut"), CardinalityOperator.All).get()) {
				result = IndexEventConsequenceEnum.NEGOTIATED_CLOSE_OUT;
			} else if (areEqual(switchArgument, MapperS.of("CancellationAndPayment"), CardinalityOperator.All).get()) {
				result = IndexEventConsequenceEnum.CANCELLATION_AND_PAYMENT;
			} else if (areEqual(switchArgument, MapperS.of("RelatedExchange"), CardinalityOperator.All).get()) {
				result = IndexEventConsequenceEnum.RELATED_EXCHANGE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

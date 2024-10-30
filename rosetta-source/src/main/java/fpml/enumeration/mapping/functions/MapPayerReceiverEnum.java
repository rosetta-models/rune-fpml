package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.party.PayerReceiverEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPayerReceiverEnum.MapPayerReceiverEnumDefault.class)
public abstract class MapPayerReceiverEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PayerReceiverEnum evaluate(String value) {
		PayerReceiverEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PayerReceiverEnum doEvaluate(String value);

	public static class MapPayerReceiverEnumDefault extends MapPayerReceiverEnum {
		@Override
		protected PayerReceiverEnum doEvaluate(String value) {
			PayerReceiverEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PayerReceiverEnum assignOutput(PayerReceiverEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Payer"), CardinalityOperator.All).get()) {
				result = PayerReceiverEnum.PAYER;
			} else if (areEqual(switchArgument, MapperS.of("Receiver"), CardinalityOperator.All).get()) {
				result = PayerReceiverEnum.RECEIVER;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

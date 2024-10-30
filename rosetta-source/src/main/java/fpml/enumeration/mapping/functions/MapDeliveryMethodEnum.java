package fpml.enumeration.mapping.functions;

import cdm.product.common.settlement.DeliveryMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDeliveryMethodEnum.MapDeliveryMethodEnumDefault.class)
public abstract class MapDeliveryMethodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DeliveryMethodEnum evaluate(String value) {
		DeliveryMethodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DeliveryMethodEnum doEvaluate(String value);

	public static class MapDeliveryMethodEnumDefault extends MapDeliveryMethodEnum {
		@Override
		protected DeliveryMethodEnum doEvaluate(String value) {
			DeliveryMethodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DeliveryMethodEnum assignOutput(DeliveryMethodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("DeliveryVersusPayment"), CardinalityOperator.All).get()) {
				result = DeliveryMethodEnum.DELIVERY_VERSUS_PAYMENT;
			} else if (areEqual(switchArgument, MapperS.of("FreeOfPayment"), CardinalityOperator.All).get()) {
				result = DeliveryMethodEnum.FREE_OF_PAYMENT;
			} else if (areEqual(switchArgument, MapperS.of("PreDelivery"), CardinalityOperator.All).get()) {
				result = DeliveryMethodEnum.PRE_DELIVERY;
			} else if (areEqual(switchArgument, MapperS.of("PrePayment"), CardinalityOperator.All).get()) {
				result = DeliveryMethodEnum.PRE_PAYMENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

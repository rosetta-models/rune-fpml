package fpml.enumeration.mapping.functions;

import cdm.product.common.settlement.ScheduledTransferEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapScheduledTransferEnum.MapScheduledTransferEnumDefault.class)
public abstract class MapScheduledTransferEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ScheduledTransferEnum evaluate(String value) {
		ScheduledTransferEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ScheduledTransferEnum doEvaluate(String value);

	public static class MapScheduledTransferEnumDefault extends MapScheduledTransferEnum {
		@Override
		protected ScheduledTransferEnum doEvaluate(String value) {
			ScheduledTransferEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ScheduledTransferEnum assignOutput(ScheduledTransferEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Coupon"), CardinalityOperator.All).get()) {
				result = ScheduledTransferEnum.COUPON;
			} else if (areEqual(switchArgument, MapperS.of("CreditEvent"), CardinalityOperator.All).get()) {
				result = ScheduledTransferEnum.CREDIT_EVENT;
			} else if (areEqual(switchArgument, MapperS.of("DividendReturn"), CardinalityOperator.All).get()) {
				result = ScheduledTransferEnum.DIVIDEND_RETURN;
			} else if (areEqual(switchArgument, MapperS.of("ExerciseFee"), CardinalityOperator.All).get()) {
				result = ScheduledTransferEnum.EXERCISE;
			} else if (areEqual(switchArgument, MapperS.of("InterestReturn"), CardinalityOperator.All).get()) {
				result = ScheduledTransferEnum.INTEREST_RETURN;
			} else if (areEqual(switchArgument, MapperS.of("PriceReturn"), CardinalityOperator.All).get()) {
				result = ScheduledTransferEnum.PERFORMANCE;
			} else if (areEqual(switchArgument, MapperS.of("PrincipleExchange"), CardinalityOperator.All).get()) {
				result = ScheduledTransferEnum.PRINCIPAL_PAYMENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.product.asset.DividendDateReferenceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDividendDateReferenceEnum.MapDividendDateReferenceEnumDefault.class)
public abstract class MapDividendDateReferenceEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DividendDateReferenceEnum evaluate(String value) {
		DividendDateReferenceEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DividendDateReferenceEnum doEvaluate(String value);

	public static class MapDividendDateReferenceEnumDefault extends MapDividendDateReferenceEnum {
		@Override
		protected DividendDateReferenceEnum doEvaluate(String value) {
			DividendDateReferenceEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DividendDateReferenceEnum assignOutput(DividendDateReferenceEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AdHocDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.AD_HOC_DATE;
			} else if (areEqual(switchArgument, MapperS.of("CashSettlementPaymentDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.CASH_SETTLEMENT_PAYMENT_DATE;
			} else if (areEqual(switchArgument, MapperS.of("CashSettlePaymentDateExDiv"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.CASH_SETTLE_PAYMENT_DATE_EX_DIV;
			} else if (areEqual(switchArgument, MapperS.of("CashSettlePaymentDateIssuerPayment"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.CASH_SETTLE_PAYMENT_DATE_ISSUER_PAYMENT;
			} else if (areEqual(switchArgument, MapperS.of("CumulativeEquityExDiv"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.CUMULATIVE_EQUITY_EX_DIV;
			} else if (areEqual(switchArgument, MapperS.of("CumulativeEquityPaid"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.CUMULATIVE_EQUITY_PAID;
			} else if (areEqual(switchArgument, MapperS.of("CumulativeLiborExDiv"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.CUMULATIVE_INTEREST_EX_DIV;
			} else if (areEqual(switchArgument, MapperS.of("CumulativeLiborPaid"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.CUMULATIVE_INTEREST_PAID;
			} else if (areEqual(switchArgument, MapperS.of("DividendPaymentDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.DIVIDEND_PAYMENT_DATE;
			} else if (areEqual(switchArgument, MapperS.of("DividendValuationDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.DIVIDEND_VALUATION_DATE;
			} else if (areEqual(switchArgument, MapperS.of("EquityPaymentDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.EQUITY_PAYMENT_DATE;
			} else if (areEqual(switchArgument, MapperS.of("ExDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.EX_DATE;
			} else if (areEqual(switchArgument, MapperS.of("FloatingAmountPaymentDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.FLOATING_AMOUNT_PAYMENT_DATE;
			} else if (areEqual(switchArgument, MapperS.of("FollowingPaymentDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.FOLLOWING_PAYMENT_DATE;
			} else if (areEqual(switchArgument, MapperS.of("RecordDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.RECORD_DATE;
			} else if (areEqual(switchArgument, MapperS.of("SharePayment"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.SHARE_PAYMENT;
			} else if (areEqual(switchArgument, MapperS.of("TerminationDate"), CardinalityOperator.All).get()) {
				result = DividendDateReferenceEnum.TERMINATION_DATE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

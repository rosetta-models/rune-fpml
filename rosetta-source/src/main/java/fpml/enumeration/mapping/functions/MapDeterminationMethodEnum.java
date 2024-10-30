package fpml.enumeration.mapping.functions;

import cdm.observable.common.DeterminationMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDeterminationMethodEnum.MapDeterminationMethodEnumDefault.class)
public abstract class MapDeterminationMethodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DeterminationMethodEnum evaluate(String value) {
		DeterminationMethodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DeterminationMethodEnum doEvaluate(String value);

	public static class MapDeterminationMethodEnumDefault extends MapDeterminationMethodEnum {
		@Override
		protected DeterminationMethodEnum doEvaluate(String value) {
			DeterminationMethodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DeterminationMethodEnum assignOutput(DeterminationMethodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AgreedInitialPrice"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.AGREED_INITIAL_PRICE;
			} else if (areEqual(switchArgument, MapperS.of("AsSpecifiedInMasterConfirmation"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.AS_SPECIFIED_IN_MASTER_CONFIRMATION;
			} else if (areEqual(switchArgument, MapperS.of("CalculationAgent"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.CALCULATION_AGENT;
			} else if (areEqual(switchArgument, MapperS.of("ClosingPrice"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.CLOSING_PRICE;
			} else if (areEqual(switchArgument, MapperS.of("DividendCurrency"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.DIVIDEND_CURRENCY;
			} else if (areEqual(switchArgument, MapperS.of("ExpiringContractLevel"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.EXPIRING_CONTRACT_LEVEL;
			} else if (areEqual(switchArgument, MapperS.of("HedgeExecution"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.HEDGE_EXECUTION;
			} else if (areEqual(switchArgument, MapperS.of("IssuerPaymentCurrency"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.ISSUER_PAYMENT_CURRENCY;
			} else if (areEqual(switchArgument, MapperS.of("NAV"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.NAV;
			} else if (areEqual(switchArgument, MapperS.of("OpenPrice"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.OPEN_PRICE;
			} else if (areEqual(switchArgument, MapperS.of("OSPPrice"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.OSP_PRICE;
			} else if (areEqual(switchArgument, MapperS.of("SettlementCurrency"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.SETTLEMENT_CURRENCY;
			} else if (areEqual(switchArgument, MapperS.of("StrikeDateDetermination"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.STRIKE_DATE_DETERMINATION;
			} else if (areEqual(switchArgument, MapperS.of("TWAPPrice"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.TWAP_PRICE;
			} else if (areEqual(switchArgument, MapperS.of("ValuationTime"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.VALUATION_TIME;
			} else if (areEqual(switchArgument, MapperS.of("VWAPPrice"), CardinalityOperator.All).get()) {
				result = DeterminationMethodEnum.VWAP_PRICE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

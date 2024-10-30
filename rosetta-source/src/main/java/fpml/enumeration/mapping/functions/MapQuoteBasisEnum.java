package fpml.enumeration.mapping.functions;

import cdm.observable.asset.QuoteBasisEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapQuoteBasisEnum.MapQuoteBasisEnumDefault.class)
public abstract class MapQuoteBasisEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public QuoteBasisEnum evaluate(String value) {
		QuoteBasisEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract QuoteBasisEnum doEvaluate(String value);

	public static class MapQuoteBasisEnumDefault extends MapQuoteBasisEnum {
		@Override
		protected QuoteBasisEnum doEvaluate(String value) {
			QuoteBasisEnum result = null;
			return assignOutput(result, value);
		}
		
		protected QuoteBasisEnum assignOutput(QuoteBasisEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Currency1PerCurrency2"), CardinalityOperator.All).get()) {
				result = QuoteBasisEnum.CURRENCY_1_PER_CURRENCY_2;
			} else if (areEqual(switchArgument, MapperS.of("PutCurrencyPerCallCurrency"), CardinalityOperator.All).get()) {
				result = QuoteBasisEnum.CURRENCY_1_PER_CURRENCY_2;
			} else if (areEqual(switchArgument, MapperS.of("Currency2PerCurrency1"), CardinalityOperator.All).get()) {
				result = QuoteBasisEnum.CURRENCY_2_PER_CURRENCY_1;
			} else if (areEqual(switchArgument, MapperS.of("CallCurrencyPerPutCurrency"), CardinalityOperator.All).get()) {
				result = QuoteBasisEnum.CURRENCY_2_PER_CURRENCY_1;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

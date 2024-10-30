package fpml.enumeration.mapping.functions;

import cdm.observable.asset.QuotationRateTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapQuotationRateTypeEnum.MapQuotationRateTypeEnumDefault.class)
public abstract class MapQuotationRateTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public QuotationRateTypeEnum evaluate(String value) {
		QuotationRateTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract QuotationRateTypeEnum doEvaluate(String value);

	public static class MapQuotationRateTypeEnumDefault extends MapQuotationRateTypeEnum {
		@Override
		protected QuotationRateTypeEnum doEvaluate(String value) {
			QuotationRateTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected QuotationRateTypeEnum assignOutput(QuotationRateTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Bid"), CardinalityOperator.All).get()) {
				result = QuotationRateTypeEnum.BID;
			} else if (areEqual(switchArgument, MapperS.of("Ask"), CardinalityOperator.All).get()) {
				result = QuotationRateTypeEnum.ASK;
			} else if (areEqual(switchArgument, MapperS.of("Mid"), CardinalityOperator.All).get()) {
				result = QuotationRateTypeEnum.MID;
			} else if (areEqual(switchArgument, MapperS.of("ExercisingPartyPays"), CardinalityOperator.All).get()) {
				result = QuotationRateTypeEnum.EXERCISING_PARTY_PAYS;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

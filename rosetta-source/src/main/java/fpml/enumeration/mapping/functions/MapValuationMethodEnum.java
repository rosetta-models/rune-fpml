package fpml.enumeration.mapping.functions;

import cdm.observable.asset.ValuationMethodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapValuationMethodEnum.MapValuationMethodEnumDefault.class)
public abstract class MapValuationMethodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ValuationMethodEnum evaluate(String value) {
		ValuationMethodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ValuationMethodEnum doEvaluate(String value);

	public static class MapValuationMethodEnumDefault extends MapValuationMethodEnum {
		@Override
		protected ValuationMethodEnum doEvaluate(String value) {
			ValuationMethodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ValuationMethodEnum assignOutput(ValuationMethodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Market"), CardinalityOperator.All).get()) {
				result = ValuationMethodEnum.MARKET;
			} else if (areEqual(switchArgument, MapperS.of("Highest"), CardinalityOperator.All).get()) {
				result = ValuationMethodEnum.HIGHEST;
			} else if (areEqual(switchArgument, MapperS.of("AverageMarket"), CardinalityOperator.All).get()) {
				result = ValuationMethodEnum.AVERAGE_MARKET;
			} else if (areEqual(switchArgument, MapperS.of("AverageHighest"), CardinalityOperator.All).get()) {
				result = ValuationMethodEnum.AVERAGE_HIGHEST;
			} else if (areEqual(switchArgument, MapperS.of("BlendedMarket"), CardinalityOperator.All).get()) {
				result = ValuationMethodEnum.BLENDED_MARKET;
			} else if (areEqual(switchArgument, MapperS.of("BlendedHighest"), CardinalityOperator.All).get()) {
				result = ValuationMethodEnum.BLENDED_HIGHEST;
			} else if (areEqual(switchArgument, MapperS.of("AverageBlendedMarket"), CardinalityOperator.All).get()) {
				result = ValuationMethodEnum.AVERAGE_BLENDED_MARKET;
			} else if (areEqual(switchArgument, MapperS.of("AverageBlendedHighest"), CardinalityOperator.All).get()) {
				result = ValuationMethodEnum.AVERAGE_BLENDED_HIGHEST;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

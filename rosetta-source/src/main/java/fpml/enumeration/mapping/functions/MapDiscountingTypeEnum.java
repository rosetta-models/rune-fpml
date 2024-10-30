package fpml.enumeration.mapping.functions;

import cdm.product.asset.DiscountingTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDiscountingTypeEnum.MapDiscountingTypeEnumDefault.class)
public abstract class MapDiscountingTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DiscountingTypeEnum evaluate(String value) {
		DiscountingTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DiscountingTypeEnum doEvaluate(String value);

	public static class MapDiscountingTypeEnumDefault extends MapDiscountingTypeEnum {
		@Override
		protected DiscountingTypeEnum doEvaluate(String value) {
			DiscountingTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DiscountingTypeEnum assignOutput(DiscountingTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Standard"), CardinalityOperator.All).get()) {
				result = DiscountingTypeEnum.STANDARD;
			} else if (areEqual(switchArgument, MapperS.of("FRA"), CardinalityOperator.All).get()) {
				result = DiscountingTypeEnum.FRA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA"), CardinalityOperator.All).get()) {
				result = DiscountingTypeEnum.FRA;
			} else if (areEqual(switchArgument, MapperS.of("FRAYield"), CardinalityOperator.All).get()) {
				result = DiscountingTypeEnum.FRA_YIELD;
			} else if (areEqual(switchArgument, MapperS.of("AFMA"), CardinalityOperator.All).get()) {
				result = DiscountingTypeEnum.AFMA;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

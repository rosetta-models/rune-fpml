package fpml.enumeration.mapping.functions;

import cdm.product.asset.ReturnTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapReturnTypeEnum.MapReturnTypeEnumDefault.class)
public abstract class MapReturnTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ReturnTypeEnum evaluate(String value) {
		ReturnTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ReturnTypeEnum doEvaluate(String value);

	public static class MapReturnTypeEnumDefault extends MapReturnTypeEnum {
		@Override
		protected ReturnTypeEnum doEvaluate(String value) {
			ReturnTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ReturnTypeEnum assignOutput(ReturnTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Price"), CardinalityOperator.All).get()) {
				result = ReturnTypeEnum.PRICE;
			} else if (areEqual(switchArgument, MapperS.of("Total"), CardinalityOperator.All).get()) {
				result = ReturnTypeEnum.TOTAL;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

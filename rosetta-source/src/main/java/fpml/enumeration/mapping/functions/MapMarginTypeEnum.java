package fpml.enumeration.mapping.functions;

import cdm.product.template.MarginTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapMarginTypeEnum.MapMarginTypeEnumDefault.class)
public abstract class MapMarginTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public MarginTypeEnum evaluate(String value) {
		MarginTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract MarginTypeEnum doEvaluate(String value);

	public static class MapMarginTypeEnumDefault extends MapMarginTypeEnum {
		@Override
		protected MarginTypeEnum doEvaluate(String value) {
			MarginTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected MarginTypeEnum assignOutput(MarginTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Cash"), CardinalityOperator.All).get()) {
				result = MarginTypeEnum.CASH;
			} else if (areEqual(switchArgument, MapperS.of("Instrument"), CardinalityOperator.All).get()) {
				result = MarginTypeEnum.INSTRUMENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

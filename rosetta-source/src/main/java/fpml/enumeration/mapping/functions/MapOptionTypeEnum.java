package fpml.enumeration.mapping.functions;

import cdm.product.template.OptionTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapOptionTypeEnum.MapOptionTypeEnumDefault.class)
public abstract class MapOptionTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public OptionTypeEnum evaluate(String value) {
		OptionTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract OptionTypeEnum doEvaluate(String value);

	public static class MapOptionTypeEnumDefault extends MapOptionTypeEnum {
		@Override
		protected OptionTypeEnum doEvaluate(String value) {
			OptionTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected OptionTypeEnum assignOutput(OptionTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Payer"), CardinalityOperator.All).get()) {
				result = OptionTypeEnum.PAYER;
			} else if (areEqual(switchArgument, MapperS.of("Receiver"), CardinalityOperator.All).get()) {
				result = OptionTypeEnum.RECEIVER;
			} else if (areEqual(switchArgument, MapperS.of("Straddle"), CardinalityOperator.All).get()) {
				result = OptionTypeEnum.STRADDLE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

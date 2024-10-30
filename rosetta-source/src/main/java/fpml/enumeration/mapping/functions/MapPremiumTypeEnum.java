package fpml.enumeration.mapping.functions;

import cdm.observable.asset.PremiumTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPremiumTypeEnum.MapPremiumTypeEnumDefault.class)
public abstract class MapPremiumTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PremiumTypeEnum evaluate(String value) {
		PremiumTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PremiumTypeEnum doEvaluate(String value);

	public static class MapPremiumTypeEnumDefault extends MapPremiumTypeEnum {
		@Override
		protected PremiumTypeEnum doEvaluate(String value) {
			PremiumTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PremiumTypeEnum assignOutput(PremiumTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("PrePaid"), CardinalityOperator.All).get()) {
				result = PremiumTypeEnum.PRE_PAID;
			} else if (areEqual(switchArgument, MapperS.of("PostPaid"), CardinalityOperator.All).get()) {
				result = PremiumTypeEnum.POST_PAID;
			} else if (areEqual(switchArgument, MapperS.of("Variable"), CardinalityOperator.All).get()) {
				result = PremiumTypeEnum.VARIABLE;
			} else if (areEqual(switchArgument, MapperS.of("Fixed"), CardinalityOperator.All).get()) {
				result = PremiumTypeEnum.FIXED;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

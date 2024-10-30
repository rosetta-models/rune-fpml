package fpml.enumeration.mapping.functions;

import cdm.product.asset.CreditSeniorityEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCreditSeniorityEnum.MapCreditSeniorityEnumDefault.class)
public abstract class MapCreditSeniorityEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CreditSeniorityEnum evaluate(String value) {
		CreditSeniorityEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CreditSeniorityEnum doEvaluate(String value);

	public static class MapCreditSeniorityEnumDefault extends MapCreditSeniorityEnum {
		@Override
		protected CreditSeniorityEnum doEvaluate(String value) {
			CreditSeniorityEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CreditSeniorityEnum assignOutput(CreditSeniorityEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Other"), CardinalityOperator.All).get()) {
				result = CreditSeniorityEnum.OTHER;
			} else if (areEqual(switchArgument, MapperS.of("SeniorLossAbsorbingCapacity"), CardinalityOperator.All).get()) {
				result = CreditSeniorityEnum.SENIOR_LOSS_ABSORBING_CAPACITY;
			} else if (areEqual(switchArgument, MapperS.of("SeniorSec"), CardinalityOperator.All).get()) {
				result = CreditSeniorityEnum.SENIOR_SEC;
			} else if (areEqual(switchArgument, MapperS.of("SeniorUnSec"), CardinalityOperator.All).get()) {
				result = CreditSeniorityEnum.SENIOR_UN_SEC;
			} else if (areEqual(switchArgument, MapperS.of("SubLowerTier2"), CardinalityOperator.All).get()) {
				result = CreditSeniorityEnum.SUB_LOWER_TIER_2;
			} else if (areEqual(switchArgument, MapperS.of("SubTier1"), CardinalityOperator.All).get()) {
				result = CreditSeniorityEnum.SUB_TIER_1;
			} else if (areEqual(switchArgument, MapperS.of("SubTier3"), CardinalityOperator.All).get()) {
				result = CreditSeniorityEnum.SUB_TIER_3;
			} else if (areEqual(switchArgument, MapperS.of("SubUpperTier2"), CardinalityOperator.All).get()) {
				result = CreditSeniorityEnum.SUB_UPPER_TIER_2;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

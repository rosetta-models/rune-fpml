package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapNaturalPersonRoleEnum.MapNaturalPersonRoleEnumDefault.class)
public abstract class MapNaturalPersonRoleEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public NaturalPersonRoleEnum evaluate(String value) {
		NaturalPersonRoleEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract NaturalPersonRoleEnum doEvaluate(String value);

	public static class MapNaturalPersonRoleEnumDefault extends MapNaturalPersonRoleEnum {
		@Override
		protected NaturalPersonRoleEnum doEvaluate(String value) {
			NaturalPersonRoleEnum result = null;
			return assignOutput(result, value);
		}
		
		protected NaturalPersonRoleEnum assignOutput(NaturalPersonRoleEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Broker"), CardinalityOperator.All).get()) {
				result = NaturalPersonRoleEnum.BROKER;
			} else if (areEqual(switchArgument, MapperS.of("Buyer"), CardinalityOperator.All).get()) {
				result = NaturalPersonRoleEnum.BUYER;
			} else if (areEqual(switchArgument, MapperS.of("DecisionMaker"), CardinalityOperator.All).get()) {
				result = NaturalPersonRoleEnum.DECISION_MAKER;
			} else if (areEqual(switchArgument, MapperS.of("ExecutionWithinFirm"), CardinalityOperator.All).get()) {
				result = NaturalPersonRoleEnum.EXECUTION_WITHIN_FIRM;
			} else if (areEqual(switchArgument, MapperS.of("InvestmentDecisionMaker"), CardinalityOperator.All).get()) {
				result = NaturalPersonRoleEnum.INVESTMENT_DECISION_MAKER;
			} else if (areEqual(switchArgument, MapperS.of("Seller"), CardinalityOperator.All).get()) {
				result = NaturalPersonRoleEnum.SELLER;
			} else if (areEqual(switchArgument, MapperS.of("Trader"), CardinalityOperator.All).get()) {
				result = NaturalPersonRoleEnum.TRADER;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

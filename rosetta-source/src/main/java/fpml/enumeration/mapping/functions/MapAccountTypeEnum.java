package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.party.AccountTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapAccountTypeEnum.MapAccountTypeEnumDefault.class)
public abstract class MapAccountTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public AccountTypeEnum evaluate(String value) {
		AccountTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract AccountTypeEnum doEvaluate(String value);

	public static class MapAccountTypeEnumDefault extends MapAccountTypeEnum {
		@Override
		protected AccountTypeEnum doEvaluate(String value) {
			AccountTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected AccountTypeEnum assignOutput(AccountTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AggregateClient"), CardinalityOperator.All).get()) {
				result = AccountTypeEnum.AGGREGATE_CLIENT;
			} else if (areEqual(switchArgument, MapperS.of("Client"), CardinalityOperator.All).get()) {
				result = AccountTypeEnum.CLIENT;
			} else if (areEqual(switchArgument, MapperS.of("House"), CardinalityOperator.All).get()) {
				result = AccountTypeEnum.HOUSE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

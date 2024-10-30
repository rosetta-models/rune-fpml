package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.asset.common.PutCallEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPutCallEnum.MapPutCallEnumDefault.class)
public abstract class MapPutCallEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PutCallEnum evaluate(String value) {
		PutCallEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PutCallEnum doEvaluate(String value);

	public static class MapPutCallEnumDefault extends MapPutCallEnum {
		@Override
		protected PutCallEnum doEvaluate(String value) {
			PutCallEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PutCallEnum assignOutput(PutCallEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Put"), CardinalityOperator.All).get()) {
				result = PutCallEnum.PUT;
			} else if (areEqual(switchArgument, MapperS.of("CallCurrencyPerPutCurrency"), CardinalityOperator.All).get()) {
				result = PutCallEnum.PUT;
			} else if (areEqual(switchArgument, MapperS.of("Call"), CardinalityOperator.All).get()) {
				result = PutCallEnum.CALL;
			} else if (areEqual(switchArgument, MapperS.of("PutCurrencyPerCallCurrency"), CardinalityOperator.All).get()) {
				result = PutCallEnum.CALL;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

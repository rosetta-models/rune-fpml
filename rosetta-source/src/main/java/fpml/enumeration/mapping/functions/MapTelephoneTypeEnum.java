package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.party.TelephoneTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapTelephoneTypeEnum.MapTelephoneTypeEnumDefault.class)
public abstract class MapTelephoneTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public TelephoneTypeEnum evaluate(String value) {
		TelephoneTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract TelephoneTypeEnum doEvaluate(String value);

	public static class MapTelephoneTypeEnumDefault extends MapTelephoneTypeEnum {
		@Override
		protected TelephoneTypeEnum doEvaluate(String value) {
			TelephoneTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected TelephoneTypeEnum assignOutput(TelephoneTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Work"), CardinalityOperator.All).get()) {
				result = TelephoneTypeEnum.WORK;
			} else if (areEqual(switchArgument, MapperS.of("Mobile"), CardinalityOperator.All).get()) {
				result = TelephoneTypeEnum.MOBILE;
			} else if (areEqual(switchArgument, MapperS.of("Fax"), CardinalityOperator.All).get()) {
				result = TelephoneTypeEnum.FAX;
			} else if (areEqual(switchArgument, MapperS.of("Personal"), CardinalityOperator.All).get()) {
				result = TelephoneTypeEnum.PERSONAL;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

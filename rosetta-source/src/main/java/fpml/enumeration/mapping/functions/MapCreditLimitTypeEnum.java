package fpml.enumeration.mapping.functions;

import cdm.event.workflow.CreditLimitTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCreditLimitTypeEnum.MapCreditLimitTypeEnumDefault.class)
public abstract class MapCreditLimitTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CreditLimitTypeEnum evaluate(String value) {
		CreditLimitTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CreditLimitTypeEnum doEvaluate(String value);

	public static class MapCreditLimitTypeEnumDefault extends MapCreditLimitTypeEnum {
		@Override
		protected CreditLimitTypeEnum doEvaluate(String value) {
			CreditLimitTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CreditLimitTypeEnum assignOutput(CreditLimitTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("CS01"), CardinalityOperator.All).get()) {
				result = CreditLimitTypeEnum.CS01;
			} else if (areEqual(switchArgument, MapperS.of("DV01"), CardinalityOperator.All).get()) {
				result = CreditLimitTypeEnum.DV01;
			} else if (areEqual(switchArgument, MapperS.of("IM"), CardinalityOperator.All).get()) {
				result = CreditLimitTypeEnum.IM;
			} else if (areEqual(switchArgument, MapperS.of("Notional"), CardinalityOperator.All).get()) {
				result = CreditLimitTypeEnum.NOTIONAL;
			} else if (areEqual(switchArgument, MapperS.of("NPV"), CardinalityOperator.All).get()) {
				result = CreditLimitTypeEnum.NPV;
			} else if (areEqual(switchArgument, MapperS.of("PV01"), CardinalityOperator.All).get()) {
				result = CreditLimitTypeEnum.PV01;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

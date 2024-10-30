package fpml.enumeration.mapping.functions;

import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapSettlementTypeEnum.MapSettlementTypeEnumDefault.class)
public abstract class MapSettlementTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public SettlementTypeEnum evaluate(String value) {
		SettlementTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract SettlementTypeEnum doEvaluate(String value);

	public static class MapSettlementTypeEnumDefault extends MapSettlementTypeEnum {
		@Override
		protected SettlementTypeEnum doEvaluate(String value) {
			SettlementTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected SettlementTypeEnum assignOutput(SettlementTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Cash"), CardinalityOperator.All).get()) {
				result = SettlementTypeEnum.CASH;
			} else if (areEqual(switchArgument, MapperS.of("Physical"), CardinalityOperator.All).get()) {
				result = SettlementTypeEnum.PHYSICAL;
			} else if (areEqual(switchArgument, MapperS.of("Election"), CardinalityOperator.All).get()) {
				result = SettlementTypeEnum.ELECTION;
			} else if (areEqual(switchArgument, MapperS.of("CashOrPhysical"), CardinalityOperator.All).get()) {
				result = SettlementTypeEnum.CASH_OR_PHYSICAL;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.product.asset.DividendAmountTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDividendAmountTypeEnum.MapDividendAmountTypeEnumDefault.class)
public abstract class MapDividendAmountTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DividendAmountTypeEnum evaluate(String value) {
		DividendAmountTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DividendAmountTypeEnum doEvaluate(String value);

	public static class MapDividendAmountTypeEnumDefault extends MapDividendAmountTypeEnum {
		@Override
		protected DividendAmountTypeEnum doEvaluate(String value) {
			DividendAmountTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DividendAmountTypeEnum assignOutput(DividendAmountTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("RecordAmount"), CardinalityOperator.All).get()) {
				result = DividendAmountTypeEnum.RECORD_AMOUNT;
			} else if (areEqual(switchArgument, MapperS.of("ExAmount"), CardinalityOperator.All).get()) {
				result = DividendAmountTypeEnum.EX_AMOUNT;
			} else if (areEqual(switchArgument, MapperS.of("PaidAmount"), CardinalityOperator.All).get()) {
				result = DividendAmountTypeEnum.PAID_AMOUNT;
			} else if (areEqual(switchArgument, MapperS.of("AsSpecifiedInMasterConfirmation"), CardinalityOperator.All).get()) {
				result = DividendAmountTypeEnum.AS_SPECIFIED_IN_MASTER_CONFIRMATION;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

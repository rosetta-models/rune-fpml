package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.common.MatrixTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapMatrixTypeEnum.MapMatrixTypeEnumDefault.class)
public abstract class MapMatrixTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public MatrixTypeEnum evaluate(String value) {
		MatrixTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract MatrixTypeEnum doEvaluate(String value);

	public static class MapMatrixTypeEnumDefault extends MapMatrixTypeEnum {
		@Override
		protected MatrixTypeEnum doEvaluate(String value) {
			MatrixTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected MatrixTypeEnum assignOutput(MatrixTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("CreditDerivativesPhysicalSettlementMatrix"), CardinalityOperator.All).get()) {
				result = MatrixTypeEnum.CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX;
			} else if (areEqual(switchArgument, MapperS.of("EquityDerivativesMatrix"), CardinalityOperator.All).get()) {
				result = MatrixTypeEnum.EQUITY_DERIVATIVES_MATRIX;
			} else if (areEqual(switchArgument, MapperS.of("SettlementMatrix"), CardinalityOperator.All).get()) {
				result = MatrixTypeEnum.SETTLEMENT_MATRIX;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

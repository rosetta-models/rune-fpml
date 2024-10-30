package fpml.enumeration.mapping.functions;

import cdm.product.asset.SettledEntityMatrixSourceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapSettledEntityMatrixSourceEnum.MapSettledEntityMatrixSourceEnumDefault.class)
public abstract class MapSettledEntityMatrixSourceEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public SettledEntityMatrixSourceEnum evaluate(String value) {
		SettledEntityMatrixSourceEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract SettledEntityMatrixSourceEnum doEvaluate(String value);

	public static class MapSettledEntityMatrixSourceEnumDefault extends MapSettledEntityMatrixSourceEnum {
		@Override
		protected SettledEntityMatrixSourceEnum doEvaluate(String value) {
			SettledEntityMatrixSourceEnum result = null;
			return assignOutput(result, value);
		}
		
		protected SettledEntityMatrixSourceEnum assignOutput(SettledEntityMatrixSourceEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ConfirmationAnnex"), CardinalityOperator.All).get()) {
				result = SettledEntityMatrixSourceEnum.CONFIRMATION_ANNEX;
			} else if (areEqual(switchArgument, MapperS.of("NotApplicable"), CardinalityOperator.All).get()) {
				result = SettledEntityMatrixSourceEnum.NOT_APPLICABLE;
			} else if (areEqual(switchArgument, MapperS.of("Publisher"), CardinalityOperator.All).get()) {
				result = SettledEntityMatrixSourceEnum.PUBLISHER;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

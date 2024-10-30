package fpml.enumeration.mapping.functions;

import cdm.product.asset.NonCashDividendTreatmentEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapNonCashDividendTreatmentEnum.MapNonCashDividendTreatmentEnumDefault.class)
public abstract class MapNonCashDividendTreatmentEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public NonCashDividendTreatmentEnum evaluate(String value) {
		NonCashDividendTreatmentEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract NonCashDividendTreatmentEnum doEvaluate(String value);

	public static class MapNonCashDividendTreatmentEnumDefault extends MapNonCashDividendTreatmentEnum {
		@Override
		protected NonCashDividendTreatmentEnum doEvaluate(String value) {
			NonCashDividendTreatmentEnum result = null;
			return assignOutput(result, value);
		}
		
		protected NonCashDividendTreatmentEnum assignOutput(NonCashDividendTreatmentEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("PotentialAdjustmentEvent"), CardinalityOperator.All).get()) {
				result = NonCashDividendTreatmentEnum.POTENTIAL_ADJUSTMENT_EVENT;
			} else if (areEqual(switchArgument, MapperS.of("CashEquivalent"), CardinalityOperator.All).get()) {
				result = NonCashDividendTreatmentEnum.CASH_EQUIVALENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

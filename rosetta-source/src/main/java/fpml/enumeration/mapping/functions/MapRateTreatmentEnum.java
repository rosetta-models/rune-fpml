package fpml.enumeration.mapping.functions;

import cdm.product.asset.RateTreatmentEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapRateTreatmentEnum.MapRateTreatmentEnumDefault.class)
public abstract class MapRateTreatmentEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public RateTreatmentEnum evaluate(String value) {
		RateTreatmentEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract RateTreatmentEnum doEvaluate(String value);

	public static class MapRateTreatmentEnumDefault extends MapRateTreatmentEnum {
		@Override
		protected RateTreatmentEnum doEvaluate(String value) {
			RateTreatmentEnum result = null;
			return assignOutput(result, value);
		}
		
		protected RateTreatmentEnum assignOutput(RateTreatmentEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("BondEquivalentYield"), CardinalityOperator.All).get()) {
				result = RateTreatmentEnum.BOND_EQUIVALENT_YIELD;
			} else if (areEqual(switchArgument, MapperS.of("MoneyMarketYield"), CardinalityOperator.All).get()) {
				result = RateTreatmentEnum.MONEY_MARKET_YIELD;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

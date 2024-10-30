package fpml.enumeration.mapping.functions;

import cdm.product.asset.DividendEntitlementEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDividendEntitlementEnum.MapDividendEntitlementEnumDefault.class)
public abstract class MapDividendEntitlementEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DividendEntitlementEnum evaluate(String value) {
		DividendEntitlementEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DividendEntitlementEnum doEvaluate(String value);

	public static class MapDividendEntitlementEnumDefault extends MapDividendEntitlementEnum {
		@Override
		protected DividendEntitlementEnum doEvaluate(String value) {
			DividendEntitlementEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DividendEntitlementEnum assignOutput(DividendEntitlementEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ExDate"), CardinalityOperator.All).get()) {
				result = DividendEntitlementEnum.EX_DATE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

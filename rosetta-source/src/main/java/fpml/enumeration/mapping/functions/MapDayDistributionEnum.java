package fpml.enumeration.mapping.functions;

import cdm.product.asset.DayDistributionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDayDistributionEnum.MapDayDistributionEnumDefault.class)
public abstract class MapDayDistributionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DayDistributionEnum evaluate(String value) {
		DayDistributionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DayDistributionEnum doEvaluate(String value);

	public static class MapDayDistributionEnumDefault extends MapDayDistributionEnum {
		@Override
		protected DayDistributionEnum doEvaluate(String value) {
			DayDistributionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DayDistributionEnum assignOutput(DayDistributionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("All"), CardinalityOperator.All).get()) {
				result = DayDistributionEnum.ALL;
			} else if (areEqual(switchArgument, MapperS.of("First"), CardinalityOperator.All).get()) {
				result = DayDistributionEnum.FIRST;
			} else if (areEqual(switchArgument, MapperS.of("Last"), CardinalityOperator.All).get()) {
				result = DayDistributionEnum.LAST;
			} else if (areEqual(switchArgument, MapperS.of("Penultimate"), CardinalityOperator.All).get()) {
				result = DayDistributionEnum.PENULTIMATE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

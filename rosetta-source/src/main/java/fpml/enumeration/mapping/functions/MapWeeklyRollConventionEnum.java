package fpml.enumeration.mapping.functions;

import cdm.product.common.schedule.WeeklyRollConventionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapWeeklyRollConventionEnum.MapWeeklyRollConventionEnumDefault.class)
public abstract class MapWeeklyRollConventionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public WeeklyRollConventionEnum evaluate(String value) {
		WeeklyRollConventionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract WeeklyRollConventionEnum doEvaluate(String value);

	public static class MapWeeklyRollConventionEnumDefault extends MapWeeklyRollConventionEnum {
		@Override
		protected WeeklyRollConventionEnum doEvaluate(String value) {
			WeeklyRollConventionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected WeeklyRollConventionEnum assignOutput(WeeklyRollConventionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("TBILL"), CardinalityOperator.All).get()) {
				result = WeeklyRollConventionEnum.TBILL;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

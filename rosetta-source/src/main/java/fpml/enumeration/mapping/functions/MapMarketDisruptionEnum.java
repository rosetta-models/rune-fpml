package fpml.enumeration.mapping.functions;

import cdm.observable.event.MarketDisruptionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapMarketDisruptionEnum.MapMarketDisruptionEnumDefault.class)
public abstract class MapMarketDisruptionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public MarketDisruptionEnum evaluate(String value) {
		MarketDisruptionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract MarketDisruptionEnum doEvaluate(String value);

	public static class MapMarketDisruptionEnumDefault extends MapMarketDisruptionEnum {
		@Override
		protected MarketDisruptionEnum doEvaluate(String value) {
			MarketDisruptionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected MarketDisruptionEnum assignOutput(MarketDisruptionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ModifiedPostponement"), CardinalityOperator.All).get()) {
				result = MarketDisruptionEnum.MODIFIED_POSTPONEMENT;
			} else if (areEqual(switchArgument, MapperS.of("Omission"), CardinalityOperator.All).get()) {
				result = MarketDisruptionEnum.OMISSION;
			} else if (areEqual(switchArgument, MapperS.of("Postponement"), CardinalityOperator.All).get()) {
				result = MarketDisruptionEnum.POSTPONEMENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

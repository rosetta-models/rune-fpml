package fpml.enumeration.mapping.functions;

import cdm.observable.asset.calculatedrate.ObservationPeriodDatesEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapObservationPeriodDatesEnum.MapObservationPeriodDatesEnumDefault.class)
public abstract class MapObservationPeriodDatesEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ObservationPeriodDatesEnum evaluate(String value) {
		ObservationPeriodDatesEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ObservationPeriodDatesEnum doEvaluate(String value);

	public static class MapObservationPeriodDatesEnumDefault extends MapObservationPeriodDatesEnum {
		@Override
		protected ObservationPeriodDatesEnum doEvaluate(String value) {
			ObservationPeriodDatesEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ObservationPeriodDatesEnum assignOutput(ObservationPeriodDatesEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Standard"), CardinalityOperator.All).get()) {
				result = ObservationPeriodDatesEnum.STANDARD;
			} else if (areEqual(switchArgument, MapperS.of("SetInAdvance"), CardinalityOperator.All).get()) {
				result = ObservationPeriodDatesEnum.SET_IN_ADVANCE;
			} else if (areEqual(switchArgument, MapperS.of("FixingDate"), CardinalityOperator.All).get()) {
				result = ObservationPeriodDatesEnum.FIXING_DATE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.base.datetime.PeriodEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPeriodEnum.MapPeriodEnumDefault.class)
public abstract class MapPeriodEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PeriodEnum evaluate(String value) {
		PeriodEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PeriodEnum doEvaluate(String value);

	public static class MapPeriodEnumDefault extends MapPeriodEnum {
		@Override
		protected PeriodEnum doEvaluate(String value) {
			PeriodEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PeriodEnum assignOutput(PeriodEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("D"), CardinalityOperator.All).get()) {
				result = PeriodEnum.D;
			} else if (areEqual(switchArgument, MapperS.of("PerCalendarDay"), CardinalityOperator.All).get()) {
				result = PeriodEnum.D;
			} else if (areEqual(switchArgument, MapperS.of("W"), CardinalityOperator.All).get()) {
				result = PeriodEnum.W;
			} else if (areEqual(switchArgument, MapperS.of("NearbyWeek"), CardinalityOperator.All).get()) {
				result = PeriodEnum.W;
			} else if (areEqual(switchArgument, MapperS.of("M"), CardinalityOperator.All).get()) {
				result = PeriodEnum.M;
			} else if (areEqual(switchArgument, MapperS.of("NearbyMonth"), CardinalityOperator.All).get()) {
				result = PeriodEnum.M;
			} else if (areEqual(switchArgument, MapperS.of("Y"), CardinalityOperator.All).get()) {
				result = PeriodEnum.Y;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

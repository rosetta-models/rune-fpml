package fpml.enumeration.mapping.functions;

import cdm.base.datetime.PeriodExtendedEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPeriodExtendedEnum.MapPeriodExtendedEnumDefault.class)
public abstract class MapPeriodExtendedEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PeriodExtendedEnum evaluate(String value) {
		PeriodExtendedEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PeriodExtendedEnum doEvaluate(String value);

	public static class MapPeriodExtendedEnumDefault extends MapPeriodExtendedEnum {
		@Override
		protected PeriodExtendedEnum doEvaluate(String value) {
			PeriodExtendedEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PeriodExtendedEnum assignOutput(PeriodExtendedEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("D"), CardinalityOperator.All).get()) {
				result = PeriodExtendedEnum.D;
			} else if (areEqual(switchArgument, MapperS.of("PerCalendarDay"), CardinalityOperator.All).get()) {
				result = PeriodExtendedEnum.D;
			} else if (areEqual(switchArgument, MapperS.of("W"), CardinalityOperator.All).get()) {
				result = PeriodExtendedEnum.W;
			} else if (areEqual(switchArgument, MapperS.of("M"), CardinalityOperator.All).get()) {
				result = PeriodExtendedEnum.M;
			} else if (areEqual(switchArgument, MapperS.of("PerMonth"), CardinalityOperator.All).get()) {
				result = PeriodExtendedEnum.M;
			} else if (areEqual(switchArgument, MapperS.of("Y"), CardinalityOperator.All).get()) {
				result = PeriodExtendedEnum.Y;
			} else if (areEqual(switchArgument, MapperS.of("T"), CardinalityOperator.All).get()) {
				result = PeriodExtendedEnum.T;
			} else if (areEqual(switchArgument, MapperS.of("Term"), CardinalityOperator.All).get()) {
				result = PeriodExtendedEnum.T;
			} else if (areEqual(switchArgument, MapperS.of("PerCalculationPeriod"), CardinalityOperator.All).get()) {
				result = PeriodExtendedEnum.C;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

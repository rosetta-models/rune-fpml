package fpml.enumeration.mapping.functions;

import cdm.base.datetime.daycount.DayCountFractionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapDayCountFractionEnum.MapDayCountFractionEnumDefault.class)
public abstract class MapDayCountFractionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public DayCountFractionEnum evaluate(String value) {
		DayCountFractionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract DayCountFractionEnum doEvaluate(String value);

	public static class MapDayCountFractionEnumDefault extends MapDayCountFractionEnum {
		@Override
		protected DayCountFractionEnum doEvaluate(String value) {
			DayCountFractionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected DayCountFractionEnum assignOutput(DayCountFractionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ACT/360"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.ACT_360;
			} else if (areEqual(switchArgument, MapperS.of("ACT/365L"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.ACT_365L;
			} else if (areEqual(switchArgument, MapperS.of("ACT/365.FIXED"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.ACT_365_FIXED;
			} else if (areEqual(switchArgument, MapperS.of("ACT/ACT.AFB"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.ACT_ACT_AFB;
			} else if (areEqual(switchArgument, MapperS.of("ACT/ACT.ICMA"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.ACT_ACT_ICMA;
			} else if (areEqual(switchArgument, MapperS.of("ACT/ACT.ISMA"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.ACT_ACT_ISMA;
			} else if (areEqual(switchArgument, MapperS.of("ACT/ACT.ISDA"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.ACT_ACT_ISDA;
			} else if (areEqual(switchArgument, MapperS.of("CAL/252"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.CAL_252;
			} else if (areEqual(switchArgument, MapperS.of("BUS/252"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.CAL_252;
			} else if (areEqual(switchArgument, MapperS.of("1/1"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum._1_1;
			} else if (areEqual(switchArgument, MapperS.of("30E/360"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum._30E_360;
			} else if (areEqual(switchArgument, MapperS.of("30E/360.ISDA"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum._30E_360_ISDA;
			} else if (areEqual(switchArgument, MapperS.of("30/360"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum._30_360;
			} else if (areEqual(switchArgument, MapperS.of("RBA"), CardinalityOperator.All).get()) {
				result = DayCountFractionEnum.RBA_BOND_BASIS;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

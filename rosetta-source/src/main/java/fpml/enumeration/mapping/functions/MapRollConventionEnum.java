package fpml.enumeration.mapping.functions;

import cdm.base.datetime.RollConventionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapRollConventionEnum.MapRollConventionEnumDefault.class)
public abstract class MapRollConventionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public RollConventionEnum evaluate(String value) {
		RollConventionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract RollConventionEnum doEvaluate(String value);

	public static class MapRollConventionEnumDefault extends MapRollConventionEnum {
		@Override
		protected RollConventionEnum doEvaluate(String value) {
			RollConventionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected RollConventionEnum assignOutput(RollConventionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("EOM"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.EOM;
			} else if (areEqual(switchArgument, MapperS.of("FRN"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.FRN;
			} else if (areEqual(switchArgument, MapperS.of("IMM"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.IMM;
			} else if (areEqual(switchArgument, MapperS.of("IMMCAD"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.IMMCAD;
			} else if (areEqual(switchArgument, MapperS.of("IMMAUD"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.IMMAUD;
			} else if (areEqual(switchArgument, MapperS.of("IMMNZD"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.IMMNZD;
			} else if (areEqual(switchArgument, MapperS.of("SFE"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.SFE;
			} else if (areEqual(switchArgument, MapperS.of("NONE"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.NONE;
			} else if (areEqual(switchArgument, MapperS.of("TBILL"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.TBILL;
			} else if (areEqual(switchArgument, MapperS.of("1"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._1;
			} else if (areEqual(switchArgument, MapperS.of("2"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._2;
			} else if (areEqual(switchArgument, MapperS.of("3"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._3;
			} else if (areEqual(switchArgument, MapperS.of("4"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._4;
			} else if (areEqual(switchArgument, MapperS.of("5"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._5;
			} else if (areEqual(switchArgument, MapperS.of("6"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._6;
			} else if (areEqual(switchArgument, MapperS.of("7"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._7;
			} else if (areEqual(switchArgument, MapperS.of("8"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._8;
			} else if (areEqual(switchArgument, MapperS.of("9"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._9;
			} else if (areEqual(switchArgument, MapperS.of("10"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._10;
			} else if (areEqual(switchArgument, MapperS.of("11"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._11;
			} else if (areEqual(switchArgument, MapperS.of("12"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._12;
			} else if (areEqual(switchArgument, MapperS.of("13"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._13;
			} else if (areEqual(switchArgument, MapperS.of("14"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._14;
			} else if (areEqual(switchArgument, MapperS.of("15"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._15;
			} else if (areEqual(switchArgument, MapperS.of("16"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._16;
			} else if (areEqual(switchArgument, MapperS.of("17"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._17;
			} else if (areEqual(switchArgument, MapperS.of("18"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._18;
			} else if (areEqual(switchArgument, MapperS.of("19"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._19;
			} else if (areEqual(switchArgument, MapperS.of("20"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._20;
			} else if (areEqual(switchArgument, MapperS.of("21"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._21;
			} else if (areEqual(switchArgument, MapperS.of("22"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._22;
			} else if (areEqual(switchArgument, MapperS.of("23"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._23;
			} else if (areEqual(switchArgument, MapperS.of("24"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._24;
			} else if (areEqual(switchArgument, MapperS.of("25"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._25;
			} else if (areEqual(switchArgument, MapperS.of("26"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._26;
			} else if (areEqual(switchArgument, MapperS.of("27"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._27;
			} else if (areEqual(switchArgument, MapperS.of("28"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._28;
			} else if (areEqual(switchArgument, MapperS.of("29"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._29;
			} else if (areEqual(switchArgument, MapperS.of("30"), CardinalityOperator.All).get()) {
				result = RollConventionEnum._30;
			} else if (areEqual(switchArgument, MapperS.of("MON"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.MON;
			} else if (areEqual(switchArgument, MapperS.of("TUE"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.TUE;
			} else if (areEqual(switchArgument, MapperS.of("WED"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.WED;
			} else if (areEqual(switchArgument, MapperS.of("THU"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.THU;
			} else if (areEqual(switchArgument, MapperS.of("FRI"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.FRI;
			} else if (areEqual(switchArgument, MapperS.of("SAT"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.SAT;
			} else if (areEqual(switchArgument, MapperS.of("SUN"), CardinalityOperator.All).get()) {
				result = RollConventionEnum.SUN;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

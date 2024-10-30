package fpml.enumeration.mapping.functions;

import cdm.base.math.CapacityUnitEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCapacityUnitEnum.MapCapacityUnitEnumDefault.class)
public abstract class MapCapacityUnitEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CapacityUnitEnum evaluate(String value) {
		CapacityUnitEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CapacityUnitEnum doEvaluate(String value);

	public static class MapCapacityUnitEnumDefault extends MapCapacityUnitEnum {
		@Override
		protected CapacityUnitEnum doEvaluate(String value) {
			CapacityUnitEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CapacityUnitEnum assignOutput(CapacityUnitEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("BBL"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.BBL;
			} else if (areEqual(switchArgument, MapperS.of("CWT"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.USCWT;
			} else if (areEqual(switchArgument, MapperS.of("dag"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.DAG;
			} else if (areEqual(switchArgument, MapperS.of("Day"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.DAY;
			} else if (areEqual(switchArgument, MapperS.of("dmtu"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.DMTU;
			} else if (areEqual(switchArgument, MapperS.of("FEU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.FEU;
			} else if (areEqual(switchArgument, MapperS.of("GAL"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.USGAL;
			} else if (areEqual(switchArgument, MapperS.of("GBBSH"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.GBBSH;
			} else if (areEqual(switchArgument, MapperS.of("GBBTU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.GBBTU;
			} else if (areEqual(switchArgument, MapperS.of("GBMBTU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.GBMBTU;
			} else if (areEqual(switchArgument, MapperS.of("GBMMBTU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.GBMMBTU;
			} else if (areEqual(switchArgument, MapperS.of("GBTHM"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.GBTHM;
			} else if (areEqual(switchArgument, MapperS.of("GJ"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.GJ;
			} else if (areEqual(switchArgument, MapperS.of("GW"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.GW;
			} else if (areEqual(switchArgument, MapperS.of("Gwh"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.GWH;
			} else if (areEqual(switchArgument, MapperS.of("hl"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.HL;
			} else if (areEqual(switchArgument, MapperS.of("HOGB"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.HOGB;
			} else if (areEqual(switchArgument, MapperS.of("ISOBTU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.ISOBTU;
			} else if (areEqual(switchArgument, MapperS.of("ISOMBTU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.ISOMBTU;
			} else if (areEqual(switchArgument, MapperS.of("ISOMMBTU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.ISOMMBTU;
			} else if (areEqual(switchArgument, MapperS.of("ISOTHM"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.ISOTHM;
			} else if (areEqual(switchArgument, MapperS.of("KG"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.KG;
			} else if (areEqual(switchArgument, MapperS.of("kl"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.KL;
			} else if (areEqual(switchArgument, MapperS.of("KW"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.KW;
			} else if (areEqual(switchArgument, MapperS.of("KWD"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.KWD;
			} else if (areEqual(switchArgument, MapperS.of("KWh"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.KWH;
			} else if (areEqual(switchArgument, MapperS.of("KWM"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.KWM;
			} else if (areEqual(switchArgument, MapperS.of("KWMIN"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.KWMIN;
			} else if (areEqual(switchArgument, MapperS.of("KWY"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.KWY;
			} else if (areEqual(switchArgument, MapperS.of("L"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.L;
			} else if (areEqual(switchArgument, MapperS.of("LB"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.LB;
			} else if (areEqual(switchArgument, MapperS.of("MB"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MB;
			} else if (areEqual(switchArgument, MapperS.of("MBF"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MBF;
			} else if (areEqual(switchArgument, MapperS.of("MJ"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MJ;
			} else if (areEqual(switchArgument, MapperS.of("MMBF"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MMBF;
			} else if (areEqual(switchArgument, MapperS.of("msf"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MSF;
			} else if (areEqual(switchArgument, MapperS.of("MT"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MT;
			} else if (areEqual(switchArgument, MapperS.of("MW"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MW;
			} else if (areEqual(switchArgument, MapperS.of("MWD"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MWD;
			} else if (areEqual(switchArgument, MapperS.of("MWh"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MWH;
			} else if (areEqual(switchArgument, MapperS.of("MWM"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MWM;
			} else if (areEqual(switchArgument, MapperS.of("MWMIN"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MWMIN;
			} else if (areEqual(switchArgument, MapperS.of("MWY"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.MWY;
			} else if (areEqual(switchArgument, MapperS.of("ozt"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.OZT;
			} else if (areEqual(switchArgument, MapperS.of("SGB"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.SGB;
			} else if (areEqual(switchArgument, MapperS.of("USBSH"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.USBSH;
			} else if (areEqual(switchArgument, MapperS.of("USBTU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.USBTU;
			} else if (areEqual(switchArgument, MapperS.of("USMBTU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.USMBTU;
			} else if (areEqual(switchArgument, MapperS.of("USMMBTU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.USMMBTU;
			} else if (areEqual(switchArgument, MapperS.of("st"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.UST;
			} else if (areEqual(switchArgument, MapperS.of("USTHM"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.USTHM;
			} else if (areEqual(switchArgument, MapperS.of("t"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.GBT;
			} else if (areEqual(switchArgument, MapperS.of("TEU"), CardinalityOperator.All).get()) {
				result = CapacityUnitEnum.TEU;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

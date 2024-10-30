package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.common.GoverningLawEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapGoverningLawEnum.MapGoverningLawEnumDefault.class)
public abstract class MapGoverningLawEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public GoverningLawEnum evaluate(String value) {
		GoverningLawEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract GoverningLawEnum doEvaluate(String value);

	public static class MapGoverningLawEnumDefault extends MapGoverningLawEnum {
		@Override
		protected GoverningLawEnum doEvaluate(String value) {
			GoverningLawEnum result = null;
			return assignOutput(result, value);
		}
		
		protected GoverningLawEnum assignOutput(GoverningLawEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AsSpecifiedInMasterAgreement"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.AS_SPECIFIED_IN_MASTER_AGREEMENT;
			} else if (areEqual(switchArgument, MapperS.of("CAAB"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.CAAB;
			} else if (areEqual(switchArgument, MapperS.of("CABC"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.CABC;
			} else if (areEqual(switchArgument, MapperS.of("CAMN"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.CAMN;
			} else if (areEqual(switchArgument, MapperS.of("CAON"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.CAON;
			} else if (areEqual(switchArgument, MapperS.of("CAQC"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.CAQC;
			} else if (areEqual(switchArgument, MapperS.of("DE"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.DE;
			} else if (areEqual(switchArgument, MapperS.of("FR"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.FR;
			} else if (areEqual(switchArgument, MapperS.of("GBEN"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.GBEN;
			} else if (areEqual(switchArgument, MapperS.of("GBGY"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.GBGY;
			} else if (areEqual(switchArgument, MapperS.of("GBIM"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.GBIM;
			} else if (areEqual(switchArgument, MapperS.of("GBJY"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.GBJY;
			} else if (areEqual(switchArgument, MapperS.of("GBSC"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.GBSC;
			} else if (areEqual(switchArgument, MapperS.of("JP"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.JP;
			} else if (areEqual(switchArgument, MapperS.of("USCA"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.USCA;
			} else if (areEqual(switchArgument, MapperS.of("USDE"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.USDE;
			} else if (areEqual(switchArgument, MapperS.of("USIL"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.USIL;
			} else if (areEqual(switchArgument, MapperS.of("USNY"), CardinalityOperator.All).get()) {
				result = GoverningLawEnum.USNY;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

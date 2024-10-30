package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.master.MasterAgreementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapMasterAgreementTypeEnum.MapMasterAgreementTypeEnumDefault.class)
public abstract class MapMasterAgreementTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public MasterAgreementTypeEnum evaluate(String value) {
		MasterAgreementTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract MasterAgreementTypeEnum doEvaluate(String value);

	public static class MapMasterAgreementTypeEnumDefault extends MapMasterAgreementTypeEnum {
		@Override
		protected MasterAgreementTypeEnum doEvaluate(String value) {
			MasterAgreementTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected MasterAgreementTypeEnum assignOutput(MasterAgreementTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AFB"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.AFB;
			} else if (areEqual(switchArgument, MapperS.of("Bespoke"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.BESPOKE;
			} else if (areEqual(switchArgument, MapperS.of("CMA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.CMA;
			} else if (areEqual(switchArgument, MapperS.of("CMOF"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.CMOF;
			} else if (areEqual(switchArgument, MapperS.of("EEIPower"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.EEI_POWER;
			} else if (areEqual(switchArgument, MapperS.of("EFETElectricity"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.EFET_ELECTRICITY;
			} else if (areEqual(switchArgument, MapperS.of("EFETGas"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.EFET_GAS;
			} else if (areEqual(switchArgument, MapperS.of("EMA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.EMA;
			} else if (areEqual(switchArgument, MapperS.of("FBF"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.FBF;
			} else if (areEqual(switchArgument, MapperS.of("GMRA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.GMRA;
			} else if (areEqual(switchArgument, MapperS.of("GMSLA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.GMSLA;
			} else if (areEqual(switchArgument, MapperS.of("GTMA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.GTMA;
			} else if (areEqual(switchArgument, MapperS.of("GasEDI"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.GAS_EDI;
			} else if (areEqual(switchArgument, MapperS.of("German"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.GERMAN;
			} else if (areEqual(switchArgument, MapperS.of("ICOM"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.ICOM;
			} else if (areEqual(switchArgument, MapperS.of("IETA-ERPA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.IETA_ERPA;
			} else if (areEqual(switchArgument, MapperS.of("IETA-ETMA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.IETA_ETMA;
			} else if (areEqual(switchArgument, MapperS.of("IETA-IETMA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.IETA_IETMA;
			} else if (areEqual(switchArgument, MapperS.of("IFEMA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.IFEMA;
			} else if (areEqual(switchArgument, MapperS.of("IFEOMA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.IFEOMA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.ISDA_MASTER;
			} else if (areEqual(switchArgument, MapperS.of("ISDAFIA-CDEA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.ISDAFIA_CDEA;
			} else if (areEqual(switchArgument, MapperS.of("ISDAIIFM-TMA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.ISDAIIFM_TMA;
			} else if (areEqual(switchArgument, MapperS.of("JSCC"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.JSCC;
			} else if (areEqual(switchArgument, MapperS.of("LBMA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.LBMA;
			} else if (areEqual(switchArgument, MapperS.of("LEAP"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.LEAP;
			} else if (areEqual(switchArgument, MapperS.of("MCPSA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.MCPSA;
			} else if (areEqual(switchArgument, MapperS.of("NAESBGas"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.NAESB_GAS;
			} else if (areEqual(switchArgument, MapperS.of("NBP"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.NBP;
			} else if (areEqual(switchArgument, MapperS.of("RussianDerivatives"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.RUSSIAN_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("RussianRepo"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.RUSSIAN_REPO;
			} else if (areEqual(switchArgument, MapperS.of("SCoTA"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.S_CO_TA;
			} else if (areEqual(switchArgument, MapperS.of("Swiss"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.SWISS;
			} else if (areEqual(switchArgument, MapperS.of("TTF"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.TTF;
			} else if (areEqual(switchArgument, MapperS.of("ZBT"), CardinalityOperator.All).get()) {
				result = MasterAgreementTypeEnum.ZBT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.observable.asset.SettlementRateOptionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapSettlementRateOptionEnum.MapSettlementRateOptionEnumDefault.class)
public abstract class MapSettlementRateOptionEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public SettlementRateOptionEnum evaluate(String value) {
		SettlementRateOptionEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract SettlementRateOptionEnum doEvaluate(String value);

	public static class MapSettlementRateOptionEnumDefault extends MapSettlementRateOptionEnum {
		@Override
		protected SettlementRateOptionEnum doEvaluate(String value) {
			SettlementRateOptionEnum result = null;
			return assignOutput(result, value);
		}
		
		protected SettlementRateOptionEnum assignOutput(SettlementRateOptionEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ARS.BNAR/ARS01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_BNAR_ARS01;
			} else if (areEqual(switchArgument, MapperS.of("ARS01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_BNAR_ARS01;
			} else if (areEqual(switchArgument, MapperS.of("ARS.EMTA.INDICATIVE.SURVEY.RATE/ARS04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_EMTA_INDICATIVE_SURVEY_RATE_ARS04;
			} else if (areEqual(switchArgument, MapperS.of("ARS04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_EMTA_INDICATIVE_SURVEY_RATE_ARS04;
			} else if (areEqual(switchArgument, MapperS.of("ARS.EMTA.INDUSTRY.SURVEY.RATE/ARS03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_EMTA_INDUSTRY_SURVEY_RATE_ARS03;
			} else if (areEqual(switchArgument, MapperS.of("ARS03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_EMTA_INDUSTRY_SURVEY_RATE_ARS03;
			} else if (areEqual(switchArgument, MapperS.of("ARS.MAE/ARS05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_MAE_ARS05;
			} else if (areEqual(switchArgument, MapperS.of("ARS05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_MAE_ARS05;
			} else if (areEqual(switchArgument, MapperS.of("ARS.OFFICIAL.RATE/ARS02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_OFFICIAL_RATE_ARS02;
			} else if (areEqual(switchArgument, MapperS.of("ARS02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ARS_OFFICIAL_RATE_ARS02;
			} else if (areEqual(switchArgument, MapperS.of("BRL.BRBY/BRL01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_BRBY_BRL01;
			} else if (areEqual(switchArgument, MapperS.of("BRL01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_BRBY_BRL01;
			} else if (areEqual(switchArgument, MapperS.of("BRL.EMTA.INDICATIVE.SURVEY.RATE/BRL13"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_EMTA_INDICATIVE_SURVEY_RATE_BRL13;
			} else if (areEqual(switchArgument, MapperS.of("BRL13"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_EMTA_INDICATIVE_SURVEY_RATE_BRL13;
			} else if (areEqual(switchArgument, MapperS.of("BRL.EMTA.INDUSTRY.SURVEY.RATE/BRL12"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_EMTA_INDUSTRY_SURVEY_RATE_BRL12;
			} else if (areEqual(switchArgument, MapperS.of("BRL12"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_EMTA_INDUSTRY_SURVEY_RATE_BRL12;
			} else if (areEqual(switchArgument, MapperS.of("BRL.OFFICIAL.RATE/BRL02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_OFFICIAL_RATE_BRL02;
			} else if (areEqual(switchArgument, MapperS.of("BRL02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_OFFICIAL_RATE_BRL02;
			} else if (areEqual(switchArgument, MapperS.of("BRL.PCOT-COMMERCIAL/BRL03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PCOT_COMMERCIAL_BRL03;
			} else if (areEqual(switchArgument, MapperS.of("BRL03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PCOT_COMMERCIAL_BRL03;
			} else if (areEqual(switchArgument, MapperS.of("BRL.PCOT-FLOATING/BRL04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PCOT_FLOATING_BRL04;
			} else if (areEqual(switchArgument, MapperS.of("BRL04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PCOT_FLOATING_BRL04;
			} else if (areEqual(switchArgument, MapperS.of("BRL.PTAX/BRL09"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_BRL09;
			} else if (areEqual(switchArgument, MapperS.of("BRL09"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_BRL09;
			} else if (areEqual(switchArgument, MapperS.of("BRL.PTAX-COMMERCIAL.BRFR/BRL06"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_COMMERCIAL_BRFR_BRL06;
			} else if (areEqual(switchArgument, MapperS.of("BRL06"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_COMMERCIAL_BRFR_BRL06;
			} else if (areEqual(switchArgument, MapperS.of("BRL.PTAX-COMMERCIAL/BRL05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_COMMERCIAL_BRL05;
			} else if (areEqual(switchArgument, MapperS.of("BRL05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_COMMERCIAL_BRL05;
			} else if (areEqual(switchArgument, MapperS.of("BRL.PTAX-FLOATING.BRFR/BRL08"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_FLOATING_BRFR_BRL08;
			} else if (areEqual(switchArgument, MapperS.of("BRL08"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_FLOATING_BRFR_BRL08;
			} else if (areEqual(switchArgument, MapperS.of("BRL.PTAX-FLOATING/BRL07"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_FLOATING_BRL07;
			} else if (areEqual(switchArgument, MapperS.of("BRL07"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.BRL_PTAX_FLOATING_BRL07;
			} else if (areEqual(switchArgument, MapperS.of("CLP.BCCH/CLP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_BCCH_CLP01;
			} else if (areEqual(switchArgument, MapperS.of("CLP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_BCCH_CLP01;
			} else if (areEqual(switchArgument, MapperS.of("CLP.CHILD-INFORMAL/CLP02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILD_INFORMAL_CLP02;
			} else if (areEqual(switchArgument, MapperS.of("CLP02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILD_INFORMAL_CLP02;
			} else if (areEqual(switchArgument, MapperS.of("CLP.CHILD-INTERBANK/CLP03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILD_INTERBANK_CLP03;
			} else if (areEqual(switchArgument, MapperS.of("CLP03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILD_INTERBANK_CLP03;
			} else if (areEqual(switchArgument, MapperS.of("CLP.CHILD-OBSERVADO/CLP04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILD_OBSERVADO_CLP04;
			} else if (areEqual(switchArgument, MapperS.of("CLP04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILD_OBSERVADO_CLP04;
			} else if (areEqual(switchArgument, MapperS.of("CLP.CHILG-INFORMAL/CLP05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILG_INFORMAL_CLP05;
			} else if (areEqual(switchArgument, MapperS.of("CLP05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILG_INFORMAL_CLP05;
			} else if (areEqual(switchArgument, MapperS.of("CLP.CHILG-INTERBANK/CLP06"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILG_INTERBANK_CLP06;
			} else if (areEqual(switchArgument, MapperS.of("CLP06"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILG_INTERBANK_CLP06;
			} else if (areEqual(switchArgument, MapperS.of("CLP.CHILG-OBSERVADO/CLP07"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILG_OBSERVADO_CLP07;
			} else if (areEqual(switchArgument, MapperS.of("CLP07"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_CHILG_OBSERVADO_CLP07;
			} else if (areEqual(switchArgument, MapperS.of("CLP.DOLAR.OBS/CLP10"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_DOLAR_OBS_CLP10;
			} else if (areEqual(switchArgument, MapperS.of("CLP10"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_DOLAR_OBS_CLP10;
			} else if (areEqual(switchArgument, MapperS.of("CLP.EMTA.INDICATIVE.SURVEY.RATE/CLP11"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_EMTA_INDICATIVE_SURVEY_RATE_CLP11;
			} else if (areEqual(switchArgument, MapperS.of("CLP11"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_EMTA_INDICATIVE_SURVEY_RATE_CLP11;
			} else if (areEqual(switchArgument, MapperS.of("CLP.OFFICIAL.RATE/CLP08"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_OFFICIAL_RATE_CLP08;
			} else if (areEqual(switchArgument, MapperS.of("CLP08"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_OFFICIAL_RATE_CLP08;
			} else if (areEqual(switchArgument, MapperS.of("CLP.TELERATE.38942/CLP09"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_TELERATE_38942_CLP09;
			} else if (areEqual(switchArgument, MapperS.of("CLP09"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CLP_TELERATE_38942_CLP09;
			} else if (areEqual(switchArgument, MapperS.of("CNY.SAEC/CNY01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CNY_SAEC_CNY01;
			} else if (areEqual(switchArgument, MapperS.of("CNY01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CNY_SAEC_CNY01;
			} else if (areEqual(switchArgument, MapperS.of("CNY.SFEMC.INDICATIVE.SURVEY.RATE/CNY02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CNY_SFEMC_INDICATIVE_SURVEY_RATE_CNY02;
			} else if (areEqual(switchArgument, MapperS.of("CNY02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CNY_SFEMC_INDICATIVE_SURVEY_RATE_CNY02;
			} else if (areEqual(switchArgument, MapperS.of("COP.CO/COL03/COP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.COP_CO_COL03_COP01;
			} else if (areEqual(switchArgument, MapperS.of("COP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.COP_CO_COL03_COP01;
			} else if (areEqual(switchArgument, MapperS.of("COP.EMTA.INDICATIVE.SURVEY.RATE/COP03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.COP_EMTA_INDICATIVE_SURVEY_RATE_COP03;
			} else if (areEqual(switchArgument, MapperS.of("COP03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.COP_EMTA_INDICATIVE_SURVEY_RATE_COP03;
			} else if (areEqual(switchArgument, MapperS.of("COP.TRM/COP02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.COP_TRM_COP02;
			} else if (areEqual(switchArgument, MapperS.of("COP02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.COP_TRM_COP02;
			} else if (areEqual(switchArgument, MapperS.of("CURRENCY-IMPLIED.RATE.(ADR)/CURA1"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_IMPLIED_RATE__ADR__CURA1;
			} else if (areEqual(switchArgument, MapperS.of("CURA1"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_IMPLIED_RATE__ADR__CURA1;
			} else if (areEqual(switchArgument, MapperS.of("CURRENCY-IMPLIED.RATE.(LOCAL.ASSET)/CURA2"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_IMPLIED_RATE__LOCAL_ASSET__CURA2;
			} else if (areEqual(switchArgument, MapperS.of("CURA2"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_IMPLIED_RATE__LOCAL_ASSET__CURA2;
			} else if (areEqual(switchArgument, MapperS.of("CURRENCY-MUTUAL.AGREEMENT/CURA3"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_MUTUAL_AGREEMENT_CURA3;
			} else if (areEqual(switchArgument, MapperS.of("CURA3"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_MUTUAL_AGREEMENT_CURA3;
			} else if (areEqual(switchArgument, MapperS.of("CURRENCY-REFERENCE.DEALERS/CURA4"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_REFERENCE_DEALERS_CURA4;
			} else if (areEqual(switchArgument, MapperS.of("CURA4"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_REFERENCE_DEALERS_CURA4;
			} else if (areEqual(switchArgument, MapperS.of("CURRENCY-WHOLESALE.MARKET/CURA5"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_WHOLESALE_MARKET_CURA5;
			} else if (areEqual(switchArgument, MapperS.of("CURA5"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.CURRENCY_WHOLESALE_MARKET_CURA5;
			} else if (areEqual(switchArgument, MapperS.of("ECS.DNRP/ECS01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ECS_DNRP_ECS01;
			} else if (areEqual(switchArgument, MapperS.of("ECS01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ECS_DNRP_ECS01;
			} else if (areEqual(switchArgument, MapperS.of("IDR.ABS/IDR01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.IDR_ABS_IDR01;
			} else if (areEqual(switchArgument, MapperS.of("IDR01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.IDR_ABS_IDR01;
			} else if (areEqual(switchArgument, MapperS.of("IDR.JISDOR/IDR04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.IDR_JISDOR_IDR04;
			} else if (areEqual(switchArgument, MapperS.of("IDR04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.IDR_JISDOR_IDR04;
			} else if (areEqual(switchArgument, MapperS.of("IDR.SFEMC.INDICATIVE.SURVEY.RATE/IDR02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.IDR_SFEMC_INDICATIVE_SURVEY_RATE_IDR02;
			} else if (areEqual(switchArgument, MapperS.of("IDR02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.IDR_SFEMC_INDICATIVE_SURVEY_RATE_IDR02;
			} else if (areEqual(switchArgument, MapperS.of("IDR.VWAP/IDR03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.IDR_VWAP_IDR03;
			} else if (areEqual(switchArgument, MapperS.of("IDR03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.IDR_VWAP_IDR03;
			} else if (areEqual(switchArgument, MapperS.of("ILS.BOIJ/ILS01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ILS_BOIJ_ILS01;
			} else if (areEqual(switchArgument, MapperS.of("ILS01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ILS_BOIJ_ILS01;
			} else if (areEqual(switchArgument, MapperS.of("ILS.FXIL/ILS02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ILS_FXIL_ILS02;
			} else if (areEqual(switchArgument, MapperS.of("ILS02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.ILS_FXIL_ILS02;
			} else if (areEqual(switchArgument, MapperS.of("INR.FBIL/INR01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.INR_FBIL_INR01;
			} else if (areEqual(switchArgument, MapperS.of("INR.RBIB/INR01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.INR_RBIB_INR01;
			} else if (areEqual(switchArgument, MapperS.of("INR.SFEMC.INDICATIVE.SURVEY.RATE/INR02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.INR_SFEMC_INDICATIVE_SURVEY_RATE_INR02;
			} else if (areEqual(switchArgument, MapperS.of("INR02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.INR_SFEMC_INDICATIVE_SURVEY_RATE_INR02;
			} else if (areEqual(switchArgument, MapperS.of("KRW.KEBEY/KRW01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KRW_KEBEY_KRW01;
			} else if (areEqual(switchArgument, MapperS.of("KRW01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KRW_KEBEY_KRW01;
			} else if (areEqual(switchArgument, MapperS.of("KRW.KFTC18/KRW02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KRW_KFTC18_KRW02;
			} else if (areEqual(switchArgument, MapperS.of("KRW02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KRW_KFTC18_KRW02;
			} else if (areEqual(switchArgument, MapperS.of("KRW.SFEMC.INDICATIVE.SURVEY.RATE/KRW04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KRW_SFEMC_INDICATIVE_SURVEY_RATE_KRW04;
			} else if (areEqual(switchArgument, MapperS.of("KRW04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KRW_SFEMC_INDICATIVE_SURVEY_RATE_KRW04;
			} else if (areEqual(switchArgument, MapperS.of("KRW.TELERATE.45644/KRW03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KRW_TELERATE_45644_KRW03;
			} else if (areEqual(switchArgument, MapperS.of("KRW03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KRW_TELERATE_45644_KRW03;
			} else if (areEqual(switchArgument, MapperS.of("KZT.EMTA.INDICATIVE.SURVEY.RATE/KZT02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KZT_EMTA_INDICATIVE_SURVEY_RATE_KZT02;
			} else if (areEqual(switchArgument, MapperS.of("KZT02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KZT_EMTA_INDICATIVE_SURVEY_RATE_KZT02;
			} else if (areEqual(switchArgument, MapperS.of("KZT.KASE/KZT01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KZT_KASE_KZT01;
			} else if (areEqual(switchArgument, MapperS.of("KZT01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.KZT_KASE_KZT01;
			} else if (areEqual(switchArgument, MapperS.of("LBP.BDLX/LBP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.LBP_BDLX_LBP01;
			} else if (areEqual(switchArgument, MapperS.of("LBP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.LBP_BDLX_LBP01;
			} else if (areEqual(switchArgument, MapperS.of("MAD.OFFICIAL.RATE/MAD01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MAD_OFFICIAL_RATE_MAD01;
			} else if (areEqual(switchArgument, MapperS.of("MAD01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MAD_OFFICIAL_RATE_MAD01;
			} else if (areEqual(switchArgument, MapperS.of("MXP.BNMX/MXP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MXP_BNMX_MXP01;
			} else if (areEqual(switchArgument, MapperS.of("MXP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MXP_BNMX_MXP01;
			} else if (areEqual(switchArgument, MapperS.of("MXP.FIXING.RATE/MXP02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MXP_FIXING_RATE_MXP02;
			} else if (areEqual(switchArgument, MapperS.of("MXP02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MXP_FIXING_RATE_MXP02;
			} else if (areEqual(switchArgument, MapperS.of("MXP.MEX01/MXP03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MXP_MEX01_MXP03;
			} else if (areEqual(switchArgument, MapperS.of("MXP03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MXP_MEX01_MXP03;
			} else if (areEqual(switchArgument, MapperS.of("MXP.PUBLISHED/MXP04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MXP_PUBLISHED_MXP04;
			} else if (areEqual(switchArgument, MapperS.of("MXP04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MXP_PUBLISHED_MXP04;
			} else if (areEqual(switchArgument, MapperS.of("MYR.ABS/MYR01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MYR_ABS_MYR01;
			} else if (areEqual(switchArgument, MapperS.of("MYR01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MYR_ABS_MYR01;
			} else if (areEqual(switchArgument, MapperS.of("MYR.KL.REF/MYR04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MYR_KL_REF_MYR04;
			} else if (areEqual(switchArgument, MapperS.of("MYR04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MYR_KL_REF_MYR04;
			} else if (areEqual(switchArgument, MapperS.of("MYR.PPKM/MYR03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MYR_PPKM_MYR03;
			} else if (areEqual(switchArgument, MapperS.of("MYR03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MYR_PPKM_MYR03;
			} else if (areEqual(switchArgument, MapperS.of("MYR.SFEMC.INDICATIVE.SURVEY.RATE/MYR02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MYR_SFEMC_INDICATIVE_SURVEY_RATE_MYR02;
			} else if (areEqual(switchArgument, MapperS.of("MYR02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.MYR_SFEMC_INDICATIVE_SURVEY_RATE_MYR02;
			} else if (areEqual(switchArgument, MapperS.of("PEN.EMTA.INDICATIVE.SURVEY.RATE/PEN04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PEN_EMTA_INDICATIVE_SURVEY_RATE_PEN04;
			} else if (areEqual(switchArgument, MapperS.of("PEN04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PEN_EMTA_INDICATIVE_SURVEY_RATE_PEN04;
			} else if (areEqual(switchArgument, MapperS.of("PEN.INTERBANK.AVE/PEN05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PEN_INTERBANK_AVE_PEN05;
			} else if (areEqual(switchArgument, MapperS.of("PEN05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PEN_INTERBANK_AVE_PEN05;
			} else if (areEqual(switchArgument, MapperS.of("PEN.PDSB/PEN01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PEN_PDSB_PEN01;
			} else if (areEqual(switchArgument, MapperS.of("PEN01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PEN_PDSB_PEN01;
			} else if (areEqual(switchArgument, MapperS.of("PEN.WT.AVE/PEN03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PEN_WT_AVE_PEN03;
			} else if (areEqual(switchArgument, MapperS.of("PEN03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PEN_WT_AVE_PEN03;
			} else if (areEqual(switchArgument, MapperS.of("PHP.BAPPESO/PHP06"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_BAPPESO_PHP06;
			} else if (areEqual(switchArgument, MapperS.of("PHP.PDSPESO/PHP06"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_PDSPESO_PHP06;
			} else if (areEqual(switchArgument, MapperS.of("PHP.PHPESO/PHP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_PHPESO_PHP01;
			} else if (areEqual(switchArgument, MapperS.of("PHP01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_PHPESO_PHP01;
			} else if (areEqual(switchArgument, MapperS.of("PHP.SFEMC.INDICATIVE.SURVEY.RATE/PHP05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_SFEMC_INDICATIVE_SURVEY_RATE_PHP05;
			} else if (areEqual(switchArgument, MapperS.of("PHP05"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_SFEMC_INDICATIVE_SURVEY_RATE_PHP05;
			} else if (areEqual(switchArgument, MapperS.of("PHP.TELERATE.15439/PHP03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_TELERATE_15439_PHP03;
			} else if (areEqual(switchArgument, MapperS.of("PHP03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_TELERATE_15439_PHP03;
			} else if (areEqual(switchArgument, MapperS.of("PHP.TELERATE.2920/PHP02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_TELERATE_2920_PHP02;
			} else if (areEqual(switchArgument, MapperS.of("PHP02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PHP_TELERATE_2920_PHP02;
			} else if (areEqual(switchArgument, MapperS.of("PKR.SBPK/PKR01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PKR_SBPK_PKR01;
			} else if (areEqual(switchArgument, MapperS.of("PKR01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PKR_SBPK_PKR01;
			} else if (areEqual(switchArgument, MapperS.of("PKR.SFEMC.INDICATIVE.SURVEY.RATE/PKR02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PKR_SFEMC_INDICATIVE_SURVEY_RATE_PKR02;
			} else if (areEqual(switchArgument, MapperS.of("PKR02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PKR_SFEMC_INDICATIVE_SURVEY_RATE_PKR02;
			} else if (areEqual(switchArgument, MapperS.of("PLZ.NBPQ/PLZ01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PLZ_NBPQ_PLZ01;
			} else if (areEqual(switchArgument, MapperS.of("PLZ01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PLZ_NBPQ_PLZ01;
			} else if (areEqual(switchArgument, MapperS.of("PLZ.NBPR/PLZ02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PLZ_NBPR_PLZ02;
			} else if (areEqual(switchArgument, MapperS.of("PLZ02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.PLZ_NBPR_PLZ02;
			} else if (areEqual(switchArgument, MapperS.of("RUB.CME-EMTA/RUB03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.RUB_CME_EMTA_RUB03;
			} else if (areEqual(switchArgument, MapperS.of("RUB03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.RUB_CME_EMTA_RUB03;
			} else if (areEqual(switchArgument, MapperS.of("RUB.EMTA.INDICATIVE.SURVEY.RATE/RUB04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.RUB_EMTA_INDICATIVE_SURVEY_RATE_RUB04;
			} else if (areEqual(switchArgument, MapperS.of("RUB04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.RUB_EMTA_INDICATIVE_SURVEY_RATE_RUB04;
			} else if (areEqual(switchArgument, MapperS.of("RUB.MICEXFRX/RUB01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.RUB_MICEXFRX_RUB01;
			} else if (areEqual(switchArgument, MapperS.of("RUB01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.RUB_MICEXFRX_RUB01;
			} else if (areEqual(switchArgument, MapperS.of("RUB.MMVB/RUB02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.RUB_MMVB_RUB02;
			} else if (areEqual(switchArgument, MapperS.of("RUB02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.RUB_MMVB_RUB02;
			} else if (areEqual(switchArgument, MapperS.of("SGD.VWAP/SGD3"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.SGD_VWAP_SGD3;
			} else if (areEqual(switchArgument, MapperS.of("SGD3"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.SGD_VWAP_SGD3;
			} else if (areEqual(switchArgument, MapperS.of("SKK.NBSB/SKK01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.SKK_NBSB_SKK01;
			} else if (areEqual(switchArgument, MapperS.of("SKK01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.SKK_NBSB_SKK01;
			} else if (areEqual(switchArgument, MapperS.of("THB.ABS/THB01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.THB_ABS_THB01;
			} else if (areEqual(switchArgument, MapperS.of("THB.VWAP/THB01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.THB_VWAP_THB01;
			} else if (areEqual(switchArgument, MapperS.of("TWD.SFEMC.INDICATIVE.SURVEY.RATE/TWD04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.TWD_SFEMC_INDICATIVE_SURVEY_RATE_TWD04;
			} else if (areEqual(switchArgument, MapperS.of("TWD04"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.TWD_SFEMC_INDICATIVE_SURVEY_RATE_TWD04;
			} else if (areEqual(switchArgument, MapperS.of("TWD.TAIFX1/TWD03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.TWD_TAIFX1_TWD03;
			} else if (areEqual(switchArgument, MapperS.of("TWD03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.TWD_TAIFX1_TWD03;
			} else if (areEqual(switchArgument, MapperS.of("TWD.TELERATE.6161/TWD01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.TWD_TELERATE_6161_TWD01;
			} else if (areEqual(switchArgument, MapperS.of("TWD01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.TWD_TELERATE_6161_TWD01;
			} else if (areEqual(switchArgument, MapperS.of("TWD.TFEMA/TWD02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.TWD_TFEMA_TWD02;
			} else if (areEqual(switchArgument, MapperS.of("TWD02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.TWD_TFEMA_TWD02;
			} else if (areEqual(switchArgument, MapperS.of("UAH.EMTA.INDICATIVE.SURVEY.RATE/UAH03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.UAH_EMTA_INDICATIVE_SURVEY_RATE_UAH03;
			} else if (areEqual(switchArgument, MapperS.of("UAH03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.UAH_EMTA_INDICATIVE_SURVEY_RATE_UAH03;
			} else if (areEqual(switchArgument, MapperS.of("UAH.EMTA.INDUSTRY.SURVEY.RATE/UAH02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.UAH_EMTA_INDUSTRY_SURVEY_RATE_UAH02;
			} else if (areEqual(switchArgument, MapperS.of("UAH02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.UAH_EMTA_INDUSTRY_SURVEY_RATE_UAH02;
			} else if (areEqual(switchArgument, MapperS.of("UAH.GFI/UAH01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.UAH_GFI_UAH01;
			} else if (areEqual(switchArgument, MapperS.of("UAH01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.UAH_GFI_UAH01;
			} else if (areEqual(switchArgument, MapperS.of("VEF.FIX/VEF01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.VEF_FIX_VEF01;
			} else if (areEqual(switchArgument, MapperS.of("VEF01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.VEF_FIX_VEF01;
			} else if (areEqual(switchArgument, MapperS.of("VND.ABS/VND01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.VND_ABS_VND01;
			} else if (areEqual(switchArgument, MapperS.of("VND01"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.VND_ABS_VND01;
			} else if (areEqual(switchArgument, MapperS.of("VND.FX/VND02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.VND_FX_VND02;
			} else if (areEqual(switchArgument, MapperS.of("VND02"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.VND_FX_VND02;
			} else if (areEqual(switchArgument, MapperS.of("VND.SFEMC.INDICATIVE.SURVEY.RATE/VND03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.VND_SFEMC_INDICATIVE_SURVEY_RATE_VND03;
			} else if (areEqual(switchArgument, MapperS.of("VND03"), CardinalityOperator.All).get()) {
				result = SettlementRateOptionEnum.VND_SFEMC_INDICATIVE_SURVEY_RATE_VND03;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

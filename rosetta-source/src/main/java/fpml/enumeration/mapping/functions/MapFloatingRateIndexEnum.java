package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapFloatingRateIndexEnum.MapFloatingRateIndexEnumDefault.class)
public abstract class MapFloatingRateIndexEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public FloatingRateIndexEnum evaluate(String value) {
		FloatingRateIndexEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract FloatingRateIndexEnum doEvaluate(String value);

	public static class MapFloatingRateIndexEnumDefault extends MapFloatingRateIndexEnum {
		@Override
		protected FloatingRateIndexEnum doEvaluate(String value) {
			FloatingRateIndexEnum result = null;
			return assignOutput(result, value);
		}
		
		protected FloatingRateIndexEnum assignOutput(FloatingRateIndexEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AED-EIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AED_EIBOR;
			} else if (areEqual(switchArgument, MapperS.of("AED-EBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AED_EBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("AUD-AONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_AONIA;
			} else if (areEqual(switchArgument, MapperS.of("AUD-AONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_AONIA_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("AUD-AONIA-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_AONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("AUD-AONIA-OIS-COMPOUND-SwapMarker"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_AONIA_OIS_COMPOUND_SWAP_MARKER;
			} else if (areEqual(switchArgument, MapperS.of("AUD-BBR-AUBBSW"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_BBR_AUBBSW;
			} else if (areEqual(switchArgument, MapperS.of("AUD-BBR-BBSW"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_BBR_BBSW;
			} else if (areEqual(switchArgument, MapperS.of("AUD-BBR-BBSW-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_BBR_BBSW_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("AUD-BBR-BBSY (BID)"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_BBR_BBSY__BID_;
			} else if (areEqual(switchArgument, MapperS.of("AUD-BBR-ISDC"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_BBR_ISDC;
			} else if (areEqual(switchArgument, MapperS.of("AUD-BBSW"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_BBSW;
			} else if (areEqual(switchArgument, MapperS.of("AUD-BBSW Quarterly Swap Rate ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_BBSW_QUARTERLY_SWAP_RATE_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("AUD-BBSW Semi Annual Swap Rate ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_BBSW_SEMI_ANNUAL_SWAP_RATE_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("AUD-BBSY Bid"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_BBSY_BID;
			} else if (areEqual(switchArgument, MapperS.of("AUD-LIBOR-BBA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_LIBOR_BBA;
			} else if (areEqual(switchArgument, MapperS.of("AUD-LIBOR-BBA-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_LIBOR_BBA_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("AUD-LIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_LIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("AUD-Quarterly Swap Rate-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_QUARTERLY_SWAP_RATE_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("AUD-Quarterly Swap Rate-ICAP-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_QUARTERLY_SWAP_RATE_ICAP_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("AUD-Semi-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("AUD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_SEMI_ANNUAL_SWAP_RATE_BGCANTOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("AUD-Semi-Annual Swap Rate-ICAP-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_SEMI_ANNUAL_SWAP_RATE_ICAP_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("AUD-Semi-annual Swap Rate-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_SEMI_ANNUAL_SWAP_RATE_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("AUD-Swap Rate-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.AUD_SWAP_RATE_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("BRL-CDI"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.BRL_CDI;
			} else if (areEqual(switchArgument, MapperS.of("CAD-BA-CDOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_BA_CDOR;
			} else if (areEqual(switchArgument, MapperS.of("CAD-BA-CDOR-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_BA_CDOR_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("CAD-BA-ISDD"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_BA_ISDD;
			} else if (areEqual(switchArgument, MapperS.of("CAD-BA-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_BA_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("CAD-BA-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_BA_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("CAD-BA-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_BA_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("CAD-CDOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_CDOR;
			} else if (areEqual(switchArgument, MapperS.of("CAD-CORRA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_CORRA;
			} else if (areEqual(switchArgument, MapperS.of("CAD-CORRA CanDeal TMX Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_CORRA_CAN_DEAL_TMX_TERM;
			} else if (areEqual(switchArgument, MapperS.of("CAD-CORRA Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_CORRA_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("CAD-CORRA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_CORRA_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("CAD-CORRA-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_CORRA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("CAD-ISDA-Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_ISDA_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("CAD-LIBOR-BBA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_LIBOR_BBA;
			} else if (areEqual(switchArgument, MapperS.of("CAD-LIBOR-BBA-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_LIBOR_BBA_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("CAD-LIBOR-BBA-SwapMarker"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_LIBOR_BBA_SWAP_MARKER;
			} else if (areEqual(switchArgument, MapperS.of("CAD-LIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_LIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("CAD-REPO-CORRA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_REPO_CORRA;
			} else if (areEqual(switchArgument, MapperS.of("CAD-TBILL-ISDD"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_TBILL_ISDD;
			} else if (areEqual(switchArgument, MapperS.of("CAD-TBILL-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_TBILL_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("CAD-TBILL-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_TBILL_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("CAD-TBILL-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CAD_TBILL_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("CHF-3M LIBOR SWAP-CME vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("CHF-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_3_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("CHF-3M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_3_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("CHF-6M LIBORSWAP-CME vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_6_M_LIBORSWAP_CME_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("CHF-6M LIBOR SWAP-CME vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("CHF-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("CHF-Annual Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_ANNUAL_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("CHF-Annual Swap Rate-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_ANNUAL_SWAP_RATE_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("CHF-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("CHF-Basis Swap-3m vs 6m-LIBOR-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_BASIS_SWAP_3_M_VS_6_M_LIBOR_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("CHF-ISDAFIX-Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_ISDAFIX_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("CHF-LIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_LIBOR;
			} else if (areEqual(switchArgument, MapperS.of("CHF-LIBOR-BBA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_LIBOR_BBA;
			} else if (areEqual(switchArgument, MapperS.of("CHF-LIBOR-BBA-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_LIBOR_BBA_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("CHF-LIBOR-ISDA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_LIBOR_ISDA;
			} else if (areEqual(switchArgument, MapperS.of("CHF-LIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_LIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("CHF-OIS-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_OIS_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON Average 12M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_AVERAGE_12_M;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON Average 1M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_AVERAGE_1_M;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON Average 1W"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_AVERAGE_1_W;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON Average 2M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_AVERAGE_2_M;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON Average 3M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_AVERAGE_3_M;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON Average 6M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_AVERAGE_6_M;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON Average 9M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_AVERAGE_9_M;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("CHF-SARON-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_SARON_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("CHF-TOIS-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_TOIS_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("CHF USD-Basis Swaps-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CHF_USD_BASIS_SWAPS_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("CLP-ICP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CLP_ICP;
			} else if (areEqual(switchArgument, MapperS.of("CLP-TNA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CLP_TNA;
			} else if (areEqual(switchArgument, MapperS.of("CL-CLICP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CL_CLICP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("CNH-HIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNH_HIBOR;
			} else if (areEqual(switchArgument, MapperS.of("CNH-HIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNH_HIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("CNH-HIBOR-TMA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNH_HIBOR_TMA;
			} else if (areEqual(switchArgument, MapperS.of("CNY 7-Repo Compounding Date"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_7_REPO_COMPOUNDING_DATE;
			} else if (areEqual(switchArgument, MapperS.of("CNY-CNREPOFIX=CFXS-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_CNREPOFIX_CFXS_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("CNY-Deposit Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_DEPOSIT_RATE;
			} else if (areEqual(switchArgument, MapperS.of("CNY-Fixing Repo Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_FIXING_REPO_RATE;
			} else if (areEqual(switchArgument, MapperS.of("CNY-LPR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_LPR;
			} else if (areEqual(switchArgument, MapperS.of("CNY-PBOCB-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_PBOCB_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_QUARTERLY_7_DAY_REPO_NON_DELIVERABLE_SWAP_RATE_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("CNY-Quarterly 7 day Repo Non Deliverable Swap Rate-TRADITION-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_QUARTERLY_7_DAY_REPO_NON_DELIVERABLE_SWAP_RATE_TRADITION_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("CNY-Quarterly 7D Repo NDS Rate Tradition"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_QUARTERLY_7_D_REPO_NDS_RATE_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("CNY-SHIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_SHIBOR;
			} else if (areEqual(switchArgument, MapperS.of("CNY-SHIBOR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_SHIBOR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("CNY-Shibor-OIS-Compounding"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_SHIBOR_OIS_COMPOUNDING;
			} else if (areEqual(switchArgument, MapperS.of("CNY-SHIBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_SHIBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("CNY-Semi-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("CNY-Semi-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CNY_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("COP-IBR-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.COP_IBR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("COP-IBR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.COP_IBR_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("CZK-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CZK_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("CZK-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CZK_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("CZK-CZEONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CZK_CZEONIA;
			} else if (areEqual(switchArgument, MapperS.of("CZK-CZEONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CZK_CZEONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("CZK-PRIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CZK_PRIBOR;
			} else if (areEqual(switchArgument, MapperS.of("CZK-PRIBOR-PRBO"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CZK_PRIBOR_PRBO;
			} else if (areEqual(switchArgument, MapperS.of("CZK-PRIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.CZK_PRIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("DKK-CIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_CIBOR;
			} else if (areEqual(switchArgument, MapperS.of("DKK-CIBOR2"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_CIBOR2;
			} else if (areEqual(switchArgument, MapperS.of("DKK-CIBOR2-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_CIBOR_2_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("DKK-CIBOR2-DKNA13"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_CIBOR2_DKNA13;
			} else if (areEqual(switchArgument, MapperS.of("DKK-CIBOR-DKNA13"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_CIBOR_DKNA13;
			} else if (areEqual(switchArgument, MapperS.of("DKK-CIBOR-DKNA13-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_CIBOR_DKNA_13_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("DKK-CIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_CIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("DKK-CITA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_CITA;
			} else if (areEqual(switchArgument, MapperS.of("DKK-CITA-DKNA14-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_CITA_DKNA14_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("DKK-DESTR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_DESTR;
			} else if (areEqual(switchArgument, MapperS.of("DKK-DESTR Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_DESTR_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("DKK-DESTR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_DESTR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("DKK-DKKOIS-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_DKKOIS_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("DKK-Tom Next-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.DKK_TOM_NEXT_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("EUR-3M EURIBOR SWAP-CME vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_3_M_EURIBOR_SWAP_CME_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-3M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_3_M_EURIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_3_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-3M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_3_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-6M EURIBOR SWAP-CME vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_6_M_EURIBOR_SWAP_CME_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-6M EURIBOR SWAP-CME vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_6_M_EURIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_6_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-6M EURIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_6_M_EURIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-10:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_10_00;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-10:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_10_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-10:00-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_10_00_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-10:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_10_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-10:00-SwapMarker"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_10_00_SWAP_MARKER;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-10:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_10_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-11:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_11_00;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-11:00-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_11_00_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-11:00-SwapMarker"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_11_00_SWAP_MARKER;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-3 Month"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_3_MONTH;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-3 Month-SwapMarker"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_3_MONTH_SWAP_MARKER;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-4:15-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_4_15_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("EUR-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("EUR Basis Swap-EONIA vs 3m EUR+IBOR Swap Rates-A/360-10:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_BASIS_SWAP_EONIA_VS_3_M_EUR_IBOR_SWAP_RATES_A_360_10_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-CNO TEC10"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_CNO_TEC10;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-AVERAGE"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_AVERAGE_1;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-Average"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_AVERAGE;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-OIS-10:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_OIS_10_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-OIS-10:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_OIS_10_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-OIS-10:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_OIS_10_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-OIS-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_OIS_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-OIS-4:15-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_OIS_4_15_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-OIS-COMPOUND-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_OIS_COMPOUND_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EONIA-Swap-Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EONIA_SWAP_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURIBOR-Act/365"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_ACT_365;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURIBOR-Act/365-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_ACT_365_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EUR EURIBOR-Annual Bond Swap vs 1m-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_ANNUAL_BOND_SWAP_VS_1_M_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR EURIBOR-Basis Swap-1m vs 3m-Euribor-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_BASIS_SWAP_1_M_VS_3_M_EURIBOR_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR EURIBOR-Basis Swap-3m vs 6m-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_BASIS_SWAP_3_M_VS_6_M_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURIBOR ICE Swap Rate-11:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_ICE_SWAP_RATE_11_00;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURIBOR ICE Swap Rate-12:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_ICE_SWAP_RATE_12_00;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURIBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURIBOR-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURIBOR_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURONIA-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EURONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURONIA_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR Average 12M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_AVERAGE_12_M;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR Average 1M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_AVERAGE_1_M;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR Average 1W"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_AVERAGE_1_W;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR Average 3M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_AVERAGE_3_M;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR Average 6M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_AVERAGE_6_M;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR FTSE Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_FTSE_TERM;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR ICE Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_ICE_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR ICE Compounded Index 0 Floor"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR ICE Compounded Index 0 Floor 2D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR ICE Compounded Index 0 Floor 5D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR ICE Compounded Index 2D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_ICE_COMPOUNDED_INDEX_2_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR ICE Compounded Index 5D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_ICE_COMPOUNDED_INDEX_5_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EuroSTR Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_EURO_STR_TERM;
			} else if (areEqual(switchArgument, MapperS.of("EUR-ISDA-EURIBOR Swap Rate-11:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ISDA_EURIBOR_SWAP_RATE_11_00;
			} else if (areEqual(switchArgument, MapperS.of("EUR-ISDA-EURIBOR Swap Rate-12:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ISDA_EURIBOR_SWAP_RATE_12_00;
			} else if (areEqual(switchArgument, MapperS.of("EUR-ISDA-LIBOR Swap Rate-10:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ISDA_LIBOR_SWAP_RATE_10_00;
			} else if (areEqual(switchArgument, MapperS.of("EUR-ISDA-LIBOR Swap Rate-11:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_ISDA_LIBOR_SWAP_RATE_11_00;
			} else if (areEqual(switchArgument, MapperS.of("EUR-LIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_LIBOR;
			} else if (areEqual(switchArgument, MapperS.of("EUR-LIBOR-BBA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_LIBOR_BBA;
			} else if (areEqual(switchArgument, MapperS.of("EUR-LIBOR-BBA-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_LIBOR_BBA_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EUR-LIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_LIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("EUR-TAM-CDC"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_TAM_CDC;
			} else if (areEqual(switchArgument, MapperS.of("EUR-TEC10-CNO"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_TEC10_CNO;
			} else if (areEqual(switchArgument, MapperS.of("EUR-TEC10-CNO-SwapMarker"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_TEC_10_CNO_SWAP_MARKER;
			} else if (areEqual(switchArgument, MapperS.of("EUR-TEC10-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_TEC_10_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("EUR-TEC5-CNO"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_TEC5_CNO;
			} else if (areEqual(switchArgument, MapperS.of("EUR-TEC5-CNO-SwapMarker"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_TEC_5_CNO_SWAP_MARKER;
			} else if (areEqual(switchArgument, MapperS.of("EUR-TEC5-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_TEC_5_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("EUR-TMM-CDC-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_TMM_CDC_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("EUR USD-Basis Swaps-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.EUR_USD_BASIS_SWAPS_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("GBP-6M LIBOR SWAP-CME vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("GBP-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("GBP-6M LIBOR SWAP-EUREX vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_6_M_LIBOR_SWAP_EUREX_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("GBP-ISDA-Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_ISDA_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("GBP-LIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_LIBOR;
			} else if (areEqual(switchArgument, MapperS.of("GBP-LIBOR-BBA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_LIBOR_BBA;
			} else if (areEqual(switchArgument, MapperS.of("GBP-LIBOR-BBA-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_LIBOR_BBA_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("GBP-LIBOR ICE Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_LIBOR_ICE_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("GBP-LIBOR-ISDA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_LIBOR_ISDA;
			} else if (areEqual(switchArgument, MapperS.of("GBP-LIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_LIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("GBP-RONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_RONIA;
			} else if (areEqual(switchArgument, MapperS.of("GBP-RONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_RONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA FTSE Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_FTSE_TERM;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA ICE Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_ICE_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA ICE Compounded Index 0 Floor"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA ICE Compounded Index 0 Floor 2D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA ICE Compounded Index 0 Floor 5D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA ICE Compounded Index 2D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_ICE_COMPOUNDED_INDEX_2_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA ICE Compounded Index 5D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_ICE_COMPOUNDED_INDEX_5_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA ICE Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_ICE_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA ICE Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_ICE_TERM;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA-OIS-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_OIS_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA-OIS-11:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_OIS_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA-OIS-4:15-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_OIS_4_15_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("GBP-SONIA Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SONIA_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("GBP-Semi-Annual Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SEMI_ANNUAL_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("GBP-Semi-Annual Swap Rate-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SEMI_ANNUAL_SWAP_RATE_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("GBP-Semi Annual Swap Rate-11:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SEMI_ANNUAL_SWAP_RATE_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("GBP-Semi Annual Swap Rate-4:15-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SEMI_ANNUAL_SWAP_RATE_4_15_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("GBP-Semi-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("GBP-Semi-Annual Swap Rate-SwapMarker26"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_SEMI_ANNUAL_SWAP_RATE_SWAP_MARKER_26;
			} else if (areEqual(switchArgument, MapperS.of("GBP-UK Base Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_UK_BASE_RATE;
			} else if (areEqual(switchArgument, MapperS.of("GBP USD-Basis Swaps-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_USD_BASIS_SWAPS_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("GBP-WMBA-RONIA-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_WMBA_RONIA_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("GBP-WMBA-SONIA-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GBP_WMBA_SONIA_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("GRD-ATHIBOR-ATHIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GRD_ATHIBOR_ATHIBOR;
			} else if (areEqual(switchArgument, MapperS.of("GRD-ATHIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GRD_ATHIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("GRD-ATHIBOR-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GRD_ATHIBOR_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("GRD-ATHIMID-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GRD_ATHIMID_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("GRD-ATHIMID-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.GRD_ATHIMID_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HIBOR;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HIBOR-HIBOR="), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HIBOR_HIBOR_;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HIBOR-HIBOR-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HIBOR_HIBOR_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HIBOR-HKAB"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HIBOR_HKAB;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HIBOR-HKAB-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HIBOR_HKAB_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HIBOR-ISDC"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HIBOR_ISDC;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HONIA;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("HKD-HONIX-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_HONIX_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("HKD-ISDA-Swap Rate-11:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_ISDA_SWAP_RATE_11_00;
			} else if (areEqual(switchArgument, MapperS.of("HKD-ISDA-Swap Rate-4:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_ISDA_SWAP_RATE_4_00;
			} else if (areEqual(switchArgument, MapperS.of("HKD-Quarterly-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("HKD-Quarterly-Annual Swap Rate-11:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("HKD-Quarterly-Annual Swap Rate-4:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_QUARTERLY_ANNUAL_SWAP_RATE_4_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("HKD-Quarterly-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_QUARTERLY_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("HKD-Quarterly-Quarterly Swap Rate-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_QUARTERLY_QUARTERLY_SWAP_RATE_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("HKD-Quarterly-Quarterly Swap Rate-4:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_QUARTERLY_QUARTERLY_SWAP_RATE_4_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("HKD-Quarterly-Quarterly Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HKD_QUARTERLY_QUARTERLY_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("HUF-BUBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HUF_BUBOR;
			} else if (areEqual(switchArgument, MapperS.of("HUF-BUBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HUF_BUBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("HUF-BUBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HUF_BUBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("HUF-HUFONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HUF_HUFONIA;
			} else if (areEqual(switchArgument, MapperS.of("HUF-HUFONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.HUF_HUFONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("IDR-IDMA-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_IDMA_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("IDR-IDRFIX"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_IDRFIX;
			} else if (areEqual(switchArgument, MapperS.of("IDR-JIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_JIBOR;
			} else if (areEqual(switchArgument, MapperS.of("IDR-JIBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_JIBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("IDR-SBI-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_SBI_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("IDR-SOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_SOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("IDR-SOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_SOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("IDR-SOR-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_SOR_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("IDR-Semi-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("IDR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_SEMI_ANNUAL_SWAP_RATE_NON_DELIVERABLE_16_00_TULLETT_PREBON;
			} else if (areEqual(switchArgument, MapperS.of("IDR-Semi-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.IDR_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("ILS-SHIR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ILS_SHIR;
			} else if (areEqual(switchArgument, MapperS.of("ILS-SHIR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ILS_SHIR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("ILS-TELBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ILS_TELBOR;
			} else if (areEqual(switchArgument, MapperS.of("ILS-TELBOR01-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ILS_TELBOR_01_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("ILS-TELBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ILS_TELBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("INR-BMK"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_BMK;
			} else if (areEqual(switchArgument, MapperS.of("INR-CMT"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_CMT;
			} else if (areEqual(switchArgument, MapperS.of("INR-FBIL-MIBOR-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_FBIL_MIBOR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("INR-INBMK-REUTERS"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_INBMK_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("INR-MIBOR OIS"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_MIBOR_OIS;
			} else if (areEqual(switchArgument, MapperS.of("INR-MIBOR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_MIBOR_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("INR-MIBOR-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_MIBOR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("INR-MIFOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_MIFOR;
			} else if (areEqual(switchArgument, MapperS.of("INR-MIOIS"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_MIOIS;
			} else if (areEqual(switchArgument, MapperS.of("INR-MITOR-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_MITOR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("INR-Modified MIFOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_MODIFIED_MIFOR;
			} else if (areEqual(switchArgument, MapperS.of("INR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("INR-Semi-Annual Swap Rate-11:30-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_SEMI_ANNUAL_SWAP_RATE_11_30_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("INR-Semi Annual Swap Rate-Non-deliverable-16:00-Tullett Prebon"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_SEMI_ANNUAL_SWAP_RATE_NON_DELIVERABLE_16_00_TULLETT_PREBON;
			} else if (areEqual(switchArgument, MapperS.of("INR-Semi-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.INR_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("ISK-REIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ISK_REIBOR;
			} else if (areEqual(switchArgument, MapperS.of("ISK-REIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ISK_REIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("ISK-REIBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ISK_REIBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("JPY-Annual Swap Rate-11:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_ANNUAL_SWAP_RATE_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("JPY-Annual Swap Rate-3:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_ANNUAL_SWAP_RATE_3_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("JPY-BBSF-Bloomberg-10:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_BBSF_BLOOMBERG_10_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-BBSF-Bloomberg-15:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_BBSF_BLOOMBERG_15_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-Euroyen TIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_EUROYEN_TIBOR;
			} else if (areEqual(switchArgument, MapperS.of("JPY-ISDA-Swap Rate-10:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_ISDA_SWAP_RATE_10_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-ISDA-Swap Rate-15:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_ISDA_SWAP_RATE_15_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LIBOR;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LIBOR-BBA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LIBOR_BBA;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LIBOR-BBA-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LIBOR_BBA_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LIBOR-FRASETT"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LIBOR_FRASETT;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LIBOR-ISDA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LIBOR_ISDA;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LIBOR TSR-10:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LIBOR_TSR_10_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LIBOR TSR-15:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LIBOR_TSR_15_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LTPR MHBK"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LTPR_MHBK;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LTPR-MHCB"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LTPR_MHCB;
			} else if (areEqual(switchArgument, MapperS.of("JPY-LTPR-TBC"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_LTPR_TBC;
			} else if (areEqual(switchArgument, MapperS.of("JPY-MUTANCALL-TONAR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_MUTANCALL_TONAR;
			} else if (areEqual(switchArgument, MapperS.of("JPY-OIS-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_OIS_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("JPY-OIS-11:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_OIS_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("JPY-OIS-3:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_OIS_3_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("JPY-Quoting Banks-LIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_QUOTING_BANKS_LIBOR;
			} else if (areEqual(switchArgument, MapperS.of("JPY-STPR-Quoting Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_STPR_QUOTING_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-17096"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_17096;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-17097"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_17097;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-DTIBOR01"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_DTIBOR01;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-TIBM"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_TIBM;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-TIBM-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_TIBM_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-TIBM (10 Banks)"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_TIBM_10_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-TIBM (5 Banks)"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_TIBM_5_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-TIBM (All Banks)"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_TIBM_ALL_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-TIBM (All Banks)-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_TIBM_ALL_BANKS_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TIBOR-ZTIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TIBOR_ZTIBOR;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA Average 180D"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_AVERAGE_180_D;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA Average 30D"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_AVERAGE_30_D;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA Average 90D"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_AVERAGE_90_D;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA ICE Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_ICE_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA ICE Compounded Index 0 Floor"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA ICE Compounded Index 0 Floor 2D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA ICE Compounded Index 0 Floor 5D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA ICE Compounded Index 2D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_ICE_COMPOUNDED_INDEX_2_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA ICE Compounded Index 5D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_ICE_COMPOUNDED_INDEX_5_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA TSR-10:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_TSR_10_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TONA TSR-15:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TONA_TSR_15_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TORF QUICK"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TORF_QUICK;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TSR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TSR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TSR-Reuters-10:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TSR_REUTERS_10_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TSR-Reuters-15:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TSR_REUTERS_15_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TSR-Telerate-10:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TSR_TELERATE_10_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY-TSR-Telerate-15:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_TSR_TELERATE_15_00;
			} else if (areEqual(switchArgument, MapperS.of("JPY USD-Basis Swaps-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.JPY_USD_BASIS_SWAPS_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("KRW-Bond-3222"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.KRW_BOND_3222;
			} else if (areEqual(switchArgument, MapperS.of("KRW-CD-3220"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.KRW_CD_3220;
			} else if (areEqual(switchArgument, MapperS.of("KRW-CD 91D"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.KRW_CD_91D;
			} else if (areEqual(switchArgument, MapperS.of("KRW-CD-KSDA-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.KRW_CD_KSDA_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("KRW-KOFR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.KRW_KOFR;
			} else if (areEqual(switchArgument, MapperS.of("KRW-KOFR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.KRW_KOFR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("KRW-Quarterly Annual Swap Rate-3:30-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.KRW_QUARTERLY_ANNUAL_SWAP_RATE_3_30_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("MXN-TIIE"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MXN_TIIE;
			} else if (areEqual(switchArgument, MapperS.of("MXN-TIIE-Banxico"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MXN_TIIE_BANXICO;
			} else if (areEqual(switchArgument, MapperS.of("MXN-TIIE-Banxico-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MXN_TIIE_BANXICO_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("MXN-TIIE-Banxico-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MXN_TIIE_BANXICO_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("MXN-TIIE ON"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MXN_TIIE_ON;
			} else if (areEqual(switchArgument, MapperS.of("MXN-TIIE ON-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MXN_TIIE_ON_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("MXN-TIIE-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MXN_TIIE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("MYR-KLIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MYR_KLIBOR;
			} else if (areEqual(switchArgument, MapperS.of("MYR-KLIBOR-BNM"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MYR_KLIBOR_BNM;
			} else if (areEqual(switchArgument, MapperS.of("MYR-KLIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MYR_KLIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("MYR-MYOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MYR_MYOR;
			} else if (areEqual(switchArgument, MapperS.of("MYR-MYOR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MYR_MYOR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("MYR-Quarterly Swap Rate-11:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MYR_QUARTERLY_SWAP_RATE_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("MYR-Quarterly Swap Rate-TRADITION-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.MYR_QUARTERLY_SWAP_RATE_TRADITION_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("NOK-NIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NOK_NIBOR;
			} else if (areEqual(switchArgument, MapperS.of("NOK-NIBOR-NIBR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NOK_NIBOR_NIBR;
			} else if (areEqual(switchArgument, MapperS.of("NOK-NIBOR-NIBR-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NOK_NIBOR_NIBR_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("NOK-NIBOR-NIBR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NOK_NIBOR_NIBR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("NOK-NIBOR-OIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NOK_NIBOR_OIBOR;
			} else if (areEqual(switchArgument, MapperS.of("NOK-NIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NOK_NIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("NOK-NOWA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NOK_NOWA;
			} else if (areEqual(switchArgument, MapperS.of("NOK-NOWA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NOK_NOWA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("NZD-BBR-BID"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_BBR_BID;
			} else if (areEqual(switchArgument, MapperS.of("NZD-BBR-FRA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_BBR_FRA;
			} else if (areEqual(switchArgument, MapperS.of("NZD-BBR-ISDC"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_BBR_ISDC;
			} else if (areEqual(switchArgument, MapperS.of("NZD-BBR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_BBR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("NZD-BBR-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_BBR_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("NZD-BKBM Bid"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_BKBM_BID;
			} else if (areEqual(switchArgument, MapperS.of("NZD-BKBM FRA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_BKBM_FRA;
			} else if (areEqual(switchArgument, MapperS.of("NZD-BKBM FRA Swap Rate ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_BKBM_FRA_SWAP_RATE_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("NZD-NZIONA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_NZIONA;
			} else if (areEqual(switchArgument, MapperS.of("NZD-NZIONA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_NZIONA_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("NZD-NZIONA-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_NZIONA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("NZD-Semi-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("NZD-Semi-Annual Swap Rate-BGCANTOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_SEMI_ANNUAL_SWAP_RATE_BGCANTOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("NZD-Swap Rate-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_SWAP_RATE_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("NZD-Swap Rate-ICAP-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.NZD_SWAP_RATE_ICAP_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("PHP-PHIREF"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PHP_PHIREF;
			} else if (areEqual(switchArgument, MapperS.of("PHP-PHIREF-BAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PHP_PHIREF_BAP;
			} else if (areEqual(switchArgument, MapperS.of("PHP-PHIREF-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PHP_PHIREF_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("PHP-PHIREF-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PHP_PHIREF_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("PHP-Semi-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PHP_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("PHP-Semi-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PHP_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("PLN-POLONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLN_POLONIA;
			} else if (areEqual(switchArgument, MapperS.of("PLN-POLONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLN_POLONIA_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("PLN-POLONIA-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLN_POLONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("PLN-WIBID"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLN_WIBID;
			} else if (areEqual(switchArgument, MapperS.of("PLN-WIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLN_WIBOR;
			} else if (areEqual(switchArgument, MapperS.of("PLN-WIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLN_WIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("PLN-WIBOR-WIBO"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLN_WIBOR_WIBO;
			} else if (areEqual(switchArgument, MapperS.of("PLN-WIRON"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLN_WIRON;
			} else if (areEqual(switchArgument, MapperS.of("PLN-WIRON-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLN_WIRON_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("PLZ-WIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLZ_WIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("PLZ-WIBOR-WIBO"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.PLZ_WIBOR_WIBO;
			} else if (areEqual(switchArgument, MapperS.of("REPOFUNDS RATE-FRANCE-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.REPOFUNDS_RATE_FRANCE_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("REPOFUNDS RATE-GERMANY-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.REPOFUNDS_RATE_GERMANY_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("REPOFUNDS RATE-ITALY-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.REPOFUNDS_RATE_ITALY_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("RON-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RON_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("RON-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RON_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("RON-RBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RON_RBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("RON-ROBID"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RON_ROBID;
			} else if (areEqual(switchArgument, MapperS.of("RON-ROBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RON_ROBOR;
			} else if (areEqual(switchArgument, MapperS.of("RUB-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("RUB-Annual Swap Rate-12:45-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_ANNUAL_SWAP_RATE_12_45_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("RUB-Annual Swap Rate-4:15-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_ANNUAL_SWAP_RATE_4_15_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("RUB-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("RUB-Annual Swap Rate-TRADITION-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("RUB-Key Rate CBRF"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_KEY_RATE_CBRF;
			} else if (areEqual(switchArgument, MapperS.of("RUB-MosPrime"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_MOS_PRIME;
			} else if (areEqual(switchArgument, MapperS.of("RUB-MOSPRIME-NFEA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_MOSPRIME_NFEA;
			} else if (areEqual(switchArgument, MapperS.of("RUB-MOSPRIME-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_MOSPRIME_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("RUB-RUONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_RUONIA;
			} else if (areEqual(switchArgument, MapperS.of("RUB-RUONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_RUONIA_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("RUB-RUONIA-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.RUB_RUONIA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("SAR-SAIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SAR_SAIBOR;
			} else if (areEqual(switchArgument, MapperS.of("SAR-SRIOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SAR_SRIOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("SAR-SRIOR-SUAA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SAR_SRIOR_SUAA;
			} else if (areEqual(switchArgument, MapperS.of("SEK-Annual Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_ANNUAL_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("SEK-Annual Swap Rate-SESWFI"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_ANNUAL_SWAP_RATE_SESWFI;
			} else if (areEqual(switchArgument, MapperS.of("SEK-SIOR-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_SIOR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("SEK-STIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_STIBOR;
			} else if (areEqual(switchArgument, MapperS.of("SEK-STIBOR-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_STIBOR_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("SEK-STIBOR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_STIBOR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("SEK-STIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_STIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("SEK-STIBOR-SIDE"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_STIBOR_SIDE;
			} else if (areEqual(switchArgument, MapperS.of("SEK-SWESTR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_SWESTR;
			} else if (areEqual(switchArgument, MapperS.of("SEK-SWESTR Average 1M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_SWESTR_AVERAGE_1_M;
			} else if (areEqual(switchArgument, MapperS.of("SEK-SWESTR Average 1W"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_SWESTR_AVERAGE_1_W;
			} else if (areEqual(switchArgument, MapperS.of("SEK-SWESTR Average 2M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_SWESTR_AVERAGE_2_M;
			} else if (areEqual(switchArgument, MapperS.of("SEK-SWESTR Average 3M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_SWESTR_AVERAGE_3_M;
			} else if (areEqual(switchArgument, MapperS.of("SEK-SWESTR Average 6M"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_SWESTR_AVERAGE_6_M;
			} else if (areEqual(switchArgument, MapperS.of("SEK-SWESTR Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_SWESTR_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("SEK-SWESTR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SEK_SWESTR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Currency Basis Swap Rate-11:00-Tullett Prebon"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_CURRENCY_BASIS_SWAP_RATE_11_00_TULLETT_PREBON;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Currency Basis Swap Rate-16:00-Tullett Prebon"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_CURRENCY_BASIS_SWAP_RATE_16_00_TULLETT_PREBON;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Swap Rate-11.00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_SWAP_RATE_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Swap Rate-11:00-Tullett Prebon"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_SWAP_RATE_11_00_TULLETT_PREBON;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Swap Rate-16:00-Tullett Prebon"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_SWAP_RATE_16_00_TULLETT_PREBON;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Swap Rate-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_SWAP_RATE_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Swap Rate-ICAP-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_SWAP_RATE_ICAP_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("SGD-Semi-Annual Swap Rate-TRADITION-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SEMI_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SIBOR;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SIBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SIBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SIBOR-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SIBOR_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SONAR-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SONAR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SONAR-OIS-VWAP-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SONAR_OIS_VWAP_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SOR;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SOR-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SOR_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SOR-VWAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SOR_VWAP;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SOR-VWAP-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SOR_VWAP_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SORA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SORA;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SORA-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SORA_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("SGD-SORA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SGD_SORA_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("SKK-BRIBOR-BRBO"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SKK_BRIBOR_BRBO;
			} else if (areEqual(switchArgument, MapperS.of("SKK-BRIBOR-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SKK_BRIBOR_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("SKK-BRIBOR-NBSK07"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SKK_BRIBOR_NBSK07;
			} else if (areEqual(switchArgument, MapperS.of("SKK-BRIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.SKK_BRIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("THB-Semi-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("THB-Semi-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("THB-SOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_SOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("THB-SOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_SOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("THB-SOR-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_SOR_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("THB-THBFIX"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_THBFIX;
			} else if (areEqual(switchArgument, MapperS.of("THB-THBFIX-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_THBFIX_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("THB-THBFIX-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_THBFIX_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("THB-THOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_THOR;
			} else if (areEqual(switchArgument, MapperS.of("THB-THOR-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_THOR_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("THB-THOR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.THB_THOR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("TRY Annual Swap Rate-11:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_ANNUAL_SWAP_RATE_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("TRY-Annual Swap Rate-11:15-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_ANNUAL_SWAP_RATE_11_15_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("TRY-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("TRY-Semi-Annual Swap Rate-TRADITION-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_SEMI_ANNUAL_SWAP_RATE_TRADITION_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("TRY-TLREF"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_TLREF;
			} else if (areEqual(switchArgument, MapperS.of("TRY-TLREF-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_TLREF_OIS_COMPOUND_1;
			} else if (areEqual(switchArgument, MapperS.of("TRY-TLREF-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_TLREF_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("TRY-TRLIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_TRLIBOR;
			} else if (areEqual(switchArgument, MapperS.of("TRY-TRYIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_TRYIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("TRY-TRYIBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TRY_TRYIBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("TWD-Quarterly-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_QUARTERLY_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("TWD-Quarterly-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_QUARTERLY_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("TWD-Reference Dealers"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_REFERENCE_DEALERS;
			} else if (areEqual(switchArgument, MapperS.of("TWD-Reuters-6165"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_REUTERS_6165;
			} else if (areEqual(switchArgument, MapperS.of("TWD-TAIBIR01"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_TAIBIR01;
			} else if (areEqual(switchArgument, MapperS.of("TWD-TAIBIR02"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_TAIBIR02;
			} else if (areEqual(switchArgument, MapperS.of("TWD-TAIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_TAIBOR;
			} else if (areEqual(switchArgument, MapperS.of("TWD-TAIBOR-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_TAIBOR_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("TWD-TAIBOR-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_TAIBOR_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("TWD-TWCPBA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_TWCPBA;
			} else if (areEqual(switchArgument, MapperS.of("TWD-Telerate-6165"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.TWD_TELERATE_6165;
			} else if (areEqual(switchArgument, MapperS.of("UK Base Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.UK_BASE_RATE;
			} else if (areEqual(switchArgument, MapperS.of("USD-3M LIBOR SWAP-CME vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("USD-3M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_3_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("USD-6M LIBOR SWAP-CME vs LCH-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("USD-6M LIBOR SWAP-CME vs LCH-ICAP-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_6_M_LIBOR_SWAP_CME_VS_LCH_ICAP_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("USD-AMERIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_AMERIBOR;
			} else if (areEqual(switchArgument, MapperS.of("USD-AMERIBOR Average 30D"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_AMERIBOR_AVERAGE_30_D;
			} else if (areEqual(switchArgument, MapperS.of("USD-AMERIBOR Average 90D"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_AMERIBOR_AVERAGE_90_D;
			} else if (areEqual(switchArgument, MapperS.of("USD-AMERIBOR Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_AMERIBOR_TERM;
			} else if (areEqual(switchArgument, MapperS.of("USD-AMERIBOR Term Structure"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_AMERIBOR_TERM_STRUCTURE;
			} else if (areEqual(switchArgument, MapperS.of("USD-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("USD-Annual Swap Rate-11:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_ANNUAL_SWAP_RATE_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("USD-Annual Swap Rate-4:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_ANNUAL_SWAP_RATE_4_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("USD-AXI Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_AXI_TERM;
			} else if (areEqual(switchArgument, MapperS.of("USD-BA-H.15"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_BA_H_15;
			} else if (areEqual(switchArgument, MapperS.of("USD-BA-Reference Dealers"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_BA_REFERENCE_DEALERS;
			} else if (areEqual(switchArgument, MapperS.of("USD-BMA Municipal Swap Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_BMA_MUNICIPAL_SWAP_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("USD-BSBY"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_BSBY;
			} else if (areEqual(switchArgument, MapperS.of("USD-CD-H.15"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CD_H_15;
			} else if (areEqual(switchArgument, MapperS.of("USD-CD-Reference Dealers"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CD_REFERENCE_DEALERS;
			} else if (areEqual(switchArgument, MapperS.of("USD-CMS-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CMS_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("USD-CMS-Reference Banks-ICAP SwapPX"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CMS_REFERENCE_BANKS_ICAP_SWAP_PX;
			} else if (areEqual(switchArgument, MapperS.of("USD-CMS-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CMS_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("USD-CMS-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CMS_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("USD-CMT"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CMT;
			} else if (areEqual(switchArgument, MapperS.of("USD-CMT Average 1W"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CMT_AVERAGE_1_W;
			} else if (areEqual(switchArgument, MapperS.of("USD-CMT-T7051"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CMT_T7051;
			} else if (areEqual(switchArgument, MapperS.of("USD-CMT-T7052"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CMT_T7052;
			} else if (areEqual(switchArgument, MapperS.of("USD-COFI"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_COFI;
			} else if (areEqual(switchArgument, MapperS.of("USD-COF11-FHLBSF"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_COF11_FHLBSF;
			} else if (areEqual(switchArgument, MapperS.of("USD-COF11-Reuters"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_COF_11_REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("USD-COF11-Telerate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_COF_11_TELERATE;
			} else if (areEqual(switchArgument, MapperS.of("USD-CP-H.15"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CP_H_15;
			} else if (areEqual(switchArgument, MapperS.of("USD-CP-Money Market Yield"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CP_MONEY_MARKET_YIELD;
			} else if (areEqual(switchArgument, MapperS.of("USD-CP-Reference Dealers"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CP_REFERENCE_DEALERS;
			} else if (areEqual(switchArgument, MapperS.of("USD-CRITR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_CRITR;
			} else if (areEqual(switchArgument, MapperS.of("USD-FFCB-DISCO"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_FFCB_DISCO;
			} else if (areEqual(switchArgument, MapperS.of("USD-Federal Funds"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_FEDERAL_FUNDS;
			} else if (areEqual(switchArgument, MapperS.of("USD-Federal Funds-H.15"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_FEDERAL_FUNDS_H_15;
			} else if (areEqual(switchArgument, MapperS.of("USD-Federal Funds-H.15-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_FEDERAL_FUNDS_H_15_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("USD-Federal Funds-H.15-OIS-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_FEDERAL_FUNDS_H_15_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("USD-Federal Funds-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_FEDERAL_FUNDS_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("USD-Federal Funds-Reference Dealers"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_FEDERAL_FUNDS_REFERENCE_DEALERS;
			} else if (areEqual(switchArgument, MapperS.of("USD-FXI Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_FXI_TERM;
			} else if (areEqual(switchArgument, MapperS.of("USD-ISDAFIX3-Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_ISDAFIX_3_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("USD-ISDAFIX3-Swap Rate-3:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_ISDAFIX_3_SWAP_RATE_3_00;
			} else if (areEqual(switchArgument, MapperS.of("USD-ISDA-Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_ISDA_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("USD-ISDA-Swap Rate-3:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_ISDA_SWAP_RATE_3_00;
			} else if (areEqual(switchArgument, MapperS.of("USD-LIBOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_LIBOR;
			} else if (areEqual(switchArgument, MapperS.of("USD-LIBOR-BBA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_LIBOR_BBA;
			} else if (areEqual(switchArgument, MapperS.of("USD-LIBOR-BBA-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_LIBOR_BBA_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("USD-LIBOR ICE Swap Rate-11:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_LIBOR_ICE_SWAP_RATE_11_00;
			} else if (areEqual(switchArgument, MapperS.of("USD-LIBOR ICE Swap Rate-15:00"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_LIBOR_ICE_SWAP_RATE_15_00;
			} else if (areEqual(switchArgument, MapperS.of("USD-LIBOR-ISDA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_LIBOR_ISDA;
			} else if (areEqual(switchArgument, MapperS.of("USD-LIBOR-LIBO"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_LIBOR_LIBO;
			} else if (areEqual(switchArgument, MapperS.of("USD-LIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_LIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("USD-Municipal Swap Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_MUNICIPAL_SWAP_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("USD-Municipal Swap Libor Ratio-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_MUNICIPAL_SWAP_LIBOR_RATIO_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("USD-Municipal Swap Rate-11:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_MUNICIPAL_SWAP_RATE_11_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("USD-OIS-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_OIS_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("USD-OIS-11:00-LON-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_OIS_11_00_LON_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("USD-OIS-11:00-NY-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_OIS_11_00_NY_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("USD-OIS-11:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_OIS_11_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("USD-OIS-3:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_OIS_3_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("USD-OIS-3:00-NY-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_OIS_3_00_NY_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("USD-OIS-4:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_OIS_4_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("USD-Overnight Bank Funding Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_OVERNIGHT_BANK_FUNDING_RATE;
			} else if (areEqual(switchArgument, MapperS.of("USD-Prime"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_PRIME;
			} else if (areEqual(switchArgument, MapperS.of("USD-Prime-H.15"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_PRIME_H_15;
			} else if (areEqual(switchArgument, MapperS.of("USD-Prime-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_PRIME_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("USD-SandP Index High Grade"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SAND_P_INDEX_HIGH_GRADE;
			} else if (areEqual(switchArgument, MapperS.of("USD-SIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("USD-SIBOR-SIBO"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SIBOR_SIBO;
			} else if (areEqual(switchArgument, MapperS.of("USD-SIFMA Municipal Swap Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SIFMA_MUNICIPAL_SWAP_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR-COMPOUND"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR Average 180D"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_AVERAGE_180_D;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR Average 30D"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_AVERAGE_30_D;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR Average 90D"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_AVERAGE_90_D;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR CME Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_CME_TERM;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR ICE Compounded Index"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_ICE_COMPOUNDED_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR ICE Compounded Index 0 Floor"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR ICE Compounded Index 0 Floor 2D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR_2_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR ICE Compounded Index 0 Floor 5D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_ICE_COMPOUNDED_INDEX_0_FLOOR_5_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR ICE Compounded Index 2D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_ICE_COMPOUNDED_INDEX_2_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR ICE Compounded Index 5D Lag"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_ICE_COMPOUNDED_INDEX_5_D_LAG;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR ICE Swap Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_ICE_SWAP_RATE;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR ICE Term"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_ICE_TERM;
			} else if (areEqual(switchArgument, MapperS.of("USD-SOFR-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SOFR_OIS_COMPOUND;
			} else if (areEqual(switchArgument, MapperS.of("USD-S&P Index-High Grade"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_S_P_INDEX_HIGH_GRADE;
			} else if (areEqual(switchArgument, MapperS.of("USD Swap Rate-BCMP1"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_SWAP_RATE_BCMP_1;
			} else if (areEqual(switchArgument, MapperS.of("USD-TBILL Auction High Rate"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TBILL_AUCTION_HIGH_RATE;
			} else if (areEqual(switchArgument, MapperS.of("USD-TBILL-H.15"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TBILL_H_15;
			} else if (areEqual(switchArgument, MapperS.of("USD-TBILL-H.15-Bloomberg"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TBILL_H_15_BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("USD-TBILL-Secondary Market"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TBILL_SECONDARY_MARKET;
			} else if (areEqual(switchArgument, MapperS.of("USD-TBILL Secondary Market-Bond Equivalent Yield"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TBILL_SECONDARY_MARKET_BOND_EQUIVALENT_YIELD;
			} else if (areEqual(switchArgument, MapperS.of("USD-TIBOR-ISDC"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TIBOR_ISDC;
			} else if (areEqual(switchArgument, MapperS.of("USD-TIBOR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TIBOR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("USD-Treasury-19901-3:00-ICAP"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TREASURY_19901_3_00_ICAP;
			} else if (areEqual(switchArgument, MapperS.of("USD Treasury Rate-BCMP1"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TREASURY_RATE_BCMP_1;
			} else if (areEqual(switchArgument, MapperS.of("USD-Treasury Rate-ICAP BrokerTec"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TREASURY_RATE_ICAP_BROKER_TEC;
			} else if (areEqual(switchArgument, MapperS.of("USD-Treasury Rate-SwapMarker100"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TREASURY_RATE_SWAP_MARKER_100;
			} else if (areEqual(switchArgument, MapperS.of("USD-Treasury Rate-SwapMarker99"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TREASURY_RATE_SWAP_MARKER_99;
			} else if (areEqual(switchArgument, MapperS.of("USD-Treasury Rate-T19901"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TREASURY_RATE_T_19901;
			} else if (areEqual(switchArgument, MapperS.of("USD-Treasury Rate-T500"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.USD_TREASURY_RATE_T_500;
			} else if (areEqual(switchArgument, MapperS.of("VND-Semi-Annual Swap Rate-11:00-BGCANTOR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.VND_SEMI_ANNUAL_SWAP_RATE_11_00_BGCANTOR;
			} else if (areEqual(switchArgument, MapperS.of("VND-Semi-Annual Swap Rate-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.VND_SEMI_ANNUAL_SWAP_RATE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-DEPOSIT-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_DEPOSIT_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-DEPOSIT-SAFEX"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_DEPOSIT_SAFEX;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-JIBAR"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_JIBAR;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-JIBAR-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_JIBAR_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-JIBAR-SAFEX"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_JIBAR_SAFEX;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-Prime Average"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_PRIME_AVERAGE_1;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-PRIME-AVERAGE"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_PRIME_AVERAGE;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-PRIME-AVERAGE-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_PRIME_AVERAGE_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-Quarterly Swap Rate-1:00-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_QUARTERLY_SWAP_RATE_1_00_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-Quarterly Swap Rate-5:30-TRADITION"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_QUARTERLY_SWAP_RATE_5_30_TRADITION;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-Quarterly Swap Rate-TRADITION-Reference Banks"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_QUARTERLY_SWAP_RATE_TRADITION_REFERENCE_BANKS;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-ZARONIA"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_ZARONIA;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-ZARONIA-OIS Compound"), CardinalityOperator.All).get()) {
				result = FloatingRateIndexEnum.ZAR_ZARONIA_OIS_COMPOUND;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

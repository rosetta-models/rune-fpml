package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.asset.rates.InflationRateIndexEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapInflationRateIndexEnum.MapInflationRateIndexEnumDefault.class)
public abstract class MapInflationRateIndexEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public InflationRateIndexEnum evaluate(String value) {
		InflationRateIndexEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract InflationRateIndexEnum doEvaluate(String value);

	public static class MapInflationRateIndexEnumDefault extends MapInflationRateIndexEnum {
		@Override
		protected InflationRateIndexEnum doEvaluate(String value) {
			InflationRateIndexEnum result = null;
			return assignOutput(result, value);
		}
		
		protected InflationRateIndexEnum assignOutput(InflationRateIndexEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AUD-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.AUD_CPI;
			} else if (areEqual(switchArgument, MapperS.of("AUS-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.AUS_CPI;
			} else if (areEqual(switchArgument, MapperS.of("AUS-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.AUS_HICP;
			} else if (areEqual(switchArgument, MapperS.of("BLG-CPI-GI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.BLG_CPI_GI;
			} else if (areEqual(switchArgument, MapperS.of("BLG-CPI-HI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.BLG_CPI_HI;
			} else if (areEqual(switchArgument, MapperS.of("BLG-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.BLG_HICP;
			} else if (areEqual(switchArgument, MapperS.of("BRL-IGPM"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.BRL_IGPM;
			} else if (areEqual(switchArgument, MapperS.of("BRL-IPCA"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.BRL_IPCA;
			} else if (areEqual(switchArgument, MapperS.of("CAD-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.CAD_CPI;
			} else if (areEqual(switchArgument, MapperS.of("CLP-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.CLP_CPI;
			} else if (areEqual(switchArgument, MapperS.of("CNY-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.CNY_CPI;
			} else if (areEqual(switchArgument, MapperS.of("CZK-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.CZK_CPI;
			} else if (areEqual(switchArgument, MapperS.of("DEK-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.DEK_CPI;
			} else if (areEqual(switchArgument, MapperS.of("DEK-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.DEK_HICP;
			} else if (areEqual(switchArgument, MapperS.of("DEM-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.DEM_CPI;
			} else if (areEqual(switchArgument, MapperS.of("DEM-CPI-NRW"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.DEM_CPI_NRW;
			} else if (areEqual(switchArgument, MapperS.of("DEM-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.DEM_HICP;
			} else if (areEqual(switchArgument, MapperS.of("ESP-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ESP_CPI;
			} else if (areEqual(switchArgument, MapperS.of("ESP-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ESP_HICP;
			} else if (areEqual(switchArgument, MapperS.of("ESP-R-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ESP_R_CPI;
			} else if (areEqual(switchArgument, MapperS.of("ESP-R-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ESP_R_HICP;
			} else if (areEqual(switchArgument, MapperS.of("EUR-AI-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.EUR_AI_CPI;
			} else if (areEqual(switchArgument, MapperS.of("EUR-AI-R-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.EUR_AI_R_CPI;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EXT-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.EUR_EXT_CPI;
			} else if (areEqual(switchArgument, MapperS.of("EUR-EXT-R-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.EUR_EXT_R_CPI;
			} else if (areEqual(switchArgument, MapperS.of("FIN-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.FIN_CPI;
			} else if (areEqual(switchArgument, MapperS.of("FIN-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.FIN_HICP;
			} else if (areEqual(switchArgument, MapperS.of("FRC-EXT-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.FRC_EXT_CPI;
			} else if (areEqual(switchArgument, MapperS.of("FRC-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.FRC_HICP;
			} else if (areEqual(switchArgument, MapperS.of("GRD-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.GRD_CPI;
			} else if (areEqual(switchArgument, MapperS.of("GRD-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.GRD_HICP;
			} else if (areEqual(switchArgument, MapperS.of("HKD-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.HKD_CPI;
			} else if (areEqual(switchArgument, MapperS.of("HUF-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.HUF_CPI;
			} else if (areEqual(switchArgument, MapperS.of("IDR-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.IDR_CPI;
			} else if (areEqual(switchArgument, MapperS.of("ILS-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ILS_CPI;
			} else if (areEqual(switchArgument, MapperS.of("IRL-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.IRL_CPI;
			} else if (areEqual(switchArgument, MapperS.of("IRL-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.IRL_HICP;
			} else if (areEqual(switchArgument, MapperS.of("ISK-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ISK_CPI;
			} else if (areEqual(switchArgument, MapperS.of("ISK-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ISK_HICP;
			} else if (areEqual(switchArgument, MapperS.of("ITL-BC-EXT-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ITL_BC_EXT_CPI;
			} else if (areEqual(switchArgument, MapperS.of("ITL-BC-INT-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ITL_BC_INT_CPI;
			} else if (areEqual(switchArgument, MapperS.of("ITL-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ITL_HICP;
			} else if (areEqual(switchArgument, MapperS.of("ITL-WC-EXT-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ITL_WC_EXT_CPI;
			} else if (areEqual(switchArgument, MapperS.of("ITL-WC-INT-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ITL_WC_INT_CPI;
			} else if (areEqual(switchArgument, MapperS.of("JPY-CPI-EXF"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.JPY_CPI_EXF;
			} else if (areEqual(switchArgument, MapperS.of("KRW-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.KRW_CPI;
			} else if (areEqual(switchArgument, MapperS.of("LUX-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.LUX_CPI;
			} else if (areEqual(switchArgument, MapperS.of("LUX-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.LUX_HICP;
			} else if (areEqual(switchArgument, MapperS.of("MXN-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.MXN_CPI;
			} else if (areEqual(switchArgument, MapperS.of("MXN-UDI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.MXN_UDI;
			} else if (areEqual(switchArgument, MapperS.of("MYR-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.MYR_CPI;
			} else if (areEqual(switchArgument, MapperS.of("NLG-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.NLG_CPI;
			} else if (areEqual(switchArgument, MapperS.of("NLG-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.NLG_HICP;
			} else if (areEqual(switchArgument, MapperS.of("NOK-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.NOK_CPI;
			} else if (areEqual(switchArgument, MapperS.of("NZD-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.NZD_CPI;
			} else if (areEqual(switchArgument, MapperS.of("PER-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.PER_CPI;
			} else if (areEqual(switchArgument, MapperS.of("PLN-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.PLN_CPI;
			} else if (areEqual(switchArgument, MapperS.of("POR-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.POR_CPI;
			} else if (areEqual(switchArgument, MapperS.of("POR-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.POR_HICP;
			} else if (areEqual(switchArgument, MapperS.of("RUB-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.RUB_CPI;
			} else if (areEqual(switchArgument, MapperS.of("SEK-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.SEK_CPI;
			} else if (areEqual(switchArgument, MapperS.of("SGD-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.SGD_CPI;
			} else if (areEqual(switchArgument, MapperS.of("SWF-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.SWF_CPI;
			} else if (areEqual(switchArgument, MapperS.of("TRY-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.TRY_CPI;
			} else if (areEqual(switchArgument, MapperS.of("TWD-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.TWD_CPI;
			} else if (areEqual(switchArgument, MapperS.of("UK-HICP"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.UK_HICP;
			} else if (areEqual(switchArgument, MapperS.of("UK-RPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.UK_RPI;
			} else if (areEqual(switchArgument, MapperS.of("UK-RPIX"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.UK_RPIX;
			} else if (areEqual(switchArgument, MapperS.of("USA-CPI-U"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.USA_CPI_U;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-CPI"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ZAR_CPI;
			} else if (areEqual(switchArgument, MapperS.of("ZAR-CPIX"), CardinalityOperator.All).get()) {
				result = InflationRateIndexEnum.ZAR_CPIX;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.base.datetime.CommodityBusinessCalendarEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCommodityBusinessCalendarEnum.MapCommodityBusinessCalendarEnumDefault.class)
public abstract class MapCommodityBusinessCalendarEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CommodityBusinessCalendarEnum evaluate(String value) {
		CommodityBusinessCalendarEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CommodityBusinessCalendarEnum doEvaluate(String value);

	public static class MapCommodityBusinessCalendarEnumDefault extends MapCommodityBusinessCalendarEnum {
		@Override
		protected CommodityBusinessCalendarEnum doEvaluate(String value) {
			CommodityBusinessCalendarEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CommodityBusinessCalendarEnum assignOutput(CommodityBusinessCalendarEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ADSM"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ADSM;
			} else if (areEqual(switchArgument, MapperS.of("AGRUS-FMB"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.AGRUS_FMB;
			} else if (areEqual(switchArgument, MapperS.of("APPI"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.APPI;
			} else if (areEqual(switchArgument, MapperS.of("ARGUS-CRUDE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ARGUS_CRUDE;
			} else if (areEqual(switchArgument, MapperS.of("ARGUS-EUROPEAN-GAS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ARGUS_EUROPEAN_GAS;
			} else if (areEqual(switchArgument, MapperS.of("ARGUS-EUROPEAN-PRODUCTS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ARGUS_EUROPEAN_PRODUCTS;
			} else if (areEqual(switchArgument, MapperS.of("ARGUS-INTERNATIONAL-LPG"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ARGUS_INTERNATIONAL_LPG;
			} else if (areEqual(switchArgument, MapperS.of("ARGUS-MCCLOSKEYS-COAL-REPORT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ARGUS_MCCLOSKEYS_COAL_REPORT;
			} else if (areEqual(switchArgument, MapperS.of("ARGUS-US-PRODUCTS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ARGUS_US_PRODUCTS;
			} else if (areEqual(switchArgument, MapperS.of("ASX"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ASX;
			} else if (areEqual(switchArgument, MapperS.of("AWB"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.AWB;
			} else if (areEqual(switchArgument, MapperS.of("AWEX"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.AWEX;
			} else if (areEqual(switchArgument, MapperS.of("BALTIC-EXCHANGE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.BALTIC_EXCHANGE;
			} else if (areEqual(switchArgument, MapperS.of("BANK-NEGARA-MALAYSIA-POLICY-COMMITTEE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.BANK_NEGARA_MALAYSIA_POLICY_COMMITTEE;
			} else if (areEqual(switchArgument, MapperS.of("BELPEX"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.BELPEX;
			} else if (areEqual(switchArgument, MapperS.of("BLUENEXT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.BLUENEXT;
			} else if (areEqual(switchArgument, MapperS.of("BM&F"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.BM_F;
			} else if (areEqual(switchArgument, MapperS.of("BURSA-MALAYSIA-SETTLEMENT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.BURSA_MALAYSIA_SETTLEMENT;
			} else if (areEqual(switchArgument, MapperS.of("BURSA-MALAYSIA-TRADING"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.BURSA_MALAYSIA_TRADING;
			} else if (areEqual(switchArgument, MapperS.of("CANADIAN-GAS-PRICE-REPORTER"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CANADIAN_GAS_PRICE_REPORTER;
			} else if (areEqual(switchArgument, MapperS.of("CBOT-SOFT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CBOT_SOFT;
			} else if (areEqual(switchArgument, MapperS.of("CMAI-AROMATICS-MARKET-REPORT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CMAI_AROMATICS_MARKET_REPORT;
			} else if (areEqual(switchArgument, MapperS.of("CMAI-GLOBAL-PLASTICS-AND-POLYMERS-MARKET-REPORT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CMAI_GLOBAL_PLASTICS_AND_POLYMERS_MARKET_REPORT;
			} else if (areEqual(switchArgument, MapperS.of("CMAI-METHANOL-MARKET-REPORT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CMAI_METHANOL_MARKET_REPORT;
			} else if (areEqual(switchArgument, MapperS.of("CMAI-MONOMERS-MARKET-REPORT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CMAI_MONOMERS_MARKET_REPORT;
			} else if (areEqual(switchArgument, MapperS.of("CME-DAIRY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CME_DAIRY;
			} else if (areEqual(switchArgument, MapperS.of("CME-NON-DAIRY-SOFT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CME_NON_DAIRY_SOFT;
			} else if (areEqual(switchArgument, MapperS.of("COMEX"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.COMEX;
			} else if (areEqual(switchArgument, MapperS.of("CRU"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CRU;
			} else if (areEqual(switchArgument, MapperS.of("CRU-LONG"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.CRU_LONG;
			} else if (areEqual(switchArgument, MapperS.of("DEPARTMENT-OF-ENERGY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.DEPARTMENT_OF_ENERGY;
			} else if (areEqual(switchArgument, MapperS.of("DEWITT-BENZENE-DERIVATIVES"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.DEWITT_BENZENE_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("DME"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.DME;
			} else if (areEqual(switchArgument, MapperS.of("DOW-JONES"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.DOW_JONES;
			} else if (areEqual(switchArgument, MapperS.of("DOW-JONES-ENERGY-SERVICE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.DOW_JONES_ENERGY_SERVICE;
			} else if (areEqual(switchArgument, MapperS.of("DowJonesPower"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.DOW_JONES_POWER;
			} else if (areEqual(switchArgument, MapperS.of("EEX-COAL"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.EEX_COAL;
			} else if (areEqual(switchArgument, MapperS.of("EEX-EMISSIONS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.EEX_EMISSIONS;
			} else if (areEqual(switchArgument, MapperS.of("EEX-GAS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.EEX_GAS;
			} else if (areEqual(switchArgument, MapperS.of("EEX-POWER"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.EEX_POWER;
			} else if (areEqual(switchArgument, MapperS.of("EURONEX-MATIF"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.EURONEX_MATIF;
			} else if (areEqual(switchArgument, MapperS.of("FERTECON"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.FERTECON;
			} else if (areEqual(switchArgument, MapperS.of("FERTILIZER-WEEK"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.FERTILIZER_WEEK;
			} else if (areEqual(switchArgument, MapperS.of("GAS-DAILY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.GAS_DAILY;
			} else if (areEqual(switchArgument, MapperS.of("GAS-DAILY-PRICE-GUIDE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.GAS_DAILY_PRICE_GUIDE;
			} else if (areEqual(switchArgument, MapperS.of("GLOBALCOAL"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.GLOBALCOAL;
			} else if (areEqual(switchArgument, MapperS.of("HEREN-REPORT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.HEREN_REPORT;
			} else if (areEqual(switchArgument, MapperS.of("ICE/10X-DAILY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICE_10X_DAILY;
			} else if (areEqual(switchArgument, MapperS.of("ICE/10X-MONTHLY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICE_10X_MONTHLY;
			} else if (areEqual(switchArgument, MapperS.of("ICE-CANADA"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICE_CANADA;
			} else if (areEqual(switchArgument, MapperS.of("ICE-ECX"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICE_ECX;
			} else if (areEqual(switchArgument, MapperS.of("ICE-GAS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICE_GAS;
			} else if (areEqual(switchArgument, MapperS.of("ICE-OIL"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICE_OIL;
			} else if (areEqual(switchArgument, MapperS.of("ICE-US-AGRICULTURAL"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICE_US_AGRICULTURAL;
			} else if (areEqual(switchArgument, MapperS.of("ICIS-PRICING-BENZENE-(EUROPE)"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICIS_PRICING_BENZENE__EUROPE_;
			} else if (areEqual(switchArgument, MapperS.of("ICIS-PRICING-ETHYLENE-(EUROPE)"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICIS_PRICING_ETHYLENE__EUROPE_;
			} else if (areEqual(switchArgument, MapperS.of("ICIS-PRICING-POLYPROPYLENE-(EUROPE)"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.ICIS_PRICING_POLYPROPYLENE__EUROPE_;
			} else if (areEqual(switchArgument, MapperS.of("INSIDE-FERC"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.INSIDE_FERC;
			} else if (areEqual(switchArgument, MapperS.of("JAPAN-MOF-TSRR"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.JAPAN_MOF_TSRR;
			} else if (areEqual(switchArgument, MapperS.of("KCBOT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.KCBOT;
			} else if (areEqual(switchArgument, MapperS.of("KUALA-LUMPUR-BANK"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.KUALA_LUMPUR_BANK;
			} else if (areEqual(switchArgument, MapperS.of("LABUAN-BANK"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.LABUAN_BANK;
			} else if (areEqual(switchArgument, MapperS.of("LIFFE-LONDON-SOFT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.LIFFE_LONDON_SOFT;
			} else if (areEqual(switchArgument, MapperS.of("LME"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.LME;
			} else if (areEqual(switchArgument, MapperS.of("LONDON-BULLION-MARKET"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.LONDON_BULLION_MARKET;
			} else if (areEqual(switchArgument, MapperS.of("LONDON-BULLION-MARKET-GOLD-A.M-ONLY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.LONDON_BULLION_MARKET_GOLD_A_M_ONLY;
			} else if (areEqual(switchArgument, MapperS.of("LONDON-PLATINUM-PALLADIUM-MARKET"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.LONDON_PLATINUM_PALLADIUM_MARKET;
			} else if (areEqual(switchArgument, MapperS.of("MGEX"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.MGEX;
			} else if (areEqual(switchArgument, MapperS.of("NASDAQ-OMX"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NASDAQ_OMX;
			} else if (areEqual(switchArgument, MapperS.of("NATURAL-GAS-WEEK"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NATURAL_GAS_WEEK;
			} else if (areEqual(switchArgument, MapperS.of("NERC"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NERC;
			} else if (areEqual(switchArgument, MapperS.of("NGI"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NGI;
			} else if (areEqual(switchArgument, MapperS.of("NGX"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NGX;
			} else if (areEqual(switchArgument, MapperS.of("NUCLEAR-MARKET-REVIEW"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NUCLEAR_MARKET_REVIEW;
			} else if (areEqual(switchArgument, MapperS.of("NYMEX-ELECTRICITY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NYMEX_ELECTRICITY;
			} else if (areEqual(switchArgument, MapperS.of("NYMEX-GAS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NYMEX_GAS;
			} else if (areEqual(switchArgument, MapperS.of("NYMEX-NATURAL-GAS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NYMEX_NATURAL_GAS;
			} else if (areEqual(switchArgument, MapperS.of("NYMEX-OIL"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.NYMEX_OIL;
			} else if (areEqual(switchArgument, MapperS.of("OFFICIAL-BOARD-MARKETS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.OFFICIAL_BOARD_MARKETS;
			} else if (areEqual(switchArgument, MapperS.of("OPIS-LP-GAS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.OPIS_LP_GAS;
			} else if (areEqual(switchArgument, MapperS.of("OPIS-PROPANE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.OPIS_PROPANE;
			} else if (areEqual(switchArgument, MapperS.of("PAPER-PACKAGING-MONITOR"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PAPER_PACKAGING_MONITOR;
			} else if (areEqual(switchArgument, MapperS.of("PAPER-TRADER"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PAPER_TRADER;
			} else if (areEqual(switchArgument, MapperS.of("PERTAMINA"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PERTAMINA;
			} else if (areEqual(switchArgument, MapperS.of("PETROCHEMWIRE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PETROCHEMWIRE;
			} else if (areEqual(switchArgument, MapperS.of("PIX-PULP-BENCHMARK-INDICES"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PIX_PULP_BENCHMARK_INDICES;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-APAG-MARKETSCAN"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_APAG_MARKETSCAN;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-BUNKERWIRE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_BUNKERWIRE;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-CLEAN-TANKERWIRE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_CLEAN_TANKERWIRE;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-CRUDE-OIL-MARKETWIRE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_CRUDE_OIL_MARKETWIRE;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-DIRTY-TANKERWIRE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_DIRTY_TANKERWIRE;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-EUROPEAN-GAS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_EUROPEAN_GAS;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-EUROPEAN-MARKETSCAN"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_EUROPEAN_MARKETSCAN;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-METALS-ALERT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_METALS_ALERT;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-OILGRAM"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_OILGRAM;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-TSI-IRON-ORE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_TSI_IRON_ORE;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-TSI-SCRAP"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_TSI_SCRAP;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-TSI-STEEL"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_TSI_STEEL;
			} else if (areEqual(switchArgument, MapperS.of("PLATTS-US-MARKETSCAN"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PLATTS_US_MARKETSCAN;
			} else if (areEqual(switchArgument, MapperS.of("PULP-AND-PAPER-INTERNATIONAL"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PULP_AND_PAPER_INTERNATIONAL;
			} else if (areEqual(switchArgument, MapperS.of("PULP-AND-PAPER-WEEK"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.PULP_AND_PAPER_WEEK;
			} else if (areEqual(switchArgument, MapperS.of("RIM-PRODUCTS-INTELLIGENCE-DAILY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.RIM_PRODUCTS_INTELLIGENCE_DAILY;
			} else if (areEqual(switchArgument, MapperS.of("SAFEX-SOFT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.SAFEX_SOFT;
			} else if (areEqual(switchArgument, MapperS.of("SFE-SOFT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.SFE_SOFT;
			} else if (areEqual(switchArgument, MapperS.of("SGX"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.SGX;
			} else if (areEqual(switchArgument, MapperS.of("SICOM"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.SICOM;
			} else if (areEqual(switchArgument, MapperS.of("SP-GSCI"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.SP_GSCI;
			} else if (areEqual(switchArgument, MapperS.of("STATISTICHES-BUNDESAMT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.STATISTICHES_BUNDESAMT;
			} else if (areEqual(switchArgument, MapperS.of("TGE"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.TGE;
			} else if (areEqual(switchArgument, MapperS.of("TOCOM-OIL"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.TOCOM_OIL;
			} else if (areEqual(switchArgument, MapperS.of("TOCOM-PRECIOUS"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.TOCOM_PRECIOUS;
			} else if (areEqual(switchArgument, MapperS.of("TOCOM-SOFT"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.TOCOM_SOFT;
			} else if (areEqual(switchArgument, MapperS.of("UX-WEEKLY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.UX_WEEKLY;
			} else if (areEqual(switchArgument, MapperS.of("WORLD-PULP-MONTHLY"), CardinalityOperator.All).get()) {
				result = CommodityBusinessCalendarEnum.WORLD_PULP_MONTHLY;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

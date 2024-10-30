package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.master.MasterConfirmationTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapMasterConfirmationTypeEnum.MapMasterConfirmationTypeEnumDefault.class)
public abstract class MapMasterConfirmationTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public MasterConfirmationTypeEnum evaluate(String value) {
		MasterConfirmationTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract MasterConfirmationTypeEnum doEvaluate(String value);

	public static class MapMasterConfirmationTypeEnumDefault extends MapMasterConfirmationTypeEnum {
		@Override
		protected MasterConfirmationTypeEnum doEvaluate(String value) {
			MasterConfirmationTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected MasterConfirmationTypeEnum assignOutput(MasterConfirmationTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("DJ.CDX.EM"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.DJ_CDX_EM;
			} else if (areEqual(switchArgument, MapperS.of("DJ.CDX.EM.DIV"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.DJ_CDX_EM_DIV;
			} else if (areEqual(switchArgument, MapperS.of("DJ.CDX.NA"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.DJ_CDX_NA;
			} else if (areEqual(switchArgument, MapperS.of("DJ.iTraxx.Europe"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.DJ_I_TRAXX_EUROPE;
			} else if (areEqual(switchArgument, MapperS.of("EquityAmericas"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.EQUITY_AMERICAS;
			} else if (areEqual(switchArgument, MapperS.of("EquityAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.EQUITY_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("EquityEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.EQUITY_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1999Credit"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_1999_CREDIT;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditAustraliaNewZealand"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_AUSTRALIA_NEW_ZEALAND;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditNorthAmerican"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_NORTH_AMERICAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditSingapore"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SINGAPORE;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditSovereignAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditSovereignCentralAndEasternEurope"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_CENTRAL_AND_EASTERN_EUROPE;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditSovereignJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditSovereignLatinAmerica"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_LATIN_AMERICA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditSovereignMiddleEast"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_MIDDLE_EAST;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditSovereignWesternEurope"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_CREDIT_SOVEREIGN_WESTERN_EUROPE;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003StandardCreditAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003StandardCreditAustraliaNewZealand"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003StandardCreditEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003StandardCreditJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003StandardCreditNorthAmerican"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_NORTH_AMERICAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003StandardCreditSingapore"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2003_STANDARD_CREDIT_SINGAPORE;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004CreditSovereignAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004CreditSovereignEmergingEuropeanAndMiddleEastern"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004CreditSovereignJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004CreditSovereignLatinAmerican"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_LATIN_AMERICAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004CreditSovereignWesternEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_CREDIT_SOVEREIGN_WESTERN_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004EquityAmericasInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_EQUITY_AMERICAS_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004EquityAmericasInterdealerRev1"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_EQUITY_AMERICAS_INTERDEALER_REV_1;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004StandardCreditSovereignAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004StandardCreditSovereignEmergingEuropeanAndMiddleEastern"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004StandardCreditSovereignJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004StandardCreditSovereignLatinAmerican"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004StandardCreditSovereignWesternEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2004_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2005EquityAsiaExcludingJapanInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2005EquityAsiaExcludingJapanInterdealerRev2"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2005_EQUITY_ASIA_EXCLUDING_JAPAN_INTERDEALER_REV_2;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2005EquityJapaneseInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2005_EQUITY_JAPANESE_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2006VarianceSwapJapanese"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2006_VARIANCE_SWAP_JAPANESE;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2006VarianceSwapJapaneseInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2006_VARIANCE_SWAP_JAPANESE_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007EquityEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2007_EQUITY_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007VarianceSwapAmericas"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_AMERICAS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007VarianceSwapAsiaExcludingJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007VarianceSwapAsiaExcludingJapanRev1"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007VarianceSwapAsiaExcludingJapanRev2"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_2;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007VarianceSwapEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007VarianceSwapEuropeanRev1"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2007_VARIANCE_SWAP_EUROPEAN_REV_1;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008DividendSwapJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2008_DIVIDEND_SWAP_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008DividendSwapJapaneseRev1"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2008_DIVIDEND_SWAP_JAPANESE_REV_1;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008EquityAmericas"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2008_EQUITY_AMERICAS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008EquityAsiaExcludingJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008EquityAsiaExcludingJapanRev1"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2008_EQUITY_ASIA_EXCLUDING_JAPAN_REV_1;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008EquityJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2008_EQUITY_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009EquityAmericas"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2009_EQUITY_AMERICAS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009EquityEuropeanInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2009_EQUITY_EUROPEAN_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009EquityPanAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2009_EQUITY_PAN_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2010EquityEMEAInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2010_EQUITY_EMEA_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2013VolatilitySwapAmericas"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2013_VOLATILITY_SWAP_AMERICAS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2013VolatilitySwapAsiaExcludingJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2013_VOLATILITY_SWAP_ASIA_EXCLUDING_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2013VolatilitySwapEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2013_VOLATILITY_SWAP_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2013VolatilitySwapJapanese"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum.ISDA_2013_VOLATILITY_SWAP_JAPANESE;
			} else if (areEqual(switchArgument, MapperS.of("2003CreditIndex"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2003_CREDIT_INDEX;
			} else if (areEqual(switchArgument, MapperS.of("2004EquityEuropeanInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2004_EQUITY_EUROPEAN_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("2005VarianceSwapEuropeanInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2005_VARIANCE_SWAP_EUROPEAN_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("2006DividendSwapEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2006_DIVIDEND_SWAP_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("2006DividendSwapEuropeanInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2006_DIVIDEND_SWAP_EUROPEAN_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditAsiaFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_ASIA_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditAustraliaNewZealand"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_AUSTRALIA_NEW_ZEALAND;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditAustraliaNewZealandFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditEuropeanCoCoFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_EUROPEAN_CO_CO_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditEuropeanFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_EUROPEAN_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditJapanFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_JAPAN_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditNorthAmerican"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_NORTH_AMERICAN;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditNorthAmericanFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_NORTH_AMERICAN_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditSingapore"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_SINGAPORE;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditSingaporeFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_SINGAPORE_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditSovereignAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditSovereignEmergingEuropeanAndMiddleEastern"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditSovereignJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditSovereignLatinAmerican"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_LATIN_AMERICAN;
			} else if (areEqual(switchArgument, MapperS.of("2014CreditSovereignWesternEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_CREDIT_SOVEREIGN_WESTERN_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditAsiaFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_ASIA_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditAustraliaNewZealand"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditAustraliaNewZealandFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_AUSTRALIA_NEW_ZEALAND_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditEuropeanCoCoFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_EUROPEAN_CO_CO_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditEuropeanFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_EUROPEAN_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditJapanFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_JAPAN_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditNorthAmerican"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_NORTH_AMERICAN;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditNorthAmericanFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_NORTH_AMERICAN_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditSingapore"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SINGAPORE;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditSingaporeFinancial"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SINGAPORE_FINANCIAL;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditSovereignAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditSovereignEmergingEuropeanAndMiddleEastern"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditSovereignJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditSovereignLatinAmerican"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_LATIN_AMERICAN;
			} else if (areEqual(switchArgument, MapperS.of("2014StandardCreditSovereignWesternEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationTypeEnum._2014_STANDARD_CREDIT_SOVEREIGN_WESTERN_EUROPEAN;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

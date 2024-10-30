package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.common.MatrixTermEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapMatrixTermEnum.MapMatrixTermEnumDefault.class)
public abstract class MapMatrixTermEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public MatrixTermEnum evaluate(String value) {
		MatrixTermEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract MatrixTermEnum doEvaluate(String value);

	public static class MapMatrixTermEnumDefault extends MapMatrixTermEnum {
		@Override
		protected MatrixTermEnum doEvaluate(String value) {
			MatrixTermEnum result = null;
			return assignOutput(result, value);
		}
		
		protected MatrixTermEnum assignOutput(MatrixTermEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AsiaCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.ASIA_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("AsiaFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.ASIA_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("AsiaSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.ASIA_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("AustraliaCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.AUSTRALIA_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("AustraliaFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.AUSTRALIA_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("AustraliaSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.AUSTRALIA_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("EmergingEuropeanAndMiddleEasternSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("EmergingEuropeanCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.EMERGING_EUROPEAN_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("EmergingEuropeanCorporateLPN"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.EMERGING_EUROPEAN_CORPORATE_LPN;
			} else if (areEqual(switchArgument, MapperS.of("EmergingEuropeanFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.EMERGING_EUROPEAN_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("EmergingEuropeanFinancialCorporateLPN"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN;
			} else if (areEqual(switchArgument, MapperS.of("EuropeanCoCoFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.EUROPEAN_CO_CO_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("EuropeanCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.EUROPEAN_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("EuropeanFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.EUROPEAN_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("EuropeanSeniorNonPreferredFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("IVS1OpenMarkets"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.IVS_1_OPEN_MARKETS;
			} else if (areEqual(switchArgument, MapperS.of("JapanCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.JAPAN_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("JapanFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.JAPAN_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("JapanSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.JAPAN_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("LatinAmericaCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.LATIN_AMERICA_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("LatinAmericaCorporateBond"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.LATIN_AMERICA_CORPORATE_BOND;
			} else if (areEqual(switchArgument, MapperS.of("LatinAmericaCorporateBondOrLoan"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.LATIN_AMERICA_CORPORATE_BOND_OR_LOAN;
			} else if (areEqual(switchArgument, MapperS.of("LatinAmericaFinancialCorporateBond"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.LATIN_AMERICA_FINANCIAL_CORPORATE_BOND;
			} else if (areEqual(switchArgument, MapperS.of("LatinAmericaFinancialCorporateBondOrLoan"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN;
			} else if (areEqual(switchArgument, MapperS.of("LatinAmericaSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.LATIN_AMERICA_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("NewZealandCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.NEW_ZEALAND_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("NewZealandFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.NEW_ZEALAND_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("NewZealandSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.NEW_ZEALAND_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("NorthAmericanCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.NORTH_AMERICAN_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("NorthAmericanFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.NORTH_AMERICAN_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("SingaporeCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.SINGAPORE_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("SingaporeFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.SINGAPORE_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("SingaporeSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.SINGAPORE_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("StandardAsiaCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_ASIA_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardAsiaFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_ASIA_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardAsiaSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_ASIA_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("StandardAustraliaCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_AUSTRALIA_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardAustraliaFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_AUSTRALIA_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardAustraliaSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_AUSTRALIA_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("StandardEmergingEuropeanAndMiddleEasternSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("StandardEmergingEuropeanCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardEmergingEuropeanCorporateLPN"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN;
			} else if (areEqual(switchArgument, MapperS.of("StandardEmergingEuropeanFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardEmergingEuropeanFinancialCorporateLPN"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_EMERGING_EUROPEAN_FINANCIAL_CORPORATE_LPN;
			} else if (areEqual(switchArgument, MapperS.of("StandardEuropeanCoCoFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_EUROPEAN_CO_CO_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardEuropeanCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_EUROPEAN_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardEuropeanFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_EUROPEAN_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardEuropeanSeniorNonPreferredFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_EUROPEAN_SENIOR_NON_PREFERRED_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardJapanCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_JAPAN_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardJapanFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_JAPAN_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardJapanSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_JAPAN_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("StandardLatinAmericaCorporateBond"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_LATIN_AMERICA_CORPORATE_BOND;
			} else if (areEqual(switchArgument, MapperS.of("StandardLatinAmericaCorporateBondOrLoan"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN;
			} else if (areEqual(switchArgument, MapperS.of("StandardLatinAmericaFinancialCorporateBond"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND;
			} else if (areEqual(switchArgument, MapperS.of("StandardLatinAmericaFinancialCorporateBondOrLoan"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_LATIN_AMERICA_FINANCIAL_CORPORATE_BOND_OR_LOAN;
			} else if (areEqual(switchArgument, MapperS.of("StandardLatinAmericaSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_LATIN_AMERICA_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("StandardNewZealandCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_NEW_ZEALAND_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardNewZealandFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_NEW_ZEALAND_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardNewZealandSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_NEW_ZEALAND_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("StandardNorthAmericanCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_NORTH_AMERICAN_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardNorthAmericanFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_NORTH_AMERICAN_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardSingaporeCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_SINGAPORE_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardSingaporeFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_SINGAPORE_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardSingaporeSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_SINGAPORE_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("StandardSubordinatedEuropeanInsuranceCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardSukukFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_SUKUK_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("StandardUSMunicipalFullFaithAndCredit"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_US_MUNICIPAL_FULL_FAITH_AND_CREDIT;
			} else if (areEqual(switchArgument, MapperS.of("StandardUSMunicipalGeneralFund"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_US_MUNICIPAL_GENERAL_FUND;
			} else if (areEqual(switchArgument, MapperS.of("StandardUSMunicipalRevenue"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_US_MUNICIPAL_REVENUE;
			} else if (areEqual(switchArgument, MapperS.of("StandardWesternEuropeanSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.STANDARD_WESTERN_EUROPEAN_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("SubordinatedEuropeanInsuranceCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("SukukCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.SUKUK_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("SukukFinancialCorporate"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.SUKUK_FINANCIAL_CORPORATE;
			} else if (areEqual(switchArgument, MapperS.of("SukukSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.SUKUK_SOVEREIGN;
			} else if (areEqual(switchArgument, MapperS.of("USMunicipalFullFaithAndCredit"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.US_MUNICIPAL_FULL_FAITH_AND_CREDIT;
			} else if (areEqual(switchArgument, MapperS.of("USMunicipalGeneralFund"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.US_MUNICIPAL_GENERAL_FUND;
			} else if (areEqual(switchArgument, MapperS.of("USMunicipalRevenue"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.US_MUNICIPAL_REVENUE;
			} else if (areEqual(switchArgument, MapperS.of("WesternEuropeanSovereign"), CardinalityOperator.All).get()) {
				result = MatrixTermEnum.WESTERN_EUROPEAN_SOVEREIGN;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

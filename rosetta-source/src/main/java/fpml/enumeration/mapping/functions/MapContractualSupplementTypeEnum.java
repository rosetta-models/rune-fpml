package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.common.ContractualSupplementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapContractualSupplementTypeEnum.MapContractualSupplementTypeEnumDefault.class)
public abstract class MapContractualSupplementTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ContractualSupplementTypeEnum evaluate(String value) {
		ContractualSupplementTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ContractualSupplementTypeEnum doEvaluate(String value);

	public static class MapContractualSupplementTypeEnumDefault extends MapContractualSupplementTypeEnum {
		@Override
		protected ContractualSupplementTypeEnum doEvaluate(String value) {
			ContractualSupplementTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ContractualSupplementTypeEnum assignOutput(ContractualSupplementTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ABX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ABX;
			} else if (areEqual(switchArgument, MapperS.of("ABXTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ABX_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("CDSonLeveragedLoans"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.CD_SON_LEVERAGED_LOANS;
			} else if (areEqual(switchArgument, MapperS.of("CDSonMBS"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.CD_SON_MBS;
			} else if (areEqual(switchArgument, MapperS.of("CDX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.CDX;
			} else if (areEqual(switchArgument, MapperS.of("CDXEmergingMarkets"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.CDX_EMERGING_MARKETS;
			} else if (areEqual(switchArgument, MapperS.of("CDXEmergingMarketsDiversified"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.CDX_EMERGING_MARKETS_DIVERSIFIED;
			} else if (areEqual(switchArgument, MapperS.of("CDXSwaption"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.CDX_SWAPTION;
			} else if (areEqual(switchArgument, MapperS.of("CDXTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.CDX_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("CMBX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.CMBX;
			} else if (areEqual(switchArgument, MapperS.of("EuropeanCMBS"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.EUROPEAN_CMBS;
			} else if (areEqual(switchArgument, MapperS.of("EuropeanRMBS"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.EUROPEAN_RMBS;
			} else if (areEqual(switchArgument, MapperS.of("IOS"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.IOS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1999CreditConvertibleExchangeableAccretingObligations"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_1999_CREDIT_CONVERTIBLE_EXCHANGEABLE_ACCRETING_OBLIGATIONS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1999CreditRestructuring"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_1999_CREDIT_RESTRUCTURING;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1999CreditSuccessorAndCreditEvents"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_1999_CREDIT_SUCCESSOR_AND_CREDIT_EVENTS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003AdditionalProvisionsLPN"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_ADDITIONAL_PROVISIONS_LPN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003ContingentCreditSpreadTransaction"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CONTINGENT_CREDIT_SPREAD_TRANSACTION;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003Credit2005MatrixSupplement"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_2005_MATRIX_SUPPLEMENT;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditArgentineRepublic"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_ARGENTINE_REPUBLIC;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditAuctionSupplement"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_AUCTION_SUPPLEMENT;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditMay2003"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_MAY_2003;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditMonolineInsurers"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_MONOLINE_INSURERS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditMonolineInsurers2005"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_MONOLINE_INSURERS_2005;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditRepublicOfHungary"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditRepublicOfHungary2005"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY_2005;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditRussianFederation"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_RUSSIAN_FEDERATION;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003CreditUSMunicipals"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_CREDIT_US_MUNICIPALS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003STMicroelectronicsNV"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2003_ST_MICROELECTRONICS_NV;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007FullLookthroughDepositoryReceiptSupplement"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2007_FULL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007PartialLookthroughDepositoryReceiptSupplement"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_2007_PARTIAL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT;
			} else if (areEqual(switchArgument, MapperS.of("ISDACreditMonolineInsurers"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_CREDIT_MONOLINE_INSURERS;
			} else if (areEqual(switchArgument, MapperS.of("ISDADeliveryRestrictions"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_DELIVERY_RESTRICTIONS;
			} else if (areEqual(switchArgument, MapperS.of("ISDAFixedRecovery"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_FIXED_RECOVERY;
			} else if (areEqual(switchArgument, MapperS.of("ISDALPNReferenceEntities"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDALPN_REFERENCE_ENTITIES;
			} else if (areEqual(switchArgument, MapperS.of("ISDAMarch2004EquityCanadianSupplement"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_MARCH_2004_EQUITY_CANADIAN_SUPPLEMENT;
			} else if (areEqual(switchArgument, MapperS.of("ISDARecoveryLock"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_RECOVERY_LOCK;
			} else if (areEqual(switchArgument, MapperS.of("ISDASecuredDeliverableObligationCharacteristic"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.ISDA_SECURED_DELIVERABLE_OBLIGATION_CHARACTERISTIC;
			} else if (areEqual(switchArgument, MapperS.of("LCDX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.LCDX;
			} else if (areEqual(switchArgument, MapperS.of("LCDXTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.LCDX_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("MBX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.MBX;
			} else if (areEqual(switchArgument, MapperS.of("MCDX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.MCDX;
			} else if (areEqual(switchArgument, MapperS.of("PO"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.PO;
			} else if (areEqual(switchArgument, MapperS.of("PrimeX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.PRIME_X;
			} else if (areEqual(switchArgument, MapperS.of("StandardCDXTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.STANDARD_CDX_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("StandardLCDS"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.STANDARD_LCDS;
			} else if (areEqual(switchArgument, MapperS.of("StandardLCDSBullet"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.STANDARD_LCDS_BULLET;
			} else if (areEqual(switchArgument, MapperS.of("StandardLCDXBullet"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.STANDARD_LCDX_BULLET;
			} else if (areEqual(switchArgument, MapperS.of("StandardLCDXBulletTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.STANDARD_LCDX_BULLET_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("StandardiTraxxEuropeTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.STANDARDI_TRAXX_EUROPE_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("SyndicatedSecuredLoanCDS"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.SYNDICATED_SECURED_LOAN_CDS;
			} else if (areEqual(switchArgument, MapperS.of("TRX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.TRX;
			} else if (areEqual(switchArgument, MapperS.of("TRX.II"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.TRX_II;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxAsiaExJapan"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_ASIA_EX_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxAsiaExJapanSwaption"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_ASIA_EX_JAPAN_SWAPTION;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxAsiaExJapanTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_ASIA_EX_JAPAN_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxAustralia"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_AUSTRALIA;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxAustraliaSwaption"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_AUSTRALIA_SWAPTION;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxAustraliaTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_AUSTRALIA_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxCJ"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_CJ;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxCJTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_CJ_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxEurope"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_EUROPE;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxEuropeDealer"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_EUROPE_DEALER;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxEuropeNonDealer"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_EUROPE_NON_DEALER;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxEuropeSwaption"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_EUROPE_SWAPTION;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxEuropeTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_EUROPE_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxJapan"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxJapanSwaption"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_JAPAN_SWAPTION;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxJapanTranche"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_JAPAN_TRANCHE;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxLevX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_LEV_X;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxSDI75Dealer"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_SDI_75_DEALER;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxSDI75NonDealer"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_SDI_75_NON_DEALER;
			} else if (areEqual(switchArgument, MapperS.of("iTraxxSovX"), CardinalityOperator.All).get()) {
				result = ContractualSupplementTypeEnum.I_TRAXX_SOV_X;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

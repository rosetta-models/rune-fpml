package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.master.MasterConfirmationAnnexTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapMasterConfirmationAnnexTypeEnum.MapMasterConfirmationAnnexTypeEnumDefault.class)
public abstract class MapMasterConfirmationAnnexTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public MasterConfirmationAnnexTypeEnum evaluate(String value) {
		MasterConfirmationAnnexTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract MasterConfirmationAnnexTypeEnum doEvaluate(String value);

	public static class MapMasterConfirmationAnnexTypeEnumDefault extends MapMasterConfirmationAnnexTypeEnum {
		@Override
		protected MasterConfirmationAnnexTypeEnum doEvaluate(String value) {
			MasterConfirmationAnnexTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected MasterConfirmationAnnexTypeEnum assignOutput(MasterConfirmationAnnexTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004IndexVarianceSwapAmericasInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2004_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004ShareVarianceSwapAmericasInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2004_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007DispersionVarianceSwapEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2007_DISPERSION_VARIANCE_SWAP_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007EquityFinanceSwapEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2007_EQUITY_FINANCE_SWAP_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007IndexVarianceSwapAmericasInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2007_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007ShareVarianceSwapAmericasInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2007_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2007VarianceOptionEuropean"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2007_VARIANCE_OPTION_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008EquityFinanceSwapAsiaExcludingJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008EquityFinanceSwapAsiaExcludingJapanRev1"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008EquityOptionAsiaExcludingJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008EquityOptionAsiaExcludingJapanRev1"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN_REV_1;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008EquityOptionJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2008_EQUITY_OPTION_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009ClosedMarketsOptionsAsiaExcludingJapan"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2009_CLOSED_MARKETS_OPTIONS_ASIA_EXCLUDING_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009EquityEuropeanIS"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2009_EQUITY_EUROPEAN_IS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009EquityEuropeanInterdealerSS"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2009_EQUITY_EUROPEAN_INTERDEALER_SS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009IndexShareOptionAmericas"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2009_INDEX_SHARE_OPTION_AMERICAS;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009IndexSwapEuropeanInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2009_INDEX_SWAP_EUROPEAN_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009IndexSwapPanAsiaInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2009_INDEX_SWAP_PAN_ASIA_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2009ShareSwapPanAsia"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2009_SHARE_SWAP_PAN_ASIA;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2010FairValueShareSwapEuropeanInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2010_FAIR_VALUE_SHARE_SWAP_EUROPEAN_INTERDEALER;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2010IndexShareOptionEMEAInterdealer"), CardinalityOperator.All).get()) {
				result = MasterConfirmationAnnexTypeEnum.ISDA_2010_INDEX_SHARE_OPTION_EMEA_INTERDEALER;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

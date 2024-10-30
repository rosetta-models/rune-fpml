package fpml.enumeration.mapping.functions;

import cdm.observable.asset.InformationProviderEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapInformationProviderEnum.MapInformationProviderEnumDefault.class)
public abstract class MapInformationProviderEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public InformationProviderEnum evaluate(String value) {
		InformationProviderEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract InformationProviderEnum doEvaluate(String value);

	public static class MapInformationProviderEnumDefault extends MapInformationProviderEnum {
		@Override
		protected InformationProviderEnum doEvaluate(String value) {
			InformationProviderEnum result = null;
			return assignOutput(result, value);
		}
		
		protected InformationProviderEnum assignOutput(InformationProviderEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AssocBanksSingapore"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.ASSOC_BANKS_SINGAPORE;
			} else if (areEqual(switchArgument, MapperS.of("BankOfCanada"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.BANK_OF_CANADA;
			} else if (areEqual(switchArgument, MapperS.of("BankOfEngland"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.BANK_OF_ENGLAND;
			} else if (areEqual(switchArgument, MapperS.of("BankOfJapan"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.BANK_OF_JAPAN;
			} else if (areEqual(switchArgument, MapperS.of("Bloomberg"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.BLOOMBERG;
			} else if (areEqual(switchArgument, MapperS.of("EuroCentralBank"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.EURO_CENTRAL_BANK;
			} else if (areEqual(switchArgument, MapperS.of("FHLBSF"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.FHLBSF;
			} else if (areEqual(switchArgument, MapperS.of("FederalReserve"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.FEDERAL_RESERVE;
			} else if (areEqual(switchArgument, MapperS.of("ISDA"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.ISDA;
			} else if (areEqual(switchArgument, MapperS.of("ReserveBankAustralia"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.RESERVE_BANK_AUSTRALIA;
			} else if (areEqual(switchArgument, MapperS.of("ReserveBankNewZealand"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.RESERVE_BANK_NEW_ZEALAND;
			} else if (areEqual(switchArgument, MapperS.of("Reuters"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.REUTERS;
			} else if (areEqual(switchArgument, MapperS.of("SAFEX"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.SAFEX;
			} else if (areEqual(switchArgument, MapperS.of("Telerate"), CardinalityOperator.All).get()) {
				result = InformationProviderEnum.TELERATE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapContractualDefinitionsEnum.MapContractualDefinitionsEnumDefault.class)
public abstract class MapContractualDefinitionsEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ContractualDefinitionsEnum evaluate(String value) {
		ContractualDefinitionsEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ContractualDefinitionsEnum doEvaluate(String value);

	public static class MapContractualDefinitionsEnumDefault extends MapContractualDefinitionsEnum {
		@Override
		protected ContractualDefinitionsEnum doEvaluate(String value) {
			ContractualDefinitionsEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ContractualDefinitionsEnum assignOutput(ContractualDefinitionsEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1991"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_1991_INTEREST_RATE;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1993Commodity"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_1993_COMMODITY_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1996Equity"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_1996_EQUITY_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1997Bullion"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_1997_BULLION;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1997GovernmentBond"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_1997_GOVERNMENT_BOND_OPTION;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1998FX"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_1998_FX_AND_CURRENCY_OPTION;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1999Credit"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_1999_CREDIT_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2000"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA2000;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2002Equity"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_2002_EQUITY_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2003Credit"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_2003_CREDIT_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2004Novation"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_2004_NOVATION;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2005Commodity"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_2005_COMMODITY;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2006"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA2006;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2006Inflation"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_2006_INFLATION_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2008Inflation"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_2008_INFLATION_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2011Equity"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_2011_EQUITY_DERIVATIVES;
			} else if (areEqual(switchArgument, MapperS.of("ISDA2014Credit"), CardinalityOperator.All).get()) {
				result = ContractualDefinitionsEnum.ISDA_2014_CREDIT_DERIVATIVES;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

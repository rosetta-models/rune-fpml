package fpml.enumeration.mapping.functions;

import cdm.product.collateral.CreditSupportAgreementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCreditSupportAgreementTypeEnum.MapCreditSupportAgreementTypeEnumDefault.class)
public abstract class MapCreditSupportAgreementTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CreditSupportAgreementTypeEnum evaluate(String value) {
		CreditSupportAgreementTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CreditSupportAgreementTypeEnum doEvaluate(String value);

	public static class MapCreditSupportAgreementTypeEnumDefault extends MapCreditSupportAgreementTypeEnum {
		@Override
		protected CreditSupportAgreementTypeEnum doEvaluate(String value) {
			CreditSupportAgreementTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CreditSupportAgreementTypeEnum assignOutput(CreditSupportAgreementTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("CreditSupportDeed"), CardinalityOperator.All).get()) {
				result = CreditSupportAgreementTypeEnum.CREDIT_SUPPORT_DEED;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1995CreditSupportDeedEnglishLaw"), CardinalityOperator.All).get()) {
				result = CreditSupportAgreementTypeEnum.CREDIT_SUPPORT_DEED;
			} else if (areEqual(switchArgument, MapperS.of("CreditSupportAnnex"), CardinalityOperator.All).get()) {
				result = CreditSupportAgreementTypeEnum.CREDIT_SUPPORT_ANNEX;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1994CreditSupportAnnexNewYorkLaw"), CardinalityOperator.All).get()) {
				result = CreditSupportAgreementTypeEnum.CREDIT_SUPPORT_ANNEX;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1995CreditSupportAnnexEnglishLaw"), CardinalityOperator.All).get()) {
				result = CreditSupportAgreementTypeEnum.CREDIT_SUPPORT_ANNEX;
			} else if (areEqual(switchArgument, MapperS.of("ISDA1995CreditSupportAnnexJapaneseLaw"), CardinalityOperator.All).get()) {
				result = CreditSupportAgreementTypeEnum.CREDIT_SUPPORT_ANNEX;
			} else if (areEqual(switchArgument, MapperS.of("CollateralTransferAgreement"), CardinalityOperator.All).get()) {
				result = CreditSupportAgreementTypeEnum.COLLATERAL_TRANSFER_AGREEMENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}

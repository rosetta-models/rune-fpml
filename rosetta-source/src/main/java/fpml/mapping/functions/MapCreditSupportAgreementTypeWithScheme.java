package fpml.mapping.functions;

import cdm.product.collateral.CreditSupportAgreementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapCreditSupportAgreementTypeWithScheme.MapCreditSupportAgreementTypeWithSchemeDefault.class)
public abstract class MapCreditSupportAgreementTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return creditSupportAgreementTypeEnum 
	*/
	public CreditSupportAgreementTypeEnum evaluate(DataDocument fpmlDataDocument) {
		CreditSupportAgreementTypeEnum creditSupportAgreementTypeEnum = doEvaluate(fpmlDataDocument);
		
		return creditSupportAgreementTypeEnum;
	}

	protected abstract CreditSupportAgreementTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCreditSupportAgreementTypeWithSchemeDefault extends MapCreditSupportAgreementTypeWithScheme {
		@Override
		protected CreditSupportAgreementTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			CreditSupportAgreementTypeEnum creditSupportAgreementTypeEnum = null;
			return assignOutput(creditSupportAgreementTypeEnum, fpmlDataDocument);
		}
		
		protected CreditSupportAgreementTypeEnum assignOutput(CreditSupportAgreementTypeEnum creditSupportAgreementTypeEnum, DataDocument fpmlDataDocument) {
			creditSupportAgreementTypeEnum = null;
			
			return creditSupportAgreementTypeEnum;
		}
	}
}

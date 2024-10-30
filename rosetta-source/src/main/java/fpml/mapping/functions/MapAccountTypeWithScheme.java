package fpml.mapping.functions;

import cdm.base.staticdata.party.AccountTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapAccountTypeWithScheme.MapAccountTypeWithSchemeDefault.class)
public abstract class MapAccountTypeWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return accountTypeEnum 
	*/
	public AccountTypeEnum evaluate(DataDocument fpmlDataDocument) {
		AccountTypeEnum accountTypeEnum = doEvaluate(fpmlDataDocument);
		
		return accountTypeEnum;
	}

	protected abstract AccountTypeEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAccountTypeWithSchemeDefault extends MapAccountTypeWithScheme {
		@Override
		protected AccountTypeEnum doEvaluate(DataDocument fpmlDataDocument) {
			AccountTypeEnum accountTypeEnum = null;
			return assignOutput(accountTypeEnum, fpmlDataDocument);
		}
		
		protected AccountTypeEnum assignOutput(AccountTypeEnum accountTypeEnum, DataDocument fpmlDataDocument) {
			accountTypeEnum = null;
			
			return accountTypeEnum;
		}
	}
}

package fpml.mapping.functions;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Account.AccountBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAccount.MapAccountDefault.class)
public abstract class MapAccount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAccountNameWithScheme mapAccountNameWithScheme;
	@Inject protected MapAccountNumberWithScheme mapAccountNumberWithScheme;
	@Inject protected MapAccountTypeWithScheme mapAccountTypeWithScheme;
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return account 
	*/
	public Account evaluate(DataDocument fpmlDataDocument) {
		Account.AccountBuilder accountBuilder = doEvaluate(fpmlDataDocument);
		
		final Account account;
		if (accountBuilder == null) {
			account = null;
		} else {
			account = accountBuilder.build();
			objectValidator.validate(Account.class, account);
		}
		
		return account;
	}

	protected abstract Account.AccountBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAccountDefault extends MapAccount {
		@Override
		protected Account.AccountBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Account.AccountBuilder account = Account.builder();
			return assignOutput(account, fpmlDataDocument);
		}
		
		protected Account.AccountBuilder assignOutput(Account.AccountBuilder account, DataDocument fpmlDataDocument) {
			account = toBuilder(Account.builder()
				.setPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setAccountNumberValue(mapAccountNumberWithScheme.evaluate(fpmlDataDocument))
				.setAccountNameValue(mapAccountNameWithScheme.evaluate(fpmlDataDocument))
				.setAccountTypeValue(mapAccountTypeWithScheme.evaluate(fpmlDataDocument))
				.setAccountBeneficiaryValue(mapParty.evaluate(fpmlDataDocument))
				.setServicingPartyValue(mapParty.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(account)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

package fpml.mapping.functions;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Account.AccountBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapAccountList.MapAccountListDefault.class)
public abstract class MapAccountList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAccountNameWithScheme mapAccountNameWithScheme;
	@Inject protected MapAccountNumberWithScheme mapAccountNumberWithScheme;
	@Inject protected MapAccountTypeWithScheme mapAccountTypeWithScheme;
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return accountList 
	*/
	public List<? extends Account> evaluate(DataDocument fpmlDataDocument) {
		List<Account.AccountBuilder> accountListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Account> accountList;
		if (accountListBuilder == null) {
			accountList = null;
		} else {
			accountList = accountListBuilder.stream().map(Account::build).collect(Collectors.toList());
			objectValidator.validate(Account.class, accountList);
		}
		
		return accountList;
	}

	protected abstract List<Account.AccountBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAccountListDefault extends MapAccountList {
		@Override
		protected List<Account.AccountBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Account.AccountBuilder> accountList = new ArrayList<>();
			return assignOutput(accountList, fpmlDataDocument);
		}
		
		protected List<Account.AccountBuilder> assignOutput(List<Account.AccountBuilder> accountList, DataDocument fpmlDataDocument) {
			accountList.addAll(toBuilder(MapperC.<Account>of(MapperS.of(Account.builder()
				.setPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setAccountNumberValue(mapAccountNumberWithScheme.evaluate(fpmlDataDocument))
				.setAccountNameValue(mapAccountNameWithScheme.evaluate(fpmlDataDocument))
				.setAccountTypeValue(mapAccountTypeWithScheme.evaluate(fpmlDataDocument))
				.setAccountBeneficiaryValue(mapParty.evaluate(fpmlDataDocument))
				.setServicingPartyValue(mapParty.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(accountList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
